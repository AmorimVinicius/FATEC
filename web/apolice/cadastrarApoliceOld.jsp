
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
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
                <input class="btn btn-primary" type="submit" id="buscarCliente" value="Buscar Cliente">
                
                <br/>
            </form>               
                
            <hr>
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
                    }
                        
                        function clique(i){
                           document.getElementById('idEndereco').value = i;
                           document.getElementById('cep').disabled = true;
                           document.getElementById('logradouro').disabled = true;
                           document.getElementById('numero').disabled = true;
                           document.getElementById('complemento').disabled = true;
                           document.getElementById('bairro').disabled = true;
                           document.getElementById('cidade').disabled = true;
                           document.getElementById('estado').disabled = true;
                        }                        
                        function clique2(i){
                           document.getElementById('idPernoite').value = i;
                           document.getElementById('cepSec').disabled = true;
                           document.getElementById('logradouroSec').disabled = true;
                           document.getElementById('numeroSec').disabled = true;
                           document.getElementById('complementoSec').disabled = true;
                           document.getElementById('bairroSec').disabled = true;
                           document.getElementById('cidadeSec').disabled = true;
                           document.getElementById('estadoSec').disabled = true;
                        }
                      
                                               
                    </script>
            </div>
                       
                <br/>              
                                
                
                
                
                <hr>
            <form action='salvar' method="POST" >    
                <h3>Dados Apólice</h3>
               
                
                <div class="form-group row">
                    <label for="dataInicio" class="col-2 col-form-label">Início Apólice:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="dataInicio" disabled name="dataInicio">
                    </div>
                    <label for="dataFim" class="col-2 col-form-label">Fim Apólice:</label>
                    <div class="col-3">
                        <select class="form-control" type="text" id="dataFim" name="dataFim" onchange='fimApolice(this);' required="true" maxlength="10">
                            <option value=" "> </option>
                            <option value="6meses">6 Meses</option>
                            <option value="12meses">12 Meses</option>
                            <option value="18meses">18 Meses</option>
                            <option value="24meses">24 Meses</option>
                        </select>
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="premio" class="col-2 col-form-label">Prêmio:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="premio" name="premio" required="true" maxlength="10">
                    </div>
                    <label for="valorApolice" class="col-3 col-form-label">Valor Apólice (Franquia):</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="valorApolice" name="valorApolice" required="true" maxlength="10">
                    </div>                    
                </div>
                
                
                <div class="form-group row">
                    <label for="tipoApolice" class="col-2 col-form-label">Tipo Apólice:</label>
                    <div class="col-3">
                        <select class="form-control" type="text" id="tipoApolice" name="tipoApolice" required="true" maxlength="10">
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

                    <label for="habilitados" class="col-2 col-form-label">Habilitados:</label>
                    <div class="col-3">
                        <select class="form-control" type="text" id="habilitados" name="habilitados" >
                            <option value="" selected> </option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>
                    </div>
                    
                    
                </div>
                
                <br/><hr>
                
                <h3>Endereço Principal</h3>
                
                <div class="form-group row">

                    <label for="cep" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cep" name="cep" required="true">
                    </div>
                </div>
                
                <div class="form-group row">

                    <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouro" name="logradouro" required="true">
                    </div>
                    
                    <label for="numero" class="col-2 col-form-label">Número:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="numero" name="numero" required="true" maxlength="6">
                    </div>
                    
                </div>
              
                <div class="form-group row">

                    <label for="complemento" class="col-2 col-form-label">Complemento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="complemento" name="complemento">
                    </div>
                    
                    <label for="bairro" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="bairro" name="bairro" required="true">
                    </div>
                    
                </div>
                
                <div class="form-group row">
                    
                    <label for="estado" class="col-2 col-form-label">Estado:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="estado" name="estado" onchange="buscaCidades(this.value)" required="true">
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
  
                   
                    <label for="cidade" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="cidade" name="cidade" required="true">
                        </select>
                    </div>
                             
                              
                </div> 
                
                <br/><hr>
                <h3>Endereço Secundário</h3>
               
                <div class="form-group row">
                        
                    <label for="cepSec" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cepSec" name="cepSec" required="true" >
                    </div>
                </div>
                
                <div class="form-group row">

                    <label for="logradouroSec" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouroSec" name="logradouroSec" required="true" >
                    </div>
                    
                    <label for="numeroSec" class="col-2 col-form-label">Número:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="numeroSec" name="numeroSec" required="true" >
                    </div>
                    
                </div>
              
                <div class="form-group row">

                    <label for="complementoSec" class="col-2 col-form-label">Complemento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="complementoSec" name="complementoSec" >
                    </div>
                    
                    <label for="bairroSec" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="bairroSec" name="bairroSec" required="true" >
                    </div>
                    
                </div>
                
                
                
                <div class="form-group row">    
                    
                    <label for="estadoSec" class="col-2 col-form-label">Estado:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="estadoSec" name="estadoSec" onchange="buscaCidades2(this.value)" required="true" >
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
  
                    <label for="cidadeSec" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="cidadeSec" name="cidadeSec" required="true" >
                        </select>
                    </div>
                    
                </div> 
                <br/><hr>
                
                
                <input type="hidden" id="idEndereco" name="idEndereco">   
                <input type="hidden" id="idPernoite" name="idPernoite">   
                <input type="hidden" id="idVeiculo" name="idVeiculo" value="${resultado.get(0).veiculo.id}">   
                <input type="hidden" id="idCliente" name="idCliente" value="${resultado.get(0).cliente.id}">
            
                <input type="hidden" name="operacao" value="SALVAR">
                <input type='submit' class="btn btn-primary" name='Salvar' value='Salvar' />

            </form>
                
        </div>            
                                       
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                
            <input type="hidden" id="dataFutura">
                
            <div id="teste" style="display:none;"><label>Disciplina:</label><input type="text"></div>
        
            
            
        </div>
        
        <script type="text/javascript">
            $("#dataInicio").mask("00/00/0000");
            $("#placa").mask("AAA-0000");
            $("#cep").mask("00000-000");
            $("#cepSec").mask("00000-000");
            $("#chassi").mask("000000000000000000");         
            
             $(window).load(function(){
                var data = new Date();

                // Guarda cada pedaço em uma variável
                var dia = data.getDate();          // 1-31
                var mes = data.getMonth();         // 0-11 (zero=janeiro)
                mes++;
                var ano = data.getFullYear();       // 4 dígitos

                if (dia < 10){
                    dia = '0'+dia;
                }
                if (mes < 10){
                    mes = '0'+mes;
                }             
                dataAtual = dia+'/'+mes+'/'+ano;                
                document.getElementById('dataInicio').value = dataAtual;

            });
            
            
                               
        </script>
       

        <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
    </body>
</html>

