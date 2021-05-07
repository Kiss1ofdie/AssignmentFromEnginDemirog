package Entitites;

import java.util.ArrayList;

public class Campaign {
	private int id;
	private String name;
	private String detail;
	private int campaignDiscountPercent;
	private ArrayList<String> campaignedGame = new ArrayList<String>();
	//private boolean campaignPredicked;bu �ok detay �imdiki
	//donan�m�mla uygulayamayaca��m d�zeyde
	//data acces k�sm�n� g�rseydik String i game yap�p
	//game ekleyip ordan geri managerda game i s�ralat�rd�m ama
	//oray� tam anlam�yla g�rmedi�imiz i�in b�yle b�rak�yorum
	
	public Campaign() {
		
	}
	public Campaign(int id, String name, String detail, ArrayList<String> campaignedGame
			,int campaignDiscountPercent) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.campaignedGame = campaignedGame;
		this.campaignDiscountPercent = campaignDiscountPercent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public ArrayList<String> getCampaignedGame() {
		return campaignedGame;
	}
	public void setCampaignedGame(ArrayList<String> campaignedGame) {
		this.campaignedGame = campaignedGame;
	}
	public int getCampaignDiscountPercent() {
		return campaignDiscountPercent;
	}
	public void setCampaignDiscountPercent(int campaignDiscountPercent) {
		this.campaignDiscountPercent = campaignDiscountPercent;
	}
	
	
	
}
