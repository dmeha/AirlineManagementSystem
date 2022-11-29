package mealHandler.controller;

import mealHandler.model.*;
import mealHandler.view.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MealPlanningController implements Controller {

	private String userName;
	public HashMap<String, Integer> data;
	ArrayList<String> formResponse;

	public MealPlanningController(String userName) {
		this.userName = userName;
	}

	@Override
	public void controller() {

		MealPlanning planning = new MealPlanning(userName, 1);
		this.data = planning.getMealPlanning();
		Menu meal_details = new ViewMealPlanning(data, userName);
		HashMap<String, ArrayList<String>> userResp = meal_details.getMenu();
		String option = userResp.get("option").get(0);
		this.getSubMenu(Integer.parseInt(option));

	}

	@Override
	public void getSubMenu(int option) {

		if (option == 0)

		{
			MealPlanningController mpc = new MealPlanningController(userName);
			mpc.controller();

		} else {
			// do nothing
		}

	}

}
