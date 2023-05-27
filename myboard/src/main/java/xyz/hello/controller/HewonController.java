package xyz.hello.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import xyz.hello.dto.Hewon;
import xyz.hello.exception.LoginAuthFailException;
import xyz.hello.service.HewonService;

@Controller
@RequiredArgsConstructor
public class HewonController {

	private final HewonService hewonService;
	//private static final Logger logger = LoggerFactory.getLogger(HewonService.class);
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinform() {
		return "hewon/JoinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinform(@ModelAttribute Hewon hewon) {
		hewonService.addHewon(hewon);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginform() {
		return "hewon/LoginForm";
	}
	
	@RequestMapping(value = "/login", method =RequestMethod.POST )
	public String loginform(@ModelAttribute Hewon hewon, HttpSession session) throws LoginAuthFailException {
		Hewon authHewon = hewonService.loginAuth(hewon);
		session.setAttribute("loginHewon", authHewon);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpSession session, Model model) {
		Hewon hewoninfo= (Hewon)session.getAttribute("loginHewon");
		model.addAttribute("loginHewon", hewoninfo);
		return "hewon/mypage";
	}
	
	
	@ExceptionHandler(LoginAuthFailException.class)
	public String exceptionhandler(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("id", exception.getId());
		return "hewon/LoginForm";
	}
	

}
