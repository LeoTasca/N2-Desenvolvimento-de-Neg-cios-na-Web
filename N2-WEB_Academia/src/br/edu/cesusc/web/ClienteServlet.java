package br.edu.cesusc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.cesusc.dao.ClienteDAO;
import br.edu.cesusc.model.Cliente;

@WebServlet("/")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO clienteDAO;
	
	public ClienteServlet() {
		super();
	}

	public void init() {
		clienteDAO = new ClienteDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				newForm(request, response);
				break;
			case "/insert":
				insertCliente(request, response);
				break;
			case "/delete":
				deleteCliente(request, response);
				break;
			case "/update":
				updateCliente(request, response);
				break;
			case "/edit":
				editForm(request, response);
				break;
			default:
				listCliente(request, response);
				break;
			}
		} catch (Exception exception) {
			throw new ServletException(exception);

		}
	}

	private void listCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Cliente> listCliente = clienteDAO.selectAllclientes();
		request.setAttribute("listCliente", listCliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-list.jsp");
		dispatcher.forward(request, response);
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cliente foundCliente = clienteDAO.selectCliente(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		request.setAttribute("cliente", foundCliente);
		dispatcher.forward(request, response);
	}

	private void updateCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String nome = request.getParameter("nome");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String modalidade = request.getParameter("modalidade");
		String descricao = request.getParameter("descricao");
		
		Cliente cliente = new Cliente(id, matricula, nome, bairro, cidade, cep, estado, logradouro, numero, modalidade, descricao);
		clienteDAO.updateCliente(cliente);
		response.sendRedirect("list");
	}

	private void deleteCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		clienteDAO.deleteCliente(id);
		response.sendRedirect("list");
	}

	private void insertCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String nome = request.getParameter("nome");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String modalidade = request.getParameter("modalidade");
		String descricao = request.getParameter("descricao");

		Cliente cliente = new Cliente(matricula, nome, bairro, cidade, cep, estado, logradouro, numero, modalidade, descricao);
		clienteDAO.insertCliente(cliente);
		response.sendRedirect("list");
	}

	private void newForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
