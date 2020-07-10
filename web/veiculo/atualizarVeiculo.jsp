<%-- 
    Document   : atualizarVeiculo
    Created on : 11/04/2019, 22:58:24
    Author     : viniciusamorim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
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

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="cadastrarVeiculo.jsp">Cadastrar Veículo</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="consultarVeiculo.jsp">Consultar Veículo</a>
                                <div class="dropdown-divider"></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>

        <br/> <br/> <br/> <br/> <br/>
        
        <div class="container">	
            <h2>Atualizar Dados Cadastrais</h2>
            <br/><hr>
            <form action='alterar' method="POST">
                <h4>Veículo</h4><br/>
                <div class="form-group row">
                    <label for="marca" class="col-2 col-form-label">Marca:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="marca" name="marca" value="${resultado.get(0).marca}">
                    </div>
                    <label for="modelo" class="col-2 col-form-label">Modelo:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="modelo" name="modelo"  value="${resultado.get(0).modelo}">
                    </div>
                </div>
                    
                <div class="form-group row">
                    <label for="placa" class="col-2 col-form-label">Placa:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="placa" name="placa"  value="${resultado.get(0).placa}">
                    </div>
                    <label for="chassi" class="col-2 col-form-label">Chassi:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="chassi" name="chassi"  value="${resultado.get(0).chassi}">
                    </div>
                </div>
                    
                <div class="form-group row">
                    <label for="anoFabricacao" class="col-2 col-form-label">Ano Fabricação:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="anoFabricacao" name="anoFabricacao"  value="${resultado.get(0).anoFabricacao}">
                    </div>
                    <label for="anoModelo" class="col-2 col-form-label">Ano Modelo:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="anoModelo" name="anoModelo"  value="${resultado.get(0).anoModelo}">
                    </div>
                </div>
                    
                    <hr
                        
                <input type="text" name="idVeiculo" value="${resultado.get(0).id}"/>
                <input type="text" name="operacao" value="ALTERAR">
                <input type="text" name="idVeiculo" value="${resultado.get(0).id}"/>
                <input class="btn btn-primary" type="submit" value="alterar">
                <br/>
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
            </form>
            <br/>
        </div>
                <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
    </body>
</html>
