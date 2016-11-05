package br.com.loja.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.loja.jdbc.ConnectionFactory;
import br.com.loja.modelo.Cliente;

public class ClienteDao implements MysqlDAO<Cliente> {

	private Connection connection;

	

	@Override
	public Long insert(Cliente cliente) throws SQLException {
		String sql = "insert into contato " + "(nome,telefone,endereco,data,cpf)" + " values (?,?,?,?,?)";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			// prepared statement para inserção
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// seta os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEndereco());
			stmt.setDate(4, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, cliente.getCpf());

			// executa
			Long retorno = Long.valueOf(stmt.executeUpdate());
			
			if(retorno==0){
				throw new SQLException("Erro ao incluir usuário!");
			}
			
			rs = stmt.getGeneratedKeys();
			Long codigo = 0L;
			if(rs.next()){
				codigo = rs.getLong(1);
			}
			return codigo;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			connection.close();
			rs.close();
			
		}

	}

	@Override
	public int update(Cliente cliente) throws SQLException {
		String sql = "update contato set nome=?, telefone=?, endereco=?, data=?, cpf=? where id=?";

		PreparedStatement stmt = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			// prepared statement para inserção
			stmt = connection.prepareStatement(sql);

			// setando valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEndereco());
			stmt.setDate(4, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, cliente.getCpf());
			stmt.setLong(6, cliente.getId());
			stmt.execute();
			return 1;
		} catch (SQLException e) {
			System.out.println("Erro ao alterar");
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			connection.close();
		}
	}

	@Override
	public int select(Cliente cliente) throws SQLException {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * from cliente where id=?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
			return 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int delete(Cliente cliente) throws SQLException {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contato where id=?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
			return 1;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Cliente> getLista() throws SQLException{
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
