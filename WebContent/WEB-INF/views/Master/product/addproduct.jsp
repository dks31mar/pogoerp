
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
    id="" >
   
<fieldset>

<!-- Form Name -->
<legend>Add Product</legend>
  <div class="form-group">
  <label class="col-md-2 control-label">Product Id</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="" id="productid"   readonly="readonly"  class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" style="">Product Code<span style="color: red;">*</span></label>
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="empCode"  placeholder="Enter Product Code" required="required"  class="form-control"  type="text" id="productcode">
    </div>
  </div>
</div>
 <div class="form-group">
  <label class="col-md-2 control-label">Product Name<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="loginname" placeholder="Product Name" required="required"  class="form-control"  type="text" id="productname">
    </div>
  </div>
  <label class="col-md-2 control-label" style="">Product Type<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required" id="producttype">
  <option>---Select type---</option> 
  <c:if test="${!empty productlist}">
	<c:forEach items="${productlist}" var="cur" varStatus="loop">
      <option value="${cur.productheadid}">${cur.productheadname}</option>
	  </c:forEach>
	</c:if>
  </select>
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label" style="">Product Sub Type<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required" id="productsubtype">
  <option>---Select sub type---</option>
      <c:if test="${!empty subproductlist}">
			<c:forEach items="${subproductlist}" var="sunpro" varStatus="loop">
      <option value="${sunpro.productsubheadid}">${sunpro.productsubheadname}</option>
	  		</c:forEach>
	  </c:if>
  </select>
    </div>
  </div>
  <label class="col-md-2 control-label" style="">Cost Price</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="designation" placeholder="Cost Price"   class="form-control"  type="text" id="costprice">
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-2 control-label" >Selling Price</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="middlename" id="sellingprice"  placeholder="Selling Price" id="firstUppermiddle" onkeyup="javascript:capitalizemiddle(this.id, this.value);" class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" style="">Serviceable<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required" id="serviceable">
  <option>---Select---</option> 
      <option value="true">Yes</option>
	  <option value="false">No</option>
  </select>
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label" >Product Colour</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="lastname" id="productcolor"  placeholder="Product Colour" id="firstlastupper" onkeyup="javascript:capitalizelast(this.id, this.value);" class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" style="">Is Active<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required" id="isactive">
  <option>---Select---</option> 
      <option value="Y">Yes</option>
	  <option value="N">No</option>
  </select>
    </div>
  </div>
  
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Currency Type</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="division" class="form-control selectpicker" required="required" id="currencytype">
   <option>---Select Division---</option> 
   <c:if test="${!empty currencylist}">
	<c:forEach items="${currencylist}" var="curen" varStatus="loop">
      <option value="${curen.currencyid}">${curen.currencyname}</option>
	  </c:forEach>
	  </c:if>
     
    </select>
  </div>
</div>
  <label class="col-md-2 control-label">Unit Type</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="division" class="form-control selectpicker" required="required" id="unittype">
   <option>---Select Division---</option> 
   
   <c:if test="${!empty unitlist}">
	<c:forEach items="${unitlist}" var="unit" varStatus="loop">
     
	  <option value="${unit.unittypeid}">${unit.unittype}</option>
     </c:forEach>
     </c:if>
    </select>
  </div>
</div>
</div>
<div class="form-group"> 
   <label class="col-md-2 control-label" style="">Per Piece Rate <span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="password"   class="form-control" id="perpiecerate" placeholder="unit price" required="required" type="text">
    </div>
  </div>
 <label class="col-md-2 control-label" style="">description<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  		<textarea class="form-control" name="address"  placeholder="Product Description" required="required" id="description"></textarea>
    </div>
  </div>
</div>


<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="button" id="savecurrencyForm" class="btn btn-warning" onclick="message();" >Send <span class="glyphicon glyphicon-send"></span></button>
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>

</fieldset>
</form:form>
</div>
</div>

 <script type="text/javascript">

		function message() {
			$('#message').dialogBox({
				type : 'correct', //three type:'normal'(default),'correct','error',
				width : 250,
				height : 150,
				hasMask : true,
				hasClose : true,
				autoHide : false,
				time : '6000',
				effect : 'fall',
				title : 'Record',
				content : 'Data Saved Successfully!!!'
			});

		}
		
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
				url: "saveproductdet",
				type: "POST",
				
				  data :JSON.stringify(jsonObj),
				  cache:false,
			        beforeSend: function(xhr) {  
			            xhr.setRequestHeader("Accept", "application/json");  
			            xhr.setRequestHeader("Content-Type", "application/json");  
			        },
				     success: function(resposeJsonObject){
				    	 $('#openModal').hide();
				    	 //window.location.currency;
				    	 window.location.reload();
			     
			    }});
		});	
</script>
