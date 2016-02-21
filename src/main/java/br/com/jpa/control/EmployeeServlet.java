package br.com.jpa.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jpa.service.EmployeeService;

@WebServlet(urlPatterns = { "/employee" })
public class EmployeeServlet extends HttpServlet {

	@EJB
	private EmployeeService bean;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);

		String[] names = new String[] { "Thiago", "Erick", "Sako" };
		String[] role = new String[] { "Medico", "Engenheiro", "Padeiro", "Pedreiro", "Coordenador" };

		bean.createEmployee((int) (15 * Math.random()),names[(int) (3 * Math.random())], (int) (50000 * Math.random()));
		bean.createRole(role[(int) (5 * Math.random())]);

	}

}
