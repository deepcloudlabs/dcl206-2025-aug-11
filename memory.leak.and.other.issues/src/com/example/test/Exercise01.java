package com.example.test;

import java.util.HashSet;

public class Exercise01 {

	public static void main(String[] args) {
			var employees = new HashSet<Employee>();
			while (true) {
				employees.add(new Employee("1","Jack Bauer"));
				employees.remove(new Employee("1","Jack Bauer"));
			}
	}

}
/*
 *     struct CompareBy {
 *         bool operator()(const Employee& x,const Employee& y) const {
 *             return x.identity == y.identity;
 *         }
 *     }
 * 
 */
// set<Employee,CompareBy> employees;
class Employee extends Object {
	private String identity;
	private String fullName;

	public Employee(String identity, String fullName) {
		this.identity = identity;
		this.fullName = fullName;
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
	
}