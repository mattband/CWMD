package matthew;

//developer. Matthew devlin

public interface CustomerController {

	boolean updateCustomer(Customer customer);
	void printAllCustomers();
	boolean deleteCustomer(String customerID);
	boolean  getCustomerById(String customerID);
	 boolean insertCustomer(Customer customer);
}
