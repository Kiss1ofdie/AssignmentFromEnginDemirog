package Concrete;

import java.net.MalformedURLException;

import Abstracts.GamerCheckService;
import Abstracts.GamerService;
import Entitites.CreditCard;
import Entitites.Gamer;

public class BaseGamerManager implements GamerService {
	
	//contructor blo�una parametre olarak game eklemem gerekir mi
	private Gamer gamer;
	
	private GamerCheckService gamerCheckService;
	public BaseGamerManager(GamerCheckService gamerCheckService) {
		this.gamerCheckService = gamerCheckService;
	}
	
	public void addPerson(Gamer gamer) throws MalformedURLException {
		if(gamerCheckService.tcKimlikNoSorgula(gamer)) {
			System.out.println(gamer.getFirstName()+" sisteme Kaydedildi");
		}
		else {
			System.out.println("B�yle biri yok.");
		}
		
	}
	//buras� biraz sa�ma oldu ama sor bi
	//managerde ekstra tan�mlamak gerekiyor mu yoksa
	//zaten get ve setler bu i�lemleri yap�yorlar
	public void addPlusSubscription() {
		gamer.setPlusSubscription(true);
		System.out.println("Plus �yeli�i ba�lat�ld�.");
	}

	public void deletePlusSubscription(Gamer gamer) {
		gamer.setPlusSubscription(false);
		System.out.println("Plus �yeli�i iptal edildi.");
	}

	public void addCreditCard(CreditCard creditCard) {
		gamer.setCreditCard(creditCard);
		System.out.println("Kredi kart� eklendi");
	}

	public void changeCreditCard(CreditCard creditCard) {
		gamer.setCreditCard(creditCard);
		System.out.println("Kredi kart� bilgileri de�i�tirildi.");
		
	}

	public void deleteCreditCard() {
		System.out.println("Kredi kart� bilgileri silindi");
		
	}

}
