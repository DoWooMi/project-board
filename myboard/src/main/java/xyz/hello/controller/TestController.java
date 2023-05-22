package xyz.hello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	
	//회원 메인 페이지 요청 처리 메소드
	@RequestMapping(value = "/hi")
	public String home() {
		return "main/test";
	}
	
}