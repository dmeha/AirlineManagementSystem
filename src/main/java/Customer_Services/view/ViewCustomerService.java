package Customer_Services.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ViewCustomerService implements Menu{
	

	private final HashMap<String, String> data;
	private final String userName;
	final String line = "======================================================";

	public ViewCustomerService(HashMap<String, String> data, String userName) {
		this.data = data;
		this.userName = userName;
	}

	public HashMap<String, ArrayList<String>> getMenu() {
		
		HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName+"\t CustomerService");
        System.out.println(this.line);
        System.out.println("Ticket ID"+"\t CustomerQuery");
        this.data.forEach((key, value) ->{
            System.out.println(key +": "+ value);
        });
        
        System.out.println("0. Back to Menu");
        System.out.println("1. edit");
        
        
        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = userOption.nextInt();
        System.out.println(this.line);
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));
        return response;



	
	}


	
}
