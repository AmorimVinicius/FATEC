
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
        <script type="text/javascript" src="../style/js/config.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
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
            <form action='continuar' method="POST">
                
                <hr>
                <h4>Dados Cliente</h4>
                
                <div class="form-group row">
                    <label for="documento" class="col-2 col-form-label">CPF/CNPJ:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="documento" name="documento" required="true" maxlength="15">
                    </div>                    
                </div>
                                
               	<input type="hidden" name="operacao" value="CONTINUAR">
                <input class="btn btn-primary" type="submit" id="buscarCliente" value="Buscar Cliente">
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
                             
                 
            </div>
                       
                <br/>              
                                
                
                <hr>
            <form action='salvar' method="POST">    
                <h4>Dados Sinistro</h4>
                <div class="form-group row">
                    <label for="tipo" class="col-3 col-form-label">Tipo Apólice:</label>
                    <div class="col-3">
                        <select class="form-control" type="text" id="tipo" onchange='mostraCampo(this)' name="tipo">
                            <option value=" "> </option>
                            <option value="Colisao">Colisão</option>
                            <option value="Terceiros">De Terceiros</option>
                            <option value="FurtoRoubo">Furto/Roubo</option>
                            <option value="Incendio">Incêndio</option>
                            <option value="CausasNaturais">Causas Naturais</option>
                            <option value="Compreensivo">Compreensivo</option>
                        </select>
                    </div>                    
                </div> 
                
                <div class="form-group row">
                    <label for="descricao" class="col-3 col-form-label">Breve Descrição:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="descricao" name="descricao" required>
                    </div>                    
                </div>  
              
                <div class="form-group row">
                    <label for="documento" class="col-3 col-form-label">CPF:</label>
                    <div class="col-3">
                        <input class="form-control" onchange="isImagem(this)" type="file" id="comprovanteDocumento" name="comprovanteDocumento">
                    </div>                    
                </div>
                
                <div class="form-group row">
                    <label for="endereco" class="col-3 col-form-label">Comprovante de Endereço:</label>
                    <div class="col-3">
                        <input class="form-control" onchange="isImagem(this)" type="file" id="comprovanteEndereco" name="comprovanteEndereco">
                    </div>                    
                </div>
                
                <div class="form-group row">
                    <label for="crvl" class="col-3 col-form-label">CRVL:</label>
                    <div class="col-3">
                        <input class="form-control" onchange="isImagem(this)" type="file" id="comprovanteCRVL" name="comprovanteCRVL">
                    </div>                    
                </div>
                
                <div class="form-group row">
                    <label for="habilitacao" class="col-3 col-form-label">Habilitação:</label>
                    <div class="col-3">
                        <input class="form-control" onchange="isImagem(this)" type="file" id="comprovanteCNH" name="comprovanteCNH">
                    </div>                    
                </div>
                
                <div class="form-group row">
                    <label for="boletimOcorrencia" class="col-3 col-form-label">Boletim de Ocorrência:</label>
                    <div class="col-3">
                        <input class="form-control" onchange="isImagem(this)" type="file" id="comprovanteBO" name="comprovanteBO">
                    </div>                    
                </div>                
                    
                
                <div class="form-group row" id="classeClienteTerceiro" style="display:none;">
                    <label for="clienteTerceiro" class="col-3 col-form-label">Nome Terceiro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="clienteTerceiro" name="clienteTerceiro" >
                    </div>
                    <label for="documentoTerceiro" class="col-3 col-form-label">Documento Terceiro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="documentoTerceiro" name="documentoTerceiro" >
                    </div>
                </div>                              
                
                <div class="form-group row" id="classeVeiculoTerceiro" style="display:none;">
                    <label for="marcaVeiculoTerceiro" class="col-3 col-form-label">Marca:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="marcaVeiculoTerceiro" name="marcaVeiculoTerceiro" >
                    </div>
                    <label for="modeloVeiculoTerceiro" class="col-3 col-form-label">Veículo:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="modeloVeiculoTerceiro" name="modeloVeiculoTerceiro" >
                    </div>
                </div>
                
                <div class="form-group row" id="classeItemVeiculoTerceiro" style="display:none;">
                    <label for="placa" class="col-3 col-form-label">Placa:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="placa" name="placa" >
                    </div>
                    <label for="anoFabricacao" class="col-3 col-form-label">Ano Fabricação:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="anoFabricacao" name="anoFabricacao" >
                    </div>
                </div>
                
                <br/><br/>
                
                
                <input type="hidden" id="idVeiculo" name="idVeiculo" value="${resultado.get(0).veiculo.id}"> 
                <input type="hidden" id="idCliente" name="idCliente" value="${resultado.get(0).cliente.id}">
                <input type="hidden" id="idApolice" name="idApolice" value="${resultado.get(0).apolice.id}">
            
                <input type="hidden" name="operacao" value="SALVAR">
                <input type='submit' class="btn btn-primary" name='Salvar' value='Salvar' />

            </form>
                
        </div>         
                
                <script language="javascript">
                    function isImagem(i){   
                        var img = i.value.split(".");
                        var ext = "."+img.pop();

                        if(!ext.match(/\.(jpeg|jpg|png|)$/i)){
                           alert("Somente é permitido imagens .jpeg, .jpg ou .png");
                           i.value = '';
                           return;
                        }

                       // alert("OK!");
                    }
                    
                    function mostraCampo(el){                     
                      if (el.value === 'Terceiros'){ 
                        document.getElementById('classeClienteTerceiro').style.display = "block";
                        document.getElementById('classeVeiculoTerceiro').style.display = "block";
                        document.getElementById('classeItemVeiculoTerceiro').style.display = "block";
                      }
                    }
                    

                </script>
                         
                
               
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                
            
                
             <div id="teste" style="display:none;"><label>Disciplina:</label><input type="text"></div>
        
            
            
        </div>
        
        <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
    </body>
</html>

