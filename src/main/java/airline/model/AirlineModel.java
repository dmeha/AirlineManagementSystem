package airline.model;

import java.util.HashMap;

public class AirlineModel {

	public String userName;
	public int option;

	public AirlineModel(String userName, int option) {
		this.userName = userName;
		this.option = option;
	}

	public HashMap<String, String> getAirlineDetails() {
		HashMap<String, String> data = new HashMap<>();
		data.put("No_Of_Flights", "200");
		data.put("Domestic", "70");
		data.put("International", "130");
		data.put("Operational", "180");
		return data;
	}

}

