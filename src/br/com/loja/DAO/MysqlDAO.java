package br.com.loja.DAO;
import java.util.List;

public interface MysqlDAO<T> {
	
	public void insert(T object);
	public int update(T object);
	public int select(T object);
	public int delete(T object);
	public List<T> getLista();
	
	 
}
