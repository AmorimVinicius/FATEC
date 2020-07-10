package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Grafico;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viniciusamorim
 */
public class GraficoViewHelper implements IViewHelper{
    
    Grafico grafico;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        if (operacao.equals("LISTARFILTRO")) {
            grafico = new Grafico();  
            String dataInicial = request.getParameter("dataInicial");
            String dataFinal = request.getParameter("dataFinal");
            
            grafico.setOperacao(operacao);            

            if (dataInicial != null && !dataInicial.trim().equals("")) {
                grafico.setDataInicial(dataInicial);
            }
            
            if (dataFinal != null && !dataFinal.trim().equals("")) {
                grafico.setDataFinal(dataFinal);
            }
            
        }
        
        return grafico;
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("selecaoGrafico.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("selecaoGrafico.jsp");
            }

        } //fim consultar
        rd.forward(request, response);
    }

}
