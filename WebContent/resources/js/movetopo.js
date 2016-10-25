     function dateDifference(id){  
               var id=id;var stDate = document.getElementById('startDate'+id).value;var enDate = document.getElementById('endDate'+id).value;
              try{  var xmlhttp=new XMLHttpRequest();
               }
                catch (e)
                     {try   { var xmlhttp=new ActiveXObject("Microsoft.XMLHttp"); }
                        catch(e)
                            { alert('Unable to connect in Mozila try IE, Sorry for inconvenience ');}
                       }
                var url="DateDifference.jsp";url=url+"?startDate="+stDate+"&endDate="+enDate;xmlhttp.onreadystatechange=stateChanged;xmlhttp.open("get",url,true);xmlhttp.send(null);
    function stateChanged() 
                    {  if (xmlhttp.readyState==4)
                           {    //alert(xmlhttp.responseText);             
                                document.getElementById('warrantyDays'+id).value=(xmlhttp.responseText);
                               
                            }  }   }
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
                     {  try
                            {  var xmlhttp=new ActiveXObject("Microsoft.XMLHttp");
                            }
                        catch(e)
                            { alert('Unable to connect in Mozila try IE, Sorry for inconvenience ');
                             } }
                var url="LoadProducts.jsp";
                url=url+"?id="+id+"&pdId="+ids;;
               xmlhttp.onreadystatechange=stateChanged;xmlhttp.open("get",url,true);xmlhttp.send(null);
                function stateChanged() 
                    { if (xmlhttp.readyState==4)
                            { 
                           var response=xmlhttp.responseText;
                   				   if(response.substring((response.indexOf("~")+1),(response.indexOf("|")))>0){ document.getElementById('prodDetail'+id).innerHTML=response.substring(0,(response.indexOf("~")));
							   document.order.noOfProducts.value=parseInt(document.order.noOfProducts.value)+parseInt(response.substring((response.indexOf("~")+1),(response.indexOf("|"))));
							   var achivement=document.order.achievementValue.value;
	var sum=parseFloat(response.substring((response.indexOf("|")+1),(response.indexOf("!"))))+parseFloat(achivement);
	var dcnt=document.order.discount.value;document.order.achievementValue.value=0;document.order.afterDiscount.value=0;document.order.achievementValue.value=sum;document.order.afterDiscount.value=parseFloat(sum)-parseFloat(dcnt);
	   }  }   }       }

function makeEnableCheckBox(fieldName)
{	fieldName.checked=true;
	fieldName.disabled=false;
}

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
	}else{
		    target.style.display="none";
			target1.style.display="none";
	}}

function onlyNum(boxid)
{	var obj=document.getElementById(boxid);
	if(!isInteger(obj.value)){
		alert("Please Enter Only Numeric Values");
		obj.value="";
	}}
function hideDiv() { 
	if (document.getElementById) { 
	document.getElementById('delearMargin').style.display = 'none'; 
	} 
	else { 
		if (document.layers) { 
			document.delearMargin.display = 'none'; 
		} 
		else { 
			document.all.delearMargin.style.display = 'none'; 
		}}} 
function showDiv() { 
	if (document.getElementById) { 
	document.getElementById('delearMargin').style.display = 'block'; 
	} 
	else { 
		if (document.layers) { 
		document.delearMargin.display = 'block'; 
		} 
		else { 
		document.all.delearMargin.style.display = 'block'; 
		}}} 
