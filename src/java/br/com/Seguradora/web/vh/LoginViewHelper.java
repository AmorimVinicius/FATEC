/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Login;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viniciusamorim
 */
public class LoginViewHelper implements IViewHelper{

    Login login;
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {
            login = new Login();  
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String confirmarSenha = request.getParameter("confirmarSenha");
            
            login.setOperacao(operacao);            

            if (email != null && !email.trim().equals("")) {
                login.setLogin(email);
            }
            
            if (senha != null && !senha.trim().equals("")) {
                login.setSenha(senha);
            }
            
            if (confirmarSenha != null && !confirmarSenha.trim().equals("")) {
                login.setConfirmarSenha(confirmarSenha);
            }
            
            return login;
            
        }
        
        if (operacao.equals("AUTENTICAR")){
            login = new Login();  
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            if (email != null && !email.trim().equals("")) {
                login.setLogin(email);
            }
            if (senha != null && !senha.trim().equals("")) {
                login.setSenha(senha);
            }
           
            try {
                
            } catch (Exception e) {
            }
            
            return login;
        }
        
        return login;
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("novoLogin.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("novoLogin.jsp");
            }

        } //fim consultar
        rd.forward(request, response);
    }

}
