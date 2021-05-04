package Concrete;

import Abstract.GameService;
import Entity.Gamer;
import Entity.Campaign;

public class GameManager implements GameService{

    @Override
    public void sell(Gamer gamer, Campaign campaign) {
        System.out.println("Oyun sat��� ger�ekle�ti : " + gamer.getFirstName());
        System.out.println("Oyun sat��� i�in ge�erli kampanya: " + campaign.getCampaingName());

    }

}