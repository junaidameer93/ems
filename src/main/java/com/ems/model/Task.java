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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Task", catalog = "ems")
public class Task implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer id;
	private Globalstatus globalstatus;
	private Project project;
	private Sprint sprint;
	private Date startDateTime;
	private Date endDateTime;
	private String estimatedTime;
	private Set<Technology> technologies = new HashSet<Technology>(0);

	public Task() {
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
	@JoinColumn(name = "statusId", nullable = false)
	public Globalstatus getGlobalstatus() {
		return this.globalstatus;
	}

	public void setGlobalstatus(Globalstatus globalstatus) {
		this.globalstatus = globalstatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scrumId", nullable = false)
	public Sprint getSprint() {
		return this.sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDateTime", length = 19)
	public Date getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endDateTime", length = 19)
	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Column(name = "estimatedTime", nullable = false, length = 16777215)
	public String getEstimatedTime() {
		return this.estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tasktechnology", catalog = "ems", joinColumns = {
			@JoinColumn(name = "taskId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "techId", nullable = false, updatable = false) })
	public Set<Technology> getTechnologies() {
		return this.technologies;
	}

	public void setTechnologies(Set<Technology> technologies) {
		this.technologies = technologies;
	}

}
