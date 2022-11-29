package airline.model;

import java.util.HashMap;

public class AircraftModel {
	public String userName;
	public int option;

	public AircraftModel(String userName, int option) {
		this.userName = userName;
		this.option = option;
	}

	public HashMap<String, String> getAircraftDetails() {
		System.out.println("enter flight no here");
		HashMap<String, String> data = new HashMap<>();
		data.put("Flight_No", "AC604");
		data.put("Operational Status", "Active");
		data.put("Origin", "Source_Airport ");
		data.put("Destination", "Target_Airport");
		data.put("date_start", "start_date");
		data.put("date_end", "end_date");
		data.put("Traveler_Class", "F/B/E");
		data.put("No_Of_Travelers", "F-10/B-30/E-50");
		data.put("staff_details","pilot/Air Hostess");
		
		
		return data;
	}


}
