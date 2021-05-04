package Entity;

public class Gamer {
	private int Id;
	private String nationalId;
	private String firstName;
	private String lastName;
	private String birthDay;
	private boolean Validation;
	public Gamer(int id, String nationalId, String firstName, String lastName, String birthDay, boolean validation) {
		super();
		Id = id;
		this.nationalId = nationalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		Validation = validation;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public boolean isValidation() {
		return Validation;
	}
	public void setValidation(boolean validation) {
		Validation = validation;
	}
}
