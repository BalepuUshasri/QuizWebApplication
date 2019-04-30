package com.quizwebapplication.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.quizwebapplication.bean.User;
import com.quizwebapplication.service.UserService;

@RestController
public class UserController {

	String userName = "";

	@Autowired
	private UserService userservice;

	@Autowired
	private HttpSession httpsession;

	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("userLogin");
	}

	@PostMapping("/uservalidation")
	public User uservalidation(@RequestBody User user) {
		User getUser = userservice.submitUserForm(user);
		userName = getUser.getUserName();
		httpsession.setAttribute("userName", userName);
		return getUser;
	}

	@GetMapping("/homepage")
	public ModelAndView homepage() {
		return new ModelAndView("welcomepage", "userName", userName);
	}

	@GetMapping("/userRegister")
	public ModelAndView userRegister() {
		return new ModelAndView("userRegister");
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		httpsession.invalidate();
		return new ModelAndView("userLogin");
	}

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		userservice.saveNewUser(user);
		return "";
	}

}
