/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.FurtoRouboDAO;
import br.com.Seguradora.core.dao.SinistroDAO;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.FurtoRoubo;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosFurtoRoubo implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        
        if(entidade instanceof FurtoRoubo){
            FurtoRoubo fr = (FurtoRoubo)entidade;
            
            // VERIFICAR STATUS SINISTRO
            if (fr.getOperacao().equals("SALVAR")){
                boolean statusSinistro = FurtoRouboDAO.statusSinistro(fr.getSinistro().getId());
                    if(statusSinistro == true){
                        return "O sinistro ainda está para aprovação! Entre em contato com a seguradora para maiores informações!";
                    }
            }
            
            // VERIFICAR STATUS SINISTRO
            if (fr.getOperacao().equals("LISTARFILTRO")){
                boolean existeSinistro = SinistroDAO.existeSinistro(fr.getVeiculo().getPlaca());
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