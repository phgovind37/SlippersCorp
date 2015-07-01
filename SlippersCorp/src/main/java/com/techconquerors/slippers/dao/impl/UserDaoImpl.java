package com.techconquerors.slippers.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techconquerors.slippers.dao.interfaces.UserDao;
import com.techconquerors.slippers.jpa.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public User getUserByUserName(String userName) throws HibernateException{
		try{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where userName = :uname");
		query.setParameter("uname", userName);
		return (User) query.uniqueResult();
		
		} catch(HibernateException he){
			throw new HibernateException(he);
		}
	}
	@Override
	@Transactional
	public List<User> getAllUsers() {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		return criteria.list();
	}

}
