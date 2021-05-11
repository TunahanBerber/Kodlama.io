package eTicaretSistemiOdev5.dataAccess.concretes;

import eTicaretSistemiOdev5.business.abstracts.ValidationService;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class HibernateMemberDao implements MemberDao{
	
	//Kendine kural edin baðýmlýlýktan kurtulmak adýna soldaki referans tutucu parametreler interface olsun!
	//Objen bir bilgi tutan sýnýf olsun , bir veritabaný iþi yapan class olsun, sisteme yönelik iþ kodlarýný
	//içeren bir sýnýf olsun yada validation doðrulama yapan bir class olsun özetle ne olursa olsun bu kuraldan
	//kaçma ileride kodumuza eklenecek durumlarda baðýmlýlýklarý gidermek adýna.
	
	//Kullancýnýn üye olurken girdiði parolayý mail adresini ismini ve soy ismini doðrulamadan veri tabanýna 
	//kaydetme iþleri yapmamalýyým. Bu doðrulama iþini oluþturduðum validation sýnýfý ile yapýyorum. Veri tabaný
	//iþlerinde doðrulama iþini aktif bir þekilde kullanacaðým için doðrulama sýnýfýný kullanmadan kullanýcýyý 
	//veritabanýna kaydetmemek adýna constructor injection yöntemi ile veritabaný iþlerini yaptýðým HibernateMemberDao
	//sýnýfýnýn ValidationManager sýnýfýný kullanmasýný zorunlu kýldým. Main'de HibernateMemberDao newlendiði anda
	//parametre olarak ValidationService tipinde bir Validation sýnýfý isteyecek.
	ValidationService validationManager;
	
	public HibernateMemberDao(ValidationService validationManager) {
		super();
		this.validationManager = validationManager;
	}
	
	//ÇOK ÖNEMLÝ
	//Bu fonksiyonun boolean deger dondurmesinin sebebi þu benim kullanýcým sisteme baþarýlý bir þekilde üye olup kayýt olabildiyse
	//eðer true dönüyor, olamadýysa mail adresi, ismi, soyisimi, parolasý istenilen þartlarý saðlamadýysa eðer kullancý üye
	//olamayor ve ben bu kullanýcýyý veritabanýba eklemiyorum. Deðer döndürmemde ki amaç Mainde veritabanýna eklenmeyen kullancýnýn 
	//login olmamasýný saðlamak. Buradan dönen deðerleri ben MemberManager içerisinde ki login metodunda kullanýp üye olamamýþ 
	//kullanýcýnýn simülasyonda login olmasýný engelleyeceðim. Bunu veritabanýndan ekleme yaðtýðým yerde yapmak zorundayým çünkü
	//elimde gerçek bir veri yok tamamen simülasyon yapýyorum. Eðer elimde gerçek veri olsaydý bu class'ýn altýnda bir metod
	//oluþturup veritabanýn içersinden kullancý þifrelerini ve mail adreslerini çeken ve kullanýcýnýn girdiði parametrelere göre 
	//kýyaslayýp burada gönderdiðim parametrelerin veritabanýnda olmasý dahilinde true dönen , olmamasý durumunda false dönen bir
	//metod tasarlardým. Bu metoddan dönen deðeri de MemberManager altýnda ki login fonksiyonunun altýnda deðerlendirip üye olmayan
	//kullanýcýnýn login olmasýný engellerdim. Simülasyon yaptðýmýz için ve elimizde gerçek bir veri olmadýðý için böyle bir yönteme
	//gidildi. Gerçek bir sistemde elimizde veri varken veritabaný varken böyle bir yol izlemek çok büyük ve saçma bir hataya sebebiyet
	//verirdi çünkü ben bu yöntemle her login iþleminde add metodunun altýnda kullanýcý ekleyerek login olmak isteyen kullanýcýnýn veritabanýnda
	//olup olmadýðýný yokluyorum. Elimizde veri olmadýðý için ve simülasyon yaptýðýmýz için bu yöntem tercih edildi. Aþaðýdaki ifler göze
	//spagetti gibi gelebilir ama bundan baþka yol yok kullanýcý üye olurken 4 farklý parametreyi doðru girdiyse veritabanýna eklenmeli.
	//Tek bir if'in altýnda yapýlabilirdi ama kullanýcý hangi parametreyi yanlýþ giriyorsa o yönde bilgilendirme alsýn istedim.
	@Override
	public boolean add(Entity member) {
		
		if(!validationManager.validateName(member.getName())) {
			System.out.println("Kullanýcý adý 2 karakterden fazla olmalý!");
			return false;
		}
		else if(!validationManager.validatePassword(member.getPassword())) {
			System.out.println("Kullanýcý þifresi en az 6 karakterden oluþmalý!");
			return false;
		}
		else if(!validationManager.validateSurname(member.getSurname())) {
			System.out.println("Kullanýcý soyadý 2 karakterden fazla olmalý!");
			return false;
		}
		else if(!validationManager.validateMailAddress(member.getMailAddress())) {
			System.out.println("Geçersiz mail adresi!");
			return false;
		}
		else if(validationManager.validateIsClicked(!member.isClicked())) {
			System.out.println("Kullanýcý e-posta doðrulama linkine týklamadý!");
			return false;
		}
		else {
			//Yukarýdaki tüm þartlar saðlanmýyorsa eðer kullanýcý parolasýný mail adresini , ismini ve soyismini 
			//sistemde istenilen þekilde girmiþ demektir. Bu durumda ben veri tabanýna kullanýcýmý kaydetme iþlerini burada yapacaðým.
			
			System.out.println("Veri tabanýna eklendi : "+member.getName());
			return true;
		}
		
	}
	
	//Veritabanýnda güncelleme iþleri bu metodun altýnda yapýlacak.
	@Override
	public void update(Entity member) {
		
		System.out.println("Veri tabanýnda güncellendi : "+member.getName());
	}
	
	//Veritabanýndan kullanýcý silme iþleri bu metodun altýnda yapýlacak.
	@Override
	public void delete(Entity member) {
		
		System.out.println("Veri tabanýndan silindi : "+member.getName());
	}

}