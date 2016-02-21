package br.com.jpa.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import br.com.jpa.model.Departament;
import br.com.jpa.model.Employee;
import br.com.jpa.model.Role;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmployeeService {

	@PersistenceContext(name = "EmployeeService")
	private EntityManager em;

	@Resource(lookup = "java:jboss/datasources/employee")
	private DataSource dataSource;

	public EmployeeService() {
	}

	public Role createRole(String name) {
		Role role = new Role(name);
		em.persist(role);
		return role;
	}
	
	public Employee createEmployee(int id, String name, long salary) {
		Departament departament = new Departament();
		departament.setName("IT");
		Employee emp = new Employee();
		emp.setName(name);
		emp.setWage(salary);
		emp.setDepartament(departament);
		
		departament.getStaff().add(emp);
		em.persist(emp);

		try {
			Connection connection = dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Deu ruim: " + e.getMessage());
		}
		return emp;
	}

	public void removeEmployee(int id) {
		Employee emp = findEmployee(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public Employee raiseEmployeeSalary(int id, long raise) {
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			emp.setWage(emp.getWage() + raise);
		}
		return emp;
	}

	public Employee findEmployee(int id) {
		return em.find(Employee.class, id);
	}

	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e",
				Employee.class);
		return query.getResultList();
	}

}
