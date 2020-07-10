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
public class DadosObrigatoriosClienteJuridico implements IStrategy{

    @Override
	public String processar(EntidadeDominio entidade) {
		
            if(entidade instanceof ClienteJuridico){
                ClienteJuridico cj = (ClienteJuridico)entidade;
                
                Endereco endereco = new Endereco();
                
         	if(endereco.getCep()== null || endereco.getCep().trim().equals("")){
                    return "Campo obrigatório em branco. Preencha a Razão Social do cliente.";
		}  
		/*if(cj.getNome() == null || cj.getNome().trim().equals("")){
                    return "Campo obrigatório em branco. Preencha a Razão Social do cliente.";
		}       
                if(cj.getCnpj()== null || cj.getCnpj().trim().equals("")){
                    return "Campo obrigatório em branco. Preencha o CNPJ do cliente.";
		}
                if(cj.getEmail()== null || cj.getEmail().trim().equals("")){
                    return "Campo obrigatório em branco. Preencha o e-mail do cliente.";
                }
                if(cj.getTelefoneComercial()== null || cj.getTelefoneComercial().trim().equals("")){
                    return "Campo obrigatório em branco. Preencha o telefone comercial do cliente.";
		}
                if(cj.getTelefoneCelular()== null || cj.getTelefoneCelular().trim().equals("")){
                    return "Campo obrigatório em branco. Preencha o telefone celular do cliente.";
		}
                if(cj.getPessoaResponsavel()== null || cj.getPessoaResponsavel().trim().equals("")){
                    return "Campo obrigatório em branco. Preencha o nome da pessoa responsável do cliente.";
		}*/
                
            }else{
                return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
            }
    return null;
	}   
}
