package eTicaretSistemiOdev5.business.abstracts;

public interface ValidationService {
	
	//Validate do�rulama i�ini yapan s�n�flar�n ortak metodlar�n� i�eren interface.
	//Parametre olarak Member class'� verilmedi�ine �zellikle dikkat edilsin. ��nk� kullan�c�n�n 
	//�ye olma i�lemlerini yaparken girdi�i parametrelerin �artlar� sa�lay�p sa�lamad���n� kontrol 
	//edece�iz.
	
	boolean validateName(String name);
	boolean validateSurname(String surname);
	boolean validateMailAddress(String mailAddress);
	boolean validatePassword(String password);
	boolean validateIsClicked(boolean isClicked);

}