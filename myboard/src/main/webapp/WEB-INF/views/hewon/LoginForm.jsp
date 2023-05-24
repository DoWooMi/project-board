<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.loginform {
	padding-top: 50px;
}
.logindiv {
    display: flex;
    justify-content: center;
    align-items: center;
}
.login-wrapper{
    width: 400px;
    height: 300px;
    padding: 40px;
    box-sizing: border-box;
    text-align: center;
}

#login_t{
    font-size: 24px;
    color: #0d6efd;
    margin-bottom: 20px;
}
#idbox, #passwdbox, #loginBtn{
    width: 100%;
    height: 48px;
    padding: 0 10px;
    box-sizing: border-box;
    margin-bottom: 16px;
    border-radius: 6px;
    background-color: #E8F0FE;
    border: none;
}

#loginBtn{
    color: white;
    font-size: 16px;
    background-color: #0d6efd;
    
}
#link {
	background-color: white;
	font-size: 14px;
	border: none;
}
.error {
	color: red;
	font-size: 15px;
	text-align: left;
	vertical-align: middle;
}
</style>
<title>LoginForm</title>
</head>
<body>
	<body>
	<div class="loginform">
	<form id="login" method="post" action="<c:url value="/login"/>" >
		<div class="logindiv">
		<div class="login-wrapper">
    		<h2 id="login_t">Login</h2>
			<input id="idbox" type="text" name="id" value="${id}" placeholder="아이디">
			<input id="passwdbox" type="password" name="pw" placeholder="비밀번호">
			<span id="loginMsg" class="error">${message }</span>
			<button id="loginBtn" type="submit">로그인</button> 
    	</div>
		</div>
    </form>
    
    
    <div style="text-align: center">
		<input id="link" type="button" value="아이디 찾기&nbsp;&nbsp;&nbsp;" onclick="location.href='<c:url value=""/>';">
		<input id="link" type="button" value="비밀번호 찾기&nbsp;&nbsp;&nbsp;" onclick="location.href='<c:url value=""/>';">
		<input id="link" type="button" value="회원가입" onclick="location.href='${pageContext.request.contextPath }/join';">
    </div>
    </div>
    <script type="text/javascript">
    $("#login").submit(function() {
    	var result=true;
    	
    	if($("#idbox").val()=="") {
			$("#loginMsg").text("아이디를 입력해 주세요.");
			result=false;
		}
    	
    	if($("#passwdbox").val()=="") {
			$("#loginMsg").text("비밀번호를 입력해 주세요.");
			result=false;
		}
    	return result;
    });
    </script>
</body>
</body>
</html>