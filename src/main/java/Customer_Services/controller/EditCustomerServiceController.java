package Customer_Services.controller;

import java.util.ArrayList;
import java.util.HashMap;

import Customer_Services.model.EditCustomerService;
import Customer_Services.view.Menu;
import Customer_Services.view.ViewEditCustomerService;

public class EditCustomerServiceController implements Controller {
	private String userName;
	public HashMap<String, String> data;

	public EditCustomerServiceController(String userName) {
		this.userName = userName;
	}

	@Override
	public void controller() {

		EditCustomerService service = new EditCustomerService(userName, 1);
		this.data = service.getEditCustomerService();
		Menu service_details = new ViewEditCustomerService(data, userName);
		HashMap<String, ArrayList<String>> userResp = service_details.getMenu();
		String option = userResp.get("option").get(0);
		this.getSubMenu(Integer.parseInt(option));

	}

	@Override
	public void getSubMenu(int option) {
		if (option == 0)

		{
			EditCustomerServiceController esc_controller = new EditCustomerServiceController("abc");
			esc_controller.controller();

		} else if (option == 1) {
			CustomerServiceController sc_controller = new CustomerServiceController("abc");
			sc_controller.controller();

		} else {
			// nothing here.

		}
	}

}
