package saleSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {
		String jdbcUrl = "jdbc:sqlite:sale.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		
		String sql = "create table user (firsname varchar(20), lastname varchar(20));";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
	}

}
