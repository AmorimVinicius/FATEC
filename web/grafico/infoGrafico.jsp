
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/data.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; max-width: 800px; margin: 0 auto"></div>

<div style="max-width: 800px; margin: 0 auto">

<pre id="data">Date,Distance,Label,Last
2013-01-02,2.3,1,0
2013-01-02,3.1,2,10
2013-01-03,4.8,3,20
2013-01-04,1.3,4,0</pre>
</div>
<script type="text/javascript">
$(function () {
    $('#container').highcharts({

        data: {
            csv: document.getElementById('data').innerHTML,
            seriesMapping: [{
                x: 0,
                y: 1
            },{
                x: 0,
                y: 2
            },{
                x: 0,
                y: 3
            }]
        },
        chart: {
            type: 'column'
        },
        title: {
            text: 'Daily runs'
        },
        xAxis: {
            minTickInterval: 24 * 36e5
        },
        yAxis: {
            title: {
                text: 'Distance'
            },
            labels: {
                format: '{value} km'
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                dataLabels: {
                    enabled: true,
                    format: '{point.label}'
                },
                tooltip: {
                    valueSuffix: ' km'
                }
            }
        },
        series: [{
            type: 'line'
        },{
            type: 'column'
        },{
            type: 'area'
        }]

    });
});
</script>
</body>
</html>
