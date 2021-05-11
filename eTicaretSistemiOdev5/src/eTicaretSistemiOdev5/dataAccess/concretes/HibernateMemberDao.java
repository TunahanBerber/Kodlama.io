package eTicaretSistemiOdev5.dataAccess.concretes;

import eTicaretSistemiOdev5.business.abstracts.ValidationService;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class HibernateMemberDao implements MemberDao{
	
	//Kendine kural edin ba��ml�l�ktan kurtulmak ad�na soldaki referans tutucu parametreler interface olsun!
	//Objen bir bilgi tutan s�n�f olsun , bir veritaban� i�i yapan class olsun, sisteme y�nelik i� kodlar�n�
	//i�eren bir s�n�f olsun yada validation do�rulama yapan bir class olsun �zetle ne olursa olsun bu kuraldan
	//ka�ma ileride kodumuza eklenecek durumlarda ba��ml�l�klar� gidermek ad�na.
	
	//Kullanc�n�n �ye olurken girdi�i parolay� mail adresini ismini ve soy ismini do�rulamadan veri taban�na 
	//kaydetme i�leri yapmamal�y�m. Bu do�rulama i�ini olu�turdu�um validation s�n�f� ile yap�yorum. Veri taban�
	//i�lerinde do�rulama i�ini aktif bir �ekilde kullanaca��m i�in do�rulama s�n�f�n� kullanmadan kullan�c�y� 
	//veritaban�na kaydetmemek ad�na constructor injection y�ntemi ile veritaban� i�lerini yapt���m HibernateMemberDao
	//s�n�f�n�n ValidationManager s�n�f�n� kullanmas�n� zorunlu k�ld�m. Main'de HibernateMemberDao newlendi�i anda
	//parametre olarak ValidationService tipinde bir Validation s�n�f� isteyecek.
	ValidationService validationManager;
	
	public HibernateMemberDao(ValidationService validationManager) {
		super();
		this.validationManager = validationManager;
	}
	
	//�OK �NEML�
	//Bu fonksiyonun boolean deger dondurmesinin sebebi �u benim kullan�c�m sisteme ba�ar�l� bir �ekilde �ye olup kay�t olabildiyse
	//e�er true d�n�yor, olamad�ysa mail adresi, ismi, soyisimi, parolas� istenilen �artlar� sa�lamad�ysa e�er kullanc� �ye
	//olamayor ve ben bu kullan�c�y� veritaban�ba eklemiyorum. De�er d�nd�rmemde ki ama� Mainde veritaban�na eklenmeyen kullanc�n�n 
	//login olmamas�n� sa�lamak. Buradan d�nen de�erleri ben MemberManager i�erisinde ki login metodunda kullan�p �ye olamam�� 
	//kullan�c�n�n sim�lasyonda login olmas�n� engelleyece�im. Bunu veritaban�ndan ekleme ya�t���m yerde yapmak zorunday�m ��nk�
	//elimde ger�ek bir veri yok tamamen sim�lasyon yap�yorum. E�er elimde ger�ek veri olsayd� bu class'�n alt�nda bir metod
	//olu�turup veritaban�n i�ersinden kullanc� �ifrelerini ve mail adreslerini �eken ve kullan�c�n�n girdi�i parametrelere g�re 
	//k�yaslay�p burada g�nderdi�im parametrelerin veritaban�nda olmas� dahilinde true d�nen , olmamas� durumunda false d�nen bir
	//metod tasarlard�m. Bu metoddan d�nen de�eri de MemberManager alt�nda ki login fonksiyonunun alt�nda de�erlendirip �ye olmayan
	//kullan�c�n�n login olmas�n� engellerdim. Sim�lasyon yapt��m�z i�in ve elimizde ger�ek bir veri olmad��� i�in b�yle bir y�nteme
	//gidildi. Ger�ek bir sistemde elimizde veri varken veritaban� varken b�yle bir yol izlemek �ok b�y�k ve sa�ma bir hataya sebebiyet
	//verirdi ��nk� ben bu y�ntemle her login i�leminde add metodunun alt�nda kullan�c� ekleyerek login olmak isteyen kullan�c�n�n veritaban�nda
	//olup olmad���n� yokluyorum. Elimizde veri olmad��� i�in ve sim�lasyon yapt���m�z i�in bu y�ntem tercih edildi. A�a��daki ifler g�ze
	//spagetti gibi gelebilir ama bundan ba�ka yol yok kullan�c� �ye olurken 4 farkl� parametreyi do�ru girdiyse veritaban�na eklenmeli.
	//Tek bir if'in alt�nda yap�labilirdi ama kullan�c� hangi parametreyi yanl�� giriyorsa o y�nde bilgilendirme als�n istedim.
	@Override
	public boolean add(Entity member) {
		
		if(!validationManager.validateName(member.getName())) {
			System.out.println("Kullan�c� ad� 2 karakterden fazla olmal�!");
			return false;
		}
		else if(!validationManager.validatePassword(member.getPassword())) {
			System.out.println("Kullan�c� �ifresi en az 6 karakterden olu�mal�!");
			return false;
		}
		else if(!validationManager.validateSurname(member.getSurname())) {
			System.out.println("Kullan�c� soyad� 2 karakterden fazla olmal�!");
			return false;
		}
		else if(!validationManager.validateMailAddress(member.getMailAddress())) {
			System.out.println("Ge�ersiz mail adresi!");
			return false;
		}
		else if(validationManager.validateIsClicked(!member.isClicked())) {
			System.out.println("Kullan�c� e-posta do�rulama linkine t�klamad�!");
			return false;
		}
		else {
			//Yukar�daki t�m �artlar sa�lanm�yorsa e�er kullan�c� parolas�n� mail adresini , ismini ve soyismini 
			//sistemde istenilen �ekilde girmi� demektir. Bu durumda ben veri taban�na kullan�c�m� kaydetme i�lerini burada yapaca��m.
			
			System.out.println("Veri taban�na eklendi : "+member.getName());
			return true;
		}
		
	}
	
	//Veritaban�nda g�ncelleme i�leri bu metodun alt�nda yap�lacak.
	@Override
	public void update(Entity member) {
		
		System.out.println("Veri taban�nda g�ncellendi : "+member.getName());
	}
	
	//Veritaban�ndan kullan�c� silme i�leri bu metodun alt�nda yap�lacak.
	@Override
	public void delete(Entity member) {
		
		System.out.println("Veri taban�ndan silindi : "+member.getName());
	}

}