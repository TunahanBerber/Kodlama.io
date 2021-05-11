package eTicaretSistemiOdev5;

import eTicaretSistemiOdev5.business.abstracts.MemberService;
import eTicaretSistemiOdev5.business.abstracts.ValidationService;
import eTicaretSistemiOdev5.business.concretes.MemberManager;
import eTicaretSistemiOdev5.business.concretes.ValidationManager;
import eTicaretSistemiOdev5.core.concretes.GoogleAccountManagerAdapter;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.dataAccess.concretes.HibernateMemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;
import eTicaretSistemiOdev5.entities.concretes.Member;

public class Main {

	public static void main(String[] args) {
		
		//Bu kýsýmda kullanýcý herhangi bir hesapla sisteme kayýt olabiliyor.
		
		//Entity tipinde yeni bir üye oluþturuldu.
		Entity memberTunahan = new Member("Tunahan","Berber","123456","tunahanberber123@gmail.com",true);
		
		//Kullancýnýn üye olurken mail adresi ,ismi ve soyismi gibi þartlarý saðlayýp saðlamadýðýný
		//ValidationService tipinde bir ValidationManager class'ý ile anlýyoruz. Bu class'ý veritabaný iþlerimizi yapan
		//MemberDao tipindeki HibernateMemberDao sýnýfýmýz constructor'ýnda parametre olarak alýyor çünkü ValidationManager
		//sýnýfý HibernateMemberDao'nun içerisinde constructor injection yöntemi ile kullanýldý.
		ValidationService validationManager = new ValidationManager();
		MemberDao hibernateMemberDao = new HibernateMemberDao(validationManager);
		
		//MemberService tipindeki MemberManager sýnýfým ise parametre olarak üye sýnýfýný ve veritabaný iþlerinin yapýldýðý sýnýfý
		//alýyor çünkü Member sýnýfým ve HibernateMemberDao sýnýfým MemberManager içerisinde constructor injeciton yöntemi ile
		//kullanýldý.
		MemberService memberService = new MemberManager(memberTunahan,hibernateMemberDao);
		
		//Kullannýcý login olmak için MemberManager sýnýfýnýn login metodunu kullanýyor. Login olurken kullanýcýdan mail adresi ve
		//þifre isteniyor. Buradaki parametreleri kullanýcýnýn login sayfasýndan girdiðini düþünebilirsiniz. Hatta Scanner sýnýfý
		//ile yine bu kodlar üzerinden kendinizde girdi yollayabilirsiniz.
		memberService.login("tunahanberber123@gmail.com","123456");
		
		System.out.println("-------------------------------");
		
		//Bundan sonraki kýsýmda kullanýcý sisteme google hesabýyla kayýt oluyor. Buradaki kodlarýn yukarýdaki kodlardan tek farký
		//Kendi sistemizde kayýt olan kullanýcý ve login iþlemini gerçekleþtiren kullanýcý google mail adresini ve google þifresi
		//kullanarak sistemimize kayýt oluyor ve login iþlemini gerçekleþtiriyor.
		
		Entity memberFatmanur = new Member("Fatmanur","Sevindik","1234567","fatmanursevindik123@gmail.com",true);
		MemberService memberServiceGoogle = new GoogleAccountManagerAdapter(memberFatmanur, hibernateMemberDao);
		memberServiceGoogle.login("fatmanursevindik123@gmail.com", "1234567");
		
		
	}

}