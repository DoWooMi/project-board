<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>  
      
<style>
.joinform {
	padding-top: 50px;
}
#hewonBtn {
	background-color: #706FFF;
	color: #fff;
	padding: 2px 7px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
.my{
	font-weight: 600;
	padding: 12px;
}
</style>
</head>
<body>
<div class="joinform">
	<div style="padding: 12px;">
	<h3 style="text-align: center; font-size: 10px; font-weight:900; color: #706FFF;">내정보</h3>
		<div class="my">😀 아이디 : <span>${loginHewon.id }</span></div>
		<div class="my">✏ 이름 : <span>${loginHewon.name }</span></div>	
		<div class="my">📧 이메일 : <span>${loginHewon.email }</span></div>	
		<div class="my">☎ 전화번호 : <span>${loginHewon.phone }</span></div>	
	<br>
	<button type="submit" id="hewonBtn">회원정보변경</button>
	<button type="submit" id="hewonBtn">회원탈퇴</button>
	</div>	
</div>
</body>
</html> 
    