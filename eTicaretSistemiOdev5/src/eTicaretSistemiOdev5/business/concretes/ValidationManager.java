package eTicaretSistemiOdev5.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaretSistemiOdev5.business.abstracts.ValidationService;

public class ValidationManager implements ValidationService{
	
	//Bu sýnýfýn altýnda kullancýnýn üye olurken isim, soyisim, parola ve mailde istenilen þartlarý saðlayýp saðlamadýðýný
	//kontrol ettim.
	
	boolean value=true;
	
	//Kullanýcýnýn isminin 2 karakterden küçük olmadýðýný kontrol eden metod. Kullanýcý üye olurken isim olarak
	//2 karakterden büyük veya eþit bir isim girdiðinde true , tam tersi durumda false döndürecek.
	@Override
	public boolean validateName(String name) {
		
		if(name.length()<2) {
			return false;
		}
		else {
			return value;
		}
		
		
	}
	//Kullanýcýnýn soyisminin 2 karakterden küçük olmadýðýný kontrol eden metod. Kullanýcý üye olurken soyisim olarak
	//2 karakterden büyük veya eþit bir isim girdiðinde true , tam tersi durumda false döndürecek.
	@Override
	public boolean validateSurname(String surname) {
		
		if(surname.length()<2) {
			return false;
		}
		else {
			return value;
		}
		
		
	}
	
	//Bu metodun altýnda regex kullanarak kullanýcýn üye olurken girdiði mail formatýnýn doðru olup olmadýðýný deðerlendiriyoruz.
	//Kullanýcýnýn üye olurken girdiði mail formatý doðruysa true , deðilse bu metod false dönecek. Bu metod çalýþýrken 
	//mail için gereken doðru regex formatýný bulup emailRegex deðiþkenine atadýk. Daha sonra emailPath.matcher ile kullanýcýnýn
	//üye olurken girdiði email adresinin regex ile uyumlu olup olmadýðýný kýyasladýk. 
	@Override
	public boolean validateMailAddress(String mailAddress) {
		// TODO Auto-generated method stub
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPath = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPath.matcher(mailAddress);
		return matcher.find();
	}
	
	//Kullancý üye olurken parola olarak 6 karakterden küçük bir parola girdiyse false, istenilen þartý
	//saðlayýp 6'dan büyük veya 6'ya eþit bir parola girdiyse true dönecek.
	@Override
	public boolean validatePassword(String password) {
		if(password.length()<6) {
			return false;
		}
		else {
			return value;
		}
		
		
	}
	
	//Kullanýcý doðrulama linkine týkladýysa true , týklamadýysa false döndürecek. Bu durum Main'de kurduðumuz 
	//senaryoya göre Member sýnýfýnýn isClicked özelliðine false yada true göndermemize göre deðiþecek.
	@Override
	public boolean validateIsClicked(boolean isClicked) {
		// TODO Auto-generated method stub
		return isClicked;
	}

}