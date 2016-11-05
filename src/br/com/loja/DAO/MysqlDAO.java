package br.com.loja.DAO;
import java.sql.SQLException;
import java.util.List;

public interface MysqlDAO<T> {
	
	public Long insert(T object) throws SQLException;
	public int update(T object) throws SQLException;
	public int select(T object) throws SQLException;
	public int delete(T object) throws SQLException;
	public List<T> getLista() throws SQLException;
	
	 
}
