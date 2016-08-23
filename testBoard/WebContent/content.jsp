<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>게시판</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	>

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script  src="https://code.jquery.com/jquery-2.2.4.js"></script>
	<script type="text/javascript">
	
		
	function insertComment(){
		
		var id=document.getElementById("boardid").value;
		var ccontent=document.getElementById("ccontent").value;
		var cpass=document.getElementById("cpass").value;
		var cname=document.getElementById("cname").value;
		
		

		$.ajax({
				type : 'GET',
				url : 'insertComment.do?bnum='+id+'&ccomment='+ccontent+'&password='+cpass+'&name='+cname,
				contentType : 'application/json;charset=utf-8',
				dataType : 'json',
				error : function(xhr, status, msg) {
					alert("상태값 : " + status + " Http 에러메세지 : " + msg);
				},
				success : showResult
			});
		}
	
	


		function showResult(data) {
			console.log(data.jsondata);
			
			$("#commentbody tr").remove();
			
			$.each(data.jsondata, function(idx, item) {

				$("<tr>").append($("<td>").html(item.name)).append(
						$("<td>").html(item.ccomment)).append(
						$("<td>").html(item.wdate)).appendTo("#commentbody");

			})//each
		}//showResult
	</script>
</head>
<body>

	<div class="col-md-6 col-md-offset-3" style="margin-top: 50px;">
	<input type="hidden" value="${item.id }" id="boardid"/>
		<table class="table">
			<tr>
				<td colspan="1" class="col-xs-1">제목</td>
				<td colspan="3" class="col-xs-12"><input type="text"
					class="form-control" name="subject" placeholder="제목"
					value="${item.subject }" readonly="readonly"></td>
			</tr>
			<tr>
				<td class="col-xs-1">이름</td>
				<td class="col-xs-5"><input type="text" class="form-control"
					placeholder="이름" name="name" value="${item.name }"
					readonly="readonly"></td>
				<td class="col-xs-1">작성날짜</td>
				<td class="col-xs-5"><input type="text" class="form-control"
					value="${item.wdate }" name="wdate" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea class="form-control" rows="3"
						name="content" contenteditable="false" disabled="disabled">${item.content }</textarea>
				</td>
			<tr>
		</table>
		<div align="right">
			<a href="list.do?name=${sessionScope.name }&nowPage=1&nowBlock=1" class="btn">확인</a> 
			<a href="deleteForm.do?id=${item.id }" class="btn">삭제</a>
			<a href="editeForm.do?id=${item.id }" " class="btn">수정</a>
		</div>
		
		
		

	</div>
	<div class="col-md-6 col-md-offset-3" >
		<table class="table">
			<thead>
				<tr>
					<th>이름</th>
					<th>내용</th>
					<th>날짜</th>
				</tr>				
			</thead>
			<tbody id="commentbody">
				<c:forEach items="${comment}" var="comment">
					<tr>
						<td>${comment.name }</td>
						<td>${comment.ccomment }</td>
						<td>${comment.wdate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="col-md-6 col-md-offset-3" >
		<table>
			<tr>
				<td>이름</td>
				<td class="col-xs-5"><input type="text" class="form-control" 	placeholder="이름" name="name" value="${sessionScope.name }" 	readonly="readonly" id="cname"></td>
				<td>비밀번호</td>
				<td class="col-xs-5"><input type="password" class="form-control" 	placeholder="비번" name="password"  id="cpass"></td>
			</tr>
			<tr>
				<td colspan="4">
				<textarea class="form-control" rows="3" name="ccomment" class="col-md-4" id="ccontent"></textarea>
			
					<input type="button" value="확인" onclick="insertComment()"/>
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>