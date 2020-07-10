/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.IncendioDAO;
import br.com.Seguradora.core.dao.MecanicaDAO;
import br.com.Seguradora.core.dao.SinistroDAO;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Incendio;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosIncendio implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        
        if(entidade instanceof Incendio){
            Incendio i = (Incendio)entidade;
            // VERIFICAR STATUS SINISTRO
            if (i.getOperacao().equals("SALVAR")){
                boolean statusAprovacao = IncendioDAO.statusSinistro(i.getSinistro().getId());
                if(statusAprovacao == true){
                    return "O sinistro ainda está para aprovação! Entre em contato com a seguradora para maiores informações!";
                }
            }
            
            // VERIFICAR STATUS SINISTRO
                if (i.getOperacao().equals("LISTARFILTRO")){
                    boolean existeSinistro = SinistroDAO.existeSinistro(i.getVeiculo().getPlaca());
                    if(existeSinistro == false){
                        return "A placa informada não existe ou não temos sinistros abertos para a mesma";
                    }
                }
            
            // VERIFICAR SE FOI DADO ENTRADA NA MECANICA
                if (i.getOperacao().equals("SALVAR")){
                    boolean statusMecanica = MecanicaDAO.statusMecanica(i.getSinistro().getId());
                    if(statusMecanica == false){
                        return "Deve ser dado entrada do veículo na Oficina cadastrada!";
                    }
                }
            
            
            // VERIFICAR STATUS SINISTRO
            if (i.getOperacao().equals("LISTARFILTRO")){
                boolean existeSinistro = SinistroDAO.existeSinistro(i.getVeiculo().getPlaca());
                if(existeSinistro == false){
                    return "A placa informada não existe ou não temos sinistros abertos para a mesma";
                }
            }
            
            
            // VEFIFICAR SE SINISTRO JÁ FOI ENCERRADO
            if (i.getOperacao().equals("SALVAR")){
                boolean statusSinistro = SinistroDAO.verificarSinistroEncerrado(i.getVeiculo().getId());
                if (statusSinistro == true){
                    return "O sinistro foi encerrado!";
                }
            }
            
        }else{
            return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
        }
        return null;
    }  
    
}
