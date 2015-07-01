package com.techconquerors.slippers.service.interfaces;

import java.util.List;

import com.techconquerors.slippers.jpa.ProductCategories;


public interface ProductsService {
	public List<ProductCategories> getAllCategories();
	public ProductCategories addCategory(ProductCategories category);
	public ProductCategories getCategoryById(final Long id);
	
}
