package Customer_Services.controller;

import java.util.ArrayList;
import java.util.HashMap;
import Customer_Services.model.CustomerService;
import Customer_Services.view.Menu;
import Customer_Services.view.ViewCustomerService;
import Customer_Services.controller.EditCustomerServiceController;

public class CustomerServiceController implements Controller {
	private String userName;
	public HashMap<String, String> data;

	public CustomerServiceController(String userName) {
		this.userName = userName;
	}

	@Override
	public void controller() {

		CustomerService service = new CustomerService(userName, 1);
		this.data = service.getCustomerService();
		Menu service_details = new ViewCustomerService(data, userName);
		HashMap<String, ArrayList<String>> userResp = service_details.getMenu();
		String option = userResp.get("option").get(0);
		this.getSubMenu(Integer.parseInt(option));

	}

	@Override
	public void getSubMenu(int option) {
		if (option == 0)

		{
			CustomerServiceController sc_controller = new CustomerServiceController("abc");
			sc_controller.controller();

		} else if (option == 1) {
			EditCustomerServiceController esc_controller = new EditCustomerServiceController("abc");
			esc_controller.controller();

		} else {
			// nothing here.

		}
	}

}
