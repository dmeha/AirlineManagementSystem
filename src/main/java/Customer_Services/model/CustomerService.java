package Customer_Services.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class CustomerService extends DAO {

	public String userName;
	public int option;
	private Connection connection;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public CustomerService(String userName, int option) {
		super();
		this.userName = userName;
		this.option = option;
		this.connection = getConnection();

	}

	public HashMap<String, String> getCustomerService() {
		HashMap<String, String> data = new HashMap<>();
		try {
			String sqlStatement = "SELECT Ticket_ID, Customer_Query FROM Customer_Service";
			// this.connection = getConnection();
			this.preparedStatement = this.connection.prepareStatement(sqlStatement);

			this.resultSet = this.preparedStatement.executeQuery();
			while (this.resultSet.next())

				data.put(String.valueOf(this.resultSet.getString("Ticket_ID")),
						this.resultSet.getString("Customer_Query"));
		} catch (Exception e) {

			System.out.println("Exception found:" + e);
		}

		return data;
	}
}
