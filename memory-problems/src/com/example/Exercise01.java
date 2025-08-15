package com.example;

import java.util.ArrayList;
import java.util.Objects;

public class Exercise01 {

	public static void main(String[] args) {
		var employees = new ArrayList<Employee>();
		employees.add(new Employee("1", "jack bauer", 100_000, "tr1"));
		employees.add(new Employee("2", "kateausten", 500_000, "tr2"));
		employees.add(new Employee("3", "james sawyer", 300_000, "tr3"));
		employees.add(new Employee("4", "ben linus", 400_000, "tr4"));
        System.out.println(employees.contains(new Employee("4", "ben linus", 400_000, "tr4")));
        System.out.println(employees.size());
        employees.remove(new Employee("3", "james sawyer", 300_000, "tr3"));
        System.out.println(employees.size());
	}

}

class Employee {
	private String identity;
	private String fullName;
	private double salary;
	private String iban;

	public Employee(String identity, String fullName, double salary, String iban) {
		this.identity = identity;
		this.fullName = fullName;
		this.salary = salary;
		this.iban = iban;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}


	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(identity, other.identity);
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", fullName=" + fullName + ", salary=" + salary + ", iban=" + iban
				+ "]";
	}

}