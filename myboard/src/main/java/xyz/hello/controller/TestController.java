package xyz.hello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	
	//ȸ�� ���� ������ ��û ó�� �޼ҵ�
	@RequestMapping(value = "/hi")
	public String home() {
		return "main/test";
	}
	
}