package com.techconquerors.slippers.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "login";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String defaultHome(Locale locale, Model model) {
		return defaultLogin(model);
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultHome1(Locale locale, Model model) {
		return defaultLogin(model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String defaultLogin(Model model) {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String uname = auth.getName();
		if(uname.equalsIgnoreCase("jesus")){
			return "redirect:/admin/home";
		} else{
			return "redirect:/service/user/home";
		}
	}
	
	@RequestMapping("/admin/home")
    public String adminHome(Model model) {
		final Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		final String name = auth.getName(); // get logged in username
		logger.info("Welcome to the user : "+name);
		logger.warn("Warning.............");
        model.addAttribute("message", "Hi Admin  : " + name + ", Welcome to 'Spring Security Custom Login Form Example'");
        return "home";
    }
	@RequestMapping("/service/user/home")
    public String userHome(Model model) {
		final Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		final String name = auth.getName(); // get logged in username
        model.addAttribute("message", "Hi User  : " + name + ", Welcome to 'Spring Security Custom Login Form Example'");
        return "home";
    }
     
    @RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
    public String logoutPage() {
        return "logoutPage";
    }
     
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }
	
}
