package xyz.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//ȸ�� ���� ������ ��û ó�� �޼ҵ�
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
}
