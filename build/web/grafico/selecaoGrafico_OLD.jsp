
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
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
		
	<script type="text/javascript">
            $(document).ready(function(){
	 	$(".form-control").datepicker({
                    dateFormat: 'dd/mm/yy',
                    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
                    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
                    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
                    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
                    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
                    nextText: 'Próximo',
                    prevText: 'Anterior'
		});
            });
	</script>
        
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
        //google.charts.load('current', {'packages':['corechart']});
        //google.charts.setOnLoadCallback(drawChart);
        
        // Carregando a API Visualization e os pacotes de gráficos
        google.load('visualization', '1.0', {'packages':['corechart']});
      
        // Configurando o método que será executado quando a API for carregada
        google.setOnLoadCallback(drawChart);

        function drawChart() {
          var data = google.visualization.arrayToDataTable([
          ['Data', 'Total Sinistros', "Aprovados", "Reprovados", "Aguardando"],
            
            <c:forEach var="grafico" items="${resultado}" varStatus="loop">
                ['${grafico.dataInicial}', ${grafico.quantidade}, ${grafico.aprovado}, ${grafico.recusado}, ${grafico.aguardando}],            
            </c:forEach>
                
          ]);
    
                var options = {
		    'legend':'right',
		    'title':'TOTAL DE SINISTROS',
		    'is3D':true,
		    'width':1000,
		    'height':500,
                    hAxis: { // eixo horizontal
                        title: 'Intervalo de Dias'},
                    vAxis: { // eixo vertical
                        title: 'Quantidade de Sinistros por Dias'},
		    seriesType: "bars",

                    series: {
                        1: {type: "line"},
                        2: {type: "line"},
                        3: {type: "line"}
                    }
                    
		};

          var chart = new google.visualization.ComboChart(document.getElementById('curve_chart'));

          chart.draw(data, options);
        }
        </script>        
        
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
            <h1>Selecionar Intervalo</h1>
            <form action='filtrar' method="POST">
                
                <hr>
                 
               <div>
                    <label for="dataInicial" class="col-3 col-form-label">Data Inicial:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="dataInicial" name="dataInicial">
                    </div>
                    <label for="dataFinal" class="col-3 col-form-label">Data Final:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="dataFinal" name="dataFinal" >
                    </div>
                </div>

                <br>
                <hr>
                
               	<input type="hidden" name="operacao" value="LISTARFILTRO">
                <input class="btn btn-primary" type="submit" id="criarGrafico" value="Gerar Gráfico">
                <br/>
            </form>               
                
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>  
      
                <br/>
                                
                <div id="curve_chart" style="width: 900px; height: 500px"></div>        
             
            
                       
                <br/>              
                                
                
                <hr>
           
                
             <div id="teste" style="display:none;"><label>Disciplina:</label><input type="text"></div>
        
            
            
        </div>
    </body>
</html>

