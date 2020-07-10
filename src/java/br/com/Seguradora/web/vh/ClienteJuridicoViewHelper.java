/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author viniciusamorim
 */
public class ClienteJuridicoViewHelper implements IViewHelper{
    public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		ClienteJuridico clienteJuridico = null; 
                Endereco endereco = null;
                
		if(!operacao.equals("VISUALIZAR")){

			String id = request.getParameter("id");
                        String razaoSocial = request.getParameter("razaoSocial");
			String cnpj = request.getParameter("cnpj");
			String email = request.getParameter("email");
                        String telefoneComercial = request.getParameter("telefoneComercial");
                        String telefoneCelular = request.getParameter("telefoneCelular");
                        String pessoaResponsavel = request.getParameter("pessoaResponsavel");
                        String infoAdicional = request.getParameter("infoAdicional");
                        String cep = request.getParameter("cep");                      
		
			clienteJuridico = new ClienteJuridico();
			
                        if(id != null && !id.trim().equals("")){
				clienteJuridico.setId(Integer.parseInt(id));
			}
                        
                        if(razaoSocial != null && !razaoSocial.trim().equals("")){
				clienteJuridico.setNome(razaoSocial);
			}
                        
                        if(cnpj != null && !cnpj.trim().equals("")){
				clienteJuridico.setCnpj(cnpj);
			}
                        
                        if(email != null && !email.trim().equals("")){
				clienteJuridico.setEmail(email);
			}
                        
                        if(telefoneComercial != null && !telefoneComercial.trim().equals("")){
				clienteJuridico.setTelefoneComercial(telefoneComercial);
			}
                        
                        if(telefoneCelular != null && !telefoneCelular.trim().equals("")){
				clienteJuridico.setTelefoneCelular(telefoneCelular);
			}
                        
                        if(pessoaResponsavel != null && !pessoaResponsavel.trim().equals("")){
				clienteJuridico.setPessoaResponsavel(pessoaResponsavel);
			}
                        
                        if(infoAdicional != null && !infoAdicional.trim().equals("")){
				clienteJuridico.setInfoAdicional(infoAdicional);
			}
                        
                        // DADOS ENDERECO
                        if(cep != null && !cep.trim().equals("")){
                            endereco.setCep(cep);                                
			}
                        
                        
                        
		}else{
			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			String txtId = request.getParameter("id");
			int id=0;
			
			if(txtId != null && !txtId.trim().equals("")){
				id = Integer.parseInt(txtId);
			}
			
			for(EntidadeDominio e: resultado.getEntidades()){
				if(e.getId() == id){
                                    clienteJuridico = (ClienteJuridico)e;
				}
			}
		}
              
		
            return clienteJuridico;
	}

	
	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response)  throws IOException, ServletException {
		RequestDispatcher d=null;
		
		String operacao = request.getParameter("operacao");
		
		if(resultado.getMsg() == null){
			if(operacao.equals("SALVAR")){
				resultado.setMsg("Cliente Jurídico cadastrado com sucesso!");
			}
			
			request.getSession().setAttribute("resultado", resultado);
			d= request.getRequestDispatcher("consultarClienteJuridico.jsp");  			
		}
		
		if(resultado.getMsg() == null && operacao.equals("ALTERAR")){
			
			d= request.getRequestDispatcher("consultarClienteJuridico.jsp"); 
                        resultado.setMsg("Cliente Jurídico alterado com sucesso!");
		}
		
		if(resultado.getMsg() == null && operacao.equals("VISUALIZAR")){
			
			request.setAttribute("clienteJuridico", resultado.getEntidades().get(0));
			d= request.getRequestDispatcher("salvarClienteJuridico.jsp");  			
		}
                
                
		if(resultado.getMsg() == null && operacao.equals("EXCLUIR")){
			
			request.getSession().setAttribute("resultado", null);
			d= request.getRequestDispatcher("consultarClienteJuridico.jsp"); 
                        resultado.setMsg("Registro excluído com sucesso!");
		}
                          
		
		if(resultado.getMsg() != null){
			if(operacao.equals("SALVAR") || operacao.equals("ALTERAR")){
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("consultarClienteJuridico.jsp");  	
			}
		}
		
		d.forward(request,response); 
		
	}
}


