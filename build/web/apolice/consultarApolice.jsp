
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <link rel="stylesheet" href="../style/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
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
                            <a class="nav-link" href="../admin/index.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Apólice
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="cadastrarApolice.jsp">Cadastrar Apólice</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="consultarApolice.jsp">Consultar Apólice</a>
                            </div>
                        </li>                        
                    </ul>
                </div>
            </nav>
        </div>
        <br/> <br/> <br/> <br/> <br/>
        <div class="container">	
            <h1>Consultar Apólice</h1>
            <form action='filtrar' method="POST">
                <div class="form-group row">
                    <label for="documento" class="col-2 col-form-label">Documento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="documento" name="documento" >
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="placa" class="col-2 col-form-label">Placa:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="placa" name="placa" >
                    </div>
                </div>

                <hr/>
                
                <div class="form-group row">
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" class="custom-control-input" id="opStatus1" checked value="1" name="opStatus">
                        <label class="custom-control-label" for="opStatus1">Ativo</label>
                    </div>

                 
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" class="custom-control-input" id="opStatus" value="0" name="opStatus">
                        <label class="custom-control-label" for="opStatus">Inativo</label>
                    </div>


                </div>

               	<input type="hidden" name="operacao" value="LISTARFILTRO">

                <input class="btn btn-primary" type="submit" value="filtrar">
                <br/>
            
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>


      
            <br/>
            <div class="row">
                <form> 
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Data Início</th>
                            <th scope="col">Data Fim</th>
                            <th scope="col">Prêmio</th>
                            <th scope="col">Valor Apólice (Franquia)</th>
                            <th scope="col">Tipo Apólice</th>
                            <th scope="col">Marca</th>
                            <th scope="col">Modelo</th>
                            <th scope="col">Placa</th>
                            <th scope="col">Alterar</th>
                            <th scope="row">Encerrar</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="apolice" items="${resultado}" >
                            <tr>
                                <td>${apolice.dataInicio}</td>
                                <td>${apolice.dataFim}</td>
                                <td>${apolice.premio}</td>
                                <td>${apolice.valorApolice}</td>
                                <td>${apolice.tipoApolice}</td>             
                                <td>${apolice.veiculo.marca}</td>
                                <td>${apolice.veiculo.modelo}</td>
                                <td>${apolice.veiculo.placa}</td>
                                <td><a href="preAtualizar?id=${apolice.id}&operacao=PREATUALIZAR"><input class="btn btn-secondary" type="button" value="Alterar"></a></td>
                                <td><a href="excluir?id=${apolice.id}&veiculo=${apolice.veiculo.id}&operacao=EXCLUIR"><input class="btn btn-danger" type="button" value="Encerrar"></a></td>
                                <td><input type="hidden" id="nomeCliente" name="nomeCliente" value="${apolice.cliente.nome}"></td>
                                <td><input type="hidden" name="documentoCliente" id="documentoCliente" value="${apolice.cliente.documento}"></td>
                                <td><input type="hidden" id="idEndereco" value="${apolice.endereco.id}"></td>
                                <td><input type="hidden" id="cepEndereco" value="${apolice.endereco.cep}"></td>
                                <td><input type="hidden" id="logradouroEndereco" value="${apolice.endereco.logradouro}"></td>
                                <td><input type="hidden" id="complementoEndereco" value="${apolice.endereco.complemento}"></td>
                                <td><input type="hidden" id="numeroEndereco" value="${apolice.endereco.numero}"></td>
                                <td><input type="hidden" id="bairroEndereco" value="${apolice.endereco.bairro}"></td>
                                <td><input type="hidden" id="cidadeEndereco" value="${apolice.cidade.cidade}"></td>
                                <td><input type="hidden" id="estadoEndereco" value="${apolice.estado.estado}"></td>
                                <td><input type="hidden" id="idPernoite" value="${apolice.endereco.idPernoite}"></td>
                                <td><input type="hidden" id="cepPernoite" value="${apolice.endereco.cepSec}"></td>
                                <td><input type="hidden" id="logradouroPernoite" value="${apolice.endereco.logradouroSec}"></td>
                                <td><input type="hidden" id="complementoPernoite" value="${apolice.endereco.complementoSec}"></td>
                                <td><input type="hidden" id="numeroPernoite" value="${apolice.endereco.numeroSec}"></td>
                                <td><input type="hidden" id="bairroPernoite" value="${apolice.endereco.bairroSec}"></td>
                                <td><input type="hidden" id="cidadePernoite" value="${apolice.cidade.cidadeSec}"></td>
                                <td><input type="hidden" id="estadoPernoite" value="${apolice.estado.estadoSec}"></td>                                
                                <td><input type="hidden" id="idVeiculo" name='idVeiculo' value="${apolice.veiculo.id}"></td>                                
                                <td><input type="hidden" id="idCliente" value="${apolice.cliente.id}"></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
                             
                
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                
            </div>
        

        </div>

        <script type="text/javascript">
            $("#documento").mask("000.000.000-00");
            $("#placa").mask("AAA-0000");
        </script>


        <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
    </body>
</html>

