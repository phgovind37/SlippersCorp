package com.techconquerors.slippers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandlerController {

	@RequestMapping(value="/sessionExpired")
	public String expiredSession(Model model){
		return "error/sessionTimeOut";
	}
	@RequestMapping(value = "/accessDenied")
	public String accessDeniedHandler() {
		return "error/accessDenied";
	}

	@RequestMapping(value = "/pageNotFound")
	public String pageNotFoundHandler() {
		return "error/pageNotFound";
	}

	@RequestMapping(value = "/error")
	public String ErrorHandler() {
		return "error/error";
	}
	
}
