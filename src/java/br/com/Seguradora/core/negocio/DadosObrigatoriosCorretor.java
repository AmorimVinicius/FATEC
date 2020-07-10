/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.ClienteDAO;
import br.com.Seguradora.core.dao.CorretorDAO;
import br.com.Seguradora.dominio.Corretor;
import br.com.Seguradora.dominio.EntidadeDominio;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosCorretor implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        
            if(entidade instanceof Corretor){
                Corretor corretor = (Corretor)entidade;
                
                // VALIDAR ENDEREÇOS IGUAIS
                if(corretor.getEndereco().getCep().equals(corretor.getEndereco().getCepSec())){
                    return "O Endereço Principal não deve ser igual o Endereço Secundário!";
                }                                

                // VALIDAR CNPJ
                boolean cnpj = ValidarCNPJ.isCnpj(corretor.getDocumento());
                if (cnpj == false){
                    return "O CNPJ inserido é inválido. Por favor verifique!";
                }
                
                // VERIFICAR SE CNPJ JÁ EXISTE
                if (corretor.getOperacao().equals("SALVAR")){
                    boolean cnpjExiste = CorretorDAO.isExisteCNPJ(corretor.getDocumento());
                    if(cnpjExiste == true){
                        return "O CNPJ inserido já existe em nossa base de dados!";
                    }
                }
                
                // VALIDAR CLIENTE ASSOCIADO
                if (corretor.getOperacao().equals("SALVAR")){
                    boolean clienteExiste = ClienteDAO.isExisteCPF(corretor.getCliente().getDocumento());
                    if(clienteExiste == false){
                        return "O CNPJ informado não está associado a nenhum cliente!";
                    }
                }                
                
                // VALIDAR QUANTIDADE DE CARACTERE CEP
                String cep = corretor.getEndereco().getCep().replace("-", "");
                if (cep.length()<8){
                    return "O CEP infomado é inválido. Verifique a quantidade de caracteres!";
                }
                
                
            }else{
                return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
            }
        return null;
    }   
}