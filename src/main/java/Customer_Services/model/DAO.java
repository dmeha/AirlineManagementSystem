package Customer_Services.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class DAO {

	String url;
	String user;
	String password;
	Connection connection;
	//constructor to establishing connection
	public DAO() {
		this.url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_TEST";
		this.user = "CSCI5308_12_TEST_USER";
		this.password = "EJaiqueigahNg6cu";

	}
	

	public Connection getConnection() {
		try {

			this.connection = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.connection;
	}

	public void closeConnection() {
		try {
			this.connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}