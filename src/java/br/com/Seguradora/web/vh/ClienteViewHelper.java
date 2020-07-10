package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.Cidade;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Estado;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteViewHelper implements IViewHelper{

    //Objetos necessários para cadastrar um Cliente
    Cliente cliente;
    Endereco endereco;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            cliente = new Cliente();            
            endereco = new Endereco();
            String nome = request.getParameter("nome");
            String documento = request.getParameter("documento");
            String email = request.getParameter("email");
            String sexo = request.getParameter("sexo");
            String estadoCivil = request.getParameter("estadoCivil");
            String dataNascimento = request.getParameter("dataNascimento");
            String telefoneComercial = request.getParameter("telefoneComercial");
            String telefoneCelular = request.getParameter("telefoneCelular");
            String infoAdicional = request.getParameter("infoAdicional");
            
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
            
            cliente.setOperacao(operacao);
            

            if (nome != null && !nome.trim().equals("")) {
                cliente.setNome(nome);
            }
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }            
            if (email != null && !email.trim().equals("")) {
                cliente.setEmail(email);
            }
            if (sexo != null && !sexo.trim().equals("")) {
                cliente.setSexo(sexo);
            }
            if (estadoCivil != null && !estadoCivil.trim().equals("")) {
                cliente.setEstadoCivil(estadoCivil);
            }
            if (dataNascimento != null && !dataNascimento.trim().equals("")) {
                cliente.setDataNascimento(dataNascimento);
            }
            if (telefoneComercial != null && !telefoneComercial.trim().equals("")) {
                cliente.setTelefoneComercial(telefoneComercial);
            }
            if (telefoneCelular != null && !telefoneCelular.trim().equals("")) {
                cliente.setTelefoneCelular(telefoneCelular);
            }
            if (infoAdicional != null && !infoAdicional.trim().equals("")) {
                cliente.setInfoAdicional(infoAdicional);
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
            
            cliente.setEndereco(endereco);
            return cliente;
            
        }   

        if (operacao.equals("ALTERAR")) {

            cliente = new Cliente();            
            endereco = new Endereco();
            String nome = request.getParameter("nome");
            String documento = request.getParameter("documento");
            String email = request.getParameter("email");
            String sexo = request.getParameter("sexo");
            String estadoCivil = request.getParameter("estadoCivil");
            String dataNascimento = request.getParameter("dataNascimento");
            String telefoneComercial = request.getParameter("telefoneComercial");
            String telefoneCelular = request.getParameter("telefoneCelular");
            String infoAdicional = request.getParameter("infoAdicional");
            String id = request.getParameter("idCliente");
            
            String cep = request.getParameter("cep");
            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String idEnd = request.getParameter("idEndereco");
            
            cliente.setOperacao(operacao);
            cliente.setId(Integer.parseInt(id));
            endereco.setId(Integer.parseInt(idEnd));
            
            if (nome != null && !nome.trim().equals("")) {
                cliente.setNome(nome);
            }
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }            
            if (email != null && !email.trim().equals("")) {
                cliente.setEmail(email);
            }
            if (sexo != null && !sexo.trim().equals("")) {
                cliente.setSexo(sexo);
            }
            if (estadoCivil != null && !estadoCivil.trim().equals("")) {
                cliente.setEstadoCivil(estadoCivil);
            }
            if (dataNascimento != null && !dataNascimento.trim().equals("")) {
                cliente.setDataNascimento(dataNascimento);
            }
            if (telefoneComercial != null && !telefoneComercial.trim().equals("")) {
                cliente.setTelefoneComercial(telefoneComercial);
            }
            if (telefoneCelular != null && !telefoneCelular.trim().equals("")) {
                cliente.setTelefoneCelular(telefoneCelular);
            }
            if (infoAdicional != null && !infoAdicional.trim().equals("")) {
                cliente.setInfoAdicional(infoAdicional);
            }

            
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
         //       endereco.setCidade(cidade);
            }
            if (estado != null && !estado.trim().equals("")) {
          //      endereco.setEstado(estado);
            }
            
            cliente.setEndereco(endereco);
            return cliente;

        }

        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            cliente = new Cliente();
            if (op != null && !"".equals(op)) {

                cliente.setId(Integer.parseInt(request.getParameter("id")));

                return cliente;

            } else {
                cliente = new Cliente();

                return cliente;
            }
        } // fim consultar

        String uri = request.getRequestURI();
        if (uri.equals("/Seguradora/cliente/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        if (operacao.equals("EXCLUIR")) {

            cliente = new Cliente();
            cliente.setId(Integer.parseInt(request.getParameter("id")));
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if ("1".equals(status)) {
                    cliente.setStatus(1);
                }
            }

            return cliente;

        }// fim excluir (ATIVAR/DESATIVAR)

        if (operacao.equals("LISTARFILTRO")) {

            cliente = new Cliente();
            endereco = new Endereco();

            String status = request.getParameter("opStatus");        
            String nome = request.getParameter("nome");
            String documento = request.getParameter("documento");
            String email = request.getParameter("email");
            String sexo = request.getParameter("sexo");
            String estadoCivil = request.getParameter("estadoCivil");
            String dataNascimento = request.getParameter("dataNascimento");
            String telefoneComercial = request.getParameter("telefoneComercial");
            String telefoneCelular = request.getParameter("telefoneCelular");
            String infoAdicional = request.getParameter("infoAdicional");
            
            String cep = request.getParameter("cep");
            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            

            if (status.equals("0")) {
                cliente.setStatus(0);
                
            } else {
                cliente.setStatus(1);
            }

            if (nome != null && !nome.trim().equals("")) {
                cliente.setNome(nome);
            }
            if (email != null && !email.trim().equals("")) {
                cliente.setEmail(email);
            }            
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }
            if (sexo != null && !sexo.trim().equals("")) {
                cliente.setSexo(sexo);
            }
            if (estadoCivil != null && !estadoCivil.trim().equals("")) {
                cliente.setEstadoCivil(estadoCivil);
            }
            if (dataNascimento != null && !dataNascimento.trim().equals("")) {
                cliente.setDataNascimento(dataNascimento);
            }
            if (telefoneComercial != null && !telefoneComercial.trim().equals("")) {
                cliente.setTelefoneComercial(telefoneComercial);
            }
            if (telefoneCelular != null && !telefoneCelular.trim().equals("")) {
                cliente.setTelefoneCelular(telefoneCelular);
            }
            if (infoAdicional != null && !infoAdicional.trim().equals("")) {
                cliente.setInfoAdicional(infoAdicional);
            }
            
            
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
        //        endereco.setCidade(cidade);
            }
            if (estado != null && !estado.trim().equals("")) {
        //        endereco.setEstado(estado);
            }

            cliente.setEndereco(endereco);
            return cliente;

            }
            

        // fim listar filtro


        if (operacao.equals("PREATUALIZAR")) {
            cliente = new Cliente();

            String id = request.getParameter("id");

            if (id != null && !id.trim().equals("")) {

                cliente.setId(Integer.parseInt(id));

                return cliente;

            } else {

                return cliente;
            }
        } // PREATUALIZAR
        
        
        if (operacao.equals("AUTENTICAR")){          
            cliente = new Cliente();  
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String confirmarSenha = request.getParameter("confirmarSenha");
            
            cliente.setOperacao(operacao);            

            if (email != null && !email.trim().equals("")) {
                cliente.setEmail(email);
            }
            
            if (senha != null && !senha.trim().equals("")) {
                cliente.setSenha(senha);
            }
            
            if (confirmarSenha != null && !confirmarSenha.trim().equals("")) {
                cliente.setConfirmarSenha(confirmarSenha);
            }
            
            return cliente;
            
        }

        return cliente;
}
    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarCliente.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarCliente.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("consultarCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("consultarCliente.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("consultarCliente.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarCliente.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarCliente.jsp");
            }

        } //fim consultar

        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarCliente.jsp");
            }
        }

        rd.forward(request, response);
    }

}
