package eTicaretSistemiOdev5.business.abstracts;



public interface MemberService {
	
	//Kullan�c�n�n login , �ifre de�i�tirme mail adresi de�i�tirme gibi metodlar�n� bu interface'in alt�nda gruplad�m.
	//Parametre olarak Entity tipinde Member class'�n� almad���n� �zellikle belirtmek isterim ��nk� bu i�lemlerde ki parametreleri kullan�c� sisteme 
	//girerken , �ifresini veya mail adresini de�i�tirirken kendisi input olarak girecek. Girdi�i inputlara g�re biz kullan�c�y� y�nlendirece�iz.
	
	void login(String password,String mailAddress);
	void changePassword(String password);
	void changeMailAddress(String mailAddress);
	
	
}