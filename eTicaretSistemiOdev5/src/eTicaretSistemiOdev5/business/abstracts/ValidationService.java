package eTicaretSistemiOdev5.business.abstracts;

public interface ValidationService {
	
	//Validate doðrulama iþini yapan sýnýflarýn ortak metodlarýný içeren interface.
	//Parametre olarak Member class'ý verilmediðine özellikle dikkat edilsin. Çünkü kullanýcýnýn 
	//üye olma iþlemlerini yaparken girdiði parametrelerin þartlarý saðlayýp saðlamadýðýný kontrol 
	//edeceðiz.
	
	boolean validateName(String name);
	boolean validateSurname(String surname);
	boolean validateMailAddress(String mailAddress);
	boolean validatePassword(String password);
	boolean validateIsClicked(boolean isClicked);

}