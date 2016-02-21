package br.com.jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "departament")
public class Departament {

	public Departament() {
		staff = new ArrayList<Employee>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEP_GEN")
	@SequenceGenerator(name = "DEP_GEN", sequenceName = "departament_sequence")
	private int id;

	private String name;

	/*@OneToMany(mappedBy = "departament")*/
	@OneToMany
	private List<Employee> staff;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getStaff() {
		return staff;
	}

	public void setStaff(List<Employee> staff) {
		this.staff = staff;
	}

}
