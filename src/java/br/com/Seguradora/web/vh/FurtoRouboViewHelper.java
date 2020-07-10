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
public class FurtoRouboViewHelper implements IViewHelper{
    
    Veiculo veiculo;
    Cliente cliente;
    Apolice apolice;
    Endereco endereco;
    Sinistro sinistro;
    FurtoRoubo furtoRoubo;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String operacao = request.getParameter("operacao");
        
        if (operacao.equals("SALVAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            endereco = new Endereco();
            sinistro = new Sinistro();
            furtoRoubo = new FurtoRoubo();
            
            String descricao = request.getParameter("descricao");
            String idCliente = request.getParameter("idCliente");
            String idVeiculo = request.getParameter("idVeiculo");
            String idSinistro = request.getParameter("idSinistro");
            
            furtoRoubo.setOperacao(operacao);
            
            if (descricao != null && !descricao.trim().equals("")) {
                furtoRoubo.setDescricao(descricao);
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
            
            furtoRoubo.setCliente(cliente);
            furtoRoubo.setVeiculo(veiculo);
            furtoRoubo.setSinistro(sinistro);
            return furtoRoubo;
           
            
        }
        
        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            furtoRoubo = new FurtoRoubo();
            furtoRoubo.setOperacao(operacao);
            
            if (op != null && !"".equals(op)) {

                furtoRoubo.setId(Integer.parseInt(request.getParameter("id")));

                return furtoRoubo;

            } else {
                furtoRoubo = new FurtoRoubo();

                return furtoRoubo;
            }
        }
        
        
        if (operacao.equals("LISTARFILTRO")) {
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            sinistro = new Sinistro();
            furtoRoubo = new FurtoRoubo();
            
            String status = request.getParameter("opStatus");   
            String documento = request.getParameter("documento");
            String placa = request.getParameter("placa");            
            
            furtoRoubo.setOperacao(operacao);
            
            if (status.equals("0")) {
                furtoRoubo.setStatus(0);
                
            } else {
                furtoRoubo.setStatus(1);
            }
            
             if (documento != null && !documento.trim().equals("")) {
                cliente.setNome(documento);
            }
            if (placa != null && !placa.trim().equals("")) {
                veiculo.setPlaca(placa);
            }
            
            furtoRoubo.setCliente(cliente);
            furtoRoubo.setVeiculo(veiculo);            
            return furtoRoubo;
            
        }
        
        
         String uri = request.getRequestURI();
        if (uri.equals("/Seguradora/furtoRoubo/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        if (operacao.equals("EXCLUIR")) {

            furtoRoubo = new FurtoRoubo();
            furtoRoubo.setId(Integer.parseInt(request.getParameter("id")));
            furtoRoubo.setOperacao(operacao);
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if ("1".equals(status)) {
                    furtoRoubo.setStatus(1);
                }
            }

            return furtoRoubo;

        }
        
        return furtoRoubo;
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarFurtoRoubo.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaFurtoRoubo.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarFurtoRoubo.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaFurtoRoubo.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarFurtoRoubo.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarFurtoRoubo.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarFurtoRoubo.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarFurtoRoubo.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarFurtoRoubo.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarFurtoRoubo.jsp");
            }

        } //fim consultar

        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarFurtoRoubo.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarFurtoRoubo.jsp");
            }
        }

        rd.forward(request, response);
    }

}
    

