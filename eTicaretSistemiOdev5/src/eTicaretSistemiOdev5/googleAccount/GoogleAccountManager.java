package eTicaretSistemiOdev5.googleAccount;

public class GoogleAccountManager {
	
	//Dýþarýdan sistemime GoogleAccountManager class'ýný dahil ettiðimi düþünelim.
	
	//GoogleAccountManager dýþarýdan eklendi. Ben sýnýfa bu sýnýfýn içerisinde ki kodlara müdahale edemiyorum.
	
	//Bu bilgilerin GoogleAccountManager'da var olan kullanýcýlarýn bilgileri olduðunu farz edelim
	//Deðer olarak test için Main'de gireceðim parametreleri girdim..
	private String googleMailAddress = "enesmalik2006@gmail.com";
	private String googlePassword = "123456enes";
	
	
	//GoogleAccountManager kendi kontrol ediyor buraya gelen adresler ve þifreler google adresi ve þifresi mi deðil mi diye
	public void login(String mailAddress,String password) {
		
		if(!googleMailAddress.equals(mailAddress)) {
			System.out.println("Girilen google mail adresi yanlýþ!");
		}
		else if(!googlePassword.equals(password)) {
			System.out.println("Girilen google þifresi yanlýþ!");
		}
		else if(!googleMailAddress.equals(mailAddress) && !googlePassword.equals(password)) {
			System.out.println("Girilen google þifresi ve mail adresi yanlýþ!");
		}
		else {
			System.out.println("Kulllanýcý baþarýlý bir þekilde google hesabýyla login oldu.");
		}
		
	}

}