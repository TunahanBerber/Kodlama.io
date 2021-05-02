package interfaces;

public class Main {

	public static void main(String[] args) {
		
		Logger[] loggers = {new SmsLogger(),new EmailLogger(),new FileLogger()};
		
		CustomerMenager customerMenager = new CustomerMenager(loggers);
		
		Customer engin = new Customer(1, "Engin","Demiro�"); 
		
		customerMenager.add(engin);
	}

}
