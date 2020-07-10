/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.negocio;

import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosEndereco implements IStrategy{

    @Override
	public String processar(EntidadeDominio entidade) {
		
            if(entidade instanceof ClienteJuridico){
                ClienteJuridico end = (ClienteJuridico)entidade;
                
                if(end.getEndereco().getCep()== null || end.getEndereco().getCep().trim().equals("")){
                    return "Campo obrigatório em branco. Preencha o nome da cep do endereco.";
		}
                
            }else{
                return "Dado não pode ser validado, pois entidade não é um Endereço!";
            }
    return null;
	}   
}
