package Concrete;

import Abstract.GameService;
import Entity.Gamer;
import Entity.Campaign;

public class GameManager implements GameService{

    @Override
    public void sell(Gamer gamer, Campaign campaign) {
        System.out.println("Oyun satýþý gerçekleþti : " + gamer.getFirstName());
        System.out.println("Oyun satýþý için geçerli kampanya: " + campaign.getCampaingName());

    }

}