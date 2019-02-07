package com.springboot.springrestdatajpa.dto;

import java.util.Optional;

import com.springboot.springrestdatajpa.entity.Employee;

public class ApiDTOBuilder {

	private ApiDTOBuilder() {
	    throw new IllegalStateException("ApiDTOBuilder");
	  }

	public static EmployeeDTO employeeToEmployeeDTO(Employee employee) {
		return new EmployeeDTO(employee.getId(),employee.getName(),employee.getSalary(),employee.getDepartement());
	}
	
	public static Employee employeeDTOToEmployee(EmployeeDTO employee) {
		return new Employee(employee.getId(),employee.getName(),employee.getSalary(),employee.getDepartement());
	}

	public static EmployeeDTO employeeToEmployeeDTO(Optional<Employee> employee) {
		if (employee.isPresent()) {
			
			return new EmployeeDTO(employee.get().getId(),employee.get().getName(),employee.get().getSalary(),employee.get().getDepartement());

		} else {
			return null;
		}
	}
}
