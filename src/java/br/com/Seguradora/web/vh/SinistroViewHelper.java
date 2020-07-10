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
import br.com.Seguradora.dominio.ClienteTerceiro;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Estado;
import br.com.Seguradora.dominio.Mecanica;
import br.com.Seguradora.dominio.Pessoa;
import br.com.Seguradora.dominio.Sinistro;
import br.com.Seguradora.dominio.Veiculo;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author viniciusamorim
 */
public class SinistroViewHelper implements IViewHelper{
    
    Veiculo veiculo;
    Cliente cliente;
    Apolice apolice;
    Endereco endereco;
    Sinistro sinistro;
    ClienteTerceiro clienteTerceiro;
    Mecanica mecanica;
    Pessoa pessoa;
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String operacao = request.getParameter("operacao");
        if (operacao.equals("SALVAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            endereco = new Endereco();
            sinistro = new Sinistro();
            clienteTerceiro = new ClienteTerceiro();
            
            
            String tipo = request.getParameter("tipo");
            String descricao = request.getParameter("descricao");
            String idCliente = request.getParameter("idCliente");
            String idVeiculo = request.getParameter("idVeiculo");
            String recuperaTipo = request.getParameter("idTipo");
            String idApolice = request.getParameter("idApolice");
            String comprovanteDocumento = request.getParameter("comprovanteDocumento");
            String comprovanteEndereco = request.getParameter("comprovanteEndereco");
            String comprovanteCRVL = request.getParameter("comprovanteCRVL");
            String comprovanteCNH = request.getParameter("comprovanteCNH");
            String comprovanteBO = request.getParameter("comprovanteBO");
            
            // DADOS TERCEIRO
            String nomeTerceiro = request.getParameter("clienteTerceiro");
            String documentoTerceiro = request.getParameter("documentoTerceiro");
            String marcaVeiculoTerceiro = request.getParameter("marcaVeiculoTerceiro");
            String modeloVeiculoTerceiro = request.getParameter("modeloVeiculoTerceiro");
            String placaVeiculoTerceiro = request.getParameter("placa");
            String anoVeiculoFabricacaoTerceiro = request.getParameter("anoFabricacao");
                        
            sinistro.setOperacao(operacao);
            
            if (tipo != null && !tipo.trim().equals("")) {
                sinistro.setTipo(tipo);
            }
            if (descricao != null && !descricao.trim().equals("")) {
                sinistro.setDescricao(descricao);
            }
            if (recuperaTipo != null && !recuperaTipo.trim().equals("")) {
                sinistro.setRecuperaTipo(recuperaTipo);
            }
            if (idCliente != null && !idCliente.trim().equals("")) {
                cliente.setId(Integer.parseInt(idCliente));
            }
            if (idVeiculo != null && !idVeiculo.trim().equals("")) {
                veiculo.setId(Integer.parseInt(idVeiculo));
            }
            if (idApolice != null && !idApolice.trim().equals("")) {
                apolice.setId(Integer.parseInt(idApolice));
            }
            if (nomeTerceiro != null && !nomeTerceiro.trim().equals("")) {                
                clienteTerceiro.setNome(nomeTerceiro);
            }
            if (documentoTerceiro != null && !documentoTerceiro.trim().equals("")) {
                clienteTerceiro.setDocumento(documentoTerceiro);
            }
            if (nomeTerceiro != null && !nomeTerceiro.trim().equals("")) {
                clienteTerceiro.setNome(nomeTerceiro);
            }
            if (marcaVeiculoTerceiro != null && !marcaVeiculoTerceiro.trim().equals("")) {
                veiculo.setMarca(marcaVeiculoTerceiro);                
            }
            if (modeloVeiculoTerceiro != null && !modeloVeiculoTerceiro.trim().equals("")) {
                veiculo.setModelo(modeloVeiculoTerceiro);                
            }
            if (placaVeiculoTerceiro != null && !placaVeiculoTerceiro.trim().equals("")) {
                veiculo.setPlaca(placaVeiculoTerceiro);                
            }
            if (anoVeiculoFabricacaoTerceiro != null && !anoVeiculoFabricacaoTerceiro.trim().equals("")) {
                veiculo.setAnoFabricacao(anoVeiculoFabricacaoTerceiro);
            }
                       
           
            if (comprovanteDocumento != null && !comprovanteDocumento.trim().equals("")) {
                comprovanteDocumento = comprovanteDocumento.replace("C:\\Users\\viniciusamorim\\Desktop\\Seguradora\\web\\", "");
                comprovanteDocumento = comprovanteDocumento.replace("\\","/");
                sinistro.setComprovanteDocumento(comprovanteDocumento);
            }
            if (comprovanteEndereco != null && !comprovanteEndereco.trim().equals("")) {
                comprovanteEndereco = comprovanteEndereco.replace("C:\\Users\\viniciusamorim\\Desktop\\Seguradora\\web\\", "");
                comprovanteEndereco = comprovanteEndereco.replace("\\","/");                
                sinistro.setComprovanteEndereco(comprovanteEndereco);
            }
            if (comprovanteCRVL != null && !comprovanteCRVL.trim().equals("")) {
                comprovanteCRVL = comprovanteCRVL.replace("C:\\Users\\viniciusamorim\\Desktop\\Seguradora\\web\\", "");
                comprovanteCRVL = comprovanteCRVL.replace("\\","/");
                sinistro.setComprovanteCRVL(comprovanteCRVL);
            }
            if (comprovanteCNH != null && !comprovanteCNH.trim().equals("")) {
                comprovanteCNH = comprovanteCNH.replace("C:\\Users\\viniciusamorim\\Desktop\\Seguradora\\web\\", "");
                comprovanteCNH = comprovanteCNH.replace("\\","/");
                sinistro.setComprovanteCNH(comprovanteCNH);
            }
            if (comprovanteBO != null && !comprovanteBO.trim().equals("")) {
                comprovanteBO = comprovanteBO.replace("C:\\Users\\viniciusamorim\\Desktop\\Seguradora\\web\\", "");
                comprovanteBO = comprovanteBO.replace("\\","/");
                sinistro.setComprovanteBO(comprovanteBO);
            }
            clienteTerceiro.setVeiculo(veiculo);
            sinistro.setClienteTerceiro(clienteTerceiro);
            sinistro.setCliente(cliente);     
            sinistro.setVeiculo(veiculo);
            sinistro.setEndereco(endereco);
            sinistro.setApolice(apolice);
            return sinistro;
            
        }
        
        
        if (operacao.equals("CONTINUAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            sinistro = new Sinistro();
            
            String documento = request.getParameter("documento");
            
            sinistro.setOperacao(operacao);
            
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }
                              
            sinistro.setVeiculo(veiculo);
            sinistro.setCliente(cliente);           
            return sinistro;
        }
        
        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            sinistro = new Sinistro();
            if (op != null && !"".equals(op)) {

                sinistro.setId(Integer.parseInt(request.getParameter("id")));

                return sinistro;

            } else {
                sinistro = new Sinistro();

                return sinistro;
            }
        }
        
