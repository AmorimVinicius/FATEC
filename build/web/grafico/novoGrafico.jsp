                     
<html>
<head>
  <script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js?hcode=be5162d915534272a57d0bb781d27f2b"></script>
  <script src="https://cdn.anychart.com/releases/v8/js/anychart-ui.min.js?hcode=be5162d915534272a57d0bb781d27f2b"></script>
  <script src="https://cdn.anychart.com/releases/v8/js/anychart-exports.min.js?hcode=be5162d915534272a57d0bb781d27f2b"></script>
  <link href="https://cdn.anychart.com/releases/v8/css/anychart-ui.min.css?hcode=be5162d915534272a57d0bb781d27f2b" type="text/css" rel="stylesheet">
  <link href="https://cdn.anychart.com/releases/v8/fonts/css/anychart-font.min.css?hcode=be5162d915534272a57d0bb781d27f2b" type="text/css" rel="stylesheet">
  <style type="text/css">
html, body, #container {
    width: 100%;
    height: 100%;
    margin: 0;
    padding: 0;
}
</style>
</head>
<body>
  <div id="container"></div>
  <script>
anychart.onDocumentReady(function () {
    // create data set on our data,also we can pud data directly to series
    var dataSet = anychart.data.set([
        ['Jan', 22, 43, 75],
        ['Feb', 34, 45, 56],
        ['Mar', 16, 26, 67],
        ['Apr', 12, 86, 42],
        ['May', 41, 35, 17],
        ['Jun', 47, 31, 12],
        ['Jul', 39, 27, 9],
        ['Aug', 28, 16, 23],
        ['Sep', 21, 27, 47],
        ['Oct', 18, 31, 58],
        ['Nov', 24, 42, 69],
        ['Dec', 29, 39, 71]
    ]);

    // map data for the first series,take value from first column of data set
    var seriesData_1 = dataSet.mapAs({'x': 0, 'value': 1});

    // map data for the second series,take value from second column of data set
    var seriesData_2 = dataSet.mapAs({'x': 0, 'value': 2});

    // map data for the third series, take x from the zero column and value from the third column of data set
    var seriesData_3 = dataSet.mapAs({'x': 0, 'value': 3});

    // create line chart
    var chart = anychart.line();

    // turn on chart animation
    chart.animation(true);

    // turn on the crosshair and tune it
    chart.crosshair()
            .enabled(true)
            .yLabel(false)
            .xLabel(false)
            .yStroke(null);

    // set chart padding
    chart.padding([10, 20, 5, 20]);

    // set chart title text settings
    chart.title('ACME corp. Problems During the Year');

    // set yAxis title
    chart.yAxis().title('Occurences per month');

    // temp variable to store series instance
    var series;

    // setup first series
    series = chart.line(seriesData_1);
    series.name('Purchase Returns')
            .stroke('#000000')
            .size(4);
    series.hovered().markers(true);

    // setup second series
    series = chart.line(seriesData_2);
    series.name('Delivery Failure')
            .size(4)
            .stroke(
                    {
                        color: '#6C6C6C',
                        dash: '3 5 10 5'
                    }
            );
    series.hovered().markers(true);

    // setup third series
    series = chart.line(seriesData_3);
    series.name('Order Cancellation')
            .size(4)
            .stroke(
                    {
                        color: '#C8C8C8',
                        dash: '3 5'
                    }
            );
    series.hovered().markers(true);

    // interactivity and tooltip settings
    chart.interactivity().hoverMode('by-x');

    chart.tooltip()
            .displayMode('separated')
            .positionMode('point')
            .separator(false)
            .position('right')
            .anchor('left-bottom')
            .offsetX(2)
            .offsetY(5)
            .title(false)
            .format('{%Value} times');

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

                