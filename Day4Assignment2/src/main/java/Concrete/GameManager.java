package Concrete;

import java.util.ArrayList;

import Abstracts.GameService;
import Entitites.Game;

public class GameManager implements GameService {
	Game game;
	//contructor blo�una parametre olarak game eklemem gerekir mi
	//constructor gerekiyor yoksa this. diyip burdakini de�i�trmeye
	//�al���yor ve burda herhangi bir de�er atanmad��� i�in 
	//error veriyor
	public GameManager(Game game) {
		this.game = game;
	}

	public void changeUnitPrice(double unitPrice) {
		game.setUnitPrice(unitPrice);
		System.out.println(game.getName()+" Oyunun fiyat� "+game.getUnitPrice()+" olarak de�i�tirildi");
		
	}

	public void changeAgeLimiter(int ageLimiter) {
		game.setAgeLimiter(ageLimiter);
		System.out.println(game.getName()+" Oyunun ya� limiti "+game.getAgeLimiter()+" olarak de�i�tirildi");
	}

	public void deleteAgeLimiter() {
		game.setAgeLimiter(200);
		System.out.println("Oyunun ya� limiti kald�r�ld�.");
		
	}
	
	public void addPlatforms(String platform) {
		ArrayList<String> platforms1= game.getPlatforms();
		platforms1.add(platform);
		game.setPlatforms(platforms1);
		System.out.println("Oyun "+platform+" platforma eklendi.");
	}
	
	public void changeCategory(String category) {
		game.setCategory(category);
		System.out.println("Oyunun kategorisi "+game.getCategory()+" olarak de�i�tirildi.");
		
	}

	
	

	

	
	

	

}
