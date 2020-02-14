<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- include 로고, 검색, 로그인, 카테고리 -->
<%@ include file="include/board_header.jsp"%>
</head>
<body>

<div class="container-fluid">
	<br/>
	<!-- 리스트01 : 인기 추천 프로젝트 -->
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-4" align="left">
			<p style="font-weight: bold; font-size: large;">문화</p>
		 
<!--             이미지 넘기기..?,...그..불러올 갯수대로 -->
<!--             <div class="controls pull-right hidden-xs" align="right"> -->
<!-- 				<a class="left fa fa-chevron-left btn btn-primary"  -->
<!-- 					href="#carousel-example-generic" data-slide="prev"> -->
<!-- 				</a> -->
<!-- 				<a class="right fa fa-chevron-right btn btn-primary"  -->
<!-- 					href="#carousel-example-generic" data-slide="next"> -->
<!-- 				</a> -->
<!--             </div>/.controls pull-right hidden-xs -->
            
        </div>
        <div class="col-md-4" align="right">
<!-- 			<div class="dropdown"> -->
				<div class="wrap-drop">
					<select class="drop" style="width: 100px; font-size: 15px;">
				      <option>인기 순위</option>
				      <option>최신 등록 순위</option>
				      <option>마감 임박 순위</option>
				    </select>
				</div>
			</div>
        </div>
        <div class="col-md-2" >
        </div>
	</div><!-- /.row -->
	
	<br/>
	
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<div class="row">
				<!-- 상품1 -->
				<div class="col-md-4">
					<div class="card" style="width: 400px; height: 200px;">
						<img class="card-img-top" alt="Bootstrap Thumbnail First" src="/resources/images/thumbnail_01.jpg" />
						<div class="card-block">
							<h5 class="card-title">
								모빌리티산업 투자ㅣ대한민국 캠핑 카라반이 세계로 진출합니다.
							</h5>
							
							<!-- 프로그레스 -->
							<div class="progress">
								<div class="progress-bar w-75">
								</div>
							</div><!-- /.프로그레스 -->
							<p>
								<a class="btn btn-primary  btn-lg mb30" href="#">펀딩하러가기</a> 
							</p>
						</div>
					</div>
				</div>
				
				<!-- 상품2 -->
				<div class="col-md-4" >
					<div class="card" style="width: 400px; height: 200px;">
						<img class="card-img-top" alt="Bootstrap Thumbnail First" src="/resources/images/thumbnail_02.jpg" />
						<div class="card-block">
							<h5 class="card-title">
								강집사 초대형 고양이 화장실 + 멀티박스!! 냥이와 집사를 위한 선택
							</h5>
							
							<!-- 프로그레스 -->
							<div class="progress">
								<div class="progress-bar w-50">
								</div>
							</div><!-- /.프로그레스 -->
							<p>
								<a class="btn btn-primary  btn-lg mb30" href="#">펀딩하러가기</a> 
							</p>
						</div>
					</div>
				</div>
				
				<!-- 상품3 -->
				<div class="col-md-4">
					<div class="card" style="width: 400px; height: 200px;">
						<img class="card-img-top" alt="Bootstrap Thumbnail First" src="/resources/images/thumbnail_03.jpg" />
						<div class="card-block">
							<h5 class="card-title">
								스트릿 패션 완성! 환경을 생각한 가벼운 메신져백, [비트백]
							</h5>
							
							<!-- 프로그레스 -->
							<div class="progress">
								<div class="progress-bar w-75">
								</div>
							</div><!-- /.프로그레스 -->
							<p>
								<a class="btn btn-primary  btn-lg mb30" href="#">펀딩하러가기</a> 
							</p>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		<div class="col-md-2">
		</div>
	</div> <!-- /.리스트01 : 인기프로젝트 슬라이드 묶음 -->
	
</div><!-- /.container -->

<%@ include file="include/board_footer.jsp" %>