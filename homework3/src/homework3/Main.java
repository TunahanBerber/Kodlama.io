package homework3;

public class Main {

	public static void main(String[] args) {
	
		UserManager userManager = new UserManager();
		
		Instructor instructor1 = new Instructor();
		instructor1.setId(1235979);
		instructor1.setFirstName("Engin");
		instructor1.setLastName("Demiroğ");
		instructor1.setEmail("engind@gmail.com");
		instructor1.setCourse("Yazılım Geliştirici Yetiştirme Kampı (Java + REACT )");
		instructor1.setInstructorNumber("12345");
		
		Instructor instructor2 = new Instructor();
		instructor2.setId(1332369);
		instructor2.setFirstName("Burak");
		instructor2.setLastName("Yıldırım");
		instructor2.setEmail("burakd@gmail.com");
		instructor2.setCourse("Yazılım Geliştirici Yetiştirme Kampı(C# + ANGULAR");
		instructor2.setInstructorNumber("6789");
		
		Student student1 = new Student();
		student1.setId(1);		
		student1.setFirstName("Tunahan");
		student1.setLastName("Berber");
		student1.setEmail("tunahanberber123@gmail.com");
		student1.setCourse("Yazılım Geliştirici Yetiştirme Kampı (Java + REACT )");
		student1.setStudentNumber("45678");
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor1);
		instructorManager.add(instructor2);
		
		StudentManager studentManager = new StudentManager();
		studentManager.add(student1);
	
		System.out.println();
		
		User[] user = {instructor1, instructor2, student1};
		
		userManager.multipleAdd(user);
		
		
	}

}
