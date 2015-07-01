package com.techconquerors.slippers.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techconquerors.slippers.dao.interfaces.ProductCategoriesDao;
import com.techconquerors.slippers.jpa.ProductCategories;
@Repository
public class ProductCategoriesDaoImpl implements ProductCategoriesDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public ProductCategories save(ProductCategories categories) {
		Session session = factory.getCurrentSession();
		return (ProductCategories) session.save(categories);
	}

	@Override
	@Transactional
	public ProductCategories getById(Long id) {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductCategories.class);
		criteria.add(Restrictions.eq("id", id));
		return (ProductCategories) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ProductCategories> getAllCategories() {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductCategories.class);
		return criteria.list();
	}

}
