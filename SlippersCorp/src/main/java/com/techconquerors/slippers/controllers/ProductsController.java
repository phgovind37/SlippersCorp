package com.techconquerors.slippers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techconquerors.slippers.jpa.ProductCategories;
import com.techconquerors.slippers.service.interfaces.ProductsService;

@Controller
public class ProductsController {

	@Autowired
	private ProductsService productService;
	
	@RequestMapping(value="/service/products/category/list", method=RequestMethod.GET)
	public String listCategory(Model model){
		List<ProductCategories> categories = productService.getAllCategories();
		model.addAttribute("productCategories",categories);
		return "viewCategory";
	}
	
	@RequestMapping(value="/service/products/category/add", method=RequestMethod.POST)
	public String saveCategory(Model model,@ModelAttribute("productCategory") ProductCategories productCategories){
		productService.addCategory(productCategories);
		return "listcategories";
	}
	
	@RequestMapping(value="/service/products/category/get/{id}", method=RequestMethod.POST)
	public String getCategory(Model model,@PathVariable("id") Long id){
		model.addAttribute("productCategory",productService.getCategoryById(id));
		return "viewCategory";
	}
	
	
}
