/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.ApoliceDAO;
import br.com.Seguradora.core.dao.SinistroDAO;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Sinistro;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosSinistro implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        
        if(entidade instanceof Sinistro){
            Sinistro sinistro = (Sinistro)entidade;

            // VALIDAR SE JA EXISTE UM SINISTRO EM ABERTO
            if (sinistro.getOperacao().equals("SALVAR")){
                boolean sinistroAtivo = SinistroDAO.isSinistroAtivo(sinistro.getVeiculo().getId());
                if(sinistroAtivo == true){
                    return "Já existe um sinistro em aberto!";
                }
            }
            
            // VALIDAR SE EXISTE SINISTRO PARA PLACA INFORMADA
            if (sinistro.getOperacao().equals("SALVAR")){
                boolean apoliceAtiva = ApoliceDAO.isExisteApolice(sinistro.getVeiculo().getId());
                if (apoliceAtiva == false){
                    return "A apólice do veículo selecionado não existe ou está fora de vigência!";
                }
            }
            // VALIDAR TIPO DE SINISTRO SELECIONADO
            if (sinistro.getOperacao().equals("SALVAR")){
                boolean tipoSinistro = SinistroDAO.verificarTipoApolice(sinistro.getTipo(), sinistro.getVeiculo().getId());
                // o sinistro compreensivo equivale a todos outros sinistros
                if (tipoSinistro == false){ //|| !sinistro.getTipo().equals("Compreensivo")){
                    return "O sinistro selecionado não equivale a sua apólice contratada!\n"
                            + "Para mais informações, contrate nossa área de contratos!";
                }
            }
            
            // VALIDAR CNPJ
             if (sinistro.getOperacao().equals("ALTERAR")){
                if (sinistro.getMecanica().getPessoa().getDocumento()!=null && !sinistro.getMecanica().getPessoa().getDocumento().equals("")){
                    boolean cnpj = ValidarCNPJ.isCnpj(sinistro.getMecanica().getPessoa().getDocumento());
                    if (cnpj == false){
                        return "O CNPJ inserido é inválido. Por favor verifique!";
                    }
                }
             }
        }else{
            return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
        }
        return null;
    }   
}    

