package com.springboot.springrestdatajpa.service;

import java.util.List;

import com.springboot.springrestdatajpa.dto.EmployeeDTO;

public interface EmployeeService {

	public List<EmployeeDTO> retrieveEmployees();
	public EmployeeDTO getEmployee(Long employeeId);
	public void saveEmployee(EmployeeDTO employee);
	public void updateEmployee(EmployeeDTO employee);
	public void deleteEmployee(Long employeeId);
}
