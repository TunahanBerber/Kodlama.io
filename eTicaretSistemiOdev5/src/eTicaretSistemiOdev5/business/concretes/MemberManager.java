package eTicaretSistemiOdev5.business.concretes;

import eTicaretSistemiOdev5.business.abstracts.MemberService;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class MemberManager implements MemberService{
	
	//Bu class'�n alt�nda �yelik ile ilgili i�lemleri ger�ekle�tirdik ve �yelikle ilgili metodlar� yazd�k.
	//�yelikle ilgili metodlar Entity tipinde bir Member s�n�f�na ve MemberDao tipinde bir veritaban� i�i
	//yapan s�n�fa ihtiya� duyuyordu. Bu 2 s�n�f olmadan �yelikle ilgili i�lemlerin yap�lmas� m�mk�n 
	//olmad���dan Main'de MemberManager newlenirken bu 2 s�n�f�n zorunlu olarak istenmesini constructor
	//injection ile m�mk�n k�ld�k.
	
	//Protected �zelli�i atanan bir de�i�ken veya metot, sadece bulundu�u s�n�f i�erisinden veya bulundu�u s�n�f� 
	//extend eden s�n�f i�erisinden eri�ilebilir. Bu s�n�f� extend eden GoogleAccountManagerAdapter s�n�f� ba�ka 
	//bir paketin alt�nda oldu�u i�in bu parametreleri protected yapmak zorunda kald�k.
	protected Entity member;
	protected MemberDao hibernateMemberDao;
	
	public MemberManager(Entity member, MemberDao hibernateMemberDao) {
		super();
		this.member = member;
		this.hibernateMemberDao = hibernateMemberDao;
	}
	
	//�OK �NEML�
	//Login i�lemlerini login metodumla yap�yorum. En i�teki lojiklerle(if else if else) kullanc�n�n login olurken 
	//do�ru �ifre ve mail adresi girip girmedi�ini kontrol ediyorum. Kullanc� do�ru mail adresini ve �ifreyi 
	//girdi�inde kullanc� ba�ar�l� bir �ekilde login i�lemini ger�ekle�tirmi� oluyor. Kullan�c�n�n veritaban�na 
	//eklenmeden login olamamas�n� sa�lamak ad�na d��taki if'de ise kullanc�n�n veritaban�na eklenmesi dahilinde
	//kullan�c�n�n do�ru bir �ekilde login olup olmad���n�n testinin yap�lmas�n� sa�lad�m. Yani kullanc� veritaban�na
	//eklenmediyse �ye olmad�ysa girilen mail ve �ifrenin do�rulu�unu test etmeden b�yle bir kullan�c� yok sistemde
	//kay�tl� de�il uyar�s� veriyorum. Bu durumu hibernateMemberDao.add metodunun alt�nda yapmam�n sebebi �u hibernateMemberDao.add
	//metodunun alt�nda kullan�c� ba�ar�l� bir �ekilde kay�t olduysa true , olamad�ysa false d�nen i�lemler yapm��t�m.
	//Bu i�lemleri add metodunun alt�nda yapmam�n sebebi elimizde bir veritaban� olmamas� ve burada tasarlanan sistemin
	//bir sim�lasyon olmas� e�er elimizde bir veri olsayd� HibernateMemberDao'da veritaban�n i�ersinden kullanc� �ifrelerini
	//ve mail adreslerini �eken ve burada g�nderdi�im parametrelere g�re k�yaslay�p burada g�nderdi�im parametrelerin 
	//veritaban�nda olmas� dahilinde true d�nen , olmamas� durumunda false d�n�p en d��tak�i else'deki uyar�y� veren 
	//bir metod tasarlayacakt�m.(hibernateMemberDao.add(member) yerine benimyazdigimmetod(member) olacakt�.) 
	//Sim�lasyon yapmam�m�z ve elimde veritaban� olmamas� b�yle bir durumu ortaya ��kard�. Elimizde
	//ger�ek bir veri taban� olsayd� e�er bu y�ntem yanl�� olacakt� ��nk� ben her login i�leminde yanl��l�kla ve veritaban�na
	//kullan�c�y� eklemi� olacakt�m. Bu da ger�ek bir sistem i�in �ok sa�ma ve �ok b�y�k bir hata.
	@Override
	public void login(String mailAddress,String password) {
		// TODO Auto-generated method stub
	if(hibernateMemberDao.add(member)) {
		if(password.equals(member.getPassword()) && mailAddress.equals(member.getMailAddress())) {
			System.out.println("Kullan�c� ba�ar�l� bir �ekilde login oldu.");
		}
		else if(!password.equals(member.getPassword()) && !mailAddress.equals(member.getMailAddress())) {
			System.out.println("Login i�lemi s�ras�nda mail adresi ve �ifre yanl�� girildi!");
		}
		else if(!password.equals(member.getPassword())){
			System.out.println("Login i�lemi s�ras�nda �ifre yanl�� girildi!");
		}
		else if(!mailAddress.equals(member.getMailAddress())){
			System.out.println("Login i�lemi s�ras�nda mail adresi yanl�� girildi!");
		}
	}
	else {
		System.out.println("Sistemde kay�tl� b�yle bir kullan�c� yok!");
	}
	
	}
	
	//Kullan�c� �ifresini de�i�tirmek isterse e�er eski �ifresini girmeli. Girdi�i de�er ile 
	//g�ncel �ifresi uyumlu ise �ifre de�i�time i�lemeni ger�ekle�tirmek i�in veritaban�nda g�ncelleme i�lemlerini
	//yapan metodu �a��r�yorum bu metodun alt�nda. Parametre olarak bu i�lemi ger�ekle�tirmek isteyen �yenin objesini
	//yolluyorum.
	@Override
	public void changePassword(String password) {
		if(password.equals(member.getPassword())) {
			hibernateMemberDao.update(member);
		}
		
	}
	
	//Kullan�c� mail adresini de�i�tirmek isterse e�er eski mail adresini girmeli. Girdi�i de�er ile 
	//g�ncel mail adresi uyumlu ise mail adresi de�i�time i�lemeni ger�ekle�tirmek i�in veritaban�nda 
	//g�ncelleme i�lemlerini yapan metodu �a��r�yorum bu metodun alt�nda. Parametre olarak bu i�lemi 
	//ger�ekle�tirmek isteyen �yenin objesini yolluyorum.
	@Override
	public void changeMailAddress(String mailAddress) {
		if(mailAddress.equals(member.getMailAddress())) {
			hibernateMemberDao.update(member);
		}
		
	}

}