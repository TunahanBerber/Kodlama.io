package eTicaretSistemiOdev5.core.concretes;

import eTicaretSistemiOdev5.googleAccount.GoogleAccountManager;
import eTicaretSistemiOdev5.business.concretes.MemberManager;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class GoogleAccountManagerAdapter extends MemberManager{
	
	//Bu sýnýf sayesinde dýþarýdan sistemime eklemek zorunda olduðum, içerisinde deðiþiklik yaparak müdahale de
	//bulunamadýðým GoogleAccountManager sýnýfýný sistemime entegre ediyorum.
	
	//GoogleAccountManager googleAccountManager;
	//Kodlarý yazarken yukarýda ki yoruma aldýðým hatalý kullanýmý yaptým. Bu hatalý bir kullaným senin burada bunu her türlü newlemen gerekir. 
	//Newlemeden kullanýrsan null point exception hatasý alýrsýn. Bu hatayý þundan dolayý alýrsýn aslýnda 
	//Sen bir GoogleAccountManager tipinde googleAccountManager objesi oluþturdun ama referans atamasý yapmadýn 
	//Aþaðýdaki kodlarda hata yaþamanýn sebebi bu class'ýn altýndaki login metodunun içersinde googleAccountManager.login(mailAddress, password);
	//dediðinde olmayan boþ bir referans üzerinden gitmeye çalýþman, null bir referans üzerinden ilerlemeye çalýþman.
	//Þimdi bu hatayý aldýktan sonra GoogleAccountManager yerine yukarýda interface olsaydý constructor injection yaparken 
	//nasýl çalýþýyordu gibisinden düþünebilirsin iyide orada da injection yaparken interface'in tuttuðu 
	//referansý Mainde vs. bir yerde newliyorsun. Mesela HibernateMemberDao class'ýnýn altýnda ValidationService
	//tipindeki ValidationManager Main'de newleniyor. Ýstersen xml dosyasýnda newle, istersen Mainde istersen baþka bir katmanda
	//bir class ne tipte olursa olsun yani isterse referansýný bir interface tutsun isterse de kendisi isterse baþka bir class
	//newlemezsen o class'ýn referansýný oluþturmazsýn. Tipi ne olursa olsun(interface class vs.) boþ referans tutar boþ referans 
	//üzerinden gidersen null point exception hatasýný yersin.
	
	//ÇOK ÖNEMLÝ
	//GoogleAccountManager sýnýfý dýþarýdan kendi sistemime entegre ettiðim bir sýnýf olduðu için bu sýnýfýn altýnda newlemekten 
	//çekinmiyorum. Normalde baþka bir sýnýfýn altýnda newleme iþlemi yapmak o sýnýfý newlediðin sýnýfa baðýmlý yapmaktýr. Ama ben
	//Ben sistemime dýþarýdan birþey entegre ediyorsam o entegre ettiðim þeye zaten baðýmlýyýmdýr. Bu durumda aþaðýdaki newleme iþi 
	//çok göze batmýyor.
	GoogleAccountManager googleAccountManager = new GoogleAccountManager();
	
	//GoogleAccountManagerAdapter sýnýfým MemberManager ile ayný fonksiyonlara sahip olacaðý için MemberManager sýnýfýný extend etti
	//Dolayýsýyla MemberManager'da olan constructor yani MemberManager'ýn constructor injection sayesinde sahip olduðu baðýmlýlýklar
	//burada da olmalý.
	public GoogleAccountManagerAdapter(Entity member, MemberDao hibernateMemberDao) {
		super(member, hibernateMemberDao);
		
	}
	
	//MemberManager'da ki login fonksiyonunu override etti sadece çünkü buradaki login iþlemi farklý. Ben burada 
	//google hesabým ile login olduðum için sistem hem veritabanýn da hem GoogleAccountManager tarafýnda böyle
	//bir hesabýn olup olmadýðýný sorgulamalý. Bu sorgulama iþlemi veritabaný tarafýnda hibernateMemberDao.add(member)
	//ile yapýlýrken(Bu sorgulama iþleminin neden böyle yapýldýðý HibernateManagerDao add ve MemberManager login metodu
	//üzerinde ayrýntýlý bir açýklama ile yapýldý.) google tarafýnda böyle bir hesabýn olup olmadýðý googleAccountManager.login(mailAddress, password);
	//ile yapýlýyor. 
	@Override
	public void login(String mailAddress, String password) {
		// TODO Auto-generated method stub
		
		if(hibernateMemberDao.add(member)) {
			googleAccountManager.login(mailAddress, password);
		}
		else {
			System.out.println("Sistemde kayýtlý böyle bir google hesabý yok!");
		}
		
		
	}	
	
	
	

}