package eTicaretSistemiOdev5.dataAccess.abstracts;

import eTicaretSistemiOdev5.entities.abstracts.Entity;

public interface MemberDao {
	
	//Veri tabaný iþlerini yapan class'ýmýn ortak metodlarýný bu interface sayesinde gruplamýþ oldum.
	//Ortak metodlarým parametre olarak Entity tipinde bir Member class'ý alýyor.
	
	boolean add(Entity member);
	void update(Entity member);
	void delete(Entity member);

}