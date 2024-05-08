<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투두</title>
</head>
<body>
	<h1>ajax</h1>
	<select id="selectBox">
		<option value="" selected disable>선택</option>
		<option value="list">list</option>
		<option value="root">root</option>
		<option value="root2">root2</option>
	</select>
	<h1>Hell page</h1>

<div id="here"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function(){
	//alert("잘 나옴");
	$.ajax({
		url : '/list',
		method : 'GET',
		success : function(data) {
			$('#here').html(data);
		}
	});
	
	$("#selectBox").on("change", function(){
		console.log($(this).val());
	})
});
</script>
</body>
</html>