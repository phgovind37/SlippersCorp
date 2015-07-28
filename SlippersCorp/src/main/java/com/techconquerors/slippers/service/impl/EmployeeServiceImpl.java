package com.techconquerors.slippers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techconquerors.slippers.dao.interfaces.EmployeeDao;
import com.techconquerors.slippers.jpa.Employee;
import com.techconquerors.slippers.jpa.User;
import com.techconquerors.slippers.service.interfaces.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	@Transactional
	public int deleteById(Long employeeId) {
		return employeeDao.deleteById(employeeId);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(Long employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public Employee getEmployeeByUserId(Long userId) {
		Employee emp = new Employee();
		final Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		User user = auth != null && auth.getPrincipal() instanceof User ? (User) auth
				.getPrincipal() : null;
				if(user != null && user.getId() != null){
					emp = employeeDao.getEmployeeByUserId(user.getId());
				}
		return emp;
	}

}
