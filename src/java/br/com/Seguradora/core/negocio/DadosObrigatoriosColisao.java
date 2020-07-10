/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.ColisaoDAO;
import br.com.Seguradora.core.dao.MecanicaDAO;
import br.com.Seguradora.core.dao.SinistroDAO;
import br.com.Seguradora.dominio.Colisao;
import br.com.Seguradora.dominio.EntidadeDominio;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosColisao implements IStrategy{
    
    @Override
    public String processar(EntidadeDominio entidade) {
        if(entidade instanceof Colisao){
            Colisao c = (Colisao)entidade;
                
                // VERIFICAR STATUS SINISTRO
                if (c.getOperacao().equals("SALVAR")){
                    boolean statusSinistro = ColisaoDAO.statusSinistro(c.getSinistro().getId());
                    if(statusSinistro == true){
                        return "O sinistro ainda está para aprovação! Entre em contato com a seguradora para maiores informações!";
                    }
                }
                
                // VERIFICAR SE FOI DADO ENTRADA NA MECANICA
                if (c.getOperacao().equals("SALVAR")){
                    boolean statusMecanica = MecanicaDAO.statusMecanica(c.getSinistro().getId());
                    if(statusMecanica == false){
                        return "Deve ser dado entrada do veículo na Oficina cadastrada!";
                    }
                }
                
                // VERIFICAR STATUS SINISTRO
                if (c.getOperacao().equals("LISTARFILTRO")){
                    boolean existeSinistro = SinistroDAO.existeSinistro(c.getVeiculo().getPlaca());
                    if(existeSinistro == false){
                        return "A placa informada não existe ou não temos sinistros abertos para a mesma";
                    }
                }
                
        }else{
            return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
        }
        
        return null;
        
    }
    
}
