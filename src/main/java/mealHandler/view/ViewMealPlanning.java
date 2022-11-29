package mealHandler.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ViewMealPlanning implements Menu {

	private final HashMap<String, Integer> data;
	private final String userName;
	final String line = "======================================================";

	public ViewMealPlanning(HashMap<String, Integer> data, String userName) {
		this.data = data;
		this.userName = userName;
	}

	public HashMap<String, ArrayList<String>> getMenu() {

		HashMap<String, ArrayList<String>> response = new HashMap<>();
		System.out.println(this.line);
		System.out.println(this.userName + "\t MealHandling");
		System.out.println(this.line);
		System.out.println("Meal_Type"+"\t Numbers");
		
		this.data.forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});
		System.out.println("0. Back to Menu");
		Scanner userOption = new Scanner(System.in);
		System.out.print("Enter your option: ");
		int option = userOption.nextInt();
		System.out.println(this.line);
		response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));
		return response;

	}

}
