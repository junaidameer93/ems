package com.ems.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "technology", catalog = "ems")
public class Technology implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Set<Emptechnology> emptechnologies = new HashSet<Emptechnology>(0);
	private Set<Task> tasks = new HashSet<Task>(0);

	public Technology() {
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

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "technology")
	public Set<Emptechnology> getEmptechnologies() {
		return this.emptechnologies;
	}

	public void setEmptechnologies(Set<Emptechnology> emptechnologies) {
		this.emptechnologies = emptechnologies;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tasktechnology", catalog = "ems", joinColumns = {
			@JoinColumn(name = "techId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "taskId", nullable = false, updatable = false) })
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + "]";
	}

}
