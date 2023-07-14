package com.EMPLOYEE.model;

public class TaxDeductionResponse {

	String EmployeeCode;
	String FirstName;
	String LastName;
	double YearlySalary;
	double taxAmount;
	double CessAmount;

	/**
	 * @return the employeeCode
	 */
	public String getEmployeeCode() {
		return EmployeeCode;
	}

	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		EmployeeCode = employeeCode;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @return the yearlySalary
	 */
	public double getYearlySalary() {
		return YearlySalary;
	}

	/**
	 * @param yearlySalary the yearlySalary to set
	 */
	public void setYearlySalary(double yearlySalary) {
		YearlySalary = yearlySalary;
	}

	/**
	 * @return the taxAmount
	 */
	public double getTaxAmount() {
		return taxAmount;
	}

	/**
	 * @param taxAmount the taxAmount to set
	 */
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * @return the cessAmount
	 */
	public double getCessAmount() {
		return CessAmount;
	}

	/**
	 * @param cessAmount the cessAmount to set
	 */
	public void setCessAmount(double cessAmount) {
		CessAmount = cessAmount;
	}

	@Override
	public String toString() {
		return "TaxDeductionResponse [EmployeeCode=" + EmployeeCode + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", YearlySalary=" + YearlySalary + ", taxAmount=" + taxAmount + ", CessAmount="
				+ CessAmount + "]";
	}

}
