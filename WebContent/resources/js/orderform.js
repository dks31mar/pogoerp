    //alert("globalDomainMap---"+globalDomainMap);
   // alert("11111");
   
    function setCottonno(productid,aa){
          var qq=document.getElementById('product_Quantity'+productid).value;
          var cotton=document.getElementById('noofCotton'+productid).value;
          var atque=eval(qq)*eval(cotton);    
          document.getElementById('quantity'+productid).value=atque;    
          //var noofcorton=document.getElementById('noofCotton'+productid).value;
          var capacity=document.getElementById('productCapacity'+productid).value;
          var quantity=document.getElementById('quantity'+productid).value;
          //alert("2222222--->"+quantity  +"capacity--->"+capacity);
          var actualquantity=eval(capacity)*eval(quantity);
         var idvalue="productQuantity"+productid;
         var idvalue1="quantity"+productid;
        document.getElementById(idvalue).value=actualquantity;
        document.getElementById(idvalue1).onblur();
       }
    function setquantity(productid,id){
          var productq1=document.getElementById('product_Quantity'+productid).value;
          var productq2=document.getElementById('quantity'+productid).value;
          var noofbox=1;   
          if(eval(productq2)>eval(productq1)){
               noofbox=Math.floor(productq2/productq1);
            }
          document.getElementById('noofCotton'+productid).value=noofbox;
          var noofcorton=document.getElementById('noofCotton'+productid).value;
          var capacity=document.getElementById('productCapacity'+productid).value;
          var quantity=document.getElementById('quantity'+productid).value;
          var actualquantity=eval(capacity)*eval(quantity);
          var idvalue="productQuantity"+productid;
          document.getElementById(idvalue).value=actualquantity;
          document.getElementById(idvalue).onblur();
    }
	
	function hideDiv() { 
	if (document.getElementById) { // DOM3 = IE5, NS6 
	document.getElementById('delearMargin').style.display = 'none'; 
	} 
	else { 		if (document.layers) { // Netscape 4 
			document.delearMargin.display = 'none'; 
		} 
		else { // IE 4 
			document.all.delearMargin.style.display = 'none'; 
		} }}
		
		function makeEnableCheckBox(fieldName)
{	fieldName.checked=true;
	fieldName.disabled=false;  }
 function showHideCharges(sourceId,targetId,param)
{	var flag=false;
	if(param==true){
		flag=true;		
	}else{
	flag=document.getElementById(sourceId).checked;}
	var target = document.getElementById(targetId);
	var target1= document.getElementById("showHide11");
	if(flag==true){
		if (target.style.display == "none" ){
            target.style.display="";
            target1.style.display="";
        }
	}else{         target.style.display="none";
			target1.style.display="none";
	}
}
function onlyNum(boxid)
{	var obj=document.getElementById(boxid);
	if(!isInteger(obj.value)){
		alert("Please Enter Only Numeric Values");
		obj.value="";
	}
}
function showDiv() { 
	if (document.getElementById) { // DOM3 = IE5, NS6 
	document.getElementById('delearMargin').style.display = 'block'; 
	} 
	else { 	if (document.layers) { // Netscape 4 
		document.delearMargin.display = 'block'; 
		} 
		else { // IE 4 
		document.all.delearMargin.style.display = 'block'; 
		} 
	} } 
