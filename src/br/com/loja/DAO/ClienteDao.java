package br.com.loja.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.loja.jdbc.ConnectionFactory;
import br.com.loja.modelo.Cliente;

public class ClienteDao implements MysqlDAO<Cliente> {

	private Connection connection;

	public ClienteDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void insert(Cliente cliente) {
		String sql = "insert into contato " + "(nome,telefone,endereco,data,cpf)" + " values (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEndereco());
			stmt.setDate(4, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, cliente.getCpf());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int update(Cliente cliente) {
		String sql = "update clientes set nome=?, email=?, endereco=?, dataNascimento=? where id=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// setando valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEndereco());
			stmt.setDate(4, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, cliente.getCpf());
			stmt.setLong(6, cliente.getId());
			stmt.execute();
			stmt.close();
			return 1;
		} catch (SQLException e) {
			System.out.println("Erro ao alterar");
			throw new RuntimeException(e);
		}
	}

	@Override
	public int select(Cliente cliente) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * from clientes where id=?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
			return 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int delete(Cliente cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from clientes where id=?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
			return 1;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Cliente> getLista() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando objeto contato
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));

				// montando a data através do calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				cliente.setDataNascimento(data);

				// adiciona o objeto à lista
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
