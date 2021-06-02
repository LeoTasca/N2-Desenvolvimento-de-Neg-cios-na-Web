package br.edu.cesusc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.cesusc.model.Cliente;

public class ClienteDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/academia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	private String jdbcUsername = "root";

	private String jdbcPassword = "zxasqw12";

	private static final String INSERT_CLIENTE_SQL = "INSERT INTO clientes (matricula, nome, bairro, cidade, cep, estado, logradouro, numero, modalidade, descricao) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_CLIENTE_BY_ID = "SELECT * FROM clientes WHERE id = ?;";
	private static final String SELECT_ALL_CLIENTES_SQL = "SELECT * FROM clientes;";
	private static final String DELETE_CLIENTE_SQL = "DELETE FROM clientes WHERE id = ?;";
	private static final String UPDATE_CLIENTE_SQL = "UPDATE clientes SET matricula = ?, nome = ?, bairro = ?, cidade = ?, cep = ?, estado = ?,  logradouro = ?, numero = ?, modalidade = ?,  descricao = ? WHERE id = ?;";

	public ClienteDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertCliente(Cliente cliente) throws SQLException {
		System.out.println(INSERT_CLIENTE_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENTE_SQL)) {
			preparedStatement.setInt(1, cliente.getMatricula());
			preparedStatement.setString(2, cliente.getNome());
			preparedStatement.setString(3, cliente.getBairro());
			preparedStatement.setString(4, cliente.getCidade());
			preparedStatement.setString(5, cliente.getCep());
			preparedStatement.setString(6, cliente.getEstado());
			preparedStatement.setString(7, cliente.getLogradouro());
			preparedStatement.setString(8, cliente.getNumero());
			preparedStatement.setString(9, cliente.getModalidade());
			preparedStatement.setString(10, cliente.getDescricao());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Cliente selectCliente(int id) {
		Cliente cliente = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENTE_BY_ID)) {
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int matricula = rs.getInt("matricula");
				String nome = rs.getString("nome");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String cep = rs.getString("cep");
				String estado = rs.getString("estado");
				String logradouro = rs.getString("logradouro");
				String numero = rs.getString("numero");
				String modalidade = rs.getString("modalidade");
				String descricao = rs.getString("descricao");
				
				cliente = new Cliente(id, matricula, nome, bairro, cidade, cep, estado, logradouro, numero, modalidade, descricao);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return cliente;
	}

	public List<Cliente> selectAllclientes() {
		List<Cliente> clientes = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTES_SQL)) {
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int matricula = rs.getInt("matricula");				
				String nome = rs.getString("nome");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String cep = rs.getString("cep");
				String estado = rs.getString("estado");
				String logradouro = rs.getString("logradouro");
				String numero = rs.getString("numero");
				String modalidade = rs.getString("modalidade");
				String descricao = rs.getString("descricao");
				
				clientes.add(new Cliente(id, matricula, nome, bairro, cidade, cep, estado, logradouro, numero, modalidade, descricao));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return clientes;
	}

	public boolean deleteCliente(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENTE_SQL)) {
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateCliente(Cliente cliente) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENTE_SQL)) {
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, cliente.getId());
			preparedStatement.setInt(2, cliente.getMatricula());
			preparedStatement.setString(3, cliente.getNome());
			preparedStatement.setString(4, cliente.getBairro());
			preparedStatement.setString(5, cliente.getCidade());
			preparedStatement.setString(6, cliente.getCep());
			preparedStatement.setString(7, cliente.getEstado());
			preparedStatement.setString(8, cliente.getLogradouro());
			preparedStatement.setString(9, cliente.getNumero());
			preparedStatement.setString(10, cliente.getModalidade());
			preparedStatement.setString(11, cliente.getDescricao());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException exception) {
		for (Throwable e : exception) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("Código do erro: " + ((SQLException) e).getErrorCode());
				System.err.println("Mensagem: " + e.getMessage());
			}
		}

	}
}
