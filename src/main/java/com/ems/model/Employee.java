package com.ems.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Employee", catalog = "ems", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer empId;
	private Employee manager;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String mobileNo;
	private Date joinedDate;
	private Set<Emptechnology> empTechnologies = new HashSet<Emptechnology>(0);
	private Set<EmpLeave> empLeaves = new HashSet<EmpLeave>(0);
	private Set<EmpPost> empPosts = new HashSet<EmpPost>(0);
	private Set<Salary> salaries = new HashSet<Salary>(0);
	private Set<TeamMember> teams = new HashSet<TeamMember>(0);
	private Set<Team> teamsLead = new HashSet<Team>(0);
	private Set<Project> projects = new HashSet<Project>(0);
	private Set<Employee> subOrdinate = new HashSet<Employee>(0);

	public Employee() {
	}

	public Employee(String firstName, String lastName, String email, String mobileNo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	
	public Employee(String firstName, String lastName, String email, String mobileNo, Employee manager) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.manager = manager;
	}

	public Employee(String firstName, String lastName, String email, String password, String mobileNo,
			Date joinedDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.joinedDate = joinedDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "empId", unique = true, nullable = false)
	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@JsonIgnoreProperties({ "subOrdinate" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supervisorId")
	public Employee getManager() {
		return this.manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Column(name = "firstName", nullable = false, length = 50)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middleName", length = 50)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "lastName", nullable = false, length = 50)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mobileNo", nullable = false, length = 11)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "joinedDate", nullable = false, length = 10)
	public Date getJoinedDate() {
		return this.joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Emptechnology> getEmpTechnologies() {
		return this.empTechnologies;
	}

	public void setEmpTechnologies(Set<Emptechnology> empTechnologies) {
		this.empTechnologies = empTechnologies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<EmpLeave> getEmpLeaves() {
		return this.empLeaves;
	}

	public void setEmpLeaves(Set<EmpLeave> empLeaves) {
		this.empLeaves = empLeaves;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<EmpPost> getEmpposts() {
		return this.empPosts;
	}

	public void setEmpposts(Set<EmpPost> empPosts) {
		this.empPosts = empPosts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Salary> getSalaries() {
		return this.salaries;
	}

	public void setSalaries(Set<Salary> salaries) {
		this.salaries = salaries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<TeamMember> getTeams() {
		return this.teams;
	}

	public void setTeams(Set<TeamMember> teams) {
		this.teams = teams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teamLead")
	public Set<Team> getTeamsLead() {
		return this.teamsLead;
	}

	public void setTeamsLead(Set<Team> teamsLead) {
		this.teamsLead = teamsLead;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@JsonIgnoreProperties({ "manager" })
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
	public Set<Employee> getSubOrdinate() {
		return this.subOrdinate;
	}

	public void setSubOrdinate(Set<Employee> subOrdinate) {
		this.subOrdinate = subOrdinate;
	}

}
