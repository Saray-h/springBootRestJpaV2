package com.springboot.springrestdatajpa.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.springrestdatajpa.dto.ApiDTOBuilder;
import com.springboot.springrestdatajpa.dto.EmployeeDTO;
import com.springboot.springrestdatajpa.entity.Employee;
import com.springboot.springrestdatajpa.repository.EmployeeRepository;
import com.springboot.springrestdatajpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<EmployeeDTO> retrieveEmployees() {
		List<Employee> employeesEntity = employeeRepository.findAll();
		ArrayList<EmployeeDTO> employees = new ArrayList<>();
		Iterator<Employee> iterator = employeesEntity.iterator();

		while(iterator.hasNext()) {
			Employee employee = iterator.next();
			employees.add(ApiDTOBuilder.employeeToEmployeeDTO(employee));
		}
		return employees;
	}

	@Override
	public EmployeeDTO getEmployee(Long employeeId) {		
		Optional<Employee> employee = employeeRepository.findById(employeeId);	
		return ApiDTOBuilder.employeeToEmployeeDTO(employee);
	
	}
	

	@Override
	public void saveEmployee(EmployeeDTO employee) {
		employeeRepository.save(ApiDTOBuilder.employeeDTOToEmployee(employee));
	}

	@Override
	public void updateEmployee(EmployeeDTO employee) {
		employeeRepository.save(ApiDTOBuilder.employeeDTOToEmployee(employee));

	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);

	}

}
