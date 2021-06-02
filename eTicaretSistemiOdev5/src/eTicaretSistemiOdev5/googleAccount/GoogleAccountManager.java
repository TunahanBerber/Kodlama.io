package eTicaretSistemiOdev5.googleAccount;

public class GoogleAccountManager {
	
	//Dışarıdan sistemime GoogleAccountManager class'ını dahil ettiğimi düşünelim.
	
	//GoogleAccountManager dışarıdan eklendi. Ben sınıfa bu sınıfın içerisinde ki kodlara müdahale edemiyorum.
	
	//Bu bilgilerin GoogleAccountManager'da var olan kullanıcıların bilgileri olduğunu farz edelim
	//Değer olarak test için Main'de gireceğim parametreleri girdim..
	private String googleMailAddress = "tunahanberber123@gmail..com";
	private String googlePassword = "789789Ab,";
	
	
	//GoogleAccountManager kendi kontrol ediyor buraya gelen adresler ve şifreler google adresi ve şifresi mi değil mi diye
	public void login(String mailAddress,String password) {
		
		if(!googleMailAddress.equals(mailAddress)) {
			System.out.println("Girilen google mail adresi yanlış!");
		}
		else if(!googlePassword.equals(password)) {
			System.out.println("Girilen google şifresi yanlış!");
		}
		else if(!googleMailAddress.equals(mailAddress) && !googlePassword.equals(password)) {
			System.out.println("Girilen google şifresi ve mail adresi yanlış!");
		}
		else {
			System.out.println("Kulllanıcı başarılı bir şekilde google hesabıyla login oldu.");
		}
		
	}

}
