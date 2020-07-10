/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.filtro;

import br.com.Seguradora.dominio.Cliente;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author viniciusamorim
 */
public class FiltroAutorizacao implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
      
        if(httpRequest.getRequestURL().toString().endsWith("/admin/index.jsp")) {
            chain.doFilter(request, response);
        }
        
        Cliente cliente = (Cliente) httpRequest.getSession().getAttribute("usuarioLogado");
        if (null != cliente && cliente.getPapel().equals("cliente")) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/login/login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }
}
