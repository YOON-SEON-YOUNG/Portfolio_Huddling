<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="include/mainHeader.jsp"></jsp:include>
<jsp:include page="include/makerHeader.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.tag-item, .tagUl {
	list-style: none;
	float: left;
	margin-left: 5px;
}
</style>
<link href="/resources/js/tagify.css" rel="stylesheet">
<script src="/resources/js/jQuery.tagify.min.js"></script>
<script src="/resources/js/tagify.js"></script>

<script>
	$(function() {
// 		$('input[name=tags]').tagify();
		$("#projectTitle").text("기본 정보");
		$('#projectDesc').text('기본 정보를 입력하는 곳입니다.')
		// 입력한 데이터 임시 저장
		$("#btnSave").click(function(e){
		e.preventDefault();
		var url='tempDataBasicInfo'
		formsave(url);
		});
		//카테고리 가져오기
		var category = '${basicDto.basic_category}';
		$('#basic_category option').each(function(){
			if($(this).val() == '${basicDto.basic_category}'){
				$(this).prop('selected','selected');
			}
		});
		
	});
</script>
<form id="formHidden">
<input type="hidden" id="checkSelecter" value="">
</form>
<form id="formTampData" name="formTampData">
<input type="hidden" name="temp_basic_num" value="1">
<div class="container-fluid">
	<div class="card">
		<div class="card-body">
			<div class="form-group">
				<label for="projectName">프로젝트 이름</label> <input type="text"
					class="form-control" name="basic_projectName" value='${basicDto.basic_projectName }'/>
			</div>
		</div>
		<div class="card-body">
			<div class="form-group">
				<label for="amount">목표 금액</label> <input type="text"
					class="form-control" name="basic_amount" value='${basicDto.basic_amount }'/>
			</div>
		</div>
		<div class="card-body">
			<div class="form-group">
				<label for="representImg">프로젝트 대표 이미지</label>
				<input type="hidden" name="basic_representImg" value="${basicDto.basic_representImg }">
				<div class="form-group">
				<input type="file" name='imgFile'/>
<!-- 					<button class="btn btn-primary">등록하기</button> -->
				</div>
			</div>
		</div>
		<div class="card-body">
			<div class="form-group">
				<label for="Category">카테고리</label> <select class="form-control" name="basic_category" id='basic_category'>
					<option selected>카테고리 선택</option>
					<option value="tech">가전</option>
					<option value="general">잡화</option>
					<option value="beauty">뷰티</option>
					<option value="food">푸드</option>
					<option value="education">교육</option>
				</select>
			</div>
		</div>
		<div class="card-body">
			<div class="form-group">
				<label for="datepicker">프로젝트 종료일</label>
				<jsp:include page="include/datepicker.jsp"></jsp:include>
			</div>
		</div>
		<div class=card-body>
			<div class="form-group">
				<label for="searchTag">검색용 태그</label> <input name="basic_searchTag"
					class="form-control" id="basic_searchTag" value='${basicDto.basic_searchTag }'/>
			</div>
		</div>
	</div>
</form>
	<div class="card-body">
		<div class="form-group">
			<button class="btn btn-primary" id="btnSave">저장</button>
		</div>
	</div>
</div>
