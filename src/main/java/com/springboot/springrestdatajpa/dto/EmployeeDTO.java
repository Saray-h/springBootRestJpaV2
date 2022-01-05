package com.springboot.springrestdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class EmployeeDTO {

	private Long id;
	private String name;
	private Integer salary;
	private String departement;

}
