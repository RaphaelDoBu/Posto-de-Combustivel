package com.projetoposto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
	
	@RequestMapping(method= RequestMethod.GET, path="/entrar")
	public String entrar(){
		return "entrar";
	}

}
