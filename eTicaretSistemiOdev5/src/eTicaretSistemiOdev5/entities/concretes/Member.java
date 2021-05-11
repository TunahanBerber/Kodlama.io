package eTicaretSistemiOdev5.entities.concretes;

import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class Member implements Entity{
	
	//Sisteme üye olacak kullanýcýnýn özelliklerini ve özelliklerin getterlarýný içerkmektedir.
	//Entity interface'ini implemente edip ileride doðacak olan baðýmlýlýk problemlerinin önüne 
	//geçtik. Member class'ýnýn kullanýldýðý tüm classlarda Member sýnýfýnýn referansýný Entity 
	//interface'i tutmakta. Bu sayede ileride Entity sýnýfýný implemente eden farklý classlar 
	//kodlarýmýzda bulunan tüm classlarda rahatlýkla kullanýlabilecek ve kod deðiþikliðine gidilmeyecek
	//Yapýlmasý gereken tek deðiþiklik Main'de Member class'ýný newlemek yerine Entity interface'ini
	//implemente eden farklý bir sýnýfý newlemek olacak. Farklý bir Member class'ýdan kast edilen 
	//þu anki Member class'ým ile ayný özelliklere sahip bir class. Peki bunu neden yapýyoruz 
	//ayný özelliklere sahipse eðer benim yeni Member class'ým ? Þundan dolayý yeni Member class'ý 
	//kendi içinde ekstra özelliklere veya özelliklerden baðýmsýz metodlara sahip olabilir.
	//Ortak metodlarý Entity'i implemente ederek override etmek zorunda kalýcak. Ortak metodlarý
	//unutmak gibi bir durum olmayacak ve ben interface'imle ortak metodlarý gruplamýþ olacaðým.
	//Her yeni bir Member class'ý türediðinde Entity'i implemente ederek ortak metodlarý kullanmasý
	//kaçýnýlmaz olacak ve dahada önemlisi tek deðiþiklik Main'de gerçekleþecek. Diðer classlarda
	//Entity tipinde kullanýldýðý için Member classlarým ve yeni Member class'ýmda Entity'i implemente
	//ederek Entity tipinde olacaðýndan diðer classlarda deðiþikliðe gidilmeyecek sadece Mainde eski
	//Member class'ýný newlemek yerine yeni Member class'ý newlenecek.
	
	//Burada isClicked özelliðine dikkat çekmek istiyorum. Çünkü kullanýcý doðrulama linkine týkladýðý
	//zaman üye olma durumunun gerçekleþtiðini söyleyen bir þartýmýz var. Þuan elimizde gerçek bir
	//veri ve kullanýcý aksiyonu olmadýðý için kullanýcýnýn doðrulama linkine týklama durumunu burada
	//bir özellik olarak verdim. Mainde yapacaðýmýz çeþitli senaryolara göre bu özelliðe true
	//deðeri gönderdiðimizde kullanýcýnýn linke týkladýðýný , false deðeri gönderdiðimizde linke týklamadýðýný
	//düþünüp buna göre diðer classlarda kodlarýmý tasarladým.
	
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