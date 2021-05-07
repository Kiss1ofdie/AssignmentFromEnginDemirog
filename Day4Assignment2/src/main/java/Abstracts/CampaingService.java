package Abstracts;

import Entitites.Campaign;
import Entitites.Game;

public interface CampaingService {
	//bu classta biraz gereksiz gibi oldu ��nk� yap�lmak istenilen
	//yerlere direkt get set kullnarak bu de�i�iklikleri yapar�z
	//ama dao k�sm� i�in daha farkl� kodlar girilece�i i�in
	//ilerleyen a�amalarda b�yle kullanmal� olabilir SOR
	void addGameToCampaign(String gameName);
	void deleteGameFromCampaign(String gameName);
	void changeDiscountPercent(int discountPercent);
	void unitPriceWithCampaign(Game game);
	//void addCampaign(Campaign campaign);  a��klamay� manager da yapt�m
}
