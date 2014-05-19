package br.com.service.common;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Connection;

public class MyConnection {
	private DataSource dataSource;

	public MyConnection() {
		try {

			InitialContext context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/vaccine");

		} catch (NamingException ex) {
		}
	}
	
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = (Connection) dataSource.getConnection();
		} catch (SQLException ex) {
		}
		return conn;
	}
}