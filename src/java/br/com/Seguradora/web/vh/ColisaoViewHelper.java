/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.Colisao;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
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
public class ColisaoViewHelper implements IViewHelper{

    Incendio incendio;
    Veiculo veiculo;
    Cliente cliente;
    Apolice apolice;
    Endereco endereco;
    Sinistro sinistro;
    Colisao colisao;
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String operacao = request.getParameter("operacao");
        
        if (operacao.equals("SALVAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            endereco = new Endereco();
            sinistro = new Sinistro();
            colisao = new Colisao();
            
            String descricao = request.getParameter("descricao");
            String idCliente = request.getParameter("idCliente");
            String idVeiculo = request.getParameter("idVeiculo");
            String idSinistro = request.getParameter("idSinistro");
            
            colisao.setOperacao(operacao);
            
            if (descricao != null && !descricao.trim().equals("")) {
                colisao.setDescricao(descricao);
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
            
            
            colisao.setCliente(cliente);
            colisao.setVeiculo(veiculo);
            colisao.setSinistro(sinistro);
            return colisao;
            
        }
        
        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            colisao = new Colisao();
            if (op != null && !"".equals(op)) {

                colisao.setId(Integer.parseInt(request.getParameter("id")));

                return colisao;

            } else {
                colisao = new Colisao();

                return colisao;
            }
        }
        
        
        if (operacao.equals("LISTARFILTRO")) {
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            sinistro = new Sinistro();
            colisao = new Colisao();            
            
            String status = request.getParameter("opStatus");   
            String documento = request.getParameter("documento");
            String placa = request.getParameter("placa");          
            
            colisao.setOperacao(operacao);
            
            if (status.equals("0")) {
                colisao.setStatus(0);
                
            } else {
                colisao.setStatus(1);
            }
            
             if (documento != null && !documento.trim().equals("")) {
                cliente.setNome(documento);
            }
            if (placa != null && !placa.trim().equals("")) {
                veiculo.setPlaca(placa);
            }
            
            colisao.setCliente(cliente);
            colisao.setVeiculo(veiculo);            
            return colisao;
            
        }
        
        
         String uri = request.getRequestURI();
        if (uri.equals("/Seguradora/colisao/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        if (operacao.equals("EXCLUIR")) {

            colisao = new Colisao();
            colisao.setId(Integer.parseInt(request.getParameter("id")));
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if ("1".equals(status)) {
                    colisao.setStatus(1);
                }
            }

            return colisao;

        }       
            
        return colisao;
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarColisao.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaColisao.jsp");
            }
        }
        
        if (operacao.equals("SELECIONAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarColisao.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("cadastrarColisao.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarColisao.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaColisao.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarColisao.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarColisao.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarColisao.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarColisao.jsp");
            }

        } //fim consultar
        
         if (operacao.equals("CONTINUAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarColisao.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("cadastrarColisao.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarColisao.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarColisao.jsp");
            }

        } //fim consultar
        
        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarColisao.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarColisao.jsp");
            }
        }

        rd.forward(request, response);
    }
    
    
}
