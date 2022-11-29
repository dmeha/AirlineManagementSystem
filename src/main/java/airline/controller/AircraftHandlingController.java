package airline.controller;

import java.util.ArrayList;
import java.util.HashMap;

import airline.model.AircraftModel;
import airline.view.Menu;
import airline.view.ViewAircraftDetails;

public class AircraftHandlingController implements Controller {

	private String userName;
	public HashMap<String, String> data;


	public AircraftHandlingController(String userName) {
		this.userName = userName;
	}

	@Override
	public void controller() {

		AircraftModel details = new AircraftModel(userName, 1);
		this.data = details.getAircraftDetails();
		Menu ac_details = new ViewAircraftDetails(data, userName);
		HashMap<String, ArrayList<String>> userResp = ac_details.getMenu();
		String option = userResp.get("option").get(0);
		this.getSubMenu(Integer.parseInt(option));

	}

	@Override
	public void getSubMenu(int option) {
		
		if (option == 0) {
			AircraftHandlingController ahc=new AircraftHandlingController(userName);
			ahc.controller();

		} else {
			AirlineHandlingController ahc=new AirlineHandlingController(userName);
			ahc.controller();


		}

	}

}

