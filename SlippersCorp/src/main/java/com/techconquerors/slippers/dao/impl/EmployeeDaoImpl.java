package com.techconquerors.slippers.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techconquerors.slippers.dao.interfaces.EmployeeDao;
import com.techconquerors.slippers.jpa.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private final String deleteById = "delete from Employee where id = :empid";
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
	}

	@Override
	@Transactional
	public int deleteById(Long employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(deleteById);
		query.setParameter("empId", employeeId);
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(Long employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", employeeId));
		criteria.setMaxResults(1);
		return (Employee) criteria.uniqueResult();
	}

	@Override
	@Transactional
	public Employee getEmployeeByUserId(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("user.id", userId));
		criteria.setMaxResults(1);
		return (Employee) criteria.uniqueResult();
	}

}
