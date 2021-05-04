package Entity;

import Abstract.GamerService;

import Entity.Gamer;

public class GamerManager implements GamerService {

	@Override
	public void add(Gamer gamer) {
		if(gamer.isValidation() == true ) {
			System.out.println("Oyuncu kaydý eklendi");
	}else {
		System.out.println("Oyuncu bilgileri doðrulanamadý.");
	}
}
	

	@Override
	public void update(Gamer gamer) {
		
		
	}

	@Override
	public void delete(Gamer gamer) {
		
		
	}

}
