package com.techconquerors.slippers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techconquerors.slippers.dao.interfaces.ProductCategoriesDao;
import com.techconquerors.slippers.jpa.ProductCategories;
import com.techconquerors.slippers.service.interfaces.ProductsService;
@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductCategoriesDao categoriesDao;
	
	// the following two constructors are for unit testing
	public ProductsServiceImpl(){
	}
	
	public ProductsServiceImpl(ProductCategoriesDao pCategoriesDao){
		categoriesDao = pCategoriesDao;
	}

	@Override
	public ProductCategories addCategory(ProductCategories category) {
		return categoriesDao.save(category);
	}

	@Override
	public ProductCategories getCategoryById(Long id) {
		return categoriesDao.getById(id);
	}

	@Override
	public List<ProductCategories> getAllCategories() {
		return categoriesDao.getAllCategories();
	}

}
