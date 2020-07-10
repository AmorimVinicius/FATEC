<%-- 
    Document   : salvarProduto
    Created on : 02/09/2018, 11:15:41
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
        <h1>Produto</h1>
        <form action='salvar' method="POST">
            <label for="descricao">Descrição</label>
            <input type="text" id="descricao" name="descricao"></input>
            
            <label for="quantidade">Quantidade</label>
            <input type="text" id="quantidade" name="quantidade"></input>
            
            <input type="hidden" name="operacao" value="SALVAR">
            <input type='submit' name='Salvar' value='Salvar' />
            <br/>
            <c:if test="${mensagem != null}">
                <br/>
                <p>${mensagem}</p>
            </c:if>
        </form>
    </body>
</html>
