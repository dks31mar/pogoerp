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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
<form:form method="POST" commandName="fileUploadForm" enctype="multipart/form-data" action = "upload">
		
<div class="row">
<div class="page-heading col-sm-12" style="background-color: #3C8DBD;   height: 34px; text-align: center;" ><strong id = showlabeltext> List of CSV Files  </strong> 
<label  style="margin-left: 500px;"><!-- <button href="#" class="btn btn-primary" id="getpopup1" style="margin-bottom: -25px;margin-top: -26px;HEIGHT: 28px;margin-left: 561px;"> Choose File </button> --><input type = "file" name = "file"> </label>		
<!--  <label  style="margin-left: 400px;margin-top: -5px;"><button href="#" class="btn btn-primary" id="getpopup2" style="margin-bottom: -25px;margin-top: -26px;HEIGHT: 28px;margin-left: 561px;"> Upload </button> </label>  -->
<label style="margin-left: 500px;"><input type = "submit">Upload</label>
</div>	
</div>
</form:form>

<script type="text/javascript">
        function saveMedia() {
            var formData = new FormData();
            formData.append('file', $('input[type=file]')[0].files[0]);
            console.log("form data " + formData);
            $.ajax({
                url : 'upload',
                data : formData,
                processData : false,
                contentType : false,
                type : 'POST',
                success : function(data) {
                    alert(data);
                },
                error : function(err) {
                    alert(err);
                }
            });
        }
    </script>