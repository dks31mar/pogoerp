
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

 <!-- <link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
    <script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script> -->
	
   

<style>

#success_message{ display: Edited;}
</style>



	 
<div id="message" style="display: none;"></div>
<div id="body">
<div class="container">

    <form:form class="well form-horizontal" name="forp" action="saveuserEmp" method="POST"  commandName="userbean"
    id="validate-form" >
   
<fieldset>

<!-- Form Name -->
<legend>Edit Item</legend>
  <div class="form-group">
  <label class="col-md-2 control-label">Id</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  value="${product.productid}" name="" id="productid"   readonly="readonly"  class="form-control"  type="text" required="required">
    </div>
  </div>
  <label class="col-md-2 control-label" style="">Code<span style="color: red;">*</span></label>
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="productcode" value="${product.productcode}"  placeholder="Enter Product Code" required="required"  class="form-control"  type="text" id="productcode">
  <div id="msg1" align="center"><span style="color: red">*Input Needed</span></div>
  </div>
  </div>
</div>
 <div class="form-group">
  <label class="col-md-2 control-label">Name<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input value="${product.productname}"  name="loginname" placeholder="Product Name" required="required"  class="form-control"  type="text" id="productname">
   <div id="msg2" align="center"><span style="color: red">*Input Needed</span></div>
    </div>
  </div>
   <label class="col-md-2 control-label" style="">Description<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
        <input value="${product.description}"  class="form-control" name="address"  placeholder="Product Description" required="required" id="description">
  
    <div id="msg3" align="center"><span style="color: red">*Input Needed</span></div>
    </div>
  </div>
  
</div>
<div class="form-group">
<label class="col-md-2 control-label" style="">Type<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required" id="producttype">
  <option value="${prohead.productheadid}">${prohead.productheadname}</option>
  <c:if test="${!empty productlist}">
	<c:forEach items="${productlist}" var="cur" varStatus="loop">
      <option value="${cur.productheadid}">${cur.productheadname}</option>
	  </c:forEach>
	</c:if>
  </select>
    </div>
  </div>
  <label class="col-md-2 control-label" style="">Sub Type<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required" id="productsubtype">
  <option value="${prosubhead.productsubheadid}">${prosubhead.productsubheadname}</option>
      <c:if test="${!empty subproductlist}">
			<c:forEach items="${subproductlist}" var="sunpro" varStatus="loop">
      <option value="${sunpro.productsubheadid}">${sunpro.productsubheadname}</option>
	  		</c:forEach>
	  </c:if>
  </select>
    </div>
  </div>
  
</div>

<!-- Text input-->

<div class="form-group">

<label class="col-md-2 control-label" style="">Input Cost<span style="color: red;">*</span></label></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input value="${product.costprice}"  name="designation" placeholder="Cost Price"   class="form-control"  type="text" id="costprice">
   <div id="msg4" align="center"><span style="color: red">*Input Needed</span></div>
    </div>
  </div>
  <label class="col-md-2 control-label" >Price To Sale<span style="color: red;">*</span></label></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input value="${product.sellingprice}" name="middlename" id="sellingprice"  placeholder="Selling Price" id="firstUppermiddle" onkeyup="javascript:capitalizemiddle(this.id, this.value);" class="form-control"  type="text">
   <div id="msg5" align="center"><span style="color: red">*Input Needed</span></div>
    </div>
  </div>
  
</div>
<div class="form-group">
<label class="col-md-2 control-label" style="">Repairable<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required" id="serviceable" >
  <option value="${product.serviceable eq Y?"Yes":"No"}" >${product.serviceable}</option> 
      <option value="Y">Yes</option>
	  <option value="N">No</option>
  </select>
    </div>
  </div>
  <label class="col-md-2 control-label" >Colour<span style="color: red;">*</span></label></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input value="${product.color}" name="lastname" id="productcolor"  placeholder="Product Colour" id="firstlastupper" onkeyup="javascript:capitalizelast(this.id, this.value);" class="form-control"  type="text">
   <div id="msg6" align="center"><span style="color: red">*Input Needed</span></div>
    </div>
  </div>
  
  
