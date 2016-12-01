<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/displaytag.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="resources/css/messagebox.css" />
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet" type="text/css" href="resources/css/view.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<style>

.checkbox label:after, 
.radio label:after {
    content: '';
    display: table;
    clear: both;
}

.checkbox .cr,
.radio .cr {
    position: relative;
    display: inline-block;
    border: 1px solid #a9a9a9;
    border-radius: .25em;
    width: 1.3em;
    height: 1.3em;
    float: left;
    margin-right: .5em;
}

.radio .cr {
    border-radius: 50%;
}

.checkbox .cr .cr-icon,
.radio .cr .cr-icon {
    position: absolute;
    font-size: .8em;
    line-height: 0;
    top: 50%;
    left: 20%;
}

.radio .cr .cr-icon {
    margin-left: 0.04em;
}

.checkbox label input[type="checkbox"],
.radio label input[type="radio"] {
    display: none;
}

.checkbox label input[type="checkbox"] + .cr > .cr-icon,
.radio label input[type="radio"] + .cr > .cr-icon {
    transform: scale(3) rotateZ(-20deg);
    opacity: 0;
    transition: all .3s ease-in;
}

.checkbox label input[type="checkbox"]:checked + .cr > .cr-icon,
.radio label input[type="radio"]:checked + .cr > .cr-icon {
    transform: scale(1) rotateZ(0deg);
    opacity: 1;
}

.checkbox label input[type="checkbox"]:disabled + .cr,
.radio label input[type="radio"]:disabled + .cr {
    opacity: .5;
}
</style>


