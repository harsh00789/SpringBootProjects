package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

@Controller
public class HomeController {
	
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	private UserRepository urepo;
	
	@GetMapping("/home")
	
	public String home(Model model) {
		
		model.addAttribute("title","smartcontactmanager");
	
		return "home";
		
	}
	
	@GetMapping("/about")
	public String about() {
		
		
		return "about";
		
	}
	
	@GetMapping("/signup")
	public String Signup() {
		
		
		return "signup";
		
	}
	
	@RequestMapping(value="/do_register",method = RequestMethod.POST )
	public String registered(@ModelAttribute("user") User user , Model model) {
		
		   
		user.setRole("normal");
		user.setEnabled(true);
        User result = urepo.save(user);
		
        
        
		System.out.println(result);
		
		model.addAttribute("user",user);
		
		return "signup";
	}

}
