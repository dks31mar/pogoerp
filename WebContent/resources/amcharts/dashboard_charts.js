function populateFirstChart(){
 var chart;

var chartData = [
    {
        "country": "USA",
        "visits": 4025,
        "color": "#FF0F00"
    },
    {
        "country": "China",
        "visits": 1882,
        "color": "#FF6600"
    },
    {
        "country": "Japan",
        "visits": 1809,
        "color": "#FF9E01"
    },
    {
        "country": "Germany",
        "visits": 1322,
        "color": "#FCD202"
    }
];


AmCharts.ready(function () {
    // SERIAL CHART
    var chartData = AmCharts.loadJSON('/'+globaldomain+'/newSalesCallForm.do?method=getEmployeeOrders');
    chart = new AmCharts.AmSerialChart();
    chart.dataProvider = chartData;
    chart.categoryField = "country";
    // the following two lines makes chart 3D
    chart.depth3D = 20;
    chart.angle = 30;

    // AXES
    // category
    var categoryAxis = chart.categoryAxis;
    categoryAxis.labelRotation = 90;
    categoryAxis.dashLength = 5;
    categoryAxis.gridPosition = "start";

    // value
    var valueAxis = new AmCharts.ValueAxis();
    valueAxis.title = "Order Amount";
    valueAxis.dashLength = 5;
    chart.addValueAxis(valueAxis);

    // GRAPH
    var graph = new AmCharts.AmGraph();
    graph.valueField = "visits";
    graph.colorField = "color";
    graph.balloonText = "<span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>";
    graph.type = "column";
    graph.lineAlpha = 0;
    graph.fillAlphas = 1;
    chart.addGraph(graph);

    // CURSOR
    var chartCursor = new AmCharts.ChartCursor();
    chartCursor.cursorAlpha = 0;
    chartCursor.zoomable = false;
    chartCursor.categoryBalloonEnabled = false;
    chart.addChartCursor(chartCursor);

    chart.creditsPosition = "top-right";


    // WRITE
    chart.write("chartdiv1");
});    
}


function populateSecondChart(){
var chart;
            var legend;

            var chartData = [
                {
                    "country": "Lithuania",
                    "value": 260
                },
                {
                    "country": "Ireland",
                    "value": 201
                },
                {
                    "country": "Germany",
                    "value": 65
                },
                {
                    "country": "Australia",
                    "value": 39
                },
                {
                    "country": "UK",
                    "value": 19
                },
                {
                    "country": "Latvia",
                    "value": 10
                }
            ];

            AmCharts.ready(function () {
                // PIE CHART
                var chartData = AmCharts.loadJSON('/'+globaldomain+'/newSalesCallForm.do?method=getRegionOrders');
                chart = new AmCharts.AmPieChart();
                chart.dataProvider = chartData;
                chart.titleField = "country";
                chart.valueField = "value";
                chart.outlineColor = "#FFFFFF";
                chart.outlineAlpha = 0.8;
                chart.outlineThickness = 2;
                chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
                // this makes the chart 3D
                chart.depth3D = 15;
                chart.angle = 30;

                // WRITE
                chart.write("chartdiv2");
            });
}

function populateThirdChart(){
    var chart;
            var data = [
                {
                    "title": "Website visits",
                    "value": 300
                },
                {
                    "title": "Downloads",
                    "value": 123
                },
                {
                    "title": "Requested price list",
                    "value": 98
                },
                {
                    "title": "Contaced for more info",
                    "value": 72
                },
                {
                    "title": "Purchased",
                    "value": 35
                },
                {
                    "title": "Contacted for support",
                    "value": 15
                },
                {
                    "title": "Purchased additional products",
                    "value": 8
                }
            ];
                
            AmCharts.ready(function () {
                    var data = AmCharts.loadJSON('/'+globaldomain+'/newSalesCallForm.do?method=getChartData');
                chart = new AmCharts.AmFunnelChart();
                chart.titleField = "title";
                chart.balloon.cornerRadius = 0;
                chart.marginRight = 220;
                chart.marginLeft = 15;
                chart.labelPosition = "right";
                chart.funnelAlpha = 0.9;
                chart.valueField = "value";
                chart.dataProvider = data;
                chart.startX = 0;
                chart.balloon.animationTime = 0.2;
                chart.neckWidth = "40%";
                chart.startAlpha = 0;
                chart.neckHeight = "30%";
                chart.balloonText = "[[title]]:<b>[[value]]</b>";

                chart.creditsPosition = "top-right";
                chart.write("chartdiv3");
            });
}