<div class="row" style="margin-top: 15px">
			<br>
			<div align="center">
				<i>
				
				</i> <input type="hidden" name="profile" value="0" />
			</div>
		</div>

		<div class="row">

			
		</div>

		<div class="row" id="editpo">
			<div class="page-heading col-sm-11"
				style="background-color: #3C8DBC; left: 10px">
				<span class="glyphicon glyphicon-copy"></span>PO Invoice
			</div>
		</div>
		
		
		<div class="row form-group">

				<div class="col-sm-3 form-level">
					PO Reference No:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-4">
					<input type="text" name="porefno" placeholder="PO Reference No."
						onkeyup="myFunction()" id="porefno" size="150" value="${porefnumber}"
						class="form-control" />
				</div>

				<div class="col-sm-1 form-level">
					Date:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-2">
					<span> <input type="text" class="form-control" name="dateTodate"
						id="" value="${date}" ReadOnly></input>
						
					</span>

				</div>
			</div>
			<div class="row form-group">
				<div class="col-sm-3 form-level">
					Principal Name:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-9">
					<input type="text" name="principalname"
						placeholder="Principal Name" value="YMC Co. Ltd., Japan"
						class="form-control" style="display: inline-block;" ReadOnly>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-sm-3 form-level">
					Address:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-9">
					<textarea rows="4" cols="77" name="address"
						style="border-radius: 5px; background-color: #f2f2f2;" readonly>YMC CO.,LTD. YMC Karasuma-Gojo Building 284 Daigo-cho Karasuma Nishiliru Gojo-dori,Shimogyo -Ku Kyoto 600-8106 Japan"  </textarea>
						
				</div>
			</div>
			<div class="row form-group">

				<div class="col-sm-3 form-level" >
					Invoice No:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-2">
					<input type="text" name="principalname"
						placeholder="Invoice Number" value=""
						class="form-control" style="display: inline-block;" ReadOnly>
				</div>

				<div class="col-sm-2 form-level">
					Invoice Date:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
					<span> 
						<input type="text" class="form-control" name="dateTodate1"
						id="invoicedate"  ReadOnly></input>
					</span>

				</div>
			</div>
			<div class="row form-group">

				<div class="col-sm-3 form-level" >
					S.No.:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-2">
					<select name="" class="form-control selectpicker" required="required" id="">
  						<option>---Select---</option> 
  						<c:if test="${!empty listbyporef}">
						<c:forEach items="${listbyporef}" var="poref" varStatus="loop">
						      <option value="${loop.index+1}">${loop.index+1}</option>
							 
						</c:forEach>
						</c:if>
  					</select>
				</div>

				<div class="col-sm-2 form-level">
					Part NO.:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
					<span> <select name="" class="form-control selectpicker" required="required" id="" onChange="searchPro(this.value)">
					 <option>---Select---</option> 
							<c:if test="${!empty listbyporef}">
								<c:forEach items="${listbyporef}" var="poref" varStatus="loop">
 
						      <option value="${poref.porefentryitemdetailid}">${poref.particular}</option>
							  
						  		</c:forEach>
							</c:if>
  						</select>
						
					</span>

				</div>
			</div>
			<hr style="color: black">
					<div class="row form-group">
						<div class="col-sm-7">
						</div>
					</div>
					<table style="width: 100%; bottom: 15px; position: relative; visibility: hidden;" border="0" id="gettrifchecked">
					<tbody>
					
					</tbody>
					</table>
					
					<div id='body'>
					
					<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable">
					<thead>
						<tr bgcolor="#3C8DBC">
									<td style="display: none;"><label>id</label> </td>
									<td class="col-sm-1 form-level" style="width: 10px">&nbsp;<font size="2" color="white"><label>S.No.</label></font></td>
									<td class="col-sm-3 form-level" style="width: 80px"align="center">&nbsp;<font size="2" color="white"><label >Part No</label></font></td>
									<td align="center" class="col-sm-1 form-level"style="width: 80px">&nbsp;&nbsp;&nbsp;<font size="2" color="white"><label >Description</label></font></td>
									
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >TP In JPY</label></font></td>
									
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >QTY</label></font></td>
									
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >Total JPY</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 65px"color="white"><label >Pending Qty</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 65px"color="white"><label >Receive Qty</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 65px"color="white"><label >Pending Qty</label></font></td>
									<td align="center">&nbsp;<div class="checkbox">
          <label>
            <input type="checkbox" value="" id="maincheackbox" onclick="toggle(this)">
            <span class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
            
          </label>
        </div></td>
							<%-- <td align="center"> &nbsp;<font size="2" style="width: 80px" color="white"><label path="">Total INR</label></font> --%>
					
					</tr>
					</thead>
					<tbody id="addprolisttbody">
					<c:if test="${!empty listbyporef}">
						<c:forEach items="${listbyporef}" var="poref" varStatus="loop">
					
					<tr>
					<td style="display: none;"><input type="hidden" name="date" value="${date}" id="getdate${loop.index+1}"> </td>
					<td style="display: none;"><input type="hidden" name="porefno" value="${porefnumber}" id="getporefno${loop.index+1}"> </td>
					<td style="display: none;"><input type="hidden" name="entryitemid" value="${poref.porefentryitemdetailid}" id="getid${loop.index+1}"> </td>
					<td style="right: 5px; position: relative;">&nbsp;<input type="text" style="width: 60px" name="" id="sr${loop.index+1}" value="${loop.index+1}" class="form-control" readonly></td>
					<td style="left: 2px; position: relative; width: 150px">&nbsp;<input readonly type="text" value="${poref.particular}" name="particulee${loop.index+1}" style="overflow: auto; border-radius: 3px; width: 223px;" id="partno${loop.index+1}" class="form-control"></td>
					<td style="width: 250px">&nbsp; <input readonly name="description" id="description${loop.index+1}" class="form-control" style="text-align: center;width: 238px;" value="${poref.productdescription}"></td>
					<td style="right: 7px; position: relative;">&nbsp; <input readonly type="text" style="text-align: center;" name="tpinjpy" id="tpinjpy${loop.index+1}" value="${poref.tpinjpy}" class="form-control"></td>
					<td align="center" style="right: 4px; position: relative;">&nbsp;<input readonly type="text" style="text-align: center;width: 55px;" name="qty" id="qty${loop.index+1}" class="form-control" value="${poref.qty}"></td>
					<td align="center">&nbsp; <input readonly type="text" style="text-align: center;" name="totaljpy" id="totaljpy${loop.index+1}" value="${poref.totaljpy}" class="form-control"></td>
					<td align="center">&nbsp;<button  type="button" style="text-align: center;width: 49px;background-color: #3C8DBC;color: aliceblue" name="pendingqty" id="pendingqty${loop.index+1}" value="${poref.pendingqty}" class="form-control" onclick="getacknowlegdement(${loop.index+1});">${poref.pendingqty}</button></td>
					<td align="center">&nbsp; <input  type="text" style="text-align: center;width: 69px" name="reciveqty" id="reciveqty${loop.index+1}" class="form-control" onkeyup="getcals(this.value,${loop.index+1});"></td>
					<td align="center">&nbsp; <input  type="text" style="text-align: center;width: 69px" name="remainingqty" id="remainingqty${loop.index+1}" class="form-control"></td>
					<td align="center">&nbsp;<div class="checkbox">
          		<label>
            <input type="checkbox" value="" name="savecheck" id="savecheck${loop.index+1}">
            <span class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
            
          		</label>
        </div></td>
					<td style="display: none;"><input type="hidden" name="grandtotal" value="${gtotal}" id="grandtotal${loop.index+1}"> </td>
					<td style="display: none;"><input type="hidden" name="date" value="11/21/2016" id="getdate"> </td>
					
					</tr>
					</c:forEach>
					</c:if>
					</tbody>
					</table>
					</div>
					
					
					<div class="row form-group"  position: relative;" onclick="" id="pendingformdiv">
					
					
					<table style="width: 100%; position: relative;" > 
					<tr >
					<td class="col-sm-6 form-level" align="center">
					<button type="button" value="update"
								class="btn btn-success pull-center" id="saveinvoicedetail"
								style="background-color: #3C8DBC;">Save Invoice</button>
					</td>
					
					</tr>
					
					</table>
				</div>
					
			</div>
			
			
			
			
			
			
			
			
			
			
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>



