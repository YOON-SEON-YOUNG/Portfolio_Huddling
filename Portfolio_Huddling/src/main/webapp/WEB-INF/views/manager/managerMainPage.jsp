<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
	
	#menu {
		text-align: center;
		border-style: solid;
		border-color: #F2F2F2;
	}
	
	#page {
		border-style: solid;
		border-color: #F2F2F2;
		
	}
	
</style>
<script type="text/javascript" src="/resources/js/chat.js"></script>
<script>
$(document).ready(function() {
	
	
	
	
	$("#page").load("userControl?search=");
	
	$("#userControl").click(function(e) {
		e.preventDefault();
		$("#page").empty();
		stopInter();
		$("#page").load("userControl");
	});
	
	$("#projectAppControl").click(function(e) {
		e.preventDefault();
		$("#page").empty();
		stopInter();
		$("#page").load("projectApprovalControl?project_app=1");
	});
	
	$("#projectUnAppControl").click(function(e) {
		e.preventDefault();
		$("#page").empty();
		stopInter();
		$("#page").load("projectUnApprovalControl?project_app=0");
	});
	
	$("#questionsControl").click(function(e) {
		e.preventDefault();
		$("#page").empty();
		stopInter();
		$("#page").load("questionsControl");
	});
	
	
});
</script>
<title>관리자페이지</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
			
<!-- 			타이틀 -->

				<div class="col-md-12">
					<h1 style="text-align: center;">관리자페이지</h1><a href="/">홈으로</a>		
					<hr>		
				</div>
				
<!-- 			// 타이틀 -->

			</div>
			<div class="row">
			
<!-- 			메뉴 -->

				<div id="menu" class="col-md-3">
					<hr>
					<a id="userControl" src="">회원정보</a><br><hr><br>				
					<a id="projectAppControl" src="">프로젝트 관리(승인)</a><br><hr><br>					
					<a id="projectUnAppControl" src="">프로젝트 관리(미승인)</a><br><hr><br>					
					<a id="questionsControl" src="">문의사항</a>
					<hr>						
				</div>
				
<!-- 			// 메뉴 -->
<!-- 			페이지 -->

				<div id="page" class="col-md-7">
				</div>
				
<!-- 			// 페이지 -->

				<div class="col-md-1">
				</div>

			</div>
		</div>
	</div>
</div>
</body>
</html>