function setAreaCode(code,cityname,sublocation,sublocationId)
{  var frm=document.order;
  frm.delearAreaCode.value = code;
  frm.delearLocation.value=cityname;
  frm.delearSubLocation.value=sublocation;
 }
 
 function setNumericValue(obj)
{
if(obj.value=="")
obj.value=0;
var val = obj.value;
if(isNaN(val)){
alert("Please Enter Valid Value !");
obj.value = 0;	
obj.select();
obj.focus();
}
var val = obj.value;
return(val);
}
function setAllPricesField(){
	setProductSubTotal(); 
	setNetPriceAfterDiscount();
	setTotalAmount();
}
function setProductSubTotal(){
	var totCharges=0.00;
	var productCharges=0.00;
if (typeof document.order.productIds != "undefined") {
		var noOfProducts=document.order.noOfProducts.value;
		if (noOfProducts>1){
			for (var i=0;i<noOfProducts;i++){
				var productId=this.document.order.productIds[i].value;
				var fieldName="productPrice"+productId;
				var fieldValue=0.00;
				for (var j=0;j<document.order.elements.length;j++){
					var eleName=this.document.order.elements[j].name;
					if (eleName==fieldName)
					{
					fieldValue=this.document.order.elements[j].value;
					}
				}
				productCharges=parseFloat(productCharges)+parseFloat(fieldValue);
				}
			}else{
				var productId=this.document.order.productIds.value;
				var fieldName="productPrice"+productId;
				var fieldValue=0.00;
				for (var j=0;j<document.order.elements.length;j++){
					var eleName=this.document.order.elements[j].name;
				       if (eleName==fieldName)
					{
						fieldValue=this.document.order.elements[j].value;
					break;
					}
				}
		        productCharges=parseFloat(fieldValue);
			}
	}
	totCharges=parseFloat(productCharges);
	document.order.achievementValue.value=format_number(totCharges,2);
}

function doDisabled(val)
{	if(val==1)
	{	document.order.secondStartDay.disabled=false;
		document.order.secondStartMonth.disabled=false;
		document.order.secondStartYear.disabled=false;		
	}
	else
	{	document.order.secondStartDay.disabled=true;
		document.order.secondStartMonth.disabled=true;
		document.order.secondStartYear.disabled=true;
	}}
function setDefaultValues(field,fieldQty, fieldUnitPrice,fieldToset,isFieldChecked){
	if(field.checked==false){
		fieldQty.value=0.00;
		fieldQty.disabled=true;
		fieldUnitPrice.disabled=true;
		fieldToset.value=0.00;
		isFieldChecked.value="N";
	}else{
		fieldQty.disabled=false;
		fieldUnitPrice.disabled=false;
		isFieldChecked.value="Y";
	}
	setAllPricesField();
        }