</div>
<div class="form-group"> 
<label class="col-md-2 control-label" style="">Active<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required" id="isactive">
  <option value="${product.isactive eq Y?"Y":"N"}">${product.isactive}</option> 
      <option value="Y">Yes</option>
	  <option value="N">No</option>
  </select>
    </div>
  </div>
  <label class="col-md-2 control-label">Currency<span style="color: red;">*</span></label></label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="division" class="form-control selectpicker" required="required" id="currencytype">
   <option value="${curr.currencyid}">${curr.currencyname}</option> 
   <c:if test="${!empty currencylist}">
	<c:forEach items="${currencylist}" var="curen" varStatus="loop">
      <option value="${curen.currencyid}">${curen.currencyname}</option>
	  </c:forEach>
	  </c:if>
     
    </select>
  </div>
</div>
  
</div>
<div class="form-group">
<label class="col-md-2 control-label">Unit<span style="color: red;">*</span></label></label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="division" class="form-control selectpicker" required="required" id="unittype">
   <option value="${uintt.unittypeid}">${uintt.unittype}</option> 
   
   <c:if test="${!empty unitlist}">
	<c:forEach items="${unitlist}" var="unit" varStatus="loop">
     
	  <option value="${unit.unittypeid}">${unit.unittype}</option>
     </c:forEach>
     </c:if>
    </select>
  </div>
</div> 
   <!-- <label class="col-md-2 control-label" style="">Per Piece Rate <span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="password"   class="form-control" id="perpiecerate" placeholder="unit price" required="required" type="text">
    </div>
  </div> -->

</div>


<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="button" id="savecurrencyForm" class="btn btn-warning" >Send <span class="glyphicon glyphicon-send"></span></button>
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>

</fieldset>
</form:form>
</div>
</div>
<link href="resources/css/prettify.css" rel="stylesheet" type="text/css" />
<script src="resources/js/jquery.jrumble.1.3.min.js"></script>
<script src="resources/js/jquery.jrumble.1.3.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
 <script type="text/javascript">

 
 $('#productcode,#description,#productcolor,#sellingprice,#productname,#costprice').click(function (){
	 $('#msg1').hide();
	 $('#msg2').hide();
	 $('#msg3').hide();
	 $('#msg4').hide();
	 $('#msg5').hide();
	 $('#msg6').hide();
	
 });
 
 $('#msg1').hide();
 $('#msg2').hide();
 $('#msg3').hide();
 $('#msg4').hide();
 $('#msg5').hide();
 $('#msg6').hide();
 
		$('#savecurrencyForm').click(function (){
			var productid=$('#productid').val();
			var productcode =$('#productcode').val();
			var  productname=$('#productname').val();
			
			var  producttype=$('#producttype :selected').val();
			var productsubtype =$('#productsubtype :selected').val();
			
			var  costprice=$('#costprice').val();
			var  sellingprice=$('#sellingprice').val();
			
			var  serviceable=$('#serviceable :selected').val();
			
			var  productcolor=$('#productcolor').val();
			var  isactive=$('#isactive :selected').val();
			
			var  currencytype=$('#currencytype :selected').val();
			
			var  unittype=$('#unittype :selected').val();
			var  perpiecerate=$('#perpiecerate').val();
			var description =$('#description').val();
			
			if(productcode==''){
				$('#msg1').show('fast');
				
			}else if(productname==''){
				$('#msg2').show('fast');
				
			}else if(description==''){
				$('#msg3').show('fast');
				
			}else if(costprice==''){
				$('#msg4').show('fast');
				
			}else if(sellingprice==''){
				$('#msg5').show('fast');
				
			}else if(productcolor==''){
				$('#msg6').show('fast');
				
			}else {
				var jsonObj={
						'productid': productid, 
						'productheadid': producttype,
						'productsabheadid': productsubtype,
						'productname': productname, 
						'unitprice': perpiecerate, 
						'producttypeid': '', 
						'unittypeid': unittype, 
						'currencyid': currencytype, 
						'costprice': costprice, 
						'productcode': productcode, 
						'description': description, 
						'serviceable': serviceable, 
						'productcategory': '', 
						'isactive': isactive,
						'sellingprice': sellingprice,
						'color':productcolor 
						}; 
		
					 $.ajax({
							url: "updateproductdata",
							type: "POST",
			
							  data :JSON.stringify(jsonObj),
							  cache:false,
						        beforeSend: function(xhr) {  
						            xhr.setRequestHeader("Accept", "application/json");  
						            xhr.setRequestHeader("Content-Type", "application/json");  
						        },
							     success: function(resposeJsonObject){
							    	
							    	 //window.location.currency;
							    	 window.location.href = "promaster";
						     
						    }});
			}
			
						});
		
		$('select').click(function(){
			
			$(this).find("option").eq(0).hide();
			
		});

			
</script>

