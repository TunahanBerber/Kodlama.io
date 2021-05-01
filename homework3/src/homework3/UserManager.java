package homework3;

public class UserManager {
	public void add(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " kaydedildi!" );
		
	}
	
	public void delete(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " silindi!" );
	
	}
	
	public void multipleAdd(User[] users) {
		for(User user : users) {
			add(user);
			
			}
	}
	public void multipleDelete(User[]users) {
		for(User user : users) {
			add(user);
		}
	}
}