function addDays(myDate,days_to_add ) {
	return new Date(myDate.getTime() + days_to_add *24*60*60*1000);
}
function addMonths(myDate,months_to_add ) {
	myDate.setMonth(eval(parseInt(myDate.getMonth())+parseInt(months_to_add)));
	return myDate;
}
function saveDate(proid,addMore){
	var freqobj=document.getElementById('premen').frequency;
	var freqlength=freqobj.length;
	var repeatvalue;
	if(freqlength == undefined){
		if(freqobj.checked){
			repeatvalue=freqobj.value;
		}
	}else if(freqlength>=2){
			for(var i = 0; i < freqlength; i++){
				if(freqobj[i].checked) {
					repeatvalue=freqobj[i].value;
				}}}
	var a=0;
	var x=document.getElementById("addMore").value;
	var date="";
	var days="";
	var hours="0";
	var ddh="";
	var totalDate=0;
	var pmf=0;
		if(addMore>0){
			for(a=1;a<=addMore;a++){
				if(a==1 && document.getElementById("days"+proid+a).value=="" && document.getElementById("hours"+proid+a).value==""){
				alert("Please enter First Preventive Maintenance either in days or in hours");
				return false;
					document.getElementById("days"+proid+a).focus();
					}
				if(!isInteger(document.getElementById("days"+proid+a).value)){
					document.getElementById("days"+proid+a).value="";
					alert("Please enter valid number of days");
					document.getElementById("days"+proid+a).focus();
					return false;
				}
				if(!isInteger(document.getElementById("hours"+proid+a).value)){
					document.getElementById("hours"+proid+a).value="";
					alert("Please enter valid number of hours");
					document.getElementById("hours"+proid+a).focus();
					return false;
				}
				if(document.getElementById("days"+proid+a).value!="" || document.getElementById("hours"+proid+a).value!=""){
					date=document.getElementById("pdate"+proid+a).value;
						if(document.getElementById("days"+proid+a).value==""){
							days="0";
						}else{	days=document.getElementById("days"+proid+a).value;
							totalDate+=parseInt(document.getElementById("days"+proid+a).value);
						}
						if(document.getElementById("hours"+proid+a).value==""){
							hours="0";
						}else{	hours=document.getElementById("hours"+proid+a).value; }
					if(ddh==""){
						ddh=date+","+days+","+hours;
					}else{
						ddh+="/"+date+","+days+","+hours;
					}
				}
				if(document.getElementById("days"+proid+a).value!="" || document.getElementById("hours"+proid+a).value!=""){
					pmf=a;
				
				}}}
		var repeatDaysNum=0;
		var repDays=0;
		var repHours=0;
		var repDate="";
		var date1="";
		var month1="";
		var year1="";
		var warrantyDays=parseInt(document.getElementById("warrantyDays"+proid).value);
		if(totalDate>warrantyDays){
			alert("Total number of days of Preventive Maintenance can not greater than warrenty days.");
			return false
		}
		if(repeatvalue!=undefined){
			if(document.getElementById("days"+proid+repeatvalue).value==""){
			alert("Please Enter value to repeat.");
			return false;
			}
			if(document.getElementById("days"+proid+repeatvalue).value!=""){
				repeatDaysNum=parseInt(document.getElementById("days"+proid+repeatvalue).value);
				repDays=document.getElementById("days"+proid+repeatvalue).value;
				repDate=document.getElementById("pdate"+proid+repeatvalue).value;
				repHours=document.getElementById("hours"+proid+repeatvalue).value;
				if(document.getElementById("hours"+proid+repeatvalue).value==""){
							repHours="0";
						}}}
		var today = new Date();
		var warrExp=new Date();
		warrExp.setDate(document.order.startDay.value);
		warrExp.setMonth(document.order.startMonth.value); // January = 0
		warrExp.setFullYear(document.order.startYear.value);
		warrExp=addDays(warrExp,warrantyDays);
		var addnum=parseInt(repeatDaysNum);
		if(repeatDaysNum!=0){
			today.setDate(repDate.substring(repDate.lastIndexOf("-")+1));
			today.setMonth(repDate.substring(repDate.indexOf("-")+1,repDate.lastIndexOf("-"))-1);
			today.setFullYear(repDate.substring(0,repDate.indexOf("-")));
			while(repeatDaysNum<warrantyDays){
				repeatDaysNum+=addnum;
				if(repeatDaysNum<warrantyDays){
				today.setDate(today.getDate()+parseInt(addnum)); 
				date1=today.getDate();
				month1=today.getMonth()+1;
				year1=today.getFullYear();
					if(today.getDate()<10){
						date1="0"+today.getDate();
					} if(month1<10){
						month1="0"+month1;
					} 
					if(today<=warrExp){
					ddh+="/"+today.getFullYear()+"-"+month1+"-"+date1+","+repDays+","+repHours;
					}
				}}
		}//alert(ddh);
			
			document.getElementById("pmDateOthers"+proid).value=ddh;
		document.getElementById("modelId").innerHTML="<div id='preventiveMainPopUp' style='display:none'> <DIV id='preventiveMainPopUp1' > </DIV> </div>";

Modalbox.close();
	document.getElementById("pmFrequency"+proid).value="13";
		document.getElementById("pmFrequencyOthers"+proid).value="13";
	//setDatesStr(proid);
}
function serPreMainDate(proid,stDay,stMonth,stYear,val,totval){
	var preval=parseInt(val)-1;
	if(isInteger(document.getElementById("days"+proid+val).value)){
		if(val>2){
			if(document.getElementById("days"+proid+preval).value==""){
				alert("Please Enter Previous Value");
					document.getElementById("days"+proid+val).value="";
				return false;
			}		}
if(totval>val){				for(var i=(parseInt(val)+1);i<=totval;i++){
					document.getElementById("days"+proid+i).value="";
					document.getElementById("pdate"+proid+i).value="";
					document.getElementById("showDate"+proid+i).innerHTML="";
				}}
		var numberOfDaysToAdd=document.getElementById("days"+proid+val).value;
var today = new Date();
var date="";
var month="";
var year="";
var repDate="";
if(val==1){
today.setDate(stDay);
today.setMonth(stMonth); // January = 0
today.setFullYear(stYear); 
}else{		if(document.getElementById('pdate'+proid+preval).value!=""){
			repDate=document.getElementById('pdate'+proid+preval).value;
			today.setDate(repDate.substring(repDate.lastIndexOf("-")+1));
			var preMonth=repDate.substring(repDate.indexOf("-")+1,repDate.lastIndexOf("-"))-1;
			today.setMonth(preMonth);
			today.setFullYear(repDate.substring(0,repDate.indexOf("-")));
		}}
today=addDays(today,numberOfDaysToAdd);
date=today.getDate();
month=today.getMonth()+1;
year=today.getFullYear();
if(numberOfDaysToAdd==""){
document.getElementById('showDate'+proid+val).innerHTML="";
document.getElementById('pmDate'+proid+val).innerHTML="";
}else{
document.getElementById('showDate'+proid+val).innerHTML=today.getDate()+"/"+(today.getMonth()+1)+"/"+today.getFullYear();
if(today.getDate()<10){
date="0"+today.getDate();
} if(month<10){
month="0"+month;
} 
document.getElementById('pdate'+proid+val).value=today.getFullYear()+"-"+month+"-"+date;
}}}

