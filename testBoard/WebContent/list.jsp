<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring 게시판</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
	
<script type="text/javascript">
// 	window.onload = function() {
		
// 	}
</script>	
</head>
<body>

	<div class="row" style="margin-top: 50px;">
		<div class="col-md-6 col-md-offset-3">
			<table class="table table-condensed">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>이름</th>
					<th>날짜</th>
				</tr>
				<c:forEach items="${item}" var="item">
					<tr>
						<td>${item.id }</td>
						<td><a href="content.do?id=${item.id }">${item.subject }</a></td>
						<td>${item.name }</td>
						<td>${item.wdate }</td>
					<tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<div class="row" align="center">
		<nav aria-label="Page navigation"
			style="margin-right: center; margin-top: center;">		
			
			<ul class="pagination">
				<c:if test="${page.nowBlock>1}">
					<li><a href="list.do?name=${sessionScope.name }&nowBlock=${page.nowBlock-1}&nowPage=${(page.nowBlock-1)*5-5}" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
	

			
			<c:forEach begin="1" end="${page.totalPage}" var="i">
			
						<li><a href="list.do?name=${sessionScope.name }&nowPage=${i}&nowBlock=1">${i }</a></li>
					
			</c:forEach>
			
			
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>

		</nav>
	</div>

	<div class="row">
		<div class="col-md-6 col-md-offset-3" align="right">
			<a class="btn btn-default" href="writeForm.do" role="button">글쓰기</a>
		</div>
	</div>


</body>
</html>