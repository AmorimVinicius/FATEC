
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
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Veículo
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="cadastrarApolice.jsp">Cadastrar Apólice</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="consultarApolice.jsp">Consultar Apólice</a>
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
            <h1>Consultar Apólice</h1>
            <form action='continuar' method="POST">
                            
                <h3>Dados Veículo</h3>
                
                <div class="form-group row">
                    <label for="placa" class="col-2 col-form-label">Placa:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="placa" name="placa" required="true" maxlength="8">
                    </div>                    
                </div>
                <div class="form-group row">
                    <label for="chassi" class="col-2 col-form-label">Chassi:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="chassi" name="chassi" maxlength="18">
                    </div>
                </div>
               	<input type="hidden" name="operacao" value="CONTINUAR">
                <input class="btn btn-primary" type="submit" value="Buscar Cliente">
                
                <br/>
            </form>               
                
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
                                <th scope="col">CEP</th>
                                <th scope="col">Logradouro</th>
                                <th scope="col">Número</th>                            
                                <th scope="col">Bairro</th>
                                <th scope="col">Cidade</th>
                                <th scope="col">Estado</th>   
                                <th scope="col">Principal</th> 
                                <th scope="col">Pernoite</th>                             
                                <th scope="col"></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="apolice" items="${resultado}" varStatus="loop">
                                <tr> 
                                    <td>${apolice.endereco.cep}</td>
                                    <td>${apolice.endereco.logradouro}</td>
                                    <td>${apolice.endereco.numero}</td>
                                    <td>${apolice.endereco.bairro}</td> 
                                    <td>${apolice.endereco.cidade.cidade}</td> 
                                    <td>${apolice.endereco.estado.estado}</td>                                
                                    <td><input type="radio" name="enderecoPrincipal" id="enderecoPrincipal" onClick="endereco()" value="${apolice.endereco.id}"></td>
                                    <td><input type="radio" name="enderecoPernoite" id="enderecoPernoite" onClick="endereco()" value="${apolice.endereco.id}"></td>
                                    <input type="hidden" id="idVeiculo" name="idVeiculo" value="${apolice.veiculo.id}">   
                                    <input type="hidden" id="idCliente" name="idCliente" value="${apolice.cliente.id}"> 
                                </tr>                            
                            </c:forEach>
                        </tbody>
                    </table>                    
                </form>
                
                    <script language="javascript">                      
                        var radios = document.body.querySelectorAll("input[id='enderecoPrincipal']");                        
                        for(var x=0; x<radios.length; x++){
                            radios[x].onclick = function(){
                                clique(this.value);
                            }
                        }
                        
                        var radios = document.body.querySelectorAll("input[id='enderecoPernoite']");
                        for(var x=0; x<radios.length; x++){
                            radios[x].onclick = function(){
                                clique2(this.value);
                            }
                        }
                        
                        function clique(i){
                           document.getElementById('idEndereco').value = i;
                        }                        
                        function clique2(i){
                           document.getElementById('idPernoite').value = i;
                        }
                        
                    </script>
            </div>
        
                <br/>
                <hr>
                <h3>Dados Apólice</h3>
                <div class="form-group row">
                    <label for="dataInicio" class="col-2 col-form-label">Início Apólice:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="nome" name="nome">
                    </div>
                    <label for="dataFim" class="col-2 col-form-label">Fim Apólice:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="dataFim" name="dataFim" required="true" maxlength="10">
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="premio" class="col-2 col-form-label">Prêmio:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="premio" name="premio" required="true" maxlength="10">
                    </div>
                    <label for="valorApolice" class="col-2 col-form-label">Valor Apólice:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="valorApolice" name="valorApolice" required="true" maxlength="10">
                    </div>                    
                </div>
                
                <div class="form-group row">
                    <label for="tipoApolice" class="col-2 col-form-label">Tipo Apólice:</label>
                    <div class="col-3">
                        <select class="form-control" type="text" id="tipoApolice" name="tipoApolice" required="true" maxlength="10">
                            <option value="" selected> </option>
                            <option value="Compreensivo">Compreensivo</option>
                            <option value="FurtoRoubo">Furto/Roubo</option>
                            <option value="De Terceiros">De Terceiros</option>
                        </select>
                    </div>   
                </div>
                    
        </div>            
                    
                    <input type="text" id="idEndereco" name="idEndereco">   
                    <input type="text" id="idPernoite" name="idPernoite">   
                    
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                
            
                
             <div id="teste" style="display:none;"><label>Disciplina:</label><input type="text"></div>
        
            </form>
            
            <input type="hidden" name="operacao" value="SALVAR">
            <input type='submit' class="btn btn-primary" name='Salvar' value='Salvar' />
            
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

