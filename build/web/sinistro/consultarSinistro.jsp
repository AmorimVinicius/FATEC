
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
        <script type="text/javascript" src="../style/js/estados-cidades.js"></script>
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
            <h1>Consultar Sinistro</h1>
            <form action='filtrar' method="POST">
                <div class="form-group row">
                    <label for="placa" class="col-2 col-form-label">Placa:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="placa" name="placa" >
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="documento" class="col-2 col-form-label">Documento Cliente:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="documento" name="documento" >
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

                <input class="btn btn-primary" type="submit" value="Filtrar">
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
                            <th scope="col">Nome</th>
                            <th scope="col">Documento</th>
                            <th scope="col">Modelo</th>
                            <th scope="col">Placa</th>
                            <th scope="col">Sinistro</th>
                            <th scope="col">Documento</th>
                            <th scope="col">Endereço</th>
                            <th scope="col">CRVL</th>
                            <th scope="col">CNH</th>
                            <th scope="col">B.O</th>
                            <th scope="col">Status</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Data</th>
                            <th scope="col">Aceitar</th>
                            <th scope="col">Recusar</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="sinistro" items="${resultado}" >
                            <tr>
                                <td>${sinistro.cliente.nome}</td>
                                <td>${sinistro.cliente.documento}</td>                                
                                <td>${sinistro.veiculo.modelo}</td> 
                                <td>${sinistro.veiculo.placa}</td> 
                                <td>${sinistro.tipo}</td> 
                                <td><a href="../${sinistro.comprovanteDocumento}" target="_blank" download="ComprovanteDocumento.png">Visualizar</a></td>
                                <td><a href="../${sinistro.comprovanteEndereco}" target="_blank" download="ComprovanteEndereco.png">Visualizar</a></td>
                                <td><a href="../${sinistro.comprovanteCRVL}" target="_blank" download="ComprovanteCRVL.png">Visualizar</a></td>
                                <td><a href="../${sinistro.comprovanteCNH}" target="_blank" download="ComprovanteCNH.png">Visualizar</a></td>
                                <td><a href="../${sinistro.comprovanteBO}" target="_blank" download="ComprovanteBO.png">Visualizar</a></td>
                                <td><input type="hidden" id="aceite" name="aceite" value="${sinistro.aceite}">${sinistro.aceite}</td>                                 
                                <td>${sinistro.descricao}</td> 
                                <td>${sinistro.dataAceiteRecusa}</td> 
                                <td><input type="radio" name="aprovado" id="aprovado" value="${sinistro.id}"></td>
                                <td><input type="radio" name="recusado" id="recusado" value="${sinistro.id}"></td>   
                                
                                <td><input type="hidden" id="idSinistro" name="idSinistro" value="${sinistro.id}"></td> 
                                <td><a href="excluir?id=${sinistro.id}&operacao=EXCLUIR&tipo=${sinistro.tipo}"><input class="btn btn-danger" type="button" value="Finalizar"></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
                
                <script language="javascript">                                             
                    var radios = document.body.querySelectorAll("input[id='recusado']");                        
                    for(var x=0; x<radios.length; x++){
                        radios[x].onclick = function(){
                            document.getElementById('classeMotivoRecusa').style.display = "inline";
                            document.getElementById('classeNomeMecanica').style.display = "none";
                            document.getElementById('classeEnderecoMecanicaCep').style.display = "none";
                            document.getElementById('classeEnderecoMecanicaLogradouro').style.display = "none";
                            document.getElementById('classeEnderecoMecanicaBairro').style.display = "none";
                            document.getElementById('classeEnderecoMecanicaEstado').style.display = "none";
                            cliqueRecusado(this.value);                            
                        }
                    } 
                    var radios = document.body.querySelectorAll("input[id='aprovado']");                        
                    for(var x=0; x<radios.length; x++){
                        radios[x].onclick = function(){
                            document.getElementById('classeMotivoRecusa').style.display = "none";
                            document.getElementById('classeNomeMecanica').style.display = "inline";
                            document.getElementById('classeEnderecoMecanicaCep').style.display = "inline";
                            document.getElementById('classeEnderecoMecanicaLogradouro').style.display = "inline";
                            document.getElementById('classeEnderecoMecanicaBairro').style.display = "inline";
                            document.getElementById('classeEnderecoMecanicaEstado').style.display = "inline";
                            cliqueAprovado(this.value);
                        }
                    } 
                    function cliqueRecusado(i){
                        document.getElementById('id').value = i;   
                        document.getElementById('retorno').value = "Reprovado";
                    }
                    function cliqueAprovado(i){
                        document.getElementById('id').value = i;
                        document.getElementById('retorno').value = "Aprovado";
                    }
                </script>
                
                <script type="text/javascript">
                    $(window).load(function() {
                        var aprovado = document.getElementsByName('aprovado');
                        var recusado = document.getElementsByName('recusado'); 
                        var aceite = document.getElementsByName('aceite'); 
                        var status = "Aguardando";
                        
                        // APROVADO
                        for(var i=0;i<aceite.length;i++){
                            if (document.getElementsByName("aceite")[i].value != status){
                                aprovado[i].disabled=true;
                            }
                        }
                        
                        // 
                        for(var i=0;i<aceite.length;i++){
                            if (document.getElementsByName("aceite")[i].value != status){
                                recusado[i].disabled=true;
                            }
                        }
                    })
                </script>             
                
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                
            </div>
        
            <input type="hidden" id="aguardando" name="aguardando" value="Aguardando">  
            
            <form action='alterar' method="POST">    
                
                
                <div class="form-group row" id="classeNomeMecanica" style="display:none;">
                    <h3>Dados Mecânica</h3>
                    <label for="nomeMecanica" class="col-3 col-form-label">Nome Mecânica:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="nomeMecanica" name="nomeMecanica" >
                    </div>
                     <label for="documentoMecanica" class="col-3 col-form-label">CNPJ:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="documentoMecanica" name="documentoMecanica" >
                    </div>
                    <label for="telefoneMecanica" class="col-3 col-form-label">Telefone Mecânica:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="telefoneMecanica" name="telefoneMecanica" >
                    </div>
                </div>
                
                <div class="form-group row" id="classeEnderecoMecanicaCep" style="display:none;">
                    <label for="cepMecanica" class="col-3 col-form-label">CEP:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="cepMecanica" name="cepMecanica" >
                    </div>                    
                </div>
                
                <div class="form-group row" id="classeEnderecoMecanicaLogradouro" style="display:none;">
                    <label for="logradouroMecanica" class="col-3 col-form-label">Logradouro:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="logradouroMecanica" name="logradouroMecanica" >
                    </div> 
                    <label for="numeroMecanica" class="col-3 col-form-label">Número:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="numeroMecanica" name="numeroMecanica" >
                    </div> 
                </div>
                
                <div class="form-group row" id="classeEnderecoMecanicaBairro" style="display:none;">
                    <label for="complementoMecanica" class="col-3 col-form-label">Complemento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="complementoMecanica" name="complementoMecanica" >
                    </div> 
                    <label for="bairroMecanica" class="col-3 col-form-label">Bairro:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="bairroMecanica" name="bairroMecanica" >
                    </div> 
                </div>
                
                <div class="form-group row" id="classeEnderecoMecanicaEstado" style="display:none;">
                    
                    <label for="estadoMecanica" class="col-2 col-form-label">Estado:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="estado" name="estado" onchange="buscaCidades(this.value)">
                            <option value="">Selecione o Estado</option>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                    </div>
  
                   
                    <label for="cidadeMecanica" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="cidade" name="cidade">
                        </select>
                    </div>
                </div>           
                
                <div class="form-group row" id="classeMotivoRecusa" style="display:none;">
                    <label for="motivoRecusa" class="col-3 col-form-label">Motivo Recusa:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="motivoRecusa" name="motivoRecusa" >
                    </div>
                </div>                 
                
                   
                              
                 
                
                <input type="hidden" id="id" name="id" >
                <input type="hidden" id="retorno" name="retorno">
            
                <br />
                <hr>
                
                <input type="hidden" name="operacao" value="ALTERAR">
                <input class="btn btn-primary" type="submit" value="Concluir">
            </form>
        </div>

        <script type="text/javascript">
            $("#telefoneMecanica").mask("(00) 00000-0000");
            $("#telefoneComercial").mask("(00) 0000-0000");
            $("#documento").mask("000.000.000-00");
            $("#cep").mask("00000-000");
            $("#cepSec").mask("00000-000");
            $("#dataNascimento").mask("00/00/0000");
        </script>

        <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
    </body>
</html>