        if (operacao.equals("LISTARFILTRO")) {
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            sinistro = new Sinistro();
            
            String status = request.getParameter("opStatus");   
            String documento = request.getParameter("documento");
            String placa = request.getParameter("placa");            
            
            if (status.equals("0")) {
                sinistro.setStatus(0);
                
            } else {
                sinistro.setStatus(1);
            }
            
             if (documento != null && !documento.trim().equals("")) {
                cliente.setNome(documento);
            }
            if (placa != null && !placa.trim().equals("")) {
                veiculo.setPlaca(placa);
            }
            
            sinistro.setCliente(cliente);
            sinistro.setVeiculo(veiculo);            
            return sinistro;
            
        }
        
        String uri = request.getRequestURI();
        if (uri.equals("/Seguradora/sinistro/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        if (operacao.equals("EXCLUIR")) {

            sinistro = new Sinistro();
            sinistro.setId(Integer.parseInt(request.getParameter("id")));
            
            sinistro.setOperacao(operacao);
            
            String tipo = request.getParameter("tipo");
            if (tipo != null && !tipo.trim().equals("")) {
                sinistro.setTipo(tipo);
            }
            
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if ("1".equals(status)) {
                    sinistro.setStatus(1);
                }
            }

            return sinistro;

        }
        
        if (operacao.equals("PREATUALIZAR")) {
            sinistro = new Sinistro();
            
            String id = request.getParameter("id");
            
            if (id != null && !id.trim().equals("")) {

                sinistro.setId(Integer.parseInt(id));

                return sinistro;

            } else {

                return sinistro;
            }
        } // PREATUALIZAR
        
        
        if (operacao.equals("SELECIONAR")){
            sinistro = new Sinistro();
            
            
            String idSinistro = request.getParameter("id");
            String motivoRecusa = request.getParameter("motivoRecusa");
            String retorno = request.getParameter("retorno");
            
            sinistro.setOperacao(operacao);
            
            if (idSinistro != null && !idSinistro.trim().equals("")) {
                sinistro.setId(Integer.parseInt(idSinistro));
            }
            
            if (motivoRecusa != null && !motivoRecusa.trim().equals("")) {
                sinistro.setDescricao(motivoRecusa);
            }
            
            if (retorno != null && !retorno.trim().equals("")) {
                sinistro.setAceite(retorno);
            }
                                          
            sinistro.setVeiculo(veiculo);
            sinistro.setCliente(cliente);           
            return sinistro;
        }
        
