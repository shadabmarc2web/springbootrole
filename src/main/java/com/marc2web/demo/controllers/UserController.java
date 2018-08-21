package com.marc2web.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.marc2web.demo.model.User;

import com.marc2web.demo.service.UserSevice;



@Controller
public class UserController {

	@Autowired
	private UserSevice userService;
	
	@GetMapping(value={"/", "/login"})
	public ModelAndView login(){
		
		return new ModelAndView("/login");
		
		/*ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;*/
		

	}
	
	@GetMapping(value="/registration")
	public ModelAndView registration(){
		
		User user = new User();
		return new ModelAndView("registration","user",user);
		
	/*	ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;*/
		
	}
	
	@PostMapping(value = "/registration")
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			
		bindingResult.rejectValue("email", "error.user","There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@GetMapping(value="/admin/home")
	public ModelAndView home(){
		
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " with " + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	
	/*@Autowired
	private UserRepository userRepository;

	@GetMapping(value= {"/","/home"})
	public String home() {
		return "/home";
	}

	@GetMapping(value= "/register")
	public String registerPage() {

		return "/register";
	}

	@PostMapping(value= "/createuser")
	public String register(User user) {

		//System.out.println(user);
		userRepository.save(user);

		return "/register";
	}


	@GetMapping(value="/showuser")
	public ModelAndView ShowUser() 
	{

		Iterable<User> it=userRepository.findAll(); 
		return new ModelAndView("/showUsers","users",it);

	}
	
	@GetMapping(value= "/user")
	public String home1() {
		return "/user";
	}
	
	@GetMapping(value= "/loginp")
	public String login() {
		return "/login";
	}*/
}

