


 function getCustomerData(){
            alert("customername is ---->"+document.getElementById('salescallId').value)
        }
        
        
       
        
        
        
         function updateleadshow(){
	  var myPara =  document.getElementById('updatelead').style.display='block'
	  var myPara =  document.getElementById('updatelead2').style.display='block'
	  var myPara =  document.getElementById('updatelead1').style.display='none'
	}
        
                
	function updateleadhide(){
	var myPara =  document.getElementById('updatelead').style.display='none'
	var myPara =  document.getElementById('updatelead2').style.display='none'
	var myPara =  document.getElementById('updatelead1').style.display='block'
	}
        
        function updatedairyshow(){
	var myPara =  document.getElementById('updatedairy').style.display='block'
	var myPara =  document.getElementById('updatedairy2').style.display='block'
	var myPara =  document.getElementById('updatedairy1').style.display='none'
	}
	function updatedairyhide(){
	var myPara =  document.getElementById('updatedairy').style.display='none'
	var myPara =  document.getElementById('updatedairy2').style.display='none'
	var myPara =  document.getElementById('updatedairy1').style.display='block'
	}
        
	function mapinfoshow(){
	var myPara =  document.getElementById('mapinfo').style.display='block'
	var myPara =  document.getElementById('mapinfo2').style.display='block'
	var myPara =  document.getElementById('mapinfo1').style.display='none'
	}
	function mapinfohide(){
	var myPara =  document.getElementById('mapinfo').style.display='none'
	var myPara =  document.getElementById('mapinfo2').style.display='none'
	var myPara =  document.getElementById('mapinfo1').style.display='block'
	}
        
        
        function otherinfoshow(){
	var myPara =  document.getElementById('otherinfo').style.display='block'
	var myPara =  document.getElementById('otherinfo2').style.display='block'
	var myPara =  document.getElementById('otherinfo1').style.display='none'
	}
	function otherinfohide(){
	var myPara =  document.getElementById('otherinfo').style.display='none'
	var myPara =  document.getElementById('otherinfo2').style.display='none'
	var myPara =  document.getElementById('otherinfo1').style.display='block'
	}
        
        
	
	function homeifoshow(){
	var myPara =  document.getElementById('homeinfo').style.display='block'
	var myPara =  document.getElementById('homeifo2').style.display='block'
	var myPara =  document.getElementById('homeifo1').style.display='none'
	}
	function homeifohide(){
	var myPara =  document.getElementById('homeinfo').style.display='none'
	var myPara =  document.getElementById('homeifo2').style.display='none'
	var myPara =  document.getElementById('homeifo1').style.display='block'
	}
	
	function personalifoshow(){
	var myPara =  document.getElementById('personalinfo').style.display='block'
	var myPara =  document.getElementById('personalinfo2').style.display='block'
	var myPara =  document.getElementById('personalinfo1').style.display='none'
	}
	function personalifohide(){
	var myPara =  document.getElementById('personalinfo').style.display='none'
	var myPara =  document.getElementById('personalinfo2').style.display='none'
	var myPara =  document.getElementById('personalinfo1').style.display='block'
	}
	
	function businessinfoshow(){
	var myPara =  document.getElementById('businessinfo').style.display='block'
	var myPara =  document.getElementById('businessinfo2').style.display='block'
	var myPara =  document.getElementById('businessinfo1').style.display='none'
	}
	function businessinfohide(){
	var myPara =  document.getElementById('businessinfo').style.display='none'
	var myPara =  document.getElementById('businessinfo2').style.display='none'
	var myPara =  document.getElementById('businessinfo1').style.display='block'
	}
	
	function productinfoshow(){
	var myPara =  document.getElementById('productinfo').style.display='block'
	var myPara =  document.getElementById('productfo2').style.display='block'
	var myPara =  document.getElementById('productfo').style.display='none'
	}
	function productinfohide(){
	var myPara =  document.getElementById('productinfo').style.display='none'
	var myPara =  document.getElementById('productfo2').style.display='none'
	var myPara =  document.getElementById('productfo').style.display='block'
	}
	
	function fivedivshow(){
	var myPara =  document.getElementById('fiveshow').style.display='block'
	var myPara =  document.getElementById('fivehide').style.display='none'
	
	}
        
        
        function plusshow()
	{            
     
            var x=document.getElementById('nolenght').value;
            if (x.length>9)
            {  
                document.getElementById('plushide').style.display='block' ;
                document.getElementById('addmore').style.display='block';
            }
	}   
       
	
      function plusshow22()
	{
	var x=document.getElementById('emailid').value;
         var a=x.indexOf("@");
	if (a>0)
	{
	var myPara =  document.getElementById('plushide22').style.display='block'
	var myPara =  document.getElementById('addmore22').style.display='block'
	}
	}

function plusadd(){
var myPara =  document.getElementById('plusaddshow').style.display='block'
}

function plusadd22(){
var myPara =  document.getElementById('plusaddshow22').style.display='block'
}


///////////////////////////  Addede by arvind thakur 

function otherDesignation(otherDivName,designationDIV){
   var status=document.getElementById(otherDivName).style.visibility;
        var selObj = document.getElementById(designationDIV);
        var desigText = selObj.value;

        if(desigText=='Other' || desigText=='M'){
            document.getElementById(otherDivName).style.visibility="visible" ;
            document.getElementById(otherDivName).style.display="" ;
        }else{
            document.getElementById(otherDivName).style.visibility="hidden" ;
            document.getElementById(otherDivName).style.display="none" ;
        }        
    }







