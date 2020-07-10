<%-- 
    Document   : juridico
    Created on : 26/02/2019, 22:12:59
    Author     : viniciusamorim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cliente Jurídico</h1>
        <form action='salvar' method="POST">
            
            <label for="razaoSocial">Razão Social: </label>
            <input type="text" id="razaoSocial" name="razaoSocial"></input>
            
            <label for="cnpj">CNPJ: </label>
            <input type="text" id="cnpj" name="cnpj"></input>
            
            <label for="email">E-mail: </label>
            <input type="text" id="email" name="email"></input>
            
            <label for="telefoneComercial">Telefone Comercial: </label>
            <input type="text" id="telefoneComercial" name="telefoneComercial"></input>
            
            <label for="telefoneCelular">Telefone Celular: </label>
            <input type="text" id="telefoneCelular" name="telefoneCelular"></input>
            
            <label for="pessoaResponsavel">Pessoa Responsável: </label>
            <input type="text" id="pessoaResponsavel" name="pessoaResponsavel"></input>
            
            <label for="infoAdicional">Info Adicional: </label>
            <input type="text" id="infoAdicional" name="infoAdicional"></input>
            
            <input type="hidden" name="operacao" value="SALVAR">
            <input type='submit' name='Salvar' value='Salvar' />
            <br/>
            <c:if test="${mensagem != null}">
                <br/>
                <p>${mensagem}</p>
            </c:if>
        </form>
    </body>
    </body>
</html>
