<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<HTML>
<HEAD>
<TITLE>PogoERP Print Report</TITLE>
<LINK REL="stylesheet" HREF="/pogoerpdemo/script/SearchCriteriaStyles.css" TYPE="text/css">
<link href="/pogoerpdemo/Resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/jquery.min.js"></script>
    <script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/pogoerpdemo/Resources/font-awesome-4.6.3/css/font-awesome.min.css">

<link href="/pogoerpdemo/script/stylesheet2.css" rel="stylesheet" type="text/css">
  
</HEAD>

	 <BODY LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0" BGCOLOR="#FFFFFF" onLoad="waitPreloadPage();" onClick="calcHeight2()">

<link href="/pogoerpdemo/Resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/pogoerpdemo/Resources/css/main.css" rel="stylesheet" type="text/css" />
<script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/jquery.min.js"></script>
<script language="JavaScript" src="/pogoerpdemo/script/dhtmlgoodies_calendar.js?random=20060118"></script>
<link type="text/css" rel="stylesheet" href="/pogoerpdemo/script/dhtmlgoodies_calendar.css?random=20051112" media="screen"></LINK>




<FORM NAME="SuppleirEntryForm"  METHOD="post"  action="/porefentry">
        <div><label style="padding-top: 50px"></label></div>

       
      
        <div style="margin-left:60px;font-size: 2px;">
            <table>
                <tr>
                    <td><font size="2">Purchase Order</font></td>
                    <td style="width:700px">&nbsp;</td>
                    <td style="width: 500px"><font size="2" ><b>YMC INDIA PVT. LTD.</b></font><br>
                    <font size="2">A-154-155, 1st Floor, Eros Boulevard<br>
                    Hotel Crown Plaza, Mayur Vihar, Phase-I,<br>
                    New Delhi- 110091<br>
                    Tel. no:- 011-45041701/601<br>
                    Purchase Order Fax no:- 011-45041901<br>
                    Email - sales@ymcindia.com</font></td>
                    </tr>
            </table>
            <div><label style="padding-top: 50px"></label></div>
        
        <table align="left" border="1" width="90%">
             
              
              <tr>
                <td align="left"><font size="2"><b>PO Reference No:</b></font></td>
                <td colspan="2"><font size="2">&nbsp;${porefnumber}</font></td>
                <td align="center"><font size="2"><b>Date:</b></font></td>
                <td colspan="0"><font size="2">&nbsp;${date}</font></td>
<!--                <td class="col-sm-1 form-level"><font size="2"><b>Roe</b></font></td>
                <td colspan="2"><font size="2">&nbsp; null</font></td>-->
            </tr>
             
            <tr>
                 <td colspan="9"><font size="2"><b>To,</b></font></td>
              </tr>   
               <tr>
                 <td colspan="9"align="left"><font size="2">YMC CO.,LTD. YMC Karasuma-Gojo Building 284 Daigo-cho Karasuma Nishiliru Gojo-dori,Shimogyo -Ku Kyoto 600-8106 Japan</font></td>
                </tr>               
                  </table>
                <div>
                 <label style="padding-top: 50px"></label></div>
                <table align="left">
                <tr><td ><font size="2">
                <br> Dear Reika-san,<br>
                We are pleased to place the firm order as per below<br> 
                PO-005<br></font></td></tr>
                <tr><td>&nbsp;</td></tr>
                </table>
                </div>            
                
                
     
                 <table id ="tableitem" align="center" style="margin-left:60px;width:90%" border="1">
             
                
                <tr>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="2"><b>Sr.No.</b></font></td>               
               <td align="center">&nbsp;<font size="2" ><b>Description</b></font></td>
               <td align="center">&nbsp;<font size="2" ><b>Part No</b></font></td>
               <td align="center">&nbsp;<font size="2" ><b>TP In JPY</b>&nbsp;</font></td>
               <td align="center">&nbsp;<font size="2" ><b>QTY</b></font></td> 
               <td align="center">&nbsp;<font size="2"><b>Total JPY</b></font></td>
<!--               <td align="center">&nbsp;<font size="2"><b>Total INR</b></font></td>-->
                </tr>
                
                             <c:if test="${!empty listbyporef}">
								<c:forEach items="${listbyporef}" var="poref" varStatus="loop">             
                             <tr>
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${loop.index+1}</td>
                            
                               <td align="center">&nbsp;${poref.productdescription}</td>
                               <td align="center">&nbsp;${poref.particular}</td>
                               <td align="center">&nbsp;${poref.tpinjpy}</td>
                               <td align="center" >&nbsp;${poref.qty}</td>
                               <td align="center">&nbsp;${poref.totaljpy}</td>
<!--                              <td align="center">&nbsp;null</td>-->
                             </tr>
                             </c:forEach>
                             </c:if>
                             <tr><td></td>
                                 <td align="center">Total(Qty & Amount) </td>
                                 <td></td>
                                 <td></td>
                                 <td></td>
                               <td align="center">&nbsp;${gtotal}</td>
                               </tr>
                          </table>
                          
                  <P></p><br>
              <p style="margin-left:3em;"> You are requested to kindly acknowledge the receipt of this order and arrange for a shipment at our Delhi office.
                 .</p><br>
                 <p style="margin-left:3em;">For YMC India Private Limited</p><br>
                 <p style="margin-left:3em;">Authorized Signatory</p><br><br>

                <table align="center">
                    <tr><td>&nbsp;</td></tr>
                   <tr> 
                         <td align="center" class="topHeaderText2" ><font size="4" ><a href="#" onClick="return window.print();return false" >Print</a> 
                 | <a href="#" onClick="window.close();return false">Back</a></font></td>
                    </tr>
                      
               
              
        </table>
            
</form>
           