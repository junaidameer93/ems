package com.ems.projections;

import java.util.Date;
import java.util.Set;

public interface ProjectDetail {

	Integer getId();

	String getName();

	Date getStartDate();

	String getDescription();

	int getProposalCost();

	PManager getManager();

	Set<PTeam> getTeams();

	interface PManager {
		String getFirstName();

		String getLastName();
	}

	interface PTeam {
		Integer getId();

		String getTeamName();

		Date getCreatedAt();
	}
}
