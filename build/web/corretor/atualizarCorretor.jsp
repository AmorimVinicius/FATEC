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
                                <a class="dropdown-item" href="cadastrarCorretor.jsp">Cadastrar Corretor</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="consultarCorretor.jsp">Consultar Corretor</a>
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
                <h4>Cliente</h4><br/>
                <div class="form-group row">
                    <label for="nomeFantasia" class="col-2 col-form-label">Nome Fantasia:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="nomeFantasia" name="nomeFantasia" value="${resultado.get(0).nome}">
                    </div>
                    <label for="razaoSocial" class="col-2 col-form-label">Razão Social:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="razaoSocial" name="razaoSocial"  value="${resultado.get(0).razaoSocial}">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="email" class="col-2 col-form-label">E-mail:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="email" name="email"  value="${resultado.get(0).email}">
                    </div>
                    <label for="documento" class="col-2 col-form-label">Documento:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="documento" name="documento"  value="${resultado.get(0).documento}">
                    </div>
                </div>
                   
                <div class="form-group row">

                    <label for="telefoneComercial" class="col-2 col-form-label">Telefone Comercial:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="telefoneComercial" name="telefoneComercial"  value="${resultado.get(0).telefoneComercial}">
                    </div>
                    <label for="telefoneCelular" class="col-2 col-form-label">Telefone Celular:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="telefoneCelular" name="telefoneCelular"  value="${resultado.get(0).telefoneCelular}">
                    </div>
                </div> 
                    
                <div class="form-group row">
                    
                    <label for="pessoaResponsavel" class="col-2 col-form-label">Pessoa Responsável:</label>
                    <div class="col-10">
                        <input class="form-control" type="text" id="pessoaResponsavel" name="pessoaResponsavel"  value="${resultado.get(0).pessoaResponsavel}">

                    </div>
                    
                </div>
                    
                <div class="form-group row">

                    <label for="infoAdicional" class="col-2 col-form-label">Info Adicional:</label>
                    <div class="col-10">
                        <input class="form-control" type="text" id="infoAdicional" name="infoAdicional"  value="${resultado.get(0).infoAdicional}">
                    </div>
                    
                 </div>
                    <br/>
                <hr/>
                <br/>
                <h4>Endereço Principal</h4><br/>
                <div class="form-group row">
                    <label for="cep" class="col-2 col-form-label">CEP:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="cep" name="cep"  value="${resultado.get(0).endereco.cep}">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-6">
                        <input class="form-control" type="text" id="logradouro" name="logradouro"  value="${resultado.get(0).endereco.logradouro}">
                    </div>
                    <label for="numero" class="col-2 col-form-label">Número:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="numero" name="numero"  value="${resultado.get(0).endereco.numero}">
                    </div>
                    
                </div>
                <div class="form-group row">
                    <label for="complemento" class="col-2 cm-label">Complemento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="complemento" name="complemento"  value="${resultado.get(0).endereco.complemento}">
                    </div>
                     <label for="bairro" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="bairro" name="bairro"  value="${resultado.get(0).endereco.bairro}">
                    </div>
                </div>
                
                
                <div class="form-group row">
                    <label for="cidade" class="col-2 cm-label">Cidade:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="cidade" name="cidade"  value="${resultado.get(0).endereco.cidade}">
                    </div>
                     <label for="estado" class="col-2 col-form-label">Estado:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="estado" name="estado"  value="${resultado.get(0).endereco.estado}">
                    </div>
                </div>
                    
                    <hr>
                    
                <input type="text" name="idEndereco" value="${resultado.get(0).endereco.id}"/>
                <input type="text" name="operacao" value="ALTERAR">
                <input type="text" name="idCorretor" value="${resultado.get(0).id}"/>
                <input class="btn btn-primary" type="submit" value="alterar">
                <br/>
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
            </form>
            <br/>
        </div>

        <script type="text/javascript">
            $("#telefoneCelular").mask("(00) 00000-0000");
            $("#telefoneComercial").mask("(00) 0000-0000");
            $("#documento").mask("00.000.000/0000-00");
            $("#cep").mask("00000-000");
        </script>


        <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
    </body>
</html>

