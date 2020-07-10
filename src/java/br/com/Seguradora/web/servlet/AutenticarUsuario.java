package br.com.Seguradora.web.servlet;

import br.com.Seguradora.core.dao.ClienteDAO;
import br.com.Seguradora.core.dao.LoginDAO;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.Login;
import br.com.Seguradora.excecao.ExcecaoAcessoDados;
import br.com.Seguradora.excecao.ExcecaoLimiteTentativas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutenticarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Cliente cliente = new Cliente();
        cliente.setEmail(email);
        cliente.setSenha(senha);
        
        if (null != request.getParameter("acessar")){
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente encontradoNoBanco = clienteDAO.autenticar(cliente);
            if (null != encontradoNoBanco){
                request.setAttribute("usuarioLogado", encontradoNoBanco);
                
                if (null != request.getParameter("lembrarme"));
                Cookie cookie = new Cookie("lembrarme", String.valueOf(encontradoNoBanco.getId()));
                cookie.setMaxAge(60 * 60 * 24 * 365);
                response.addCookie(cookie);
                
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", encontradoNoBanco);
                request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "Atenção! Usuário ou senha inválidos");
                request.getRequestDispatcher("/login/login.jsp").forward(request, response);
            }        
        }
    }
}
