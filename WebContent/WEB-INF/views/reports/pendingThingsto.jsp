<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="resources/css/table.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" />
<style>

.forum_hover { background-color: #380606 !important; }

.forum { color: white; }
#blue { background-color: blue; }
</style>


<div class="row" style="margin-top: 15px">
				<br>
				<div align="center">
					<i> </i> <input type="hidden" name="profile" value="0" />
				</div>
</div>
			<div class="row">

				<div class="page-heading col-md-11.5"
					style="background-color: #3C8DBD; color: white; left: 20px; height:44px;">
					<span class="glyphicon glyphicon-user" ></span><span>Pending Plan</span>
					

				</div>

			</div>
			<br>
		<table class="responstable"  id="quotprodtable">

			<thead>
				<tr>
					<th>S.N.</th>
					<th>Employee</th>
					<th>Visit</th>
					<th>Phone</th>
					<th>Email</th>
					<th>SMS</th>
					<th>Others</th>
					<th>Total</th>


				</tr>
</thead>
<tbody>
				 <c:if test="${!empty diarydata}">
					<c:forEach items="${diarydata}" var="diarylist" varStatus="loop">

						<tr>
							<td>${loop.index+1}</td>
							<td>${diarylist.enteryuser}</td>
							<td id="appoit${loop.index+1}" style="text-align: center;"><a href="">${diarylist.totalappointment }</a></td>
							
							<td id="phon${loop.index+1}" style="text-align: center;"><a href="">${diarylist.totalphone }</a></td>
							<td id="emal${loop.index+1}" style="text-align: center;"><a href="">${diarylist.totalemail }</a></td>
							<td id="smss${loop.index+1}" style="text-align: center;" ><a href="">${diarylist.totalsms }</a></td>
							<td id="otherss${loop.index+1}" style="text-align: center;"><a href="">${diarylist.totalothers }</a></td>
							<td id="total12${loop.index+1}" style="text-align: center;"><a href="">${diarylist.total }</a></td>
						</tr>

					</c:forEach>
				</c:if>
				</tbody>
				<tfoot>
					<tr>
							<td></td>
							<td>Total</td>
							<td style="text-align: center;"><a href="" id="appoit"></a></td>
							<td id="" style="text-align: center;"><a href="" id="phon"></a></td>
							<td id="" style="text-align: center;"><a href="" id="emal"></a></td>
							<td id="" style="text-align: center;"><a href="" id="smss"></a></td>
							<td id="" style="text-align: center;"><a href="" id="otherss"></a></td>
							<td id="" style="text-align: center;"><a href="" id="total12"></a></td>
						</tr>
			</tfoot>
		</table>
		
		<div>
		
		
		</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>

<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript">
<!--

//-->

$(document).ready(function(){
	
	colSum();
	disablelink();
  });

  function colSum() {
	  var table = document.getElementById("quotprodtable");
		var len=table.rows.length-1;
		
    var sumap=0;
    var sumap1=0;
    var sumap2=0;
    var sumap3=0;
    var sumap4=0;
    var sumap5=0;
  for(var i=1;i<len;i++){
	  
	  
	 sumap+= parseInt($('#appoit'+i).text());
	 sumap1+= parseInt($('#phon'+i).text());
	 sumap2+= parseInt($('#emal'+i).text());
	 sumap3+= parseInt($('#smss'+i).text());
	 sumap4+= parseInt($('#otherss'+i).text());
	 sumap5+= parseInt($('#total12'+i).text());
	 
	
  }
   
  $('#appoit').text(sumap);
  $('#phon').text(sumap1);
  $('#emal').text(sumap2);
  $('#smss').text(sumap3);
  $('#otherss').text(sumap4);
  $('#total12').text(sumap5);
  }
  function disablelink() {
	  var table = document.getElementById("quotprodtable");
		var len=table.rows.length-1;
		for(var i=1;i<len;i++){
			if($('#appoit'+i).text()=='0'){
				$('#appoit'+i).attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
			}
			
			if($('#phon'+i).text()=='0'){
				$('#phon'+i).attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
			}
			if($('#emal'+i).text()=='0'){
				$('#emal'+i).attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
			}
			if($('#smss'+i).text()=='0'){
				$('#smss'+i).attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
			}
			if($('#otherss'+i).text()=='0'){
				$('#otherss'+i).attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
			}
			if($('#total12'+i).text()=='0'){
				$('#total12'+i).attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
			}
		}
		
		
		if($('#appoit').text()=='0'){
			$('#appoit').attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
		}
		
		if($('#phon').text()=='0'){
			$('#phon').attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
		}
		if($('#emal').text()=='0'){
			$('#emal').attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
		}
		if($('#smss').text()=='0'){
			$('#smss').attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
		}
		if($('#otherss').text()=='0'){
			$('#otherss').attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
		}
		if($('#total12').text()=='0'){
			$('#total12').attr('href', '').css({'cursor': 'pointer', 'pointer-events' : 'none'});
		}
  }
  
  $(document).ready(function(){
	  $("#quotprodtable tr td a").hover(function(){
	    $(this).css("color","RED");
	  },function(){
	    $(this).css("color","");
	  });
	  
	  $('#quotprodtable').DataTable( {
	        "order": [[0, "desc" ]]
	    } );
	});
  
  
</script>
		