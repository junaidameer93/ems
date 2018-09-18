package com.ems.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Team", catalog = "ems")
public class Team implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Employee teamLead;
	private Project project;
	private String teamName;
	private Date createdAt;
	private Date resolvedAt;
	private boolean status;
	private Set<TeamMember> teammembers = new HashSet<TeamMember>(0);

	public Team() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teamLeadId", nullable = false)
	public Employee getTeamLead() {
		return this.teamLead;
	}

	public void setTeamLead(Employee teamLead) {
		this.teamLead = teamLead;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "teamName", nullable = false, length = 100)
	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdAt", nullable = false, length = 10)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "resolvedAt", length = 10)
	public Date getResolvedAt() {
		return this.resolvedAt;
	}

	public void setResolvedAt(Date resolvedAt) {
		this.resolvedAt = resolvedAt;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	public Set<TeamMember> getTeammembers() {
		return this.teammembers;
	}

	public void setTeammembers(Set<TeamMember> teammembers) {
		this.teammembers = teammembers;
	}

}
