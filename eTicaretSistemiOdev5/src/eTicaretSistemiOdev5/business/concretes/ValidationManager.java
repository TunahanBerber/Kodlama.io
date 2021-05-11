package eTicaretSistemiOdev5.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaretSistemiOdev5.business.abstracts.ValidationService;

public class ValidationManager implements ValidationService{
	
	//Bu s�n�f�n alt�nda kullanc�n�n �ye olurken isim, soyisim, parola ve mailde istenilen �artlar� sa�lay�p sa�lamad���n�
	//kontrol ettim.
	
	boolean value=true;
	
	//Kullan�c�n�n isminin 2 karakterden k���k olmad���n� kontrol eden metod. Kullan�c� �ye olurken isim olarak
	//2 karakterden b�y�k veya e�it bir isim girdi�inde true , tam tersi durumda false d�nd�recek.
	@Override
	public boolean validateName(String name) {
		
		if(name.length()<2) {
			return false;
		}
		else {
			return value;
		}
		
		
	}
	//Kullan�c�n�n soyisminin 2 karakterden k���k olmad���n� kontrol eden metod. Kullan�c� �ye olurken soyisim olarak
	//2 karakterden b�y�k veya e�it bir isim girdi�inde true , tam tersi durumda false d�nd�recek.
	@Override
	public boolean validateSurname(String surname) {
		
		if(surname.length()<2) {
			return false;
		}
		else {
			return value;
		}
		
		
	}
	
	//Bu metodun alt�nda regex kullanarak kullan�c�n �ye olurken girdi�i mail format�n�n do�ru olup olmad���n� de�erlendiriyoruz.
	//Kullan�c�n�n �ye olurken girdi�i mail format� do�ruysa true , de�ilse bu metod false d�necek. Bu metod �al���rken 
	//mail i�in gereken do�ru regex format�n� bulup emailRegex de�i�kenine atad�k. Daha sonra emailPath.matcher ile kullan�c�n�n
	//�ye olurken girdi�i email adresinin regex ile uyumlu olup olmad���n� k�yaslad�k. 
	@Override
	public boolean validateMailAddress(String mailAddress) {
		// TODO Auto-generated method stub
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPath = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPath.matcher(mailAddress);
		return matcher.find();
	}
	
	//Kullanc� �ye olurken parola olarak 6 karakterden k���k bir parola girdiyse false, istenilen �art�
	//sa�lay�p 6'dan b�y�k veya 6'ya e�it bir parola girdiyse true d�necek.
	@Override
	public boolean validatePassword(String password) {
		if(password.length()<6) {
			return false;
		}
		else {
			return value;
		}
		
		
	}
	
	//Kullan�c� do�rulama linkine t�klad�ysa true , t�klamad�ysa false d�nd�recek. Bu durum Main'de kurdu�umuz 
	//senaryoya g�re Member s�n�f�n�n isClicked �zelli�ine false yada true g�ndermemize g�re de�i�ecek.
	@Override
	public boolean validateIsClicked(boolean isClicked) {
		// TODO Auto-generated method stub
		return isClicked;
	}

}