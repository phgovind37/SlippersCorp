package com.techconquerors.slippers.dao.interfaces;

import java.util.List;

import com.techconquerors.slippers.jpa.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public int deleteById(final Long employeeId);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(final Long employeeId);
	public Employee getEmployeeByUserId(final Long userId);
}
