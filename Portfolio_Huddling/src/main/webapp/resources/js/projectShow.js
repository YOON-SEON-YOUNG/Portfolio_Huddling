/**
 * 
 */

//var project_num = pVo.project_num;
//var project_category = pVo.project_category;
//var project_image = pVo.project_image;
//var project_story = pVo.project_story;
//var project_name = pVo.project_name;
//var project_app = pVo.project_app;

//백분율 구하기
	function percent(num){
	$.get("/detail/totalPrice/" + num,function(data){
		if(data == null || typeof data == "undefined"){
			data = 0;
		}
		console.log("perVal : ", data);
		return data;
		});
	}

			
function arrStrPush(project_num, project_category, project_image, project_story, project_name, project_app) {
		if (project_app == 1) {
			var perVal = percent(project_num);
			if(perVal == null || typeof perVal == "undefined"){
				perVal = 0;
			}
			var strList = "";
			strList +="<div style='height:350px;' class='col-md-4'>";
			strList +="<a href='/detail/detailMain/"+encodeURI(project_num)+"'>";
			strList +="<img style='height:250px; width:100%;' class='card-img-top' alt='Bootstrap Thumbnail First' src='/upload/imgView?fileName="+project_image+"'"; 
			strList += "style='max-width: 100%; height: auto;'/>";
			strList +="<div class='card-block'>";
			strList +="<h5 class='card-title'>";
			strList +="<br>";
			strList +="<div style='height:20px;'>"+project_name+"</div>";
			strList +="<br>";
			strList +="</h5>";
			strList +='<div class="progress">';
			strList +='<div class="progress-bar" role="progressbar" style="width: '+perVal+'%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">'+perVal+'</div></div>'
			strList +="</div> </div> <p>";
			strList +="</p> </div> </div> </a> </div>";
			arrProject.push(strList);
		}
}

// 더보기 처리 상단
	var arrProject = new Array();
	var moreShoeNum = 0;
	
	function showProject() {
		for (var i = moreShoeNum; i < (moreShoeNum+6); i++) {
			$("#newList").append(arrProject[i]);
//			if ( (i % 3) == 0 ) {
//				$("#newList").append("<hr>");
//			}
		}
		moreShoeNum = moreShoeNum + 6;
	}
	
	// 스크롤이 최하단일때
	$(window).scroll(function(){
		  if($(document).height() <= $(window).scrollTop() + $(window).height()){
		  	showProject();
		  }
	});
// 더보기 처리 하단
	
