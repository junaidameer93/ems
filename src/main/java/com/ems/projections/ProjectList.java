package com.ems.projections;

import java.util.Date;

public interface ProjectList {

	Integer getId();

	String getName();

	Date getStartDate();

	EManager getManager();

	interface EManager {
		String getFirstName();

		String getLastName();
	}
}
