<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>글쓰기</title>
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
</head>
<body>
	<div class="col-md-6 col-md-offset-3" style="margin-top: 50px;">
	<form method="post" action="edite.do">
		<input type="hidden" value="${item.id}" name="id"/>
		<table class="table">
			<tr>
				<td colspan="1" class="col-xs-1">제목</td>
				<td colspan="3" class="col-xs-12"><input type="text" class="form-control" name="subject" placeholder="제목" value="${item.subject }"></td>
			</tr>
			<tr>
				<td class="col-xs-1">이름</td>
				<td class="col-xs-5">	<input type="text" class="form-control" placeholder="이름" readonly="readonly" name="name" value="${item.name }"></td>
				<td class="col-xs-1">비밀번호</td>
				<td class="col-xs-5">	<input type="password" class="form-control"  placeholder="Password" name="password" ></td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea class="form-control" rows="3" name="content">${item.content }</textarea>
				</td>
			<tr>
		</table>
		<input type="submit" class="btn" value="확인"/>		
	</form>
	</div>


</body>
</html>