package com.gaurav.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.gaurav.entity.User;

public class AuthHandler implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//HttpSession session =request.getSession();
	User user=(User)request.getSession().getAttribute("userObj");
		
	if(user!=null)
	{
		return true;
	}
	else {
		PrintWriter out=response.getWriter();
		
		out.println("please login");
		
		//response.sendRedirect("login");

		return false;	
	}
}

}
