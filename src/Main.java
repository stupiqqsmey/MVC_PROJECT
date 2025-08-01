import kh.edu.controller.CustomerController;
import kh.edu.dto.CustomerResponse;
import kh.edu.view.CustomerView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        CustomerView view = new CustomerView();

        List<CustomerResponse> customers = controller.getAllCustomers();

        view.displayMenu(customers);
    }
}
