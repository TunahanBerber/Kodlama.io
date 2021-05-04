package Concrete;

import Abstract.CampaignService;
import Entity.Campaign;

public class CampaignManager implements CampaignService{

	@Override
	public void add(Campaign campaign) {
		System.out.println("Kampanya Eklendi: " + campaign.getCampaingName());
		
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println("Kampanya Bilgileri G�ncellendi " + campaign.getCampaingName());
		
	}

	@Override
	public void delete(Campaign campaign) {
		System.out.println("Kampanya Silindi " + campaign.getCampaingName());
		
	}

}		
