
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
        <script type="text/javascript" src="../style/js/config.js"></script>       
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>           
        <script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js?hcode=be5162d915534272a57d0bb781d27f2b"></script>
        <script src="https://cdn.anychart.com/releases/v8/js/anychart-ui.min.js?hcode=be5162d915534272a57d0bb781d27f2b"></script>
        <script src="https://cdn.anychart.com/releases/v8/js/anychart-exports.min.js?hcode=be5162d915534272a57d0bb781d27f2b"></script>
       <style type="text/css">
        #container {
          width: 1000px;
          height: 500px;
          margin: 0;
          padding: 0;
      }
      </style>
		
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
        
        <title>Seguradora</title>              
    </head>
    
    <body>

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
                    
                <c:if test="${!mensagem != null}">
                    <hr>
                    <div class="container-fluid">                         
                    </div>
                </c:if>  
      
                <br/>
                              
                <br/>              
                    
                
        <div id="container"></div>
        
       <script>
anychart.onDocumentReady(function () {
    // create data set on our data,also we can pud data directly to series
    var dataSet = anychart.data.set([
        <c:forEach var="grafico" items="${resultado}" varStatus="loop">
            ['${grafico.dataInicial}', ${grafico.quantidade}, ${grafico.aprovado}, ${grafico.recusado}, ${grafico.aguardando}],            
        </c:forEach>
    ]);

    // quantidade total
    var seriesData_1 = dataSet.mapAs({'x': 0, 'value': 1});

    // aprovado
    var seriesData_2 = dataSet.mapAs({'x': 0, 'value': 2});

    // recusado
    var seriesData_3 = dataSet.mapAs({'x': 0, 'value': 3});
    
    // aguardando
    var seriesData_4 = dataSet.mapAs({'x': 0, 'value': 4});

    // create line chart
    var chart = anychart.bar();

    // turn on chart animation
    chart.animation(true);

    // turn on the crosshair and tune it
    chart.crosshair()
            .enabled(true)
            .yLabel(false)
            .xLabel(false)
            .yStroke(null);

    // set chart padding
    //chart.padding([10, 20, 5, 20]);

    chart.title('TOTAL DE SINISTROS');

    chart.yAxis().title('Quantidade de Sinistros por Dia');
    
    chart.xAxis().title('Intervalo de Dias');

    // temp variable to store series instance
    var series;

    // setup first series
    series = chart.bar(seriesData_1);
    series.name('Quantidade')            
            .size(4)
            .stroke({                       
                    color: '#696969'                    
                    });
    series.hovered().markers(true);

    // setup second series
    series = chart.line(seriesData_2);
    series.name('Aprovado')
            .size(4)
            .stroke({                        
                    color: '#006400',
                    line: '10'
                    });
    series.hovered().markers(true);

    // setup third series
    series = chart.line(seriesData_3);
    series.name('Recusado')
            .size(4)
            .stroke({
                    color: '#FF0000'
                    });
    series.hovered().markers(true);
    
    // setup third series
    series = chart.line(seriesData_4);
    series.name('Aguardando')
            .size(4)
            .stroke(
                    {
                        color: '#FFD700'
                    }
            );
    series.hovered().markers(true);

    // interactivity and tooltip settings
   // chart.interactivity().hoverMode('by-x');

    chart.tooltip()
            .displayMode('separated')
            .positionMode('point')
            .separator(false)
            .position('right')
            .anchor('left-bottom')
            .offsetX(2)
            .offsetY(35)
            .title(false)
            .format('{%Value} Total');
    
    // turn the legend on
    chart.legend(true);

    // set container id for the chart
    chart.container('container');
    // initiate chart drawing
    chart.draw();
});
</script>         
        
    </body>
</html>

