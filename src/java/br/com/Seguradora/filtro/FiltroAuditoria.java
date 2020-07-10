package br.com.fatecmogidascruzes.filtro;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Esse filtro foi configurado no web.xml.
 */
public class FiltroAuditoria implements Filter {

    private DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.printf("----- Acesso em %s. O computador com IP %s tentou acessar o recurso %s.\n",
                formatador.format(new Date()),
                httpRequest.getRemoteHost(),
                httpRequest.getRequestURL());

        chain.doFilter(request, response);
        
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}