function populateForthChart(){
                var chart;

            var chartData = [
                {
                    "year": 2005,
                    "income": 23.5,
                    "expenses": 18.1
                },
                {
                    "year": 2006,
                    "income": 26.2,
                    "expenses": 22.8
                },
                {
                    "year": 2007,
                    "income": 30.1,
                    "expenses": 23.9
                },
                {
                    "year": 2008,
                    "income": 29.5,
                    "expenses": 25.1
                },
                {
                    "year": 2009,
                    "income": 24.6,
                    "expenses": 25
                }
            ];


            AmCharts.ready(function () {
                // SERIAL CHART
                var chartData = AmCharts.loadJSON('/'+globaldomain+'/newSalesCallForm.do?method=getBranchOrdersCollection');
                chart = new AmCharts.AmSerialChart();
                chart.dataProvider = chartData;
                chart.categoryField = "year";
                chart.startDuration = 1;
                chart.rotate = true;

                // AXES
                // category
                var categoryAxis = chart.categoryAxis;
                categoryAxis.gridPosition = "start";
                categoryAxis.axisColor = "#DADADA";
                categoryAxis.dashLength = 3;

                // value
                var valueAxis = new AmCharts.ValueAxis();
                valueAxis.dashLength = 3;
                valueAxis.axisAlpha = 0.2;
                valueAxis.position = "top";
                valueAxis.title = "INR";
                valueAxis.minorGridEnabled = true;
                valueAxis.minorGridAlpha = 0.08;
                valueAxis.gridAlpha = 0.15;
                chart.addValueAxis(valueAxis);

                // GRAPHS
                // column graph
                var graph1 = new AmCharts.AmGraph();
                graph1.type = "column";
                graph1.title = "Income";
                graph1.valueField = "income";
                graph1.lineAlpha = 0;
                graph1.fillColors = "#ADD981";
                graph1.fillAlphas = 0.8;
                graph1.balloonText = "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b></span>";
                chart.addGraph(graph1);

                // line graph
                var graph2 = new AmCharts.AmGraph();
                graph2.type = "line";
                graph2.lineColor = "#27c5ff";
                graph2.bulletColor = "#FFFFFF";
                graph2.bulletBorderColor = "#27c5ff";
                graph2.bulletBorderThickness = 2;
                graph2.bulletBorderAlpha = 1;
                graph2.title = "Expenses";
                graph2.valueField = "expenses";
                graph2.lineThickness = 2;
                graph2.bullet = "round";
                graph2.fillAlphas = 0;
                graph2.balloonText = "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b></span>";
                chart.addGraph(graph2);

                // LEGEND
                var legend = new AmCharts.AmLegend();
                legend.useGraphSettings = true;
                chart.addLegend(legend);

                chart.creditsPosition = "top-right";

                // WRITE
                chart.write("chartdiv4");
            });

}




$(document).ready(function(){
populateFirstChart();
populateSecondChart();
populateThirdChart();
populateForthChart();
})

AmCharts.loadJSON = function(url) {
  // create the request
  if (window.XMLHttpRequest) {
    // IE7+, Firefox, Chrome, Opera, Safari
    var request = new XMLHttpRequest();
  } else {
    // code for IE6, IE5
    var request = new ActiveXObject('Microsoft.XMLHTTP');
  }
  //alert(url);
 request.open('get', url, false);
 request.send();
  // parse adn return the output
  return eval(request.responseText);
};