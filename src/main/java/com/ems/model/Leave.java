package com.ems.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Leave", catalog = "ems")
public class Leave implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private int total;
	private Set<EmpLeave> empleaves = new HashSet<EmpLeave>(0);

	public Leave() {
	}

	public Leave(String name, int total) {
		this.name = name;
		this.total = total;
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

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "total", nullable = false)
	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "leave")
	public Set<EmpLeave> getEmpleaves() {
		return this.empleaves;
	}

	public void setEmpleaves(Set<EmpLeave> empleaves) {
		this.empleaves = empleaves;
	}

}