function setAreaCode(code,cityname,sublocation,sublocationId){ var frm=document.order;frm.delearAreaCode.value = code;frm.delearLocation.value=cityname;frm.delearSubLocation.value=sublocation;}
  function CheckNumericValue(e) {
       var key = e.which ? e.which : e.keyCode;
        if ((key >= 48 && key <= 57) || key == 13 || key == 8 || key == 9 || key == 27) {
           return true;
       }
       else {
           alert("Please Enter Number Only");
           return false;
       }    }
    function setCottonno(productid,aa){
	     var qq=document.getElementById('product_Quantity'+productid).value;
          var cotton=document.getElementById('noofCotton'+productid).value;
          var atque=eval(qq)*eval(cotton);   
         document.getElementById('quantity'+productid).value=atque;    
         var capacity=document.getElementById('productCapacity'+productid).value;
          var quantity=document.getElementById('quantity'+productid).value;
         var actualquantity=eval(capacity)*eval(quantity);
        var idvalue="productQuantity"+productid;
        var idvalue1="quantity"+productid;
        document.getElementById(idvalue).value=actualquantity;
          document.getElementById(idvalue1).onblur();
    }
    function setquantity(productid,id){
       var productq1=document.getElementById('product_Quantity'+productid).value;var productq2=document.getElementById('quantity'+productid).value;var noofbox=1; if(eval(productq2)>eval(productq1)){ noofbox=Math.floor(productq2/productq1);}document.getElementById('noofCotton'+productid).value=noofbox;var noofcorton=document.getElementById('noofCotton'+productid).value;var capacity=document.getElementById('productCapacity'+productid).value;var quantity=document.getElementById('quantity'+productid).value;var actualquantity=eval(capacity)*eval(quantity);var idvalue="productQuantity"+productid;
      document.getElementById(idvalue).value=actualquantity;document.getElementById(idvalue).onblur();}

function setNumericValue(obj)
{if(obj.value=="")
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

function setDefaultValues(field,fieldQty, fieldUnitPrice,fieldToset,isFieldChecked){	
	if(field.checked==false){
		fieldQty.value=0.00; fieldQty.disabled=true; fieldUnitPrice.disabled=true; fieldToset.value=0.00; isFieldChecked.value="N";
		}else{
		fieldQty.disabled=false; fieldUnitPrice.disabled=false; isFieldChecked.value="Y";
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
				}			}	}	
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
						}else{
							days=document.getElementById("days"+proid+a).value;
							totalDate+=parseInt(document.getElementById("days"+proid+a).value);
						}
						if(document.getElementById("hours"+proid+a).value==""){
							hours="0";
						}else{
							hours=document.getElementById("hours"+proid+a).value;
						}
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
						}			}
				}
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
				}			}		}
			document.getElementById("pmDateOthers"+proid).value=ddh;
			document.getElementById("modelId").innerHTML="<div id='preventiveMainPopUp' style='display:none'> <DIV id='preventiveMainPopUp1' > </DIV> </div>";
Modalbox.close();
	document.getElementById("pmFrequency"+proid).value="13";
		document.getElementById("pmFrequencyOthers"+proid).value="13";
	}
