package interfaces;

public class CustomerMenager {
	
	private Logger[] loggers;
	
	public CustomerMenager(Logger[] loggers) {
		this.loggers = loggers;
	
	}
	
	public void add(Customer customer) {
		System.out.println("Müþteri Eklendi " + customer.getFirstName());
		
		Utils.runLoggers(loggers, customer.getLastName());
	}
	
	
	public void delete(Customer customer) {
		
		System.out.println("Müþteri Silindi " + customer.getFirstName());
		
		Utils.runLoggers(loggers, customer.getLastName());
	
	}
}	

