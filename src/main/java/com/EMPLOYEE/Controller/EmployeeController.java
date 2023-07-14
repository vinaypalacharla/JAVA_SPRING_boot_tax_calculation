package com.EMPLOYEE.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.EMPLOYEE.Service.EmployeeService;
import com.EMPLOYEE.model.Employee;
import com.EMPLOYEE.model.TaxDeductionResponse;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public String homepage() {
		String msg = "welcome";
		return msg;
	}

	@RequestMapping(value = "/employeedetails", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Employee> storeEmployeeDetails(@Validated @RequestBody Employee employee) {
		Employee storeEmployeeDetails = employeeService.storeEmployeeDetails(employee);
		return new ResponseEntity<Employee>(storeEmployeeDetails, HttpStatus.CREATED);
	}

	// Other API endpoints for employee-related operations can be defined here
	@GetMapping("/tax-deductions/{id}")
	public ResponseEntity<TaxDeductionResponse> getTaxDeductions(@PathVariable String id) {
		// Implement the logic to calculate tax deductions
		TaxDeductionResponse employeeTaxDeductions = employeeService.employeeTaxDeductions(id);
		return new ResponseEntity<TaxDeductionResponse>(employeeTaxDeductions, HttpStatus.OK);
	}

}
