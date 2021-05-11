package eTicaretSistemiOdev5.core.concretes;

import eTicaretSistemiOdev5.googleAccount.GoogleAccountManager;
import eTicaretSistemiOdev5.business.concretes.MemberManager;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class GoogleAccountManagerAdapter extends MemberManager{
	
	//Bu s�n�f sayesinde d��ar�dan sistemime eklemek zorunda oldu�um, i�erisinde de�i�iklik yaparak m�dahale de
	//bulunamad���m GoogleAccountManager s�n�f�n� sistemime entegre ediyorum.
	
	//GoogleAccountManager googleAccountManager;
	//Kodlar� yazarken yukar�da ki yoruma ald���m hatal� kullan�m� yapt�m. Bu hatal� bir kullan�m senin burada bunu her t�rl� newlemen gerekir. 
	//Newlemeden kullan�rsan null point exception hatas� al�rs�n. Bu hatay� �undan dolay� al�rs�n asl�nda 
	//Sen bir GoogleAccountManager tipinde googleAccountManager objesi olu�turdun ama referans atamas� yapmad�n 
	//A�a��daki kodlarda hata ya�aman�n sebebi bu class'�n alt�ndaki login metodunun i�ersinde googleAccountManager.login(mailAddress, password);
	//dedi�inde olmayan bo� bir referans �zerinden gitmeye �al��man, null bir referans �zerinden ilerlemeye �al��man.
	//�imdi bu hatay� ald�ktan sonra GoogleAccountManager yerine yukar�da interface olsayd� constructor injection yaparken 
	//nas�l �al���yordu gibisinden d���nebilirsin iyide orada da injection yaparken interface'in tuttu�u 
	//referans� Mainde vs. bir yerde newliyorsun. Mesela HibernateMemberDao class'�n�n alt�nda ValidationService
	//tipindeki ValidationManager Main'de newleniyor. �stersen xml dosyas�nda newle, istersen Mainde istersen ba�ka bir katmanda
	//bir class ne tipte olursa olsun yani isterse referans�n� bir interface tutsun isterse de kendisi isterse ba�ka bir class
	//newlemezsen o class'�n referans�n� olu�turmazs�n. Tipi ne olursa olsun(interface class vs.) bo� referans tutar bo� referans 
	//�zerinden gidersen null point exception hatas�n� yersin.
	
	//�OK �NEML�
	//GoogleAccountManager s�n�f� d��ar�dan kendi sistemime entegre etti�im bir s�n�f oldu�u i�in bu s�n�f�n alt�nda newlemekten 
	//�ekinmiyorum. Normalde ba�ka bir s�n�f�n alt�nda newleme i�lemi yapmak o s�n�f� newledi�in s�n�fa ba��ml� yapmakt�r. Ama ben
	//Ben sistemime d��ar�dan bir�ey entegre ediyorsam o entegre etti�im �eye zaten ba��ml�y�md�r. Bu durumda a�a��daki newleme i�i 
	//�ok g�ze batm�yor.
	GoogleAccountManager googleAccountManager = new GoogleAccountManager();
	
	//GoogleAccountManagerAdapter s�n�f�m MemberManager ile ayn� fonksiyonlara sahip olaca�� i�in MemberManager s�n�f�n� extend etti
	//Dolay�s�yla MemberManager'da olan constructor yani MemberManager'�n constructor injection sayesinde sahip oldu�u ba��ml�l�klar
	//burada da olmal�.
	public GoogleAccountManagerAdapter(Entity member, MemberDao hibernateMemberDao) {
		super(member, hibernateMemberDao);
		
	}
	
	//MemberManager'da ki login fonksiyonunu override etti sadece ��nk� buradaki login i�lemi farkl�. Ben burada 
	//google hesab�m ile login oldu�um i�in sistem hem veritaban�n da hem GoogleAccountManager taraf�nda b�yle
	//bir hesab�n olup olmad���n� sorgulamal�. Bu sorgulama i�lemi veritaban� taraf�nda hibernateMemberDao.add(member)
	//ile yap�l�rken(Bu sorgulama i�leminin neden b�yle yap�ld��� HibernateManagerDao add ve MemberManager login metodu
	//�zerinde ayr�nt�l� bir a��klama ile yap�ld�.) google taraf�nda b�yle bir hesab�n olup olmad��� googleAccountManager.login(mailAddress, password);
	//ile yap�l�yor. 
	@Override
	public void login(String mailAddress, String password) {
		// TODO Auto-generated method stub
		
		if(hibernateMemberDao.add(member)) {
			googleAccountManager.login(mailAddress, password);
		}
		else {
			System.out.println("Sistemde kay�tl� b�yle bir google hesab� yok!");
		}
		
		
	}	
	
	
	

}