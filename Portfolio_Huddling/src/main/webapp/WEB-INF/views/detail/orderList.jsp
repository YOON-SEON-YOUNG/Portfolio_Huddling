<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
/*
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
*/
 section#content ul li { border:5px solid #eee; padding:10px 20px; margin-bottom:20px; }
 section#content .orderList span { font-size:20px; font-weight:bold; display:inline-block; width:90px; margin-right:10px; }
</style>
<body>
<br>
<br>
<br>
<br>
<br>
<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		<h1>내가 후원한 펀딩</h1>
		<br>
		<br>
		<section id="content">
 
 <ul class="orderList">
  <c:forEach items="${orderList}" var="orderList">
  <li>
  <div>
   <p><span>주문번호</span><a href="/detail/orderView?n=${orderList.order_id}">${orderList.order_id}</a></p>
   <p><span>수령인</span>${orderList.order_rec}</p>
   <p><span>주소</span>(${orderList.useraddr1}) ${orderList.useraddr2} ${orderList.useraddr3}</p>
   <p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderList.amount}" /> 원</p>
   <p><span>상태</span>${orderList.delivery}</p>
  </div>
  </li>
  </c:forEach>
 </ul>

</section>
		
		
		</div>
		<div class="col-md-2">
		</div>
	</div>

</body>
</html>
<%@ include file="../board/include/board_footer.jsp"%>