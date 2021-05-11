package eTicaretSistemiOdev5.business.abstracts;



public interface MemberService {
	
	//Kullanýcýnýn login , þifre deðiþtirme mail adresi deðiþtirme gibi metodlarýný bu interface'in altýnda grupladým.
	//Parametre olarak Entity tipinde Member class'ýný almadýðýný özellikle belirtmek isterim çünkü bu iþlemlerde ki parametreleri kullanýcý sisteme 
	//girerken , þifresini veya mail adresini deðiþtirirken kendisi input olarak girecek. Girdiði inputlara göre biz kullanýcýyý yönlendireceðiz.
	
	void login(String password,String mailAddress);
	void changePassword(String password);
	void changeMailAddress(String mailAddress);
	
	
}