function serPreMainDate(proid,stDay,stMonth,stYear,val,totval){
	var preval=parseInt(val)-1;
	if(isInteger(document.getElementById("days"+proid+val).value)){
		if(val>2){
			if(document.getElementById("days"+proid+preval).value==""){
				alert("Please Enter Previous Value");
					document.getElementById("days"+proid+val).value="";
				return false;
			}}
			if(totval>val){
				for(var i=(parseInt(val)+1);i<=totval;i++){
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
}else{
    if(document.getElementById('pdate'+proid+preval).value!=""){
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
}	}}
function OpenPopUpForPM(updateForProductId,addMore)
            {			var startDay=document.order.startDay.value;
				var startMonth=document.order.startMonth.value;
				var startYear=document.order.startYear.value;
                try
                    {             
                     var xmlhttp=new XMLHttpRequest();
                    }
                catch (e)
                     {
                        try
                            {
                                var xmlhttp=new ActiveXObject("Microsoft.XMLHttp");
                            }
                        catch(e)
                            {
                                alert('Unable to connect in Mozila try IE, Sorry for inconvenience ');
                             }
                       }
                var url="SaveForPreventiveMaintenance.jsp";         
                url=url+"?str="+Math.random()+"&productid="+updateForProductId+"&startDay="+startDay+"&startMonth="+startMonth+"&startYear="+startYear+"&addMore="+addMore; 
		xmlhttp.onreadystatechange=stateChanged;
        	xmlhttp.open("get",url,true);
                xmlhttp.send(null);
                function stateChanged() 
                    {   if (xmlhttp.readyState==4)
                            { 
                                document.getElementById('preventiveMainPopUp1').innerHTML=xmlhttp.responseText;
                            }       }
            }
function OpenPopUpForPMFor(updateForProductId)
            {			var startDay=document.order.startDay.value;
				var startMonth=document.order.startMonth.value;
				var startYear=document.order.startYear.value;
				var addMore=document.getElementById("addMore").value;
		try
                    {
                   var xmlhttp=new XMLHttpRequest();
                    }
                catch (e)
                     {
                        try
                            {  var xmlhttp=new ActiveXObject("Microsoft.XMLHttp");
                            }
                        catch(e)
                            { alert('Unable to connect in Mozila try IE, Sorry for inconvenience ');
                             }
                       }
                var url="SaveForPreventiveMaintenance.jsp";         
                url=url+"?str="+Math.random()+"&productid="+updateForProductId+"&startDay="+startDay+"&startMonth="+startMonth+"&startYear="+startYear+"&addMore="+addMore; 
		xmlhttp.onreadystatechange=stateChanged;
        	xmlhttp.open("get",url,true);
                xmlhttp.send(null);
                function stateChanged() 
                    {   if (xmlhttp.readyState==4)
                            { document.getElementById('preventiveMainPopUp1').innerHTML=xmlhttp.responseText;
                            } }
            }//ended by Ayush

function forAchivement(totalAchivement)
{	var achivement=this.document.order.achievementValue.value;
	var sum=parseFloat(totalAchivement)+parseFloat(achivement);
	var dcnt=this.document.order.discount.value;
	this.document.order.achievementValue.value=sum;
	this.document.order.afterDiscount.value=parseFloat(sum)-parseFloat(dcnt);
}
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

function setAllPriceFieldForSchenck(){
    setProductSubTotal(); 
    setTotalAmountForSchenck();
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
					}	}
			productCharges=parseFloat(fieldValue);
			}	}
	totCharges=parseFloat(productCharges);
	document.order.achievementValue.value=format_number(totCharges,2);
}
function setNetPriceAfterDiscount(){
	var subtotal=document.order.achievementValue.value;
	var discount=document.order.discount.value;
	document.order.afterDiscount.value=format_number((subtotal-discount),2);	
		}
function changeCode(){
	if(document.getElementById("bcustCode").value!=""){
			var answer = confirm ("This customer code will be updated in all orders . ")
			if (answer==false)
		{document.getElementById("bcustCode").value=""}	} }

  function updatePriceWithCurrency(currencyId,unitPrice,unitPriceSC,qtyId,totalPriceId) {
    var curId = currencyId.value;
    var unitprice_sc = unitPriceSC.value;
    var allVar = "currencyId="+curId+"&upsc="+unitprice_sc;
    var url="../masters/CostingInputPrice.jsp";
    url=url+"?"+allVar;
    url=url+"&sid="+Math.random();//alert(url);
    if(curId!='' && unitprice_sc!='')
    {   new Ajax.Request(url,{method:"post",onSuccess:function(t) {
            var response=t.responseText; var costprice = parseFloat(response.substring(1,response.indexOf('@')) * 1);
            setProducTotalPriceWithCurrency(totalPriceId,unitPrice,costprice,qtyId); setAllPricesField();
          },asynchronous:true
        });
    }else{
            totPrice=parseFloat(qtyId.value)*parseFloat(unitPriceSC.value); unitPrice.value=format_number(totPrice,2); totalPriceId.value=format_number(totPrice,2); setAllPricesField();}}
  function setProducTotalPriceWithCurrency(totalPriceFieldObj,unitpriceObj,totalprice,qty){
    unitpriceObj.value=totalprice; totalPriceFieldObj.value=Number(totalprice*qty.value);    } 
function chkValidation(textObj,dataType){
	var textVal = textObj.value ;
	if(dataType != null && dataType.length>0 && textVal != null && textVal.length>0){ 
		if(dataType == "char"){
			//
		}else if(dataType == "numeric"){
			if(!(isDouble(textVal))){
				alert("Invalid Numeric Value");
				textObj.focus();
			}//end if isDouble
		}else{//date chk
			checkDate(textObj, "dd/mm/yyyy", 3);//3 for alert
		}}}

function moreEntries(){	 
		document.order.action="EnterPOFormPopup.jsp" ;
		document.order.submit();}