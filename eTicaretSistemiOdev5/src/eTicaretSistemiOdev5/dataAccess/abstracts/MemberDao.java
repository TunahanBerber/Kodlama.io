package eTicaretSistemiOdev5.dataAccess.abstracts;

import eTicaretSistemiOdev5.entities.abstracts.Entity;

public interface MemberDao {
	
	//Veri taban� i�lerini yapan class'�m�n ortak metodlar�n� bu interface sayesinde gruplam�� oldum.
	//Ortak metodlar�m parametre olarak Entity tipinde bir Member class'� al�yor.
	
	boolean add(Entity member);
	void update(Entity member);
	void delete(Entity member);

}