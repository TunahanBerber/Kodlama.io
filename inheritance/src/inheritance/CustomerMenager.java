package inheritance;

public class CustomerMenager {
	public void add(Customer  customer) {
		
		System.out.println(customer.customerNumber + " Kaydedildi ");
	}
	//bulk insert
	public void addMultiple(Customer[] customers) {
		
		for(Customer customer: customers) {
			add(customer);
		}
	}
}
//SOLID-Open Closed Principle
