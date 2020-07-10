<%-- 
    Document   : salvarClienteJuridico
    Created on : 01/03/2019, 18:21:39
    Author     : viniciusamorim
--%>

<%@page import="br.com.Seguradora.dominio.Endereco"%>
<%@page import="br.com.Seguradora.dominio.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>::: Cliente Jurídico :::</title>
    </head>
    <body>
        
        
        <%
            ClienteJuridico clienteJuridico = (ClienteJuridico) request.getAttribute("clienteJuridico");    
        %>
        
        <hr>
        <form action='salvar' method="POST">
            
            <h2>Dados Pessoais</h2>
            
            <label for="id">ID: </label>
            <input type="text" id="id" name="id" value="${param['id']}"</input>
            <span style="color: red">${mapa['id']}</span>
            <br/><br/> 
            
            <label for="razaoSocial">Razão Social: </label>
            <input type="text" id="razaoSocial" name="razaoSocial" value="${param['razaoSocial']}"</input>
            <span style="color: red">${mapa['razaoSocial']}</span>
            <br/><br/> 
            
            <label for="cnpj">CNPJ: </label>
            <input type="text" id="cnpj" name="cnpj" value="${param['cnpj']}"</input>
            <span style="color: red">${mapa['cnpj']}</span>
            <br/><br/> 
            
            <label for="email">E-mail: </label>
            <input type="text" id="email" name="email" value="${param['email']}"</input>
            <span style="color: red">${mapa['email']}</span>
            <br/><br/>
            
            <label for="telefoneComercial">Telefone Comercial: </label>
            <input type="text" id="telefoneComercial" name="telefoneComercial" value="${param['telefoneComercial']}"</input>
            <span style="color: red">${mapa['telefoneComercial']}</span>
            <br/><br/> 
            
            <label for="telefoneCelular">Telefone Celular: </label>
            <input type="text" id="telefoneCelular" name="telefoneCelular" value="${param['telefoneCelular']}"</input>
            <span style="color: red">${mapa['telefoneCelular']}</span>
            <br/><br/> 
            
            <label for="pessoaResponsavel">Pessoa Responsavel: </label>
            <input type="text" id="pessoaResponsavel" name="pessoaResponsavel" value="${param['pessoaResponsavel']}"</input>
            <span style="color: red">${mapa['pessoaResponsavel']}</span>
            <br/><br/> 
            
            <label for="infoAdicional">Info Adicional: </label>
            <input type="text" id="infoAdicional" name="infoAdicional" value="${param['infoAdicional']}"</input>
            <span style="color: red">${mapa['infoAdicional']}</span>
            <br/><br/> 
              
            <hr>
            
            <h2>Endereço Principal</h2>
                
            <label for="idEnd">ID: </label>
            <input type="text" id="idEnd" name="idEnd" value="${param['idEnd']}"</input>
            <span style="color: red">${mapa['idEnd']}</span>
            <br/><br/> 
            
            <label for="cep">CEP: </label>
            <input type="text" id="cep" name="cep" value="${param['cep']}"</input>
            <span style="color: red">${mapa['cep']}</span>
            <br/><br/>     
           
            <hr>
            
            <%
                if (clienteJuridico != null){
                    out.print("<input type='submit' id='operacao' name='operacao' value='ALTERAR'/>");
                    out.print("<input type='submit' id='operacao' name='operacao' value='EXCLUIR'/>");
                }else{
                    out.print("<input type='submit' id='operacao' name='operacao' value='SALVAR'/>");
                }
            %>
            
        </form>
    </body>
</html>
