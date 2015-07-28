package com.techconquerors.slippers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	@RequestMapping(value="/service/employees/list")
	public String listEmployees(Model model){
		return "employeesList";
	}
	
	@RequestMapping(value="/service/employees/new")
	public String newEmployee(Model model){
		return "newEmployee";
	}
	
}