function chkValidation(textObj,dataType){
	var textVal = textObj.value ;
	if(dataType != null && dataType.length>0 && textVal != null && textVal.length>0){ 
		if(dataType == "char"){
		}else if(dataType == "numeric"){
			if(!(isDouble(textVal))){
				alert("Invalid Numeric Value");
				textObj.focus();
			}//end if isDouble
		}else{//date chk
			checkDate(textObj, "dd/mm/yyyy", 3);//3 for alert
		}}}



//   Arvind Thakur 10-10-2014

  var ajaxRequest ;
    function getHttpRequestObject(){
        var httpRequest ;
        if(window.XMLHttpRequest){
            httpRequest=new XMLHttpRequest() ;
        }else if(window.ActiveXObject){
            httpRequest=new window.ActiveXObject("Microsoft.XMLHTTP") ;
        }
        return httpRequest ;
    }
    var statusXX;
    var uniqueControlId;
    function checkProductType(prodId)
    {      statusXX=0;
           ajaxRequest=getHttpRequestObject();
           var idX="quantity"+prodId;
           uniqueControlId=prodId;
           var productQtyX=document.getElementById(idX).value;
           try{
               var tempX=productQtyX.split(".");
                if(tempX.length>0){
                   if(tempX[1]>0){
                        var url="/"+globalDomainMap+"/newSalesCallForm.do?method=isServisiable&productId="+prodId;
                        if(ajaxRequest){
                            ajaxRequest.onreadystatechange=getResultList;
                            ajaxRequest.open("POST", url, true) ;
                            ajaxRequest.send(null);
                        }
                           if(statusXX==1){
                            return false;
                        }} }
                   }catch(e){
                return true;
           }
        return true;
    }
    function getResultList(){
     if(ajaxRequest.readyState == 4){
            if(ajaxRequest.status == 200){
                var res=ajaxRequest.responseText ;
                if(res=='1'){
                    alert("This is serviceable product, Quantity should not accept Decimal Value.");
                    statusXX=1;
                     var idXX="quantity"+uniqueControlId;
                    document.getElementById(idXX).value=0;
                    idXX="productPrice"+uniqueControlId;
                    document.getElementById(idXX).value=0;
                    setAllPricesField();
                }}}}
    
    
    
  function showProduct(id){
   var ids="";
              try{		  if(document.order.productIds.length==undefined)
					  ids=document.order.productIds.value;
					 if(document.order.productIds.length>1)
					  for(i=0;i<document.order.productIds.length;i++){
					  if(i==0)
						  ids=document.order.productIds[0].value;
					  else
						  ids+=","+document.order.productIds[i].value;
				  }
                     var xmlhttp=new XMLHttpRequest();
               }
                catch (e)
                     { try
                            {  var xmlhttp=new ActiveXObject("Microsoft.XMLHttp");  }
                        catch(e)
                            { alert('Unable to connect in Mozila try IE, Sorry for inconvenience ');  }
                       }
                var url="/"+globalDomainMap+"/order/LoadProducts.jsp";
                url=url+"?id="+id+"&pdId="+ids+"&frm=1";;
                xmlhttp.onreadystatechange=stateChanged;
                xmlhttp.open("get",url,true);
                xmlhttp.send(null);
                function stateChanged()
                    {

                    if (xmlhttp.readyState==4)
                            {     var response=xmlhttp.responseText;
 							   if(response.substring((response.indexOf("~")+1),(response.indexOf("|")))>0){ //this.document.getElementById('prodDetail'+id).innerHTML=response.substring(0,(response.indexOf("~")));
							   document.getElementById('prodDetail'+id).innerHTML=response.substring(0,(response.indexOf("~"))); document.order.noOfProducts.value=parseInt(document.order.noOfProducts.value)+parseInt(response.substring((response.indexOf("~")+1),(response.indexOf("|"))));
                                                          var achivement=document.order.achievementValue.value;
	var sum=parseFloat(response.substring((response.indexOf("|")+1),(response.indexOf("!"))))+parseFloat(achivement);
	var dcnt=document.order.discount.value;//alert(sum+">>"+dcnt);
	document.order.achievementValue.value=0;
	document.order.afterDiscount.value=0;
	document.order.achievementValue.value=sum;
	document.order.afterDiscount.value=parseFloat(sum)-parseFloat(dcnt);
							   }//end of if
	                            }}}


