/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.ClienteDAO;
import br.com.Seguradora.core.dao.CorretorDAO;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Login;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosLogin implements IStrategy{

     @Override
    public String processar(EntidadeDominio entidade) {
        
        if(entidade instanceof Login){
            Login l = (Login)entidade;
            String senhaforte = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
            boolean flag = l.getSenha().matches(senhaforte);
        
            if (!l.getSenha().equals(l.getSenha())){
                return "As senhas não conferem.";
            }
            
            // VERIFICAR LOGIN CLIENTE  E CORRETOR
            boolean emailClienteExiste = ClienteDAO.existeEmail(l.getLogin());
            boolean emailCorretorExiste = CorretorDAO.existeEmail(l.getLogin());
            if (emailClienteExiste == false && emailCorretorExiste == false){
                return "O e-mail não existe em nossa base de dados!";
            }            
            
            
            // VALIDAR SENHA FORTE
            if (flag == false) {
                return "Senha inválida.\nSenha deve ter 8 caracteres no mínimo, uma letra maiúscula e uma minúscula e um caracter especial(@#$%^&+=)";
            }
            
            
        }else{
            return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
        }
        return null;
    }  
    
}
