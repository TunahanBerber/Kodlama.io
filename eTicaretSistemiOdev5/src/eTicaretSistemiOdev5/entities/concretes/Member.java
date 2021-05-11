package eTicaretSistemiOdev5.entities.concretes;

import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class Member implements Entity{
	
	//Sisteme �ye olacak kullan�c�n�n �zelliklerini ve �zelliklerin getterlar�n� i�erkmektedir.
	//Entity interface'ini implemente edip ileride do�acak olan ba��ml�l�k problemlerinin �n�ne 
	//ge�tik. Member class'�n�n kullan�ld��� t�m classlarda Member s�n�f�n�n referans�n� Entity 
	//interface'i tutmakta. Bu sayede ileride Entity s�n�f�n� implemente eden farkl� classlar 
	//kodlar�m�zda bulunan t�m classlarda rahatl�kla kullan�labilecek ve kod de�i�ikli�ine gidilmeyecek
	//Yap�lmas� gereken tek de�i�iklik Main'de Member class'�n� newlemek yerine Entity interface'ini
	//implemente eden farkl� bir s�n�f� newlemek olacak. Farkl� bir Member class'�dan kast edilen 
	//�u anki Member class'�m ile ayn� �zelliklere sahip bir class. Peki bunu neden yap�yoruz 
	//ayn� �zelliklere sahipse e�er benim yeni Member class'�m ? �undan dolay� yeni Member class'� 
	//kendi i�inde ekstra �zelliklere veya �zelliklerden ba��ms�z metodlara sahip olabilir.
	//Ortak metodlar� Entity'i implemente ederek override etmek zorunda kal�cak. Ortak metodlar�
	//unutmak gibi bir durum olmayacak ve ben interface'imle ortak metodlar� gruplam�� olaca��m.
	//Her yeni bir Member class'� t�redi�inde Entity'i implemente ederek ortak metodlar� kullanmas�
	//ka��n�lmaz olacak ve dahada �nemlisi tek de�i�iklik Main'de ger�ekle�ecek. Di�er classlarda
	//Entity tipinde kullan�ld��� i�in Member classlar�m ve yeni Member class'�mda Entity'i implemente
	//ederek Entity tipinde olaca��ndan di�er classlarda de�i�ikli�e gidilmeyecek sadece Mainde eski
	//Member class'�n� newlemek yerine yeni Member class'� newlenecek.
	
	//Burada isClicked �zelli�ine dikkat �ekmek istiyorum. ��nk� kullan�c� do�rulama linkine t�klad���
	//zaman �ye olma durumunun ger�ekle�ti�ini s�yleyen bir �art�m�z var. �uan elimizde ger�ek bir
	//veri ve kullan�c� aksiyonu olmad��� i�in kullan�c�n�n do�rulama linkine t�klama durumunu burada
	//bir �zellik olarak verdim. Mainde yapaca��m�z �e�itli senaryolara g�re bu �zelli�e true
	//de�eri g�nderdi�imizde kullan�c�n�n linke t�klad���n� , false de�eri g�nderdi�imizde linke t�klamad���n�
	//d���n�p buna g�re di�er classlarda kodlar�m� tasarlad�m.
	
	private String name;
	private String surname;
	private String password;
	private String mailAddress;
	private boolean isClicked;
	
	public Member(String name, String surname, String password, String mailAddress, boolean isClicked) {
		
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.mailAddress = mailAddress;
		this.isClicked = isClicked;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPassword() {
		return password;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public boolean isClicked() {
		return isClicked;
	}

	

}