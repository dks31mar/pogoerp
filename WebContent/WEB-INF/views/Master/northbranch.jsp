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
 
    <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>

<!-- call region -->
<link rel="stylesheet" type="text/css"
	href="resources/css/table.css">
<title>Insert title here</title>

</head>
<body>








<h2>Modal Example</h2>

<!-- Trigger/Open The Modal -->
<button id="myBtn">Open Modal</button>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">×</span>
   <form>
  Region Name:<input type="text" name="firstname"><br>
  
  Phone No:<input type="text" name="phone"><br>
   
  Fax No:<input type="text" name="fax"><br>

  EmailId:<input type="text" name="fax"><br>

  
  Region Head Name:<input type="text" name="headname"><br>

  Region Address:<input type="text" name="headname"><br>
</form>











<style type="text/css">
            .contentwrap
            {
                         
                overflow: auto;
            }
 
            .wordwrap
            {
                word-wrap:break-word;		
            }
        </style>
<script>
    var globalDomain='pogoerpdemo'  ;
function  textWrap()
            {	
                if (window.attachEvent == undefined)
                {
                    var tag = document.getElementsByTagName("span");
                    for (var i = 0; i < tag.length; i++)
                    {	
                        if (tag.item(i).className == "wordwrap")
                        {
                            var text = tag.item(i).innerHTML;
                            tag.item(i).innerHTML = text.replace(/(.*?)/g, "<wbr />");
                        }
                    }
                }
				
            }
function hideMenuforFrame(){
try{
	var testobj=parent.getObj("testid").value;
	
if(testobj!=null  && parent.getObj(testobj)!=null){
//alert("sachin");
                        if (parent.getObj(testobj).style.display=="block")
                                parent.getObj(testobj).style.display="none";
				}
	//alert("Sachin");
				try{
	for (i=0; i<frames.document.getElementsByTagName("SELECT").length; i++){
		obj = frames.document.getElementsByTagName("SELECT")[i];
		if (!obj || !obj.offsetParent) continue;
		obj.style.visibility = "visible";
	}
				}catch(err){}			
	}catch(err){}			
				}
		  document.onmouseover =hideMenuforFrame;
        
</script>
<script>
var globalDomainMap='pogoerpdemo'  ;
</script> 


  
  
  
    
<HTML>
<HEAD>
<TITLE>pogoerpdemo</TITLE>
<LINK REL="stylesheet" HREF="/pogoerpdemo/script/SearchCriteriaStyles.css" TYPE="text/css">

<link href="/pogoerpdemo/script/stylesheet2.css" rel="stylesheet" type="text/css">


<SCRIPT language="JavaScript" TYPE="text/JavaScript">
        
var globalisAllowDeliveryStatus ='false'  ;
function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,'_blank',features,'width=640,height=600,left=0,top=0,resizable=yes');
}
//-->
</SCRIPT>



<script language="JavaScript">
<!--
function calcHeight2()
{
  try{

  var frameWidth = (screen.availWidth)*0.81;
  var the_height=
    parent.document.getElementById('frmMain').contentWindow.
      document.body.scrollHeight;
    var the_width=
			parent.document.getElementById('frmMain').contentWindow.
			  document.body.scrollWidth;
	if(frameWidth<the_width){
	if(parent.getObj("framediv2222").style.width!=the_width){
		

		  //change the height of the iframe
		  parent.document.getElementById('frmMain').height=
			  the_height;
		  parent.document.getElementById('frmMain').width=
			  the_width;

		//  alert(the_height);
		  parent.getObj("framediv2222").style.height  = the_height;
		  parent.getObj("framediv2222").style.width  = the_width;

	}
	}

  }catch(e){}
}
//-->
</Script>
<script src="/pogoerpdemo/script/RowHandlers.js" language="javascript" type="text/javascript"></script>
<SCRIPT TYPE="text/javascript" LANGUAGE="javascript">
/*
					Sharad 6/Nov/08
					
					*/
                                       

function waitPreloadPage() { //DOM

calcHeight2();
//document.getElementById('prepage').style.display='none'; 
textWrap();
addRowHandlers('row', 'rowMouseOver', 'none','id', 0);

}

					function handleError() {
						return true;
					}

					window.onerror = handleError;
// End -->
</SCRIPT>    
</HEAD>

         <BODY LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0" BGCOLOR="#FFFFFF"  onClick="calcHeight2()">



<!--<DIV id="prepage" style="position:absolute; font-family:arial; font-size:16; left:0px; top:0px; background-color:white; layer-background-color:white;"> 
	<script>
		document.write("<img src='/pogoerpdemo/images/loading.gif' border=0>&nbsp;&nbsp;<B>Loading ... ... Please wait!</B> <input type='text' id='focus' name='focus' readonly style='border:none' >");
	</script>        
</DIV>-->



