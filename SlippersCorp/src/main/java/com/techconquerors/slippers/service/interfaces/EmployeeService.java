package com.techconquerors.slippers.service.interfaces;

import java.util.List;

import com.techconquerors.slippers.jpa.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public int deleteById(final Long employeeId);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(final Long employeeId);
	public Employee getEmployeeByUserId(Long userId);
}
