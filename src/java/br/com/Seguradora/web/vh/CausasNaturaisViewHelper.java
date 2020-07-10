/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.CausasNaturais;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
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
public class CausasNaturaisViewHelper implements IViewHelper{
    
    Veiculo veiculo;
    Cliente cliente;
    Apolice apolice;
    Endereco endereco;
    Sinistro sinistro;
    CausasNaturais causasNaturais;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String operacao = request.getParameter("operacao");
        
        if (operacao.equals("SALVAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            endereco = new Endereco();
            sinistro = new Sinistro();
            causasNaturais = new CausasNaturais();
            
            String descricao = request.getParameter("descricao");
            String idCliente = request.getParameter("idCliente");
            String idVeiculo = request.getParameter("idVeiculo");
            String idSinistro = request.getParameter("idSinistro");
            
            causasNaturais.setOperacao(operacao);
            
            if (descricao != null && !descricao.trim().equals("")) {
                causasNaturais.setDescricao(descricao);
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
            
            causasNaturais.setCliente(cliente);
            causasNaturais.setVeiculo(veiculo);
            causasNaturais.setSinistro(sinistro);
            return causasNaturais;
           
            
        }
        
        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            causasNaturais = new CausasNaturais();
            causasNaturais.setOperacao(operacao);
            if (op != null && !"".equals(op)) {

                causasNaturais.setId(Integer.parseInt(request.getParameter("id")));

                return causasNaturais;

            } else {
                causasNaturais = new CausasNaturais();

                return causasNaturais;
            }
        }
        
        
        if (operacao.equals("LISTARFILTRO")) {
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            sinistro = new Sinistro();
            causasNaturais = new CausasNaturais();
            
            String status = request.getParameter("opStatus");   
            String documento = request.getParameter("documento");
            String placa = request.getParameter("placa");            
            
            causasNaturais.setOperacao(operacao);
            
            if (status.equals("0")) {
                causasNaturais.setStatus(0);
                
            } else {
                causasNaturais.setStatus(1);
            }
            
             if (documento != null && !documento.trim().equals("")) {
                cliente.setNome(documento);
            }
            if (placa != null && !placa.trim().equals("")) {
                veiculo.setPlaca(placa);
            }
            
            causasNaturais.setCliente(cliente);
            causasNaturais.setVeiculo(veiculo);            
            return causasNaturais;
            
        }
        
        
         String uri = request.getRequestURI();
        if (uri.equals("/Seguradora/causasNaturais/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        if (operacao.equals("EXCLUIR")) {

            causasNaturais = new CausasNaturais();
            causasNaturais.setId(Integer.parseInt(request.getParameter("id")));
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if ("1".equals(status)) {
                    causasNaturais.setStatus(1);
                }
            }

            return causasNaturais;

        }
        
        return causasNaturais;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarCausasNaturais.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCausasNaturais.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarCausasNaturais.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCausasNaturais.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarCausasNaturais.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarCausasNaturais.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarCausasNaturais.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarCausasNaturais.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarCausasNaturais.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarCausasNaturais.jsp");
            }

        } //fim consultar

        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarCausasNaturais.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarCausasNaturais.jsp");
            }
        }

        rd.forward(request, response);
    }

}

