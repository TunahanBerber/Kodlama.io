package eTicaretSistemiOdev5.business.concretes;

import eTicaretSistemiOdev5.business.abstracts.MemberService;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class MemberManager implements MemberService{
	
	//Bu class'ýn altýnda üyelik ile ilgili iþlemleri gerçekleþtirdik ve üyelikle ilgili metodlarý yazdýk.
	//Üyelikle ilgili metodlar Entity tipinde bir Member sýnýfýna ve MemberDao tipinde bir veritabaný iþi
	//yapan sýnýfa ihtiyaç duyuyordu. Bu 2 sýnýf olmadan üyelikle ilgili iþlemlerin yapýlmasý mümkün 
	//olmadýðýdan Main'de MemberManager newlenirken bu 2 sýnýfýn zorunlu olarak istenmesini constructor
	//injection ile mümkün kýldýk.
	
	//Protected özelliði atanan bir deðiþken veya metot, sadece bulunduðu sýnýf içerisinden veya bulunduðu sýnýfý 
	//extend eden sýnýf içerisinden eriþilebilir. Bu sýnýfý extend eden GoogleAccountManagerAdapter sýnýfý baþka 
	//bir paketin altýnda olduðu için bu parametreleri protected yapmak zorunda kaldýk.
	protected Entity member;
	protected MemberDao hibernateMemberDao;
	
	public MemberManager(Entity member, MemberDao hibernateMemberDao) {
		super();
		this.member = member;
		this.hibernateMemberDao = hibernateMemberDao;
	}
	
	//ÇOK ÖNEMLÝ
	//Login iþlemlerini login metodumla yapýyorum. En içteki lojiklerle(if else if else) kullancýnýn login olurken 
	//doðru þifre ve mail adresi girip girmediðini kontrol ediyorum. Kullancý doðru mail adresini ve þifreyi 
	//girdiðinde kullancý baþarýlý bir þekilde login iþlemini gerçekleþtirmiþ oluyor. Kullanýcýnýn veritabanýna 
	//eklenmeden login olamamasýný saðlamak adýna dýþtaki if'de ise kullancýnýn veritabanýna eklenmesi dahilinde
	//kullanýcýnýn doðru bir þekilde login olup olmadýðýnýn testinin yapýlmasýný saðladým. Yani kullancý veritabanýna
	//eklenmediyse üye olmadýysa girilen mail ve þifrenin doðruluðunu test etmeden böyle bir kullanýcý yok sistemde
	//kayýtlý deðil uyarýsý veriyorum. Bu durumu hibernateMemberDao.add metodunun altýnda yapmamýn sebebi þu hibernateMemberDao.add
	//metodunun altýnda kullanýcý baþarýlý bir þekilde kayýt olduysa true , olamadýysa false dönen iþlemler yapmýþtým.
	//Bu iþlemleri add metodunun altýnda yapmamýn sebebi elimizde bir veritabaný olmamasý ve burada tasarlanan sistemin
	//bir simülasyon olmasý eðer elimizde bir veri olsaydý HibernateMemberDao'da veritabanýn içersinden kullancý þifrelerini
	//ve mail adreslerini çeken ve burada gönderdiðim parametrelere göre kýyaslayýp burada gönderdiðim parametrelerin 
	//veritabanýnda olmasý dahilinde true dönen , olmamasý durumunda false dönüp en dýþtakýi else'deki uyarýyý veren 
	//bir metod tasarlayacaktým.(hibernateMemberDao.add(member) yerine benimyazdigimmetod(member) olacaktý.) 
	//Simülasyon yapmamýmýz ve elimde veritabaný olmamasý böyle bir durumu ortaya çýkardý. Elimizde
	//gerçek bir veri tabaný olsaydý eðer bu yöntem yanlýþ olacaktý çünkü ben her login iþleminde yanlýþlýkla ve veritabanýna
	//kullanýcýyý eklemiþ olacaktým. Bu da gerçek bir sistem için çok saçma ve çok büyük bir hata.
	@Override
	public void login(String mailAddress,String password) {
		// TODO Auto-generated method stub
	if(hibernateMemberDao.add(member)) {
		if(password.equals(member.getPassword()) && mailAddress.equals(member.getMailAddress())) {
			System.out.println("Kullanýcý baþarýlý bir þekilde login oldu.");
		}
		else if(!password.equals(member.getPassword()) && !mailAddress.equals(member.getMailAddress())) {
			System.out.println("Login iþlemi sýrasýnda mail adresi ve þifre yanlýþ girildi!");
		}
		else if(!password.equals(member.getPassword())){
			System.out.println("Login iþlemi sýrasýnda þifre yanlýþ girildi!");
		}
		else if(!mailAddress.equals(member.getMailAddress())){
			System.out.println("Login iþlemi sýrasýnda mail adresi yanlýþ girildi!");
		}
	}
	else {
		System.out.println("Sistemde kayýtlý böyle bir kullanýcý yok!");
	}
	
	}
	
	//Kullanýcý þifresini deðiþtirmek isterse eðer eski þifresini girmeli. Girdiði deðer ile 
	//güncel þifresi uyumlu ise þifre deðiþtime iþlemeni gerçekleþtirmek için veritabanýnda güncelleme iþlemlerini
	//yapan metodu çaðýrýyorum bu metodun altýnda. Parametre olarak bu iþlemi gerçekleþtirmek isteyen üyenin objesini
	//yolluyorum.
	@Override
	public void changePassword(String password) {
		if(password.equals(member.getPassword())) {
			hibernateMemberDao.update(member);
		}
		
	}
	
	//Kullanýcý mail adresini deðiþtirmek isterse eðer eski mail adresini girmeli. Girdiði deðer ile 
	//güncel mail adresi uyumlu ise mail adresi deðiþtime iþlemeni gerçekleþtirmek için veritabanýnda 
	//güncelleme iþlemlerini yapan metodu çaðýrýyorum bu metodun altýnda. Parametre olarak bu iþlemi 
	//gerçekleþtirmek isteyen üyenin objesini yolluyorum.
	@Override
	public void changeMailAddress(String mailAddress) {
		if(mailAddress.equals(member.getMailAddress())) {
			hibernateMemberDao.update(member);
		}
		
	}

}