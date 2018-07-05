package Util;
import java.io.BufferedWriter;
import java.io.IOException;

public class Htmlfilewriter {

	public void write( BufferedWriter bw, int Native_Heap_Free[],int Total_Heap_Free[] , int Native_Heap_Alloc[],
			int Native_Pss [],int Total_Heap_Alloc[] ,int Total_Pss[],int t)
	//,String CPU_0,
	//		String CPU_1,String CPU_2,String CPU_3)
					throws IOException {

		bw.write("\n" + 
				"<html xmlns:margin=\"http://www.w3.org/1999/xhtml\">\n" + 
				"<head>\n" + 
				"    <title>Highcharts Tutorial</title>\n" + 
				"    <script src = \"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\">\n" + 
				"    </script>\n" + 
				"    <script src = \"https://code.highcharts.com/highcharts.js\"></script>\n" + 
				"    <script src = \"https://code.highcharts.com/modules/data.js\"></script>\n" + 
				"</head>\n" + 
				"\n" + 
				"<body>\n" + 
				"<div id = \"container\" style = \"width: 750px; height: 400px; margin: 0 auto\"></div>\n" + 
				"<script language = \"JavaScript\">\n" + 
				"         $(document).ready(function() {\n" + 
				"            var data = {\n" + 
				"               table: 'datatable'\n" + 
				"            };\n" + 
				"            var chart = {\n" + 
				"               type: 'column'\n" + 
				"            };\n" + 
				"            var title = {\n" + 
				"               text: 'Memory consumption of Vision Sample App'\n" + 
				"            };\n" + 
				"            var yAxis = {\n" + 
				"               allowDecimals: false,\n" + 
				"               title: {\n" + 
				"                  text: 'Kilobytes'\n" + 
				"               }\n" + 
				"            };\n" + 
				"            var tooltip = {\n" + 
				"               formatter: function () {\n" + 
				"                  return '<b>' + this.series.name + '</b><br/>' +\n" + 
				"                     this.point.y + ' ' + this.point.name.toLowerCase();\n" + 
				"               }\n" + 
				"            };\n" + 
				"            var credits = {\n" + 
				"               enabled: false\n" + 
				"            };\n" + 
				"            var json = {};\n" + 
				"            json.chart = chart;\n" + 
				"            json.title = title;\n" + 
				"            json.data = data;\n" + 
				"            json.yAxis = yAxis;\n" + 
				"            json.credits = credits;\n" + 
				"            json.tooltip = tooltip;\n" + 
				"            $('#container').highcharts(json);\n" + 
				"         });\n" + 
				"      </script>\n" + 
				"<style>\n" + 
				"thead {color:green;}\n" + 
				"tbody {color:blue;}\n" + 
				"tfoot {color:red;}\n" + 
				"\n" + 
				"table, th, td {\n" + 
				"    border: 1px solid black;\n" + 
				"}\n" + 
				"</style>\n" + 
				"\n" + 
				"<table id = \"datatable\" style = \"width: 850px; height: 40px; margin: 0 auto\">\n" + 
				"    <thead>\n" + 
				"    <tr>\n" + 
				"         <th>Scenario</th>\n" + 
				"        <th>Total Heap Free</th>\n" + 
				"        <th>Native Heap Free</th>\n" + 
				"        <th>Native Heap Alloc</th>\n" + 
				"        <th>Native Pss</th>\n" + 
				"        <th>Total Heap_Alloc</th>\n" + 
				"        <th>Total Pss</th>\n"+
				"    </tr>\n" + 
				"    </thead>\n" + 
				"    <tbody>\n" + 
				"    <tr>\n" + 
				"        <th>login</th>\n" + 

				"        <td>"+Total_Heap_Free[1]+"</td>\n" + 
				"        <td>"+Native_Heap_Free[1]+"</td>\n" + 
				"        <td>"+Native_Heap_Alloc[1]+"</td>\n" + 
				"        <td>"+Native_Pss[1]+"</td>\n" + 
				"        <td>"+Total_Heap_Alloc[1]+"</td>\n" + 
				"        <td>"+Total_Pss[1]+"</td>\n" + 
				"        <!--</tr>-->\n" + 
				"        <!--<tr>-->\n" + 
				"        <!--<th>logout</th>-->\n" + 
				"        <!--<td>800</td>-->\n" + 
				"        <!--<td>1200</td>-->\n" + 
				"        <!--<td>1100</td>-->\n" + 
				"        <!--<td>800</td>-->\n" + 
				"        <!--</tr>-->\n" + 
				"        <tr>\n" + 
				"        <th>playback(Reading 1)</th>\n" + 
				"        <td>"+Total_Heap_Free[2]+"</td>\n" + 
				"        <td>"+Native_Heap_Free[2]+"</td>\n" + 
				"        <td>"+Native_Heap_Alloc[2]+"</td>\n" + 
				"        <td>"+Native_Pss[2]+"</td>\n" + 
				"        <td>"+Total_Heap_Alloc[2]+"</td>\n" + 
				"        <td>"+Total_Pss[2]+"</td>\n" + 
				"        </tr>\n" + 

"        <tr>\n" + 
"        <th>playback(Reading 2)</th>\n" + 
"        <td>"+Total_Heap_Free[3]+"</td>\n" + 
"        <td>"+Native_Heap_Free[3]+"</td>\n" + 
"        <td>"+Native_Heap_Alloc[3]+"</td>\n" + 
"        <td>"+Native_Pss[3]+"</td>\n" + 
"        <td>"+Total_Heap_Alloc[3]+"</td>\n" + 
"        <td>"+Total_Pss[3]+"</td>\n" + 
"        </tr>\n" + 

"        <tr>\n" + 
"        <th>playback(Reading 3)</th>\n" + 
"        <td>"+Total_Heap_Free[4]+"</td>\n" + 
"        <td>"+Native_Heap_Free[4]+"</td>\n" + 
"        <td>"+Native_Heap_Alloc[4]+"</td>\n" + 
"        <td>"+Native_Pss[4]+"</td>\n" + 
"        <td>"+Total_Heap_Alloc[4]+"</td>\n" + 
"        <td>"+Total_Pss[4]+"</td>\n" + 
"        </tr>\n" + 
"\n" + 
"    </tbody>\n" + 
"</table>\n" + 
"\n" + 
"<div id=\"piechart\" style = \"width: 550px; height: 400px; margin: 0 auto\"></div>\n" + 
"\n" + 
"<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" + 
"<script type=\"text/javascript\">\n" + 
"// Load google charts\n" + 
"google.charts.load('current', {'packages':['corechart']});\n" + 
"google.charts.setOnLoadCallback(drawChart);\n" + 
"````````````````````\n" + 
"// Draw the chart and set the chart values\n" + 
"function drawChart() {\n" + 
"  var data = google.visualization.arrayToDataTable([\n" + 
"  ['CPU Usage', 'Mah'],\n" + 
"  ['CPU1', 8],\n" + 
"  ['CPU0', 2],\n" + 
"  ['CPU2', 4],\n" + 
"  ['CPU3', 2],\n" + 
"  ['Sleep', 8]\n" + 
"]);\n" + 
"\n" + 
"  // Optional; add a title and set the width and height of the chart\n" + 
"  var options = {'title':'CPUusage', 'width':750, 'height':400};\n" + 
"\n" + 
"  // Display the chart inside the <div> element with id=\"piechart\"\n" + 
"  var chart = new google.visualization.PieChart(document.getElementById('piechart'));\n" + 
"  chart.draw(data, options);\n" + 
"}\n" + 
"</script>\n" + 
"\n" + 
"<style>\n" + 
"thead {color:green;}\n" + 
"tbody {color:blue;}\n" + 
"tfoot {color:red;}\n" + 
"\n" + 
"table, th, td {\n" + 
"    border: 1px solid black;\n" + 
"}\n" + 
"</style>\n" + 
"\n" + 
"<table id = \"datatable1\" style = \"width: 550px; height: 20px; margin: 0 auto\">\n" + 
"    <thead>\n" + 
"    <tr>\n" + 
"        <th>Scenario</th>\n" + 
"        <th>CPU0</th>\n" + 
"        <th>CPU1</th>\n" + 
"        <th>CPU2</th>\n" + 
"        <th>CPU3</th>\n" + 
"    </tr>\n" + 
"    </thead>\n" + 
"    <tbody>\n" + 
"    <tr>\n" + 
"        <th>login</th>\n" + 
//				"        <td>"+CPU_0+"</td>\n" + 
//				"        <td>"+CPU_1+"</td>\n" + 
//				"        <td>"+CPU_2+"</td>\n" + 
//				"        <td>"+CPU_3+"</td>\n" + 
"    </tr>\n" + 
"    <!--<tr>-->\n" + 
"    <!--<th>logout</th>-->\n" + 
"    <!--<td>800</td>-->\n" + 
"    <!--<td>1200</td>-->\n" + 
"    <!--<td>1100</td>-->\n" + 
"    <!--<td>800</td>-->\n" + 
"    <!--</tr>-->\n" + 
"    <tr>\n" + 
"    <th>playback</th>\n" + 
"    <td>800</td>\n" + 
"    <td>1200</td>\n" + 
"    <td>1000</td>\n" + 
"    <td>600</td>\n" + 
"    </tr>\n" + 
"\n" + 
"    </tbody>\n" + 
"</table>\n" + 
"\n" + 
"<!--<script src1 = \"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\">-->\n" + 
"<!--</script>-->\n" + 
"<!--<script src1 = \"https://code.highcharts.com/highcharts.js\"></script>-->\n" + 
"\n" + 
"<!--<div id = \"container2\" style = \"width: 550px; height: 400px; margin: 0 auto\"></div>-->\n" + 
"<!--<script language = \"JavaScript\">-->\n" + 
"<!--$(document).ready(function() {-->\n" + 
"<!--var chart = {-->\n" + 
"<!--type: 'spline',-->\n" + 
"<!--animation: Highcharts.svg, // don't animate in IE < IE 10.-->\n" + 
"<!--marginRight: 10,-->\n" + 
"\n" + 
"<!--events: {-->\n" + 
"<!--load: function () {-->\n" + 
"<!--// set up the updating of the chart each second-->\n" + 
"<!--var series = this.series[0];-->\n" + 
"\n" + 
"<!--setInterval(function () {-->\n" + 
"<!--var x = (new Date()).getTime(), // current time-->\n" + 
"<!--y = Math.random();-->\n" + 
"<!--series.addPoint([x, y], true, true);-->\n" + 
"<!--}, 1000);-->\n" + 
"<!--}-->\n" + 
"<!--}-->\n" + 
"<!--};-->\n" + 
"<!--var title = {-->\n" + 
"<!--text: 'Live random data'-->\n" + 
"<!--};-->\n" + 
"<!--var xAxis = {-->\n" + 
"<!--type: 'datetime',-->\n" + 
"<!--tickPixelInterval: 150-->\n" + 
"<!--};-->\n" + 
"<!--var yAxis = {-->\n" + 
"<!--title: {-->\n" + 
"<!--text: 'Value'-->\n" + 
"<!--},-->\n" + 
"<!--plotLines: [{-->\n" + 
"<!--value: 0,-->\n" + 
"<!--width: 1,-->\n" + 
"<!--color: '#808080'-->\n" + 
"<!--}]-->\n" + 
"<!--};-->\n" + 
"<!--var tooltip = {-->\n" + 
"<!--formatter: function () {-->\n" + 
"<!--return '<b>' + this.series.name + '</b><br/>' +-->\n" + 
"<!--Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +-->\n" + 
"<!--Highcharts.numberFormat(this.y, 2);-->\n" + 
"<!--}-->\n" + 
"<!--};-->\n" + 
"<!--var plotOptions = {-->\n" + 
"<!--area: {-->\n" + 
"<!--pointStart: 1940,-->\n" + 
"<!--marker: {-->\n" + 
"<!--enabled: false,-->\n" + 
"<!--symbol: 'circle',-->\n" + 
"<!--radius: 2,-->\n" + 
"\n" + 
"<!--states: {-->\n" + 
"<!--hover: {-->\n" + 
"<!--enabled: true-->\n" + 
"<!--}-->\n" + 
"<!--}-->\n" + 
"<!--}-->\n" + 
"<!--}-->\n" + 
"<!--};-->\n" + 
"<!--var legend = {-->\n" + 
"<!--enabled: false-->\n" + 
"<!--};-->\n" + 
"<!--var exporting = {-->\n" + 
"<!--enabled: false-->\n" + 
"<!--};-->\n" + 
"<!--var series = [{-->\n" + 
"<!--name: 'Random data',-->\n" + 
"<!--data: (function () {-->\n" + 
"<!--// generate an array of random data-->\n" + 
"<!--var data = [],time = (new Date()).getTime(),i;-->\n" + 
"\n" + 
"<!--for (i = -19; i <= 0; i += 1) {-->\n" + 
"<!--data.push({-->\n" + 
"<!--x: time + i * 1000,-->\n" + 
"<!--y: Math.random()-->\n" + 
"<!--});-->\n" + 
"<!--}-->\n" + 
"<!--return data;-->\n" + 
"<!--}())-->\n" + 
"<!--}];-->\n" + 
"\n" + 
"<!--var json = {};-->\n" + 
"<!--json.chart = chart;-->\n" + 
"<!--json.title = title;-->\n" + 
"<!--json.tooltip = tooltip;-->\n" + 
"<!--json.xAxis = xAxis;-->\n" + 
"<!--json.yAxis = yAxis;-->\n" + 
"<!--json.legend = legend;-->\n" + 
"<!--json.exporting = exporting;-->\n" + 
"<!--json.series = series;-->\n" + 
"<!--json.plotOptions = plotOptions;-->\n" + 
"\n" + 
"<!--Highcharts.setOptions({-->\n" + 
"<!--global: {-->\n" + 
"<!--useUTC: false-->\n" + 
"<!--}-->\n" + 
"<!--});-->\n" + 
"<!--$('#container2').highcharts(json);-->\n" + 
"<!--});-->\n" + 
"<!--</script>-->\n" + 
"</body>\n" + 
"\n" + 
"\n" + 
				"</html>");



		bw.close();
		System.out.println("Html file created succesfully");
	}

}