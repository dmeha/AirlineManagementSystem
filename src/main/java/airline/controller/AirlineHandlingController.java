package airline.controller;

import java.util.ArrayList;
import java.util.HashMap;

import airline.model.AirlineModel;
import airline.view.Menu;
import airline.view.ViewAirlineDetails;
import airline.view.Menu;

public class AirlineHandlingController implements Controller {

	private String userName;
	public HashMap<String, String> data;
	ArrayList<String> formResponse;

	public AirlineHandlingController(String userName) {
		this.userName = userName;
	}

	@Override
	public void controller() {

		System.out.println("AirlineControl");

		
		AirlineModel ad=new AirlineModel (userName, 1);
		this.data=ad.getAirlineDetails();
		Menu editProfile = new ViewAirlineDetails(this.data, this.userName);
		HashMap<String, ArrayList<String>> userResp = editProfile.getMenu();
		this.formResponse = userResp.get("formData");
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
