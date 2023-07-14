package com.EMPLOYEE.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMPLOYEE.Entity.EmployeeEntity;
import com.EMPLOYEE.Repository.EmployeeRepository;
import com.EMPLOYEE.model.Employee;
import com.EMPLOYEE.model.TaxDeductionResponse;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	private double yearlySalary;

	public Employee storeEmployeeDetails(Employee employee) {
		EmployeeEntity employeesaved;
		Employee EmployeeDataReturn = new Employee();
		// Implement the logic to store employee details
		EmployeeEntity entity = new EmployeeEntity();
		entity.setFirstName(employee.getFirstName());
		entity.setLastName(employee.getLastName());
		entity.setEmployeeId(employee.getEmployeeId());
		entity.setDoj(employee.getDoj());
		entity.setEmail(employee.getEmail());
		entity.setPhoneNumbers(employee.getPhoneNumbers());
		entity.setSalary(employee.getSalary());

		employeesaved = employeeRepository.save(entity);

		BeanUtils.copyProperties(employeesaved, EmployeeDataReturn);
		return EmployeeDataReturn;

	}

	// Other methods for employee-related operations can be defined here
	public TaxDeductionResponse employeeTaxDeductions(String id) {
		EmployeeEntity employee = new EmployeeEntity();
		Optional<EmployeeEntity> findById = employeeRepository.findById(id);
		if (findById != null) {
			employee = findById.get();
		}
		// Implement the logic to calculate tax deductions
		double yearlySalary = calculateYearlySalary(employee); // Implement your logic here
		double taxAmount = calculateTaxAmount(employee.getSalary()); // Implement your logic here
		double cessAmount = calculateCessAmount(employee.getSalary()); // Implement your logic here

		TaxDeductionResponse response = new TaxDeductionResponse();
		response.setEmployeeCode(employee.getEmployeeId());
		response.setFirstName(employee.getFirstName());
		response.setLastName(employee.getLastName());
		response.setYearlySalary(yearlySalary);
		response.setTaxAmount(taxAmount);
		response.setCessAmount(cessAmount);

		return response;
	}

	private double calculateCessAmount(double yearlySalary) {
		if (yearlySalary > 2500000) {
			double cessableAmount = yearlySalary - 2500000;
			return cessableAmount * 0.02;
		}
		return 0;
	}

	private double calculateTaxAmount(double yearlySalary) {
		if (yearlySalary <= 250000) {
			return 0;
		} else if (yearlySalary <= 500000) {
			return (yearlySalary - 250000) * 0.05;
		} else if (yearlySalary <= 1000000) {
			double taxAmount = (500000 - 250000) * 0.05;
			taxAmount += (yearlySalary - 500000) * 0.1;
			return taxAmount;
		} else {
			double taxAmount = (500000 - 250000) * 0.05;
			taxAmount += (1000000 - 500000) * 0.1;
			taxAmount += (yearlySalary - 1000000) * 0.2;

			return taxAmount;
		}
	}

	private double calculateYearlySalary(EmployeeEntity employee) {
		// Calculate the number of months the employee worked in the current financial
		// year
		LocalDate startOfFinancialYear = LocalDate.of(employee.getDoj().getYear(), Month.APRIL, 1);
		LocalDate endOfFinancialYear = LocalDate.of(employee.getDoj().getYear() + 1, Month.MARCH, 31);
		long numberOfMonths = ChronoUnit.MONTHS.between(startOfFinancialYear, endOfFinancialYear);

		// Calculate the total salary based on the number of months worked
		return yearlySalary = employee.getSalary() * numberOfMonths;
	}
}
