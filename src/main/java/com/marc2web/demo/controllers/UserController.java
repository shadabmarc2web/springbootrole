package com.marc2web.demo.controllers;

import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.RedirectView;

import com.marc2web.demo.dao.UserInfoDao;
import com.marc2web.demo.model.UserInfo;
import com.marc2web.demo.repository.UserRepository;
import com.marc2web.demo.validator.UserValidator;





@Controller


public class UserController implements WebMvcConfigurer{
	
	

	@Autowired
	private UserRepository userRepo;

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
@Autowired
private UserValidator userValidator;
	
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@GetMapping(value={"/","/home"})
	public String home(){

		return "/home";

	}

	@GetMapping(value = "/login")
	public String login(@RequestParam(value="error",required=false) String message,Model model) {
		if(message!=null && message.equals("true")) {
			model.addAttribute("message", "Please Enter Valid Credentials!");
		}
		
		return "/web/index";
	}
	
	@GetMapping(value = "/errorpage")
	public String error() {

		return "/accessdenied";
	}
	
	

	
	@GetMapping(value = "/logout")
	public String logout() {


	
		return "/userpage";
	}
	

	
	@GetMapping(value = "/success")
	public String userpage() {


	
		return "/userpage";
	}

	

	


	
    @GetMapping(value= "/register")
	public String getRegister(@RequestParam(value="error",required=false) String message,Model model) {

    	model.addAttribute("user", new UserInfo());
		return "register";
	}
 
	@PostMapping(value= "/register")
	public String register( @ModelAttribute("user") @Valid UserInfo user, Errors errors, Model model) {
    userValidator.validate(user, errors);
	     
		if (errors.hasErrors()) {
			
			return "/register";
		}
	
		userInfoDao.saveUser(user);
		model.addAttribute("message", "success registration");
		return "/register";
	}


	@GetMapping(value="/showuser")
	public ModelAndView showUser()
	{
		Iterable<UserInfo> it=userRepo.findAll(); 

		return new ModelAndView("/showUsers","users",it);
	}

	@GetMapping (value="delete/{user_id}/user")
	public RedirectView gotoDelete(@PathVariable ("user_id") int id)
	{

		try {
			userRepo.deleteById(id);
			return new RedirectView("/showuser");
		}catch (Exception e) {

			e.printStackTrace();

			return new RedirectView("/showuser");
		}
	}

	@GetMapping (value="update/{id}/user/request")
	public ModelAndView gotoUpdate(@PathVariable("id") Integer id)
	{
		try {
			UserInfo user=em.find(UserInfo.class,id);
		    
			return new ModelAndView("/update","user",user);

		   }	catch (Exception e){
			e.printStackTrace();
			return new ModelAndView("/update");
			
        	}     



	}
	@Transactional
	@PostMapping (value="/UpdateUser")
	public RedirectView updateUser(UserInfo user)
	{

		UserInfo user1=em.find(UserInfo.class, user.getUser_id());
		/*System.out.println(user.toString());
		System.out.println(user1.toString());*/
		
		if(user1.getUser_id()==user.getUser_id())
		{
			user1.setUsername(user.getUsername());
			user1.setEmail(user.getEmail());
			user1.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
			
		}

		em.persist(user1);
		return new RedirectView("/showuser");
		}
	
}

