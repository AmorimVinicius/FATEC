/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.Cidade;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.Corretor;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Estado;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viniciusamorim
 */
public class CorretorViewHelper implements IViewHelper{

    //Objetos necessários para cadastrar um Corretor
    Corretor corretor;
    Endereco endereco;    
    Cliente cliente;
    Estado tipoEstado;
    Cidade tipoCidade;
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
             //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            corretor = new Corretor();            
            endereco = new Endereco();
            cliente = new Cliente(); 
            tipoEstado = new Estado();
            tipoCidade = new Cidade();
            
            String nome = request.getParameter("nomeFantasia");
            String razaoSocial = request.getParameter("razaoSocial");
            String email = request.getParameter("email");
            String documento = request.getParameter("documento");
            String telefoneComercial = request.getParameter("telefoneComercial");
            String telefoneCelular = request.getParameter("telefoneCelular");
            String pessoaResponsavel = request.getParameter("pessoaResponsavel");
            String infoAdicional = request.getParameter("infoAdicional");
            String documentoCliente = request.getParameter("clienteAssociado");

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
            
            
            corretor.setOperacao(operacao);                                   
                     
            if (nome != null && !nome.trim().equals("")) {
                corretor.setNome(nome);
            }
            if (razaoSocial != null && !razaoSocial.trim().equals("")) {
                corretor.setRazaoSocial(razaoSocial);
            }
            if (email != null && !email.trim().equals("")) {
                corretor.setEmail(email);
            }
            if (documento != null && !documento.trim().equals("")) {
                corretor.setDocumento(documento);
            }
            if (telefoneComercial != null && !telefoneComercial.trim().equals("")) {
                corretor.setTelefoneComercial(telefoneComercial);
            }
            if (telefoneCelular != null && !telefoneCelular.trim().equals("")) {
                corretor.setTelefoneCelular(telefoneCelular);
            }
            if (pessoaResponsavel != null && !pessoaResponsavel.trim().equals("")) {
                corretor.setPessoaResponsavel(pessoaResponsavel);
            }
            if (infoAdicional != null && !infoAdicional.trim().equals("")) {
                corretor.setInfoAdicional(infoAdicional);
            }
            if (documentoCliente != null && !documentoCliente.trim().equals("")) {
                cliente.setDocumento(documentoCliente);
            }

