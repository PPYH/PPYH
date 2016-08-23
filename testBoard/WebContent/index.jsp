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

	<div class="col-md-4 col-md-offset-5" style="margin-top: 50px;">
		<form method="post" action="list.do?nowPage=1&nowBlock=1">
			<input type="hidden" value="${id}" name="id" />
			<table class="table">
				<tr>
					<td class="col-xs-1">이름</td>
					<td class="col-xs-2"><input type="text" class="form-control" placeholder="이름" name="name"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" class="btn" value="확인" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>