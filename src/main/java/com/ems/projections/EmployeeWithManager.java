package com.ems.projections;

public interface EmployeeWithManager {

	String getFirstName();

	String getLastName();

	EManager getManager();

	interface EManager {
		String getFirstName();

		String getLastName();
	}
}