            // PRIMEIRO ENDEREÇO
            if (cep != null && !cep.trim().equals("")) {
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
                        
            corretor.setEndereco(endereco);
            corretor.setCidade(tipoCidade);
            corretor.setEstado(tipoEstado);
            corretor.setCliente(cliente);            
            return corretor;
        }
        
        
        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            corretor = new Corretor();
            if (op != null && !"".equals(op)) {

                corretor.setId(Integer.parseInt(request.getParameter("id")));

                return corretor;

            } else {
                corretor = new Corretor();

                return corretor;
            }
        } // fim consultar
        
        
        if (operacao.equals("LISTARFILTRO")) {

            corretor = new Corretor();
            endereco = new Endereco();
            cliente = new Cliente();
            
            String status = request.getParameter("opStatus");   
            String nome = request.getParameter("nomeFantasia");
            String razaoSocial = request.getParameter("razaoSocial");
            String email = request.getParameter("email");
            String documento = request.getParameter("documento");
            String telefoneComercial = request.getParameter("telefoneComercial");
            String telefoneCelular = request.getParameter("telefoneCelular");
            String pessoaResponsavel = request.getParameter("pessoaResponsavel");
            String infoAdicional = request.getParameter("infoAdicional");
            //String documentoCliente = request.getParameter("clienteAssociado");
            /*
            String cep = request.getParameter("cep");
            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            
*/
            if (status.equals("0")) {
                corretor.setStatus(0);
                
            } else {
                corretor.setStatus(1);
            }

            if (nome != null && !nome.trim().equals("")) {
                corretor.setNome(nome);
            }
            if (razaoSocial != null && !razaoSocial.trim().equals("")) {
                corretor.setRazaoSocial(razaoSocial);
            }
            if (email != null && !email.trim().equals("")) {
                corretor.setEmail(email);
            }
            if (documento != null && !documento.trim().equals("")) {
                corretor.setDocumento(documento);
            }
            if (telefoneComercial != null && !telefoneComercial.trim().equals("")) {
                corretor.setTelefoneComercial(telefoneComercial);
            }
            if (telefoneCelular != null && !telefoneCelular.trim().equals("")) {
                corretor.setTelefoneCelular(telefoneCelular);
            }
            if (pessoaResponsavel != null && !pessoaResponsavel.trim().equals("")) {
                corretor.setPessoaResponsavel(pessoaResponsavel);
            }
            if (infoAdicional != null && !infoAdicional.trim().equals("")) {
                corretor.setInfoAdicional(infoAdicional);
            }
            //if (documentoCliente != null && !documentoCliente.trim().equals("")) {
            //    cliente.setDocumento(documentoCliente);
            //}

            // PRIMEIRO ENDEREÇO
            /*
            if (cep != null && !cep.trim().equals("")) {
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
                cidadeClass = new Cidade();
                cidadeClass.setCidade(cidade);
                endereco.setCidade(cidadeClass);
            }else{
                cidadeClass = new Cidade();
                cidadeClass.setCidade(null);
                endereco.setCidade(cidadeClass);
            }
            if (estado != null && !estado.trim().equals("")) {
                estadoClass = new Estado();
                estadoClass.setEstado(estado);
                endereco.setEstado(estadoClass);
            }else{
                estadoClass = new Estado();
                estadoClass.setEstado(null);
                endereco.setEstado(estadoClass);
            }
            */
            corretor.setEndereco(endereco);
            corretor.setCliente(cliente);            
            return corretor;

        }
        
        String uri = request.getRequestURI();
        if (uri.equals("/Seguradora/corretor/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        if (operacao.equals("EXCLUIR")) {

            corretor = new Corretor();
            corretor.setId(Integer.parseInt(request.getParameter("id")));
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if ("1".equals(status)) {
                    corretor.setStatus(1);
                }
            }

            return corretor;

        }// fim excluir (ATIVAR/DESATIVAR)
        
        
        
        if (operacao.equals("PREATUALIZAR")) {
            corretor = new Corretor();

            String id = request.getParameter("id");

            if (id != null && !id.trim().equals("")) {

                corretor.setId(Integer.parseInt(id));

                return corretor;

            } else {

                return corretor;
            }
        } // PREATUALIZAR
        
        if (operacao.equals("ALTERAR")) {
            
            corretor = new Corretor();            
            endereco = new Endereco();
            cliente = new Cliente();
            
            
            String nome = request.getParameter("nomeFantasia");
            String razaoSocial = request.getParameter("razaoSocial");
            String email = request.getParameter("email");
            String documento = request.getParameter("documento");
            String telefoneComercial = request.getParameter("telefoneComercial");
            String telefoneCelular = request.getParameter("telefoneCelular");
            String pessoaResponsavel = request.getParameter("pessoaResponsavel");
            String infoAdicional = request.getParameter("infoAdicional");
            String documentoCliente = request.getParameter("clienteAssociado");
            String id = request.getParameter("idCorretor");

            String cep = request.getParameter("cep");
            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String idEnd = request.getParameter("idEndereco");
            
            String cepSec = request.getParameter("cepSec");
            String logradouroSec = request.getParameter("logradouroSec");
            String numeroSec = request.getParameter("numeroSec");
            String complementoSec = request.getParameter("complementoSec");
            String bairroSec = request.getParameter("bairroSec");
            String cidadeSec = request.getParameter("cidadeSec");
            String estadoSec = request.getParameter("estadoSec");
            
            corretor.setOperacao(operacao);
            corretor.setId(Integer.parseInt(id));
            endereco.setId(Integer.parseInt(idEnd));
            
            if (nome != null && !nome.trim().equals("")) {
                corretor.setNome(nome);
            }
            if (razaoSocial != null && !razaoSocial.trim().equals("")) {
                corretor.setRazaoSocial(razaoSocial);
            }
            if (email != null && !email.trim().equals("")) {
                corretor.setEmail(email);
            }
            if (documento != null && !documento.trim().equals("")) {
                corretor.setDocumento(documento);
            }
            if (telefoneComercial != null && !telefoneComercial.trim().equals("")) {
                corretor.setTelefoneComercial(telefoneComercial);
            }
            if (telefoneCelular != null && !telefoneCelular.trim().equals("")) {
                corretor.setTelefoneCelular(telefoneCelular);
            }
            if (pessoaResponsavel != null && !pessoaResponsavel.trim().equals("")) {
                corretor.setPessoaResponsavel(pessoaResponsavel);
            }
            if (infoAdicional != null && !infoAdicional.trim().equals("")) {
                corretor.setInfoAdicional(infoAdicional);
            }
            if (documentoCliente != null && !documentoCliente.trim().equals("")) {
                cliente.setDocumento(documentoCliente);
            }

            // PRIMEIRO ENDEREÇO
            if (cep != null && !cep.trim().equals("")) {
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
            
           /*
            // SEGUNDO ENDEREÇO
            if (cepSec != null && !cepSec.trim().equals("")) {
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
                endereco.setCidadeSec(cidadeSec);
            }
            if (estadoSec != null && !estadoSec.trim().equals("")) {
                endereco.setEstadoSec(estadoSec);
            }*/
            
            corretor.setEndereco(endereco);
            corretor.setCliente(cliente);            
            
            return corretor;
        }
        
            return corretor;
   
    }
    

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarCorretor.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCorretor.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarCorretor.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCorretor.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarCorretor.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarCorretor.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarCorretor.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarCorretor.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarCorretor.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarCorretor.jsp");
            }

        } //fim consultar

        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarCorretor.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarCorretor.jsp");
            }
        }

        rd.forward(request, response);
    }

}
