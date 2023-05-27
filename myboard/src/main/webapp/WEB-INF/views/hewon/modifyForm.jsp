<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JoinForm</title>  
      
<style>
.updateform {
	padding-top: 50px;
}
.form {
	display : block;
	width: 500px;
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
}

label {
	display: flex;
	justify-content:space-between;
	font-weight: bold;
}
label>p {
	display: inline-block;
}

.update {
	height: 40px;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
}
#updateBtn {
	background-color: #35404E;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.msg{
	color: red;
	font-size: 0.8em;
	display: none;
}

</style>
</head>
<body>
<div class="updateform">
<form id="updateForm"  action="" class="form" method="post">
	<h3 class="mb-5" style="text-align: center; font-size: 10px; font-weight:900; color: #706FFF;">회원정보변경</h3>
	<label for="id">
		<p>아이디</p>
		<input type="hidden" name="id" class="id" value="${loginHewon.id }">
		<div>${loginHewon.id }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	</label>
		<br>

	
	<label for="password">
		<p>비밀번호</p>	
		<input class="update" type="password" id="passwd" name="pw" placeholder="6~20자 영문자, 숫자, 특수문자 사용.">
	</label>
	<div class="mb-5">
		<span id="passwdNullMsg" class="msg">비밀번호를 입력해 주세요.</span>
		<span id="passwdValidMsg" class="msg">비밀번호는 영문자,숫자,특수문자가 반드시 하나이상 포함된 6~20 범위의 문자로만 작성 가능합니다.</span>
	</div>	
	<label for="confirm-password">
		<p>비밀번호확인</p>	
		<input class="update" type="password" id="rePasswd" name="rePasswd" required>
	</label>
	<div class="mb-5">
		<span id="repasswdNullMsg" class="msg">비밀번호확인을 입력해 주세요.</span>
		<span id="repasswdMatchMsg" class="msg">비밀번호와 비밀번호확인이 서로 맞지 않습니다.</span>
	</div>	
	
	<label for="name">
		<p>이름</p>	
		<input class="update" type="text" id="name" name="name" placeholder="${loginHewon.name }">
	</label>
	<div class="mb-5">
		<span id="nameValidMsg" class="msg">이름을 형식에 맞게 입력해 주세요.</span>
	</div>
	
	<label for="email">
		<p>이메일</p>	
		<input class="update" type="email" id="email" name="email" placeholder="${loginHewon.email }">
	</label>
	<div class="mb-5">
		<span id="emailValidMsg" class="msg">이메일을 형식에 맞게 입력해 주세요.</span>
	</div>
		
	<label for="phone">
		<p>휴대폰 번호</p>	
		<input class="update" type="text" id="phone" name="phone" placeholder="${loginHewon.phone }">
	</label>
	<div class="mb-5">
		<span id="phoneValidMsg" class="msg">휴대폰 번호는 01로 시작하며, 3~4 자리의 숫자로만 입력 가능합니다.</span>	
	</div>
		
	<button type="submit" id="updateBtn">회원정보변경</button>
</form>
</div>

<script type="text/javascript">
	var submitResult;
	
	$("#updateBtn").submit(function() {
		
		submitResult=true;
		$(".msg").css("display","none");

		var idReg=/^[a-zA-Z0-9]{5,20}$/g;
		if(!idReg.test($("#id").val())) {//입력값이 형식에 맞지 않는 경우
			$("#idValidMsg").css("display","block");
			submitResult=false;
		}
			
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if($("#passwd").val()=="") {//입력값이 없는 경우
			$("#passwdNullMsg").css("display","block");
			submitResult=false;
		} else if(!passwdReg.test($("#passwd").val())) {//입력값이 형식에 맞지 않는 경우
			$("#passwdValidMsg").css("display","block");
			submitResult=false;
		} 
		
		if($("#rePasswd").val()=="") {//입력값이 없는 경우
			$("#repasswdNullMsg").css("display","block");
			submitResult=false;
		} else if($("#passwd").val()!=$("#rePasswd").val()) {//repasswd입력값과 passwd입력값이 다른 경우
			$("#repasswdMatchMsg").css("display","block");
			submitResult=false;
		}
		
		
		var nameReg=/^[가-힣]{2,10}$/g;
		if(!nameReg.test($("#name").val())) {//입력값이 형식에 맞지 않는 경우
			$("#nameValidMsg").css("display","block");
			submitResult=false;
		} 
		
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if(!emailReg.test($("#email").val())) {//입력값이 형식에 맞지 않는 경우
			$("#emailValidMsg").css("display","block");
			submitResult=false;
		}

		var phoneReg=/01[016789]-[0-9]{3,4}-[0-9]{3,4}/;
		if(!phoneReg.test($("#phone").val())) {//입력값이 형식에 맞지 않는 경우
			$("#phoneValidMsg").css("display","block");
			submitResult=false;
		}		
		
		return submitResult;
		
	});
	
</script>
</body>
</html> 
    