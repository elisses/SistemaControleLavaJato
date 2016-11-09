package br.com.loja.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.modelo.Cliente;

public class VeiculoDAO implements MysqlDAO<Cliente> {
	private Connection connection;

	@Override
	public Long insert(Cliente cliente) throws SQLException {
		String sql = "insert into veiculo "+"(id,tipo,modelo,placa)" + "values(?????)";
		return null;
	}

	@Override
	public int update(Cliente object) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int select(Cliente object) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Cliente object) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cliente> getLista() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
