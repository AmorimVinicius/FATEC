<%@page import="br.com.Seguradora.dominio.ClienteJuridico"%>
<%@page import="java.util.List"%>
<DOCTYPE html>
<html>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="estilo.css"/>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script> 
	<script type="text/javascript" src="script.js"></script> 	
<head>
</head>
<body>
	<div id="divConteudo">
		<table id="tabela">
                <thead>
				<tr>
                                        <th>ID</th>
					<th>Razão Social</th>
					<th>CNPJ</th>
					<th>E-mail</th>
				</tr>
				<tr>
					<th><input type="text" id="txtColuna1"/></th>
					<th><input type="text" id="txtColuna2"/></th>
					<th><input type="text" id="txtColuna3"/></th>
                                        <th><input type="text" id="txtColuna4"/></th>
				</tr>				
			</thead>
                <tbody>
                    <%
                        List<ClienteJuridico> clientesJuridicos = (List<ClienteJuridico>) request.getAttribute("todosClientesJuridicos");
                        if (null != clientesJuridicos) {
                            for (ClienteJuridico cj : clientesJuridicos) {
                                out.println("<tr>");
                                out.println("<td><input type='checkbox' name='id' value='" + cj.getId()+ "' /></td>");
                                out.println("<td><a href='salvar?id=" + cj.getId() + "'>" + cj.getCnpj()+ "</a></td>");
                                out.println("<td>" + cj.getNome()+ "</td>");
                                out.println("<td>" + cj.getEmail()+ "</td>");
                                out.println("<td>" + cj.getTelefoneComercial()+ "</td>");
                                out.println("<td>" + cj.getTelefoneCelular()+ "</td>");
                                out.println("<td>" + cj.getPessoaResponsavel()+ "</td>");
                                out.println("<td>" + cj.getInfoAdicional()+ "</td>");
                                
                                out.println("</tr>");
                                out.println("<br /");
                            }                        
                    } 
                        else {
                    %>
                    <tr><td colspan="8"><a href="/Seguradora/Servlet">Clique aqui para ver os dados.</a></td></tr>
                    <%
                        } 
                    %>
                </tbody>
                </table>
	</div>
</body>
</html>