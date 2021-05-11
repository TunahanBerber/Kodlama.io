package eTicaretSistemiOdev5.entities.abstracts;

public interface Entity {
	
	//Member classlarýnýn ortak metodlarýný bu interface sayesinde grupladým.
	
	String getName();
	String getPassword();
	String getMailAddress();
	String getSurname();
	boolean isClicked();

}