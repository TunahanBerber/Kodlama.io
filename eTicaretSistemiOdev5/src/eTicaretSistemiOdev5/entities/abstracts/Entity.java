package eTicaretSistemiOdev5.entities.abstracts;

public interface Entity {
	
	//Member classlar�n�n ortak metodlar�n� bu interface sayesinde gruplad�m.
	
	String getName();
	String getPassword();
	String getMailAddress();
	String getSurname();
	boolean isClicked();

}