        if (operacao.equals("ALTERAR")){
            sinistro = new Sinistro();
            endereco = new Endereco();
            mecanica = new Mecanica();
            pessoa = new Pessoa();
            
            String idSinistro = request.getParameter("id");
            String motivoRecusa = request.getParameter("motivoRecusa");
            String retorno = request.getParameter("retorno");
            
            String nomeMecanica = request.getParameter("nomeMecanica");
            String documentoMecanica = request.getParameter("documentoMecanica");
            String telefoneMecanica = request.getParameter("telefoneMecanica");
            String cepMecanica = request.getParameter("cepMecanica");
            String logradouroMecanica = request.getParameter("logradouroMecanica");
            String numeroMecanica = request.getParameter("numeroMecanica");
            String complementoMecanica = request.getParameter("complementoMecanica");
            String bairroMecanica = request.getParameter("bairroMecanica");
            String cidadeMecanica = request.getParameter("cidade");
            String estadoMecanica = request.getParameter("estado");
            
            sinistro.setOperacao(operacao);
            
            if (idSinistro != null && !idSinistro.trim().equals("")) {
                sinistro.setId(Integer.parseInt(idSinistro));
            }            
            if (motivoRecusa != null && !motivoRecusa.trim().equals("")) {
                sinistro.setDescricao(motivoRecusa);
            }            
            if (retorno != null && !retorno.trim().equals("")) {
                sinistro.setAceite(retorno);
            }
            
            // DADOS MECANICA
            if (nomeMecanica != null && !nomeMecanica.trim().equals("")) {
                sinistro.setOperacaoDAO("CADASTRARMECANICA");
                pessoa.setNome(nomeMecanica);                
            }
            else{
                sinistro.setOperacaoDAO("SINISTRORECUSADO");
            }
            if (telefoneMecanica != null && !telefoneMecanica.trim().equals("")) {
                pessoa.setTelefoneComercial(telefoneMecanica);
            }
            if (documentoMecanica != null && !documentoMecanica.trim().equals("")) {
                pessoa.setDocumento(documentoMecanica);
            }
            if (cepMecanica != null && !cepMecanica.trim().equals("")) {
                endereco.setCep(cepMecanica);
            }
            if (logradouroMecanica != null && !logradouroMecanica.trim().equals("")) {
                endereco.setLogradouro(logradouroMecanica);
            }
            if (numeroMecanica != null && !numeroMecanica.trim().equals("")) {
                endereco.setNumero(numeroMecanica);
            }
            if (complementoMecanica != null && !complementoMecanica.trim().equals("")) {
                endereco.setComplemento(complementoMecanica);
            }
            if (bairroMecanica != null && !bairroMecanica.trim().equals("")) {
                endereco.setBairro(bairroMecanica);
            }
            if (cidadeMecanica != null && !cidadeMecanica.trim().equals("")) {                
                endereco.setCidade(new Cidade());
                endereco.getCidade().setCidade(String.valueOf(cidadeMecanica));
            }
            if (estadoMecanica != null && !estadoMecanica.trim().equals("")) {
                endereco.setEstado(new Estado());
                endereco.getEstado().setEstado(String.valueOf(estadoMecanica));                
            }
            
            mecanica.setEndereco(endereco);   
            mecanica.setPessoa(pessoa);
            sinistro.setMecanica(mecanica);
            sinistro.setVeiculo(veiculo);
            sinistro.setCliente(cliente);           
            return sinistro;
        }
        
        return sinistro;
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarSinistro.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaSinistro.jsp");
            }
        }
        
        if (operacao.equals("SELECIONAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarSinistro.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("consultarSinistro.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarSinistro.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("consultarSinistro.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarSinistro.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarSinistro.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarSinistro.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarSinistro.jsp");
            }

        } //fim consultar
        
         if (operacao.equals("CONTINUAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarSinistro.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("cadastrarSinistro.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarSinistro.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                if (sinistro.getRecuperaTipo().equals("Terceiros")){
                    rd = request.getRequestDispatcher("atualizarDeTerceiros.jsp");
                    
                }else if(sinistro.getRecuperaTipo().equals("Colisao")){
                    rd = request.getRequestDispatcher("atualizarColisao.jsp");
                    
                }else if(sinistro.getRecuperaTipo().equals("FurtoRoubo")){
                    rd = request.getRequestDispatcher("atualizarFurtoRoubo.jsp");
                    
                }else if(sinistro.getRecuperaTipo().equals("Incendio")){
                    rd = request.getRequestDispatcher("atualizarIncendio.jsp");
                    
                }else if(sinistro.getRecuperaTipo().equals("CausasNaturais")){
                    rd = request.getRequestDispatcher("atualizarCausaNatural.jsp");
                }
                
            }

        } //fim consultar
        
        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarSinistro.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarSinistro.jsp");
            }
        }

        rd.forward(request, response);
    }
    
    
}
