
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
                                <a class="dropdown-item" href="cadastrarVeiculo.jsp">Cadastrar Veículo</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="consultarVeiculo.jsp">Consultar Veículo</a>
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
            <h1>Consultar Veículo</h1>
            <form action='filtrar' method="POST">
                <div class="form-group row">
                    <label for="documento" class="col-2 col-form-label">Documento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="documento" name="documento" >
                    </div>
                </div>                
                
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
                            <th scope="col">Marca</th>
                            <th scope="col">Modelo</th>
                            <th scope="col">Placa</th> 
                            <th scope="col">Ano Modelo</th>
                            <th scope="col">Sinistro</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Telefone Cliente</th>
                            <th scope="row">Data Entrada</th>
                            <th scope="row">Data Saida</th>
                            <th scope="row">Entrada</th>
                            <th scope="row">Saída</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="mecanica" items="${resultado}" >
                            <tr>
                                <td>${mecanica.veiculo.marca}</td>
                                <td>${mecanica.veiculo.modelo}</td>
                                <td>${mecanica.veiculo.placa}</td>                                
                                <td>${mecanica.veiculo.anoModelo}</td> 
                                <td>${mecanica.sinistro.tipo}</td> 
                                <td>${mecanica.sinistro.descricao}</td> 
                                <td>${mecanica.pessoa.nome}</td> 
                                <td>${mecanica.pessoa.telefoneCelular}</td>           
                                <td>${mecanica.dataEntrada}</td> 
                                <td>${mecanica.dataSaida}</td> 
                                <td><input class='entrada' type="radio" name="acao" id="entrada" value="${mecanica.sinistro.id}"></td>
                                <td><input class='saida' type="radio" name="acao" id="saida" value="${mecanica.sinistro.id}"></td>
                                <td><input type='hidden' name='idDataEntrada' id='idDataEntrada' value='${mecanica.dataEntrada}'>
                                <td><input type='hidden' name='idDataSaida' id='idDataSaida' value='${mecanica.dataSaida}'>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
                
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                
                <form action='alterar' method="POST" >      
                <input type='hidden' id='dataEntrada' name='dataEntrada'>
                <input type='hidden' id='dataSaida' name='dataSaida'>
                <input type="hidden" id="idSinistro" name="idSinistro">
                <input type="hidden" name="operacao" value="ALTERAR">
                <input type='submit' id='botaoSalvar' class="btn btn-primary" name='Alterar' value='Concluir' style="display:none;"/>
                
                </form>
                    <script language="javascript">                                             
                        var radios = document.body.querySelectorAll("input[id='entrada']");                        
                        for(var x=0; x<radios.length; x++){
                           
                            document.getElementById('botaoSalvar').style.display = "inline";
                            
                            radios[x].onclick = function(){
                                
                            var data = new Date(); // Obtém a data/hora atual

                            // Guarda cada pedaço em uma variável
                            var dia     = data.getDate();           // 1-31
                            if (dia < 10){
                                dia = "0"+dia;
                            }
                            var dia_sem = data.getDay();            // 0-6 (zero=domingo)
                            var mes     = data.getMonth();          // 0-11 (zero=janeiro)
                            mes++;
                            if (mes < 10){
                                mes = "0"+mes;
                            }
                            var ano2    = data.getYear();           // 2 dígitos
                            var ano4    = data.getFullYear();       // 4 dígitos
                            var hora    = data.getHours();          // 0-23
                            var min     = data.getMinutes();        // 0-59
                            var seg     = data.getSeconds();        // 0-59
                            var mseg    = data.getMilliseconds();   // 0-999
                            var tz      = data.getTimezoneOffset(); // em minutos

                            // Formata a data e a hora (note o mês + 1)
                            var str_data = dia + '/' + (mes) + '/' + ano4;
                            var str_hora = hora + ':' + min + ':' + seg;
                            var dataCompleta = str_data + " " + str_hora;

                            document.getElementById('dataEntrada').value = dataCompleta;           
                            document.getElementById('dataSaida').value = ""; 
                            clique(this.value);
                            }
                        } 
                        var radios = document.body.querySelectorAll("input[id='saida']");                        
                        for(var x=0; x<radios.length; x++){
                            
                            document.getElementById('botaoSalvar').style.display = "inline";
                            
                            radios[x].onclick = function(){
                                var data = new Date(); // Obtém a data/hora atual

                            // Guarda cada pedaço em uma variável
                            var dia     = data.getDate();           // 1-31
                            if (dia < 10){
                                dia = "0"+dia;
                            }
                            var dia_sem = data.getDay();            // 0-6 (zero=domingo)
                            var mes     = data.getMonth();          // 0-11 (zero=janeiro)
                            mes++;
                            if (mes < 10){
                                mes = "0"+mes;
                            }
                            var ano2    = data.getYear();           // 2 dígitos
                            var ano4    = data.getFullYear();       // 4 dígitos
                            var hora    = data.getHours();          // 0-23
                            var min     = data.getMinutes();        // 0-59
                            var seg     = data.getSeconds();        // 0-59
                            var mseg    = data.getMilliseconds();   // 0-999
                            var tz      = data.getTimezoneOffset(); // em minutos

                            // Formata a data e a hora (note o mês + 1)
                            var str_data = dia + '/' + (mes) + '/' + ano4;
                            var str_hora = hora + ':' + min + ':' + seg;
                            var dataCompleta = str_data + " " + str_hora;
                                document.getElementById('dataSaida').value = dataCompleta; 
                                document.getElementById('dataEntrada').value = ""; 
                                clique(this.value);
                            }
                        } 
                         function clique(i){
                             document.getElementById('idSinistro').value = i;
                         }
                    </script>
                    
                    
                    <script type="text/javascript">
                    $(window).load(function() {
                        var dataEntrada = document.getElementsByName('idDataEntrada');
                        var dataSaida = document.getElementsByName('idDataSaida');
                        var entrada = document.getElementsByName('entrada');
                        var saida = document.getElementsByName('saida');
                                                
                        
                        for(var i=0;i<dataEntrada.length;i++){
                            
                            if (dataEntrada[i].value === ''){
                                // SAIDA DESATIVADOS
                                document.getElementsByClassName('saida')[i].style.display = "none";    
                            }else if ((dataEntrada[i].value !== '') && (dataSaida[i].value !== '')){
                                // ENTRADA E SAIDA DESATIVADOS
                                document.getElementsByClassName('entrada')[i].style.display = "none";    
                                document.getElementsByClassName('saida')[i].style.display = "none";   
                                // ENTRADA DESATIVADOS
                            }else{
                                document.getElementsByClassName('entrada')[i].style.display = "none";
                            }                               
                        }                                       
                                               
                    })
                </script>    
                
            </div>
        

        </div>

        <script type="text/javascript">
            $("#documento").mask("000.000.000-00");
        </script>


        <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
    </body>
</html>

