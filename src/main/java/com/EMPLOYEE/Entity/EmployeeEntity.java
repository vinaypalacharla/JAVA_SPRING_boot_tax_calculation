package com.EMPLOYEE.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Entity
@Data
public class EmployeeEntity {
	@Id
	private String employeeId;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Email
	private String email;

	@ElementCollection
	private List<String> phoneNumbers;

	@NotNull
	private LocalDate doj;

	@Min(0)
	private double salary;

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumbers
	 */
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * @return the doj
	 */
	public LocalDate getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumbers=" + phoneNumbers + ", doj=" + doj + ", salary=" + salary + "]";
	}

}
