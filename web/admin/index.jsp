<%-- 
    Document   : index
    Created on : 03/06/2019, 23:04:03
    Author     : viniciusamorim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <link rel="stylesheet" href="/Seguradora/style/css/bootstrap.min.css">
        <script src="/Seguradora/style/css/index.css">
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
                            <a class="nav-link" href="/Seguradora/admin/index.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/Seguradora/cliente/cadastrarCliente.jsp">Cadastrar Cliente</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/Seguradora/cliente/consultarCliente.jsp">Consultar Cliente</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Corretor
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/Seguradora/corretor/cadastrarCorretor.jsp">Cadastrar Corretor</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/Seguradora/corretor/consultarCorretor.jsp">Consultar Corretor</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Apólice
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/Seguradora/apolice/cadastrarApolice.jsp">Cadastrar Apólice</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/Seguradora/apolice/consultarApolice.jsp">Consultar Apólice</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Véiculo
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/Seguradora/veiculo/cadastrarVeiculo.jsp">Cadastrar Véiculo</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/Seguradora/veiculo/consultarVeiculo.jsp">Consultar Véiculo</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Análise
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/Seguradora/grafico/selecaoGrafico.jsp">Gráfico</a>    
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        
        <img id="image" src="/Seguradora/imagens/logo.jpg" alt="logo" width=100% height=100%> 
        
        <script src="/Seguradora/style/js/jquery-3.3.1.min.js"></script>
        <script src="/Seguradora/style/js/popper.min.js"></script>
        <script src="/Seguradora/style/js/bootstrap.min.js"></script>
    </body>
</html>
