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
		
		//Bu k�s�mda kullan�c� herhangi bir hesapla sisteme kay�t olabiliyor.
		
		//Entity tipinde yeni bir �ye olu�turuldu.
		Entity memberTunahan = new Member("Tunahan","Berber","123456","tunahanberber123@gmail.com",true);
		
		//Kullanc�n�n �ye olurken mail adresi ,ismi ve soyismi gibi �artlar� sa�lay�p sa�lamad���n�
		//ValidationService tipinde bir ValidationManager class'� ile anl�yoruz. Bu class'� veritaban� i�lerimizi yapan
		//MemberDao tipindeki HibernateMemberDao s�n�f�m�z constructor'�nda parametre olarak al�yor ��nk� ValidationManager
		//s�n�f� HibernateMemberDao'nun i�erisinde constructor injection y�ntemi ile kullan�ld�.
		ValidationService validationManager = new ValidationManager();
		MemberDao hibernateMemberDao = new HibernateMemberDao(validationManager);
		
		//MemberService tipindeki MemberManager s�n�f�m ise parametre olarak �ye s�n�f�n� ve veritaban� i�lerinin yap�ld��� s�n�f�
		//al�yor ��nk� Member s�n�f�m ve HibernateMemberDao s�n�f�m MemberManager i�erisinde constructor injeciton y�ntemi ile
		//kullan�ld�.
		MemberService memberService = new MemberManager(memberTunahan,hibernateMemberDao);
		
		//Kullann�c� login olmak i�in MemberManager s�n�f�n�n login metodunu kullan�yor. Login olurken kullan�c�dan mail adresi ve
		//�ifre isteniyor. Buradaki parametreleri kullan�c�n�n login sayfas�ndan girdi�ini d���nebilirsiniz. Hatta Scanner s�n�f�
		//ile yine bu kodlar �zerinden kendinizde girdi yollayabilirsiniz.
		memberService.login("tunahanberber123@gmail.com","123456");
		
		System.out.println("-------------------------------");
		
		//Bundan sonraki k�s�mda kullan�c� sisteme google hesab�yla kay�t oluyor. Buradaki kodlar�n yukar�daki kodlardan tek fark�
		//Kendi sistemizde kay�t olan kullan�c� ve login i�lemini ger�ekle�tiren kullan�c� google mail adresini ve google �ifresi
		//kullanarak sistemimize kay�t oluyor ve login i�lemini ger�ekle�tiriyor.
		
		Entity memberFatmanur = new Member("Fatmanur","Sevindik","1234567","fatmanursevindik123@gmail.com",true);
		MemberService memberServiceGoogle = new GoogleAccountManagerAdapter(memberFatmanur, hibernateMemberDao);
		memberServiceGoogle.login("fatmanursevindik123@gmail.com", "1234567");
		
		
	}

}