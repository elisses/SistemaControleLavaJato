package br.com.loja.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//fazendo a conex�o
	public Connection getConnection(){
		
		
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","root");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
