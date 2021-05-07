package Concrete;

import java.util.ArrayList;

import Abstracts.CampaingService;
import Entitites.Campaign;
import Entitites.Game;

public class CampaignManager implements CampaingService {
	
	Campaign campaign;
	//contructor blo�una parametre olarak game eklemem gerekir mi
	/*
	public void addCampaign(Campaign campaign) {
		//buray� d�zenle kampanya ko�ulu tan�mlamada yazmal� 
		//yani detail de e�er o �art� sa�l�yorsa true a d�nd�recek.
		//�art her kampanya da de�i�ece�i i�in onu o kampanyaya �zg� tan�mlamal�y�z.
		//yani x kampanyas�n�n add metodu diye bu nas�l olacak
		//bunu yapamad���m i�in sal�yorum bu metodu
		
	}
	*/
	public void addGameToCampaign(String gameName) {
		ArrayList<String> campaignedGames1 = new ArrayList<String>();
		campaignedGames1.add(gameName);
		campaign.setCampaignedGame(campaignedGames1);
		System.out.println(gameName+" Kampanyaya eklendi.");
		
	}

	public void deleteGameFromCampaign(String gameName) {
		System.out.println(gameName+" Kampanyadan ��kar�ld�.");
		
	}

	public void changeDiscountPercent(int discountPercent) {
		campaign.setCampaignDiscountPercent(discountPercent);
		System.out.println("Kampanya indirim y�zdesi :%"+discountPercent+" olarak de�i�tirildi.");
		
	}

	public void unitPriceWithCampaign(Game game) {
		double unitPrice = game.getUnitPrice();
		unitPrice = unitPrice * ((100-campaign.getCampaignDiscountPercent())/100);
		game.setUnitPrice(unitPrice);
		
	}

}
