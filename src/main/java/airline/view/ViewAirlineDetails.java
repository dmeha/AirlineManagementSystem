package airline.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ViewAirlineDetails implements Menu {

	private final HashMap<String, String> data;
	private final String userName;
	final String line = "======================================================";

	public ViewAirlineDetails(HashMap<String, String> data, String userName) {
		this.data = data;
		this.userName = userName;
	}

	public HashMap<String, ArrayList<String>> getMenu() {
		
		HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        this.data.forEach((key, value) ->{
            System.out.println(key +": "+ value);
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
