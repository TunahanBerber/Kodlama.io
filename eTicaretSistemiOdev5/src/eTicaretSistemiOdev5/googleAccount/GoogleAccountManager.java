package eTicaretSistemiOdev5.googleAccount;

public class GoogleAccountManager {
	
	//D��ar�dan sistemime GoogleAccountManager class'�n� dahil etti�imi d���nelim.
	
	//GoogleAccountManager d��ar�dan eklendi. Ben s�n�fa bu s�n�f�n i�erisinde ki kodlara m�dahale edemiyorum.
	
	//Bu bilgilerin GoogleAccountManager'da var olan kullan�c�lar�n bilgileri oldu�unu farz edelim
	//De�er olarak test i�in Main'de girece�im parametreleri girdim..
	private String googleMailAddress = "enesmalik2006@gmail.com";
	private String googlePassword = "123456enes";
	
	
	//GoogleAccountManager kendi kontrol ediyor buraya gelen adresler ve �ifreler google adresi ve �ifresi mi de�il mi diye
	public void login(String mailAddress,String password) {
		
		if(!googleMailAddress.equals(mailAddress)) {
			System.out.println("Girilen google mail adresi yanl��!");
		}
		else if(!googlePassword.equals(password)) {
			System.out.println("Girilen google �ifresi yanl��!");
		}
		else if(!googleMailAddress.equals(mailAddress) && !googlePassword.equals(password)) {
			System.out.println("Girilen google �ifresi ve mail adresi yanl��!");
		}
		else {
			System.out.println("Kulllan�c� ba�ar�l� bir �ekilde google hesab�yla login oldu.");
		}
		
	}

}