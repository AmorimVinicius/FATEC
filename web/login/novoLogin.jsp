<%-- 
    Document   : novoLogin
    Created on : 02/06/2019, 18:02:49
    Author     : viniciusamorim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <link rel="stylesheet" href="../style/css/bootstrap.min.css">
        <title>Seguradora</title>
    </head>
    <body>
        <div class="container-fluid">   

            <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                <a class="navbar-brand" href="#">Seguradora</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        
        <br/> <br/> <br/> <br/> <br/>
        
        <div class="container">	
            <form action='salvar' method="POST">
                            
                <h3>Novo Login</h3>
                
                <div class="form-group row">
                    <label for="email" class="col-2 col-form-label">E-mail:</label>
                    <div class="col-5">
                        <input class="form-control" type="email" id="email" name="email" required="true">
                    </div>                    
                </div>
                <div class="form-group row">
                    <label for="senha" class="col-2 col-form-label">Senha:</label>
                    <div class="col-2">
                        <input class="form-control" type="password" id="senha" name="senha" maxlength="10">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="confirmarSenha" class="col-2 col-form-label">Confirmar Senha:</label>
                    <div class="col-2">
                        <input class="form-control" type="password" id="confirmarSenha" name="confirmarSenha" maxlength="10">
                    </div>
                </div>
               
                <hr>
                
               	<input type="hidden" name="operacao" value="SALVAR">
                <input class="btn btn-primary" type="submit" id="salvar" value="Salvar">
                
                <br/>
            </form>               
                
            
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>  
      
                <br/>
        </div>
    </body>
</html>