<script>
    try{
    //document.getElementById('focus').focus(); }catch(e){alert(e);}
</script>


 
<CENTER CLASS="errorMessageSmall">
	
 </CENTER>


 <table width="98%" border="0" cellspacing="1" cellpadding="0" align="center">
  <tr> 
      <TD ALIGN="left" CLASS="topHeaderText2" WIDTH="40%" > 
              
                         
            
          </TD>
  </tr>
</table>
<TABLE width="98%" border="0" align="center" cellspacing="0" cellpadding="1">
  <TR>
    <TD valign="top">
      

















<style type="text/css">
            .contentwrap
            {
                         
                overflow: auto;
            }
 
            .wordwrap
            {
                word-wrap:break-word;		
            }
        </style>
<script>
    var globalDomain='pogoerpdemo'  ;
function  textWrap()
            {	
                if (window.attachEvent == undefined)
                {
                    var tag = document.getElementsByTagName("span");
                    for (var i = 0; i < tag.length; i++)
                    {	
                        if (tag.item(i).className == "wordwrap")
                        {
                            var text = tag.item(i).innerHTML;
                            tag.item(i).innerHTML = text.replace(/(.*?)/g, "<wbr />");
                        }
                    }
                }
				
            }

</script>
<!--5/nov/2008 script added by sachin for hiding menu after clicking on frma body-->
<script>

function hideMenuforFrame(){
try{
	var testobj=parent.getObj("testid").value;
	
if(testobj!=null  && parent.getObj(testobj)!=null){
//alert("sachin");
                        if (parent.getObj(testobj).style.display=="block")
                                parent.getObj(testobj).style.display="none";
				}
	//alert("Sachin");
				try{
	for (i=0; i<frames.document.getElementsByTagName("SELECT").length; i++){
		obj = frames.document.getElementsByTagName("SELECT")[i];
		if (!obj || !obj.offsetParent) continue;
		obj.style.visibility = "visible";
	}
				}catch(err){alert(err);}			
	}catch(err){}			
				}


 
		  document.onmouseover =hideMenuforFrame;
                  
</script>






<HTML>
<HEAD>
<TITLE>pogoerpdemo</TITLE>
<LINK REL="stylesheet" HREF="/pogoerpdemo/script/SearchCriteriaStyles.css" TYPE="text/css">



		


	

<link href="/pogoerpdemo/script/stylesheet2.css" rel="stylesheet" type="text/css">
	

  


<SCRIPT language="JavaScript" TYPE="text/JavaScript">
<!--
function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,'_blank',features,'width=640,height=600,left=0,top=0,resizable=yes');
}
//-->
</SCRIPT>
<script language="JavaScript">
<!--
function calcHeight2()
{
/*		alert((screen.availWidth)*0.81);
		alert(parent.document.getElementById('frmMain').width)
*/
  //find the height of the internal page
  try{

  var frameWidth = (screen.availWidth)*0.81;
  var the_height=
    parent.document.getElementById('frmMain').contentWindow.
      document.body.scrollHeight;
    var the_width=
			parent.document.getElementById('frmMain').contentWindow.
			  document.body.scrollWidth;
	//alert(frameWidth<the_width);
	if(frameWidth<the_width){
	if(parent.getObj("framediv2222").style.width!=the_width){
		

		  //change the height of the iframe
		  parent.document.getElementById('frmMain').height=
			  the_height;
		  parent.document.getElementById('frmMain').width=
			  the_width;

		//  alert(the_height);
		  parent.getObj("framediv2222").style.height  = the_height;
		  parent.getObj("framediv2222").style.width  = the_width;
			//parent.getObj("test2div").style.height  = the_height;

		/*	alert(the_width);
			alert(parent.getObj("framediv2222").style.width);

				alert(parent.document.getElementById('frmMain').width);
			
*/
	}
	}

  }catch(e){}
}
//-->
</script>
</HEAD>

 <BODY LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0" BGCOLOR="#FFFFFF" onClick="calcHeight2()";>

  

<SCRIPT language="JavaScript">
<!--
function ValidateForm()
{

with(document.RegionList)
 {			
			submit();
 }
}

function confirmDelete(){
	if(confirm('Sure to delete the Region?')){
		return true;
	}else{
		return false;
		}
	}
//-->
</SCRIPT>
<TABLE WIDTH="375" BORDER="0" CELLSPACING="1" CELLPADDING="0" ALIGN="center">
    <FORM NAME="RegionList" METHOD="post" ACTION="RegionMain.jsp?operation=ADDNEW">
         
        
        
	
 </CENTER>
        
        
       <table class="responstable">
  
  <tbody><tr>
    <th>S.N.</th>
    <th data-th="Driver details"><span>Branch</span></th>
    <th>Phone No</th>
    <th>Fax No</th>
    <th>Product Detail</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  
  <tr>
    <td>1</td>
   <td><a href="#">Bhopal</a></td>
   <td></td>
   <td></td>
    <td></td>
   <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  
  <tr>
    <td>2</td>
    
    <td><a href="#">Gwalear</a></td>
    <td></td>
    <td></td>
    <td></td>
    <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  </tr>
  
  <tr>
    <td>3</td>
    <td><a href="#">Delhi</a></td>
    <td></td>
    <td></td>
    <td></td>
  <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  </tr>
  
  <tr>
    <td>4</td>
    <td><a href="#">gurgaon</a></td>
    <td></td>
    <td></td>
    <td></td>
  <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  </tr>
  <tr>
    <td>5</td>
    <td><a href="#">Branches</a></td>
    <td></td>
     <td></td>
    <td></td>
   <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  </tr>
  
</tbody></table>
        
</FORM></table></TD>
    </TD>
    <TD valign="top">
      
  </TR>
</TABLE>

                    



</body>
</html>