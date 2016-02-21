package br.com.jpa.model;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Basic
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "EMPL_GEN")
	@TableGenerator(name = "EMPL_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VALUE", table = "ID_GEN")
	private int id;

	@Column(nullable = false)
	private String name;

	@Transient
	private long salary;

	@Temporal(TemporalType.TIMESTAMP)
	private Date admission;

	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL)
	private Departament departament;

	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;

	public Employee() {
		admission = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = true)
	@Access(AccessType.PROPERTY)
	public long getWage() {
		return salary;
	}

	public void setWage(long salary) {
		this.salary = salary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
}
