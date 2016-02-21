package br.com.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "role")
public class Role {

	@Id
	/*
	 * @GeneratedValue(strategy = GenerationType.TABLE, generator = "ROLE_GEN")
	 * 
	 * @TableGenerator(name = "ROLE_GEN", pkColumnName = "GEN_NAME",
	 * valueColumnName = "GEN_VALUE", table = "ID_GEN", allocationSize = 2)
	 */
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_GEN")
	@SequenceGenerator(name = "ROLE_GEN", sequenceName = "role_sequence", initialValue = 1, allocationSize = 10)
	private int id;

	@Column(nullable = false, length = 40)
	private String name;

	/*@OneToMany(mappedBy = "role")*/
	@OneToMany
	private List<Employee> employees;

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}
}
