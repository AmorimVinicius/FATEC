
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
        <script type="text/javascript" src="../style/js/estados-cidades.js"></script>
        <script type="text/javascript" src="../style/js/estados-cidades-2.js"></script>
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
                                Veículo
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="cadastrarSinistro.jsp">Cadastrar Sinistro</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="consultarSinistro.jsp">Consultar Sinistro</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <br/> <br/> <br/> <br/> <br/>
        <div class="container">	
            <h1>Cadastrar Sinistro</h1> 
                
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
                                <th scope="col">Nome</th>
                                <th scope="col">Veículo</th>
                                <th scope="col">Placa</th>                             
                                <th scope="col"></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="sinistro" items="${resultado}" varStatus="loop">
                                <tr> 
                                    <td>${sinistro.cliente.nome}</td>
                                    <td>${sinistro.veiculo.modelo}</td>
                                    <td>${sinistro.veiculo.placa}</td>
                                    <td><input type="radio" name="veiculoSelecionado" id="veiculoSelecionado" onClick="veiculoSelecionado()" value="${sinistro.veiculo.id}"></td>
                                </tr>                            
                            </c:forEach>
                        </tbody>
                    </table>                    
                </form>
                
                
                    <script language="javascript">                      
                        var radios = document.body.querySelectorAll("input[id='veiculoSelecionado']");                        
                        for(var x=0; x<radios.length; x++){
                            radios[x].onclick = function(){
                                clique(this.value);
                            }
                        }                                                
                        function clique(i){
                           document.getElementById('idVeiculo').value = i;
                        }                   
                    </script>
                 
            </div>
                       
                <br/>              
                                
                
                <hr>
            <form action='salvar' method="POST" >    
                <h4>Dados Sinistro</h4>
                <div class="form-group row">
                    <label for="tipo" class="col-2 col-form-label">Início Apólice:</label>
                    <div class="col-3">
                        <select class="form-control" type="text" id="tipo" name="tipo">
                            <option value=" "> </option>
                            <option value="Colisao">Colisao</option>
                            <option value="De Terceiros">De Terceiros</option>
                            <option value="FurtoRoubo">Furto/Roubo</option>
                            <option value="Incendio">Incendio</option>
                            <option value="Causas Naturais">Causas Naturais</option>
                        </select>
                    </div>                    
                </div>  
              
                <br/><br/>
                
                <input type="text" id="idVeiculo" name="idVeiculo"> 
                <input type="text" id="idCliente" name="idCliente" value="${resultado.get(0).cliente.id}">
            
                <input type="hidden" name="operacao" value="SALVAR">
                <input type='submit' class="btn btn-primary" name='Salvar' value='Salvar' />

            </form>
                
        </div>            
                                       
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                
            
                
             <div id="teste" style="display:none;"><label>Disciplina:</label><input type="text"></div>
        
            
            
        </div>
        
        <script type="text/javascript">
            $("#dataInicio").mask("00/00/0000");
            $("#dataFim").mask("00/00/0000");
        </script>

        <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
    </body>
</html>

