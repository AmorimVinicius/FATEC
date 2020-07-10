package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Mecanica;
import br.com.Seguradora.dominio.Pessoa;
import br.com.Seguradora.dominio.Sinistro;
import br.com.Seguradora.dominio.Veiculo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MecanicaViewHelper implements IViewHelper{

    Mecanica mecanica;
    Cliente cliente;
    Veiculo veiculo;
    Sinistro sinistro;
    Pessoa pessoa;
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");
        
        if (operacao.equals("SALVAR")){
            mecanica = new Mecanica();
            cliente = new Cliente();
            veiculo = new Veiculo();
            sinistro = new Sinistro();
            
            mecanica.setOperacao(operacao);
            
            String dataEntrada = request.getParameter("dataEntrada");
            String dataSaida = request.getParameter("dataSaida");
            String idSinistro = request.getParameter("idSinistro");
            
            if (dataEntrada != null && !dataEntrada.trim().equals("")) {
                mecanica.setDataEntrada(dataEntrada);
            }
            if (dataSaida != null && !dataSaida.trim().equals("")) {
                mecanica.setDataSaida(dataSaida);
            }
            if (idSinistro != null && !idSinistro.trim().equals("")) {
                sinistro.setId(Integer.parseInt(idSinistro));
            }
            
            mecanica.setSinistro(sinistro);
            return mecanica;
        }
        
        if (operacao.equals("LISTARFILTRO")){
            mecanica = new Mecanica();
            cliente = new Cliente();
            veiculo = new Veiculo();
            sinistro = new Sinistro();
            pessoa = new Pessoa();
            
            String documento = request.getParameter("documento");
            
            mecanica.setOperacao(operacao);
            
            if (documento != null && !documento.trim().equals("")) {
                pessoa.setDocumento(documento);
            }
            
            mecanica.setPessoa(pessoa);
            return mecanica;
            
        }
        
        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            mecanica = new Mecanica();
            if (op != null && !"".equals(op)) {

                mecanica.setId(Integer.parseInt(request.getParameter("id")));

                return mecanica;

            } else {
                mecanica = new Mecanica();

                return mecanica;
            }
        }
        
        
        if (operacao.equals("ALTERAR")){
            mecanica = new Mecanica();
            cliente = new Cliente();
            veiculo = new Veiculo();
            sinistro = new Sinistro();
            
            mecanica.setOperacao(operacao);
            
            String dataEntrada = request.getParameter("dataEntrada");
            String dataSaida = request.getParameter("dataSaida");
            String idSinistro = request.getParameter("idSinistro");
            
            if (dataEntrada != null && !dataEntrada.trim().equals("")) {
                mecanica.setDataEntrada(dataEntrada);
                mecanica.setOperacaoDAO("ENTRADA");
            }
            if (dataSaida != null && !dataSaida.trim().equals("")) {
                mecanica.setDataSaida(dataSaida);
                mecanica.setOperacaoDAO("SAIDA");
            }
            if (idSinistro != null && !idSinistro.trim().equals("")) {
                sinistro.setId(Integer.parseInt(idSinistro));
            }
            
            mecanica.setSinistro(sinistro);
            return mecanica;
        }
            
        return mecanica;
    
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarVeiculo.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaVeiculo.jsp");
            }
        }
        
        if (operacao.equals("SELECIONAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarIncendio.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("cadastrarVeiculo.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarVeiculo.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaVeiculo.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarVeiculo.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarVeiculo.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarVeiculo.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarVeiculo.jsp");
            }

        } //fim consultar
        
         if (operacao.equals("CONTINUAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarVeiculo.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("cadastrarVeiculo.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarVeiculo.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarVeiculo.jsp");
            }

        } //fim consultar
        
        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarVeiculo.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarVeiculo.jsp");
            }
        }

        rd.forward(request, response);
    }
        
}
