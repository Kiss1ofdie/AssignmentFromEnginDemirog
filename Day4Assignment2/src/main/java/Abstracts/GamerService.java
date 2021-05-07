package Abstracts;

import java.net.MalformedURLException;

import Entitites.CreditCard;
import Entitites.Gamer;

public interface GamerService {
	void addPerson(Gamer gamer) throws MalformedURLException;//do�rulama yapabilmemiz i�in burdan kay�tl�
	//do�rulama yap�p kaydece�iz
	void addPlusSubscription();
	void deletePlusSubscription(Gamer gamer);
	void addCreditCard(CreditCard creditCard);
	void changeCreditCard(CreditCard creditCard);
	void deleteCreditCard();
	
}
