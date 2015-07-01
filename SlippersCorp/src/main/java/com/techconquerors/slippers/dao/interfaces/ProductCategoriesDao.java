package com.techconquerors.slippers.dao.interfaces;

import java.util.List;

import com.techconquerors.slippers.jpa.ProductCategories;

public interface ProductCategoriesDao {
	public ProductCategories save(ProductCategories categories);
	public ProductCategories getById(final Long id);
	public List<ProductCategories> getAllCategories();
}