function makeReadOnlyWithChecked(fieldName,targetId)
{	fieldName.checked=true;
	fieldName.disabled=true;
        if("tycossm"==globalDomainMap){
	var param=true;
	showHideCharges(fieldName,targetId,param);
        }
}

function GetXmlHttpObject()
{  var xmlHttp=null;
try
  {
  xmlHttp=new XMLHttpRequest();
  }
catch (e)
  {
  try
    {   xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");   }
  catch (e)
    {    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");    }
  }
return xmlHttp;
}
function stateChanged()
{
if (xmlHttp.readyState==4)
{ var field = document.all.qtyF.value;
  var prdId= document.all.prId.value;
  var response=xmlHttp.responseText;
  var first_char=response.substring(0,1);
if(first_char=="N")
{   document.getElementById(field).value=0;
    document.getElementById("productPrice"+prdId).value=0;
    if(globalisAllowDeliveryStatus=='true' || globalisAllowDeliveryStatus=='TRUE'){
    document.getElementById("productCostPrice"+prdId).value=0;
    }
    setAllPricesField();
    alert("No Such Product Found in Stock.");
    document.getElementById(field).focus();
    return false;
}
else if(first_char=="O")
{   var no=response.substring(5,response.indexOf("product"));
    document.getElementById(field).value=0;
    document.getElementById("productPrice"+prdId).value=0;
  if(globalisAllowDeliveryStatus=='true' || globalisAllowDeliveryStatus=='TRUE'){
    document.getElementById("productCostPrice"+prdId).value=0;
    }
    setAllPricesField();
    alert("Only "+no+" Product available in Stock.");
    document.getElementById(field).focus();
    return false;
}}}

function openWind(productId){
	var queryString="";
	var frm=document.order;
	displayMode="0";
	 if("samssm"==globalDomainMap){
         displayMode="2";
        var stday = document.getElementById("startDayP").value;
        var stMonth = document.getElementById("startMonthP").value;
        var stYear = document.getElementById("startYearP").value;
        queryString="startDay="+stday+"&startMonth="+stMonth+"&startYear="+stYear;
        }else if("konicassm"==globalDomainMap){
            var srtmnth=parseInt(frm.startMonth.value)+1;
            queryString="startDay="+frm.startDay.value+"&startMonth="+srtmnth+"&startYear="+frm.startYear.value;
         }else{
	queryString="startDay="+frm.startDay.value+"&startMonth="+frm.startMonth.value+"&startYear="+frm.startYear.value;
        }
        queryString+="&productId="+productId+"&displayMode="+displayMode;
	warrantyDaysFieldName="warrantyDays"+productId;
	pmFrequencyFieldName="pmFrequency"+productId;
	for (var i=0;i<frm.elements.length;i++){
		var eleName=frm.elements[i].name;
		if (eleName==warrantyDaysFieldName){
			queryString+="&warrantyDays="+frm.elements[i].value;
		}else if(eleName==pmFrequencyFieldName){
			queryString+="&pmFrequency="+frm.elements[i].value;
		}	}
	window.open('../order/GenerateDateList.jsp?'+queryString,'','width=375,height=300,scrollbars=1,resizable=yes,left=0,top=0');
	return false;
}

 function OpenPopUpForPM(updateForProductId,addMore)
            {			var startDay=document.order.startDay.value;
				var startMonth=document.order.startMonth.value;
				var startYear=document.order.startYear.value;
				//var daysModel=document.getElementById("days"+updateForProductId+0).value
                try
                    {    var xmlhttp=new XMLHttpRequest();       }
                catch (e)
                     {  try
                            {  var xmlhttp=new ActiveXObject("Microsoft.XMLHttp");  }
                        catch(e)
                            {   alert('Unable to connect in Mozila try IE, Sorry for inconvenience ');  }  }
                var url="/"+globalDomainMap+"/order/SaveForPreventiveMaintenance.jsp";
                url=url+"?str="+Math.random()+"&productid="+updateForProductId+"&startDay="+startDay+"&startMonth="+startMonth+"&startYear="+startYear+"&addMore="+addMore;
                xmlhttp.onreadystatechange=stateChanged;
        	xmlhttp.open("get",url,true);
                xmlhttp.send(null);
                function stateChanged()
                    {  if (xmlhttp.readyState==4)
                            {  document.getElementById('preventiveMainPopUp1').innerHTML=xmlhttp.responseText;   }
                     }	   }
function OpenPopUpForPMFor(updateForProductId)
            {			var startDay=document.order.startDay.value;
				var startMonth=document.order.startMonth.value;
				var startYear=document.order.startYear.value;
				var addMore=document.getElementById("addMore").value;
				//var daysModel=document.getElementById("days"+updateForProductId+0).value
                try
                    {
                // Firefox, Opera 8.0+, Safari
                     var xmlhttp=new XMLHttpRequest();
                    }
                catch (e)
                     {   try
                            { var xmlhttp=new ActiveXObject("Microsoft.XMLHttp");  }
                        catch(e)
                            {  alert('Unable to connect in Mozila try IE, Sorry for inconvenience ');  }   }
                var url="/"+globalDomainMap+"/order/SaveForPreventiveMaintenance.jsp";
                url=url+"?str="+Math.random()+"&productid="+updateForProductId+"&startDay="+startDay+"&startMonth="+startMonth+"&startYear="+startYear+"&addMore="+addMore;
                xmlhttp.onreadystatechange=stateChanged;
        	xmlhttp.open("get",url,true);
                xmlhttp.send(null);
                function stateChanged()
                    { if (xmlhttp.readyState==4)
                            {  document.getElementById('preventiveMainPopUp1').innerHTML=xmlhttp.responseText; }  }
            }
            
           function moreEntries(){
		document.order.action="OrderForm.jsp" ;
		document.order.submit();
	    }