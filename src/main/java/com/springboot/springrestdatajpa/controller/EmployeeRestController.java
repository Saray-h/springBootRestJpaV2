package com.springboot.springrestdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.springrestdatajpa.dto.EmployeeDTO;
import com.springboot.springrestdatajpa.service.EmployeeService;

@RestController
@RequestMapping("/api/1.0/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeServices;

	public void setEmployeeServices(EmployeeService employeeServices) {
		this.employeeServices = employeeServices;
	}

	@GetMapping(value = "", produces = "application/json")
	public ResponseEntity<List<EmployeeDTO>> getEmployees() {
		List<EmployeeDTO> employeeDTO = employeeServices.retrieveEmployees();
		return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
	}

	@GetMapping(value = "{employeeId}", produces = "application/json")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long employeeId) {
		EmployeeDTO employeeDTO = employeeServices.getEmployee(employeeId);
		return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
	}

	@PostMapping(value = "", produces = "application/json")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		try {
			employeeServices.saveEmployee(employeeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception p) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "{employeeId}", produces = "application/json")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO,
			@PathVariable(name = "employeeId") Long employeeId) {
		try {
			employeeServices.updateEmployee(employeeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception p) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "{employeeId}", produces = "application/json")
	public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		try {
			employeeServices.deleteEmployee(employeeId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception p) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
