package Customer_Services.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class EditCustomerService extends DAO {
	public String userName;
	public int option;
	private Connection connection;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public EditCustomerService(String userName, int option) {
		super();
		this.userName = userName;
		this.option = option;
		this.connection = getConnection();
	}

	public HashMap<String, String> getEditCustomerService() {
		HashMap<String, String> data = new HashMap<>();
		try {
			String sqlStatement = "SELECT Ticket_ID, Add_Response FROM Customer_Service";
			// this.connection = getConnection();
			this.preparedStatement = this.connection.prepareStatement(sqlStatement);

			this.resultSet = this.preparedStatement.executeQuery();
			while (this.resultSet.next())

				data.put(String.valueOf(this.resultSet.getString("Ticket_ID")),
						this.resultSet.getString("Add_Response"));
		} catch (Exception e) {

			System.out.println("Exception found:" + e);
		}

		return data;
	}
}
