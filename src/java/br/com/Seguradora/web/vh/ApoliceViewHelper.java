/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.Cidade;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Estado;
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
public class ApoliceViewHelper implements IViewHelper{
    
    Veiculo veiculo;
    Cliente cliente;
    Apolice apolice;
    Endereco endereco;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");
        
         if (operacao.equals("SELECIONAR")){
             apolice = new Apolice();
             endereco = new Endereco();
             String enderecoPrincipal = request.getParameter("enderecoPrincipal");
             if (enderecoPrincipal != null && !enderecoPrincipal.trim().equals("")) {
                endereco.setBairro(enderecoPrincipal);
            }
         }
        
        if (operacao.equals("SALVAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            endereco = new Endereco();
            
            String dataInicio = request.getParameter("hoje");
            String dataFim = request.getParameter("dataFutura");
            String premio = request.getParameter("premioFinal");
            String valorApolice = request.getParameter("franquiaFinal");
            String tipoApolice = request.getParameter("tipoApolice");
            String documento = request.getParameter("documento");
            String idVeiculo = request.getParameter("idVeiculo");
            String idCliente = request.getParameter("idCliente");
            String idEndereco = request.getParameter("idEndereco");
            String idPernoite = request.getParameter("idPernoite");
            String habilitados = request.getParameter("habilitados");
            String valorVeiculo = request.getParameter("valorVeiculo");
            
            // PRIMEIRO ENDERECO
            String cep = request.getParameter("cep");
            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            
            
            // SEGUNDO ENDERECO
            String cepSec = request.getParameter("cepSec");
            String logradouroSec = request.getParameter("logradouroSec");
            String numeroSec = request.getParameter("numeroSec");
            String complementoSec = request.getParameter("complementoSec");
            String bairroSec = request.getParameter("bairroSec");
            String cidadeSec = request.getParameter("cidadeSec");
            String estadoSec = request.getParameter("estadoSec");
            
            apolice.setOperacao(operacao);
            
            if (dataInicio != null && !dataInicio.trim().equals("")) {                
                apolice.setDataInicio(dataInicio);
            }
            if (dataFim != null && !dataFim.trim().equals("")) {
                apolice.setDataFim(dataFim);
            }
            if (premio != null && !premio.trim().equals("")) {
                apolice.setPremio(premio);
            }
            if (valorApolice != null && !valorApolice.trim().equals("")) {
                apolice.setValorApolice(valorApolice);
            }
            if (tipoApolice != null && !tipoApolice.trim().equals("")) {
                apolice.setTipoApolice(tipoApolice);
            }
            if (valorVeiculo != null && !valorVeiculo.trim().equals("")) {
                veiculo.setValorVeiculo(valorVeiculo);
            }
            if (habilitados != null && !habilitados.trim().equals("")) {
                apolice.setHabilitados(habilitados);
            }
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }
            if (idVeiculo != null && !idVeiculo.trim().equals("")) {
                veiculo.setId(Integer.parseInt(idVeiculo));
            }
            if (idCliente != null && !idCliente.trim().equals("")) {
                cliente.setId(Integer.parseInt(idCliente));
            }
            if (idEndereco != null && !idEndereco.trim().equals("")) {
                endereco.setId(Integer.parseInt(idEndereco));
            }
            if (idPernoite != null && !idPernoite.trim().equals("")) {
                endereco.setIdPernoite(Integer.parseInt(idPernoite));
            }
            
            // PRIMEIRO ENDEREÇO
            if (cep != null && !cep.trim().equals("")) {
                apolice.setStatusEnderecoPrincipal("ATIVO");
                endereco.setCep(cep);
            }
            if (logradouro != null && !logradouro.trim().equals("")) {
                endereco.setLogradouro(logradouro);
            }
            if (numero != null && !numero.trim().equals("")) {
                endereco.setNumero(numero);
            }
            if (complemento != null && !complemento.trim().equals("")) {
                endereco.setComplemento(complemento);
            }
            if (bairro != null && !bairro.trim().equals("")) {
                endereco.setBairro(bairro);
            }
            if (cidade != null && !cidade.trim().equals("")) {                
                endereco.setCidade(new Cidade());
                endereco.getCidade().setCidade(String.valueOf(cidade));
            }
            if (estado != null && !estado.trim().equals("")) {
                endereco.setEstado(new Estado());
                endereco.getEstado().setEstado(String.valueOf(estado));                
            }
            
            // SEGUNDO ENDEREÇO
            if (cepSec != null && !cepSec.trim().equals("")) {
                apolice.setStatusEnderecoSecundario("ATIVO");
                endereco.setCepSec(cepSec);
            }
            if (logradouroSec != null && !logradouroSec.trim().equals("")) {
                endereco.setLogradouroSec(logradouroSec);
            }
            if (numeroSec != null && !numeroSec.trim().equals("")) {
                endereco.setNumeroSec(numeroSec);
            }
            if (complementoSec != null && !complementoSec.trim().equals("")) {
                endereco.setComplementoSec(complementoSec);
            }
            if (bairroSec != null && !bairroSec.trim().equals("")) {
                endereco.setBairroSec(bairroSec);
            }
            if (cidadeSec != null && !cidadeSec.trim().equals("")) {                
                endereco.setCidadeSec(new Cidade());
                endereco.getCidadeSec().setCidade(String.valueOf(cidadeSec));
            }
            if (estadoSec != null && !estadoSec.trim().equals("")) {
                endereco.setEstadoSec(new Estado());
                endereco.getEstadoSec().setEstado(String.valueOf(estadoSec));                
            }
                        
            apolice.setCliente(cliente);     
            apolice.setVeiculo(veiculo);
            apolice.setEndereco(endereco);
            return apolice;
            
        }
        
        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            apolice = new Apolice();
            if (op != null && !"".equals(op)) {

                apolice.setId(Integer.parseInt(request.getParameter("id")));

                return apolice;

            } else {
                apolice = new Apolice();

                return apolice;
            }
        }
        
        if (operacao.equals("LISTARFILTRO")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            
            String dataInicio = request.getParameter("dataInicio");
            String dataFim = request.getParameter("dataFim");
            String premio = request.getParameter("premio");
            String valorApolice = request.getParameter("valorApolice");
            String tipoApolice = request.getParameter("tipoApolice");
            String habilitados = request.getParameter("habilitados");
            String documento = request.getParameter("documento");
            String placa = request.getParameter("placa");
            
            apolice.setOperacao(operacao);
            
            if (dataInicio != null && !dataInicio.trim().equals("")) {
                apolice.setDataInicio(dataInicio);
            }
            if (dataFim != null && !dataFim.trim().equals("")) {
                apolice.setDataFim(dataFim);
            }
            if (premio != null && !premio.trim().equals("")) {
                apolice.setPremio(premio);
            }
            if (valorApolice != null && !valorApolice.trim().equals("")) {
                apolice.setValorApolice(valorApolice);
            }
            if (habilitados != null && !habilitados.trim().equals("")) {
                apolice.setHabilitados(habilitados);
            }
            if (tipoApolice != null && !tipoApolice.trim().equals("")) {
                apolice.setTipoApolice(tipoApolice);
            }
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }
            if (placa != null && !placa.trim().equals("")) {
                veiculo.setPlaca(placa);
            }
            
            
            apolice.setCliente(cliente);  
            apolice.setVeiculo(veiculo);
            return apolice;
            
        }
        
        if (operacao.equals("CONTINUAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            endereco = new Endereco();
            
            String placa = request.getParameter("placa");
            String chassi = request.getParameter("chassi");
                        
            apolice.setOperacao(operacao);
            
            if (placa != null && !placa.trim().equals("")) {
                veiculo.setPlaca(placa);
            }
            if (chassi != null && !chassi.trim().equals("")) {
                veiculo.setChassi(chassi);
            }
                  
            apolice.setVeiculo(veiculo);
            apolice.setCliente(cliente);           
            return apolice;
            
        }
        
        String uri = request.getRequestURI();
        if (uri.equals("/Seguradora/apolice/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        
        if (operacao.equals("EXCLUIR")) {

            apolice = new Apolice();
            veiculo = new Veiculo();
            
            apolice.setId(Integer.parseInt(request.getParameter("id")));
            veiculo.setId(Integer.parseInt(request.getParameter("veiculo")));
            
            apolice.setOperacao(operacao);
            
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if ("1".equals(status)) {
                    apolice.setStatus(1);
                }
            }
            
            apolice.setVeiculo(veiculo);
            return apolice;

        }
        
        if (operacao.equals("PREATUALIZAR")) {
            apolice = new Apolice();
            cliente = new Cliente();

            String id = request.getParameter("id");
            String documento = request.getParameter("documentoCliente");
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }

            if (id != null && !id.trim().equals("")) {

                apolice.setId(Integer.parseInt(id));

                apolice.setCliente(cliente);
                return apolice;

            } else {

                apolice.setCliente(cliente);
                return apolice;
            }
        } // PREATUALIZAR
        
        if (operacao.equals("ALTERAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            
            String dataInicio = request.getParameter("dataInicio");
            String dataFim = request.getParameter("dataFim");
            String premio = request.getParameter("premio");
            String valorApolice = request.getParameter("valorApolice");
            String tipoApolice = request.getParameter("tipoApolice");
            String documento = request.getParameter("documento");
            String id = request.getParameter("idApolice");
            String idVeiculo = request.getParameter("idVeiculo");
            
            apolice.setOperacao(operacao);
            apolice.setId(Integer.parseInt(id));
            
            if (dataInicio != null && !dataInicio.trim().equals("")) {
                apolice.setDataInicio(dataInicio);
            }
            if (dataFim != null && !dataFim.trim().equals("")) {
                apolice.setDataFim(dataFim);
            }
            if (premio != null && !premio.trim().equals("")) {
                apolice.setPremio(premio);
            }
            if (valorApolice != null && !valorApolice.trim().equals("")) {
                apolice.setValorApolice(valorApolice);
            }
            if (tipoApolice != null && !tipoApolice.trim().equals("")) {
                apolice.setTipoApolice(tipoApolice);
            }
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }
            if (idVeiculo != null && !idVeiculo.trim().equals("")) {
                veiculo.setId(Integer.parseInt(idVeiculo));
            }
            
            apolice.setVeiculo(veiculo);
            apolice.setCliente(cliente);           
            return apolice;
        }
        
        return apolice;
        
        
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarApolice.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaApolice.jsp");
            }
        }
        
        if (operacao.equals("SELECIONAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarApolice.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("cadastrarApolice.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarApolice.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaApolice.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarApolice.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarApolice.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarApolice.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarApolice.jsp");
            }

        } //fim consultar
        
         if (operacao.equals("CONTINUAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarApolice.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("cadastrarApolice.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarApolice.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarApolice.jsp");
            }

        } //fim consultar
        
        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarApolice.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarApolice.jsp");
            }
        }

        rd.forward(request, response);
    }
    
}
