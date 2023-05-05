package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class tietokanta {
	private static final String URL = "jdbc:sqlite:./snakedb.sqlite";
	
	public Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
}