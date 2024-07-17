package com.gaurav.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaurav.dao.UserDao;
import com.gaurav.entity.User;
import com.mysql.cj.Session;

@Controller
public class HomeController {
     @Autowired
	private UserDao userDao;
	@RequestMapping(path="/home")
	public String Home()
	{
		return"home";
	}
	
	@RequestMapping(path="/register")
	public String Register()
	{
		return"register";
	}
	@RequestMapping(path="/login")
	public String login()
	{
		return "login";
	}
//	@RequestMapping("/addNotes")
//	public String addNotes()
//	{
//		return "add_notes";
//	}
//	
//	@RequestMapping("/viewNotes")
//	public String viewNotes()
//	{
//		return "view_notes";
//	}
//	
//	@RequestMapping("/editNotes")
//	public String editNotes()
//	{
//		return "edit_notes";
//	}
	@RequestMapping(path="/registerUser",method=RequestMethod.POST)
	public String registeruser(@ModelAttribute User user,HttpSession session,@RequestParam("email") String email,@RequestParam("password") String password)
	{
		System.out.println(user);

		
		User u=userDao.loginCheck(email,password);
		if(u==null)
		{
		userDao.saveUser(user);
		session.setAttribute("msg","Register Succesfully");
		return "redirect:/register";
	
		}
		else {
			session.setAttribute("msg","try other mail id");
			return "redirect:/register";
		}
	}
	@RequestMapping(path="/loginUser",method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session) {
		User user= userDao.login(email, password);
		
		if(user!=null)
		{
			System.out.println("User world");
			session.setAttribute("userObj",user);
		return "redirect:/home";
		}
		else {
		session.setAttribute("msg", "email and password invalid");
			return "redirect:/login";
		}
		}
	}

