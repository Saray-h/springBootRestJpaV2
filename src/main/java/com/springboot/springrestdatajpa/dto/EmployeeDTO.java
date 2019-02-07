package com.springboot.springrestdatajpa.dto;

public class EmployeeDTO {

	private Long id;
	private String name;
	private Integer salary;
	private String departement;

	public EmployeeDTO(Long id, String name, Integer salary, String departement) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.departement = departement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

}