<script>

$( function() {
    $("#invoicedate").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  

	function toggle(source)
    {
        checkboxes = document.getElementsByName('savecheck');
        for(var i=0, n=checkboxes.length;i<n;i++) {
        checkboxes[i].checked = source.checked;
        }
    }
  
 $(document).ready(function(){
	 var table = document.getElementById("quotprodtable");
		var len=table.rows.length-1;
		var qty;
		var pending;
		for(var i=1;i<=len;i++){
			
			qty=$('#qty'+i).val();
			pending=$('#pendingqty'+i).val();
			if(pending=='0.0'){
				$('#reciveqty'+i).prop("readonly", true);
				$('#remainingqty'+i).prop("readonly", true);
			}
		}
 });
 
 
 function getcals(v1,v2){
	 var pending=$('#pendingqty'+v2).val();
	 $('#remainingqty'+v2).val(pending-v1);
 }
 
 $('#saveinvoicedetail').click(function(){
	 var table = document.getElementById("quotprodtable");
		var len=table.rows.length-1;
		
		for(var n=1;n<=len;n++)
	{
			if($('#savecheck'+n).is(':checked')){
				var rec=$('#reciveqty'+n).val();
				var rem=	$('#remainingqty'+n).val();
				$('#reciveqty'+n).attr("value",rec);
				$('#remainingqty'+n).attr("value",rem);
				var row = $('#savecheck'+n).closest('tr').html();
				
				$('#gettrifchecked tbody').append('<tr>'+row+'</tr>');
				
				
			
				
			}
			
	 }
		
		var AddressesDataJSON = $("#gettrifchecked").find('input').serializeArray();
		  console.log(AddressesDataJSON);
		 alert(JSON.stringify(AddressesDataJSON));
 });
</script>