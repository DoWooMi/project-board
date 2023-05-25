<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">      
<html>
<head>
<style type="text/css">
td {
	text-align: left;
}
</style>
<title>New Post</title>
</head>
<body>

<div class="content" style="width: 1300px; margin: 0 auto; position: relative; text-align: center;" >
<br>
<h3>게시글 등록</h3>
<br>
<br>
<div>
	<form class="row gx-3 gy-2 align-items-center" name="f" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bhid" value="${loginHewon.getId()}">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" id="title" style="width: 1150px;">
				</td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td>
					<input type="file" name="uploadFile" id="img">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="18" cols="145" name="content" id="content" style="text-align: left;"></textarea>
				</td>
			</tr>
		</table>	
	</form>
	<div style="text-align: center;">
	<br>
		<p><button onclick="noticeAdd();" type="button" id="writeBtn" class="btn btn-primary btn-sm">게시글등록</button>
		<button type="button" id="resetBtn" class="btn btn-primary btn-sm" onclick="reset();">다시작성</button>
		<button type="button" id="listBtn" class="btn btn-primary btn-sm" onclick="location.href='${pageContext.request.contextPath }/blog';">게시글목록</button></p>
	</div>
	</div>
	</div>
</body>
<script type="text/javascript">
function noticeAdd() {
	if ( f.title.value == "" ) {
		alert("제목을 입력해주세요.");
		f.title.focus();
		return;
	} 
	if ( f.content.value == "" ) {
		alert("내용을 입력해주세요.");
		f.content.focus();
		return;
	}
	f.action = "<c:url value="/upload"/>"
	f.submit();
}

function reset() {
	document.getElementById("content").value = "";
	document.getElementById("title").value = "";
}

</script>
</html>