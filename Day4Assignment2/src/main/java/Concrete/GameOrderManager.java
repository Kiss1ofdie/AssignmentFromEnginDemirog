package Concrete;

import java.util.ArrayList;

import Abstracts.GameOrderService;
import Entitites.Game;
import Entitites.Gamer;

public class GameOrderManager implements GameOrderService {
	ArrayList<Game> cart = new ArrayList<Game>();
	
	public GameOrderManager(ArrayList<Game> cart) {
		this.cart= cart;
		
	}
	

	public void addToCart(Game game) {
		cart.add(game);
		System.out.println(game.getName()+" sepete eklendi.");
	}

	public void clearToFormCart() {
		cart.clear();
		System.out.println("Sepet s�f�rland�.");
	}

	public void buyToCart() {
		System.out.print("Sepetteki oyunlar al�nd� :");
		for (Game game : cart) {
			System.out.print(game.getName()+"\t");
		}
		System.out.println();
		
	}

	public void deleteFormCart(Game game) {
		System.out.println(game.getName()+" Sepetten ��kar�ld�.");
		
	}

	public void showToCart() {
		System.out.println("Sepetteki oyunlar:");
		for (Game game : cart) {
			System.out.print(game.getName()+"\t");
		}
		System.out.println();
	}

}
