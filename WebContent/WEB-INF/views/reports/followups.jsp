
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<link rel="stylesheet" type="text/css"
	href="resources/css/table.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


</head>    

<script>
$( function() {
    $("#followdatestart").datepicker({dateFormat: 'dd/mm/yy'
    	
    });
    
  });
$( function() {
    $("#followdateend").datepicker({dateFormat: 'dd/mm/yy'});
    
  });
</script>

<%
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
java.util.Date date = new java.util.Date(); 
%>
<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<i>
			
		</i> <input type="hidden" name="profile" value="0" />
	</div>
</div>
<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; color:white; left: 20px;  height: 24px;">
		<span class="glyphicon glyphicon-briefcase"></span> <span> Followup Reports</span>
		 
  		
</div>

</div><br>
<div class="container">
<div class="form-group">
    
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
 <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
   <input  class="form-control" name="" id="followdatestart" value="<%=dateFormat.format(date) %>" placeholder="Select Starting Date" readonly>
    </div>
  </div>
  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
   <input name=""  class="form-control" type="text" id="followdateend" placeholder="Select Ending Date" readonly>
    </div>
  </div>
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
 
 <button type="button" class="btn btn-success" id="getcalendarbydays">Send</button>
    </div>
  </div>
</div>
</div>
<table class="responstable" id="calendartable" style="width:98%;align:center">
  
 
</table>


<script>


function parseDate(str) {
    var mdy = str.split('/');
    return new Date(mdy[2], mdy[1]-1, mdy[0]);
}

function daydiff(first, second) {
    return Math.round((second-first)/(1000*60*60*24));
}

function checkLeapYear(yy){
	return ((yy % 100 === 0) ? (yy % 400 === 0) : (yy % 4 === 0));
}
$('#getcalendarbydays').click(function(){
	$('#calendartable').html('');
	var sdate=$('#followdatestart').val();
	var ldate=$('#followdateend').val();
	var sres = sdate.split("/");
	var lres = ldate.split("/");
	var weekday = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];
    var monthAt31=["1","3","5","7","8","10","12"];
    var monthAt30=["4","6","9","11"];
    var a = new Date(sres[1]+'/'+sres[0]+'/'+sres[2]);
    var dayinnum=a.getDay();
    var d=a.getDate();
    var day= weekday[a.getDay()];
	var totaldays=daydiff(parseDate($('#followdatestart').val()), parseDate($('#followdateend').val()));
	
	
	alert("total number of column creted "+totaldays);
	var markup='<th>S.No.</th><th>Employee Name</th>';
	for(var i=0;i<=totaldays;i++){
		markup += "<th>"+weekday[dayinnum]+"<br>"+d+"</th>";
		if(weekday[dayinnum]=="Sat"){
			
			dayinnum=parseInt(0);
		}else{
			dayinnum=parseInt(dayinnum)+parseInt(1);
		}
		/* alert((jQuery.inArray( sres[2], monthAt31) && d!=31));
		alert((jQuery.inArray( sres[2], monthAt30) && d!=30));
		alert((sres[2]=='2' && d!=28)); */
		//alert(sres[2]);
		if((monthAt31.includes(sres[1]) && d==31)){
			d=1;
		
		}else if((monthAt30.includes(sres[1]) && d==30)){
			d=1;
		}else if( (sres[2]=='2' && d==28)){
			d=1;
		}else{
			d++;
		}
		
		
	}
	$('#calendartable').prepend('<thead></thead>');
	$('#calendartable').find('thead').append(markup);
	$('#calendartable').find('thead').append('<th>Total</th><th>Average</th>');
	$.ajax({
		url: "getfollowuplistbyuserid?id=1&sdate="+sdate+"&edate="+ldate, 
		success: function(result){
			console.log(result);
			//search(result);
			
    }});
	});


</script>