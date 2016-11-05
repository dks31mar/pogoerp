<script>
function getDescription(designationid) {
			alert(designationid);
			$.ajax({
				type : "GET",
				url : 'getdesignationId',
				data : {
					"designationid" : designationid,
				},
				success : function(data) {
					var obj = JSON.parse(data);
					alert(obj);
					var content = '<option value="">Select </option>';
					$.each(obj, function(key, value) {
						content += '<option value="'+value.designationid+'">'
								+ value.designation + '</option>';
					});
					$("#designationid").append(content);
				},
				error : function(e) {
					$('#loading').hide();
				}
			});
		}	
</script>
<select id="designationid" onclick="getDescription(this.value)">
<option>--select----</option>
</select>