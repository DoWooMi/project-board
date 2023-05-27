package xyz.hello.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import xyz.hello.dto.Hewon;

public class HewonAuthInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		Hewon loginHewon=(Hewon)session.getAttribute("loginHewon");
		if(loginHewon==null) {
			response.sendRedirect("/controller/login");
			return false;
		}
		return true;
	}

}
