<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/mainHeader.jsp"></jsp:include>
<jsp:include page="include/makerHeader.jsp"></jsp:include>
<script>
	$(document).ready(function() {
		imgInp();
		var projectNum = ${projectNum};
		$.ajax({
			"url":"/maker/imgLoad/" + projectNum,
			"type":"get",
			"success":function(){
				console.log('data load success');
			}
		});
		
		$("#projectTitle").text("스토리 작성");
		$("#projectDesc").text("메이커님의 프로젝트를 소개 해보세요.");
		$('#btnSave').click(function(e) {
			e.preventDefault();
			$.get('/maker/imgCopy/' + projectNum, function(data){
				console.log('이미지 저장하는 중...');
				});
			submitContents(this);
		});
		$('#btnintroImg').click(function(e){
			e.preventDefault();
		});
    });
</script>
	<div class="container-fluid">
<form id="formTampData" name="formTampData">
	<input type="hidden" value="${projectNum}" name="temp_story_num" />
	<c:forEach items="${list }" var="list">
	<input type="hidden" value="${list.imglist_name }" class="imgName"/>	
	</c:forEach>
		<div class="card">
			<div class="card-body">
				<div class="form-group">
				<label for="inputGroupFile01">소개 이미지 등록</label>
				<div class="custom-file">
			    <input type="file" class="custom-file-input" id="imgInp" aria-describedby="inputGroupFileAddon01">
			    <label class="custom-file-label" for="inputGroupFile01">이미지 파일을 선택하세요</label>
			  	</div>
					<div class="form-group">
					  <img id="blah" src="/upload/imgView?fileName=${storyDto.story_introimg }"/>
					  <input type="hidden" id = "introImg" value="<c:if test="${storyDto.story_introimg eq null || storyDto.story_introimg eq ''}">makerUpload/default.png</c:if>${storyDto.story_introimg }" name="story_introimg"/>
					</div>
				</div>
			</div>
			<div class="card-body">
				<div class="form-group">
					<label for="summary">프로젝트 요약</label>
					<div>
						<textarea class="form-control" rows="3" name="story_summary"
							id="summary">${storyDto.story_summary}</textarea>
					</div>
				</div>
			</div>
			<div class="card-body">
				<div class="form-group">
					<Label for="storyBoard"></Label>
					<jsp:include page="include/smartEdit2.jsp"></jsp:include>
				</div>
			</div>
		</div>
</form>
<div class="card-body">
	<div class="form-gorup">
		<button class="btn btn-primary" id="btnSave">저장</button>
	</div>
</div>
</div>
<jsp:include page="../board/include/board_footer.jsp"></jsp:include>