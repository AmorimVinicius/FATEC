<%@page import="br.com.Seguradora.core.util.ConverteDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page 
    import="br.com.Seguradora.core.fachada.Resultado, br.com.Seguradora.dominio.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>::: CONSULTAR JURÍDICO :::</title>
</head>
<body>

	<%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
	%>

	<form action="salvar" method="post">
        	<label for="id">Id:</label> 
                <input type="text" id="id" name="id" /> 
                </br> 
		<label for="cnpj">CNPJ: </label> 
                <input type="text" id="cnpj" name="cnpj" /> 
                
                <input type="submit" id="operacao" name="operacao" value="CONSULTAR" />       
	</form>

	


	<%
	
	if(resultado !=null && resultado.getMsg() != null){
		out.print(resultado.getMsg());               
	}
	
	%>
<BR>

<TABLE BORDER="5"    WIDTH="50%"   CELLPADDING="4" CELLSPACING="3">
   <TR>
      <TH COLSPAN="13"><BR>
            <H3>CLIENTES JURÍDICOS</H3>
      </TH>
   </TR>
   
   <TR>
      <TH>Cód Cliente Jurídico</TH>
      <TH>Razão Social</TH>
      <TH>CNPJ</TH>
      <TH>E-mail</TH>
      <TH>Telefone Comercial</TH>
      <TH>Telefone Celular</TH>
      <TH>Pessoa Responsável</TH>
      <TH>Observação</TH>
      <TH>Código Endereço</TH>
      <TH>Cód Endereço</TH>
      <TH>CEP</TH>
      <TH></TH>
   </TR>
   
   
   <%
   
   if (resultado != null) {
		List<EntidadeDominio> entidades = resultado.getEntidades();
		StringBuilder sbRegistro = new StringBuilder();
		StringBuilder sbLink = new StringBuilder();
		
		
		if(entidades != null){
			for (int i = 0; i < entidades.size(); i++) {
				ClienteJuridico cj = (ClienteJuridico) entidades.get(i);
                                Endereco end = (Endereco) entidades.get(i);
				sbRegistro.setLength(0);
				sbLink.setLength(0);
				
			//	<a href="nome-do-lugar-a-ser-levado">descrição</a>
				
				sbRegistro.append("<TR ALIGN='CENTER'>");
				
				
				sbLink.append("<a href=salvar?");
					sbLink.append("id=");
					sbLink.append(cj.getId());						
					sbLink.append("&");
					sbLink.append("operacao=");
					sbLink.append("VISUALIZAR");
					
				sbLink.append(">");
				
                                
                                sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());	
				sbRegistro.append(cj.getId());
				sbRegistro.append("</a>");                               
				sbRegistro.append("</TD>");
                                
                                sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());	
				sbRegistro.append(cj.getNome());
				sbRegistro.append("</a>");                               
				sbRegistro.append("</TD>");
                                
                                sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());	
				sbRegistro.append(cj.getCnpj());
				sbRegistro.append("</a>");                               
				sbRegistro.append("</TD>");
                                
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());	
				sbRegistro.append(cj.getEmail());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(cj.getTelefoneComercial());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(cj.getTelefoneCelular());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
                                sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(cj.getPessoaResponsavel());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
                                
                                sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(cj.getInfoAdicional());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
                                
                                sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(end.getId());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
                                
                                sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(end.getCep());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
                                                              
                                sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append("Editar");
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
                                
				sbRegistro.append("</TR>");
				
				
				out.print(sbRegistro.toString());
				
			}
		}
		

	}
   
   %>
   
   
      
  
</TABLE>


</body>
</html>