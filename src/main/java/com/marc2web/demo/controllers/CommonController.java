package com.marc2web.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	
	@GetMapping(value="/domain/{domain}")
	 public String test(@PathVariable("domain")String domain) {
		 return "my website link \""+domain+"\" please click";
	 }

}
