/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.FurtoRoubo;
import br.com.Seguradora.dominio.Incendio;
import br.com.Seguradora.dominio.Sinistro;
import br.com.Seguradora.dominio.Veiculo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viniciusamorim
 */
public class IncendioViewHelper implements IViewHelper{
    
    Incendio incendio;
    Veiculo veiculo;
    Cliente cliente;
    Apolice apolice;
    Endereco endereco;
    Sinistro sinistro;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");
        
        if (operacao.equals("SALVAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            endereco = new Endereco();
            sinistro = new Sinistro();
            incendio = new Incendio();
            
            String descricao = request.getParameter("descricao");
            String idCliente = request.getParameter("idCliente");
            String idVeiculo = request.getParameter("idVeiculo");
            String idSinistro = request.getParameter("idSinistro");
            
            incendio.setOperacao(operacao);
            
            if (descricao != null && !descricao.trim().equals("")) {
                incendio.setDescricao(descricao);
            }
            if (idCliente != null && !idCliente.trim().equals("")) {
                cliente.setId(Integer.parseInt(idCliente));
            }
            if (idVeiculo != null && !idVeiculo.trim().equals("")) {
                veiculo.setId(Integer.parseInt(idVeiculo));
            }
            if (idSinistro != null && !idSinistro.trim().equals("")) {
                sinistro.setId(Integer.parseInt(idSinistro));
            }
            
            
            incendio.setCliente(cliente);
            incendio.setVeiculo(veiculo);
            incendio.setSinistro(sinistro);
            return incendio;
            
        }
        
        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            incendio = new Incendio();
            if (op != null && !"".equals(op)) {

                incendio.setId(Integer.parseInt(request.getParameter("id")));

                return incendio;

            } else {
                incendio = new Incendio();

                return incendio;
            }
        }
        
        
        if (operacao.equals("LISTARFILTRO")) {
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            sinistro = new Sinistro();
            incendio = new Incendio();
            
            String status = request.getParameter("opStatus");   
            String documento = request.getParameter("documento");
            String placa = request.getParameter("placa");  
            
            incendio.setOperacao(operacao);
            
            if (status.equals("0")) {
                incendio.setStatus(0);
                
            } else {
                incendio.setStatus(1);
            }
            
             if (documento != null && !documento.trim().equals("")) {
                cliente.setNome(documento);
            }
            if (placa != null && !placa.trim().equals("")) {
                veiculo.setPlaca(placa);
            }
            
            incendio.setCliente(cliente);
            incendio.setVeiculo(veiculo);            
            return incendio;
            
        }
        
        
         String uri = request.getRequestURI();
        if (uri.equals("/Seguradora/incendio/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        if (operacao.equals("EXCLUIR")) {

            incendio = new Incendio();
            incendio.setId(Integer.parseInt(request.getParameter("id")));
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if ("1".equals(status)) {
                    incendio.setStatus(1);
                }
            }

            return incendio;

        }       
            
        return incendio;
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarIncendio.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaIncendio.jsp");
            }
        }
        
        if (operacao.equals("SELECIONAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarIncendio.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("cadastrarIncendio.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarIncendio.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaIncendio.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarIncendio.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarIncendio.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarIncendio.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarIncendio.jsp");
            }

        } //fim consultar
        
         if (operacao.equals("CONTINUAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarIncendio.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("cadastrarIncendio.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarIncendio.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarIncendio.jsp");
            }

        } //fim consultar
        
        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarIncendio.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarIncendio.jsp");
            }
        }

        rd.forward(request, response);
    }
    
    
}
