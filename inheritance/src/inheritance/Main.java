package inheritance;

public class Main {

	public static void main(String[] args) {
		
		IndividualCustomer engin = new IndividualCustomer();
		engin.customerNumber = "12345";
		
		CorparateCustomer hepsiBurada = new CorparateCustomer();
		hepsiBurada.customerNumber = "78910";
		
		SendikaCustomer sendika1 = new SendikaCustomer();
		sendika1.customerNumber = "987654"; 
				
		
		CustomerMenager customerMenager = new CustomerMenager();
		Customer[] customers = {engin, sendika1,  hepsiBurada};
		
		customerMenager.addMultiple(customers);
		
		//customerMenager.add(hepsiBurada);
		//customerMenager.add(engin);
		//customerMenager.add(sendika1);
		
	}
}
	
