package mealHandler.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class MealPlanning extends DAO {

	private Connection connection;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public String userName;
	public int option;

	public MealPlanning(String userName, int option) {
		super();
		this.userName = userName;
		this.option = option;
		this.connection = getConnection();
	}

	public HashMap<String, Integer> getMealPlanning() {
		HashMap<String, Integer> data = new HashMap<>();

		String sqlStatement = "SELECT Type, Requested_Number FROM Meal_Type WHERE Type like \"%veg%\" ";
		try {
			// this.connection = getConnection();
			this.preparedStatement = this.connection.prepareStatement(sqlStatement);

			this.resultSet = this.preparedStatement.executeQuery();

			while (this.resultSet.next()) {

				int number = this.resultSet.getInt("Requested_Number");
				String type_of_meal = this.resultSet.getString("Type");
				data.put(type_of_meal, number);
				// data.put("Non-Vegetarian", number);
			}

		} catch (Exception e) {
			System.out.println("Exception found:" + e);
		}
		return data;
	}

}
