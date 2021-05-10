package nLayeredAssignment.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import nLayeredAssignment.business.abstracts.AuthService;
import nLayeredAssignment.business.abstracts.UserService;
import nLayeredAssignment.business.abstracts.UserVerificationService;
import nLayeredAssignment.entities.concretes.User;

public class UserManager implements UserService {
	Scanner scn = new Scanner(System.in);
	AuthService authService;
	
	public UserManager(AuthService authService) {
		this.authService = authService;
	}
	UserVerificationService userVerification;
	public UserManager(UserVerificationService userVerification) {
		this.userVerification = userVerification;
	}
	

	public UserManager(AuthService authService, UserVerificationService userVerification, ArrayList<User> users) {
		this.authService = authService;
		this.userVerification = userVerification;
		this.users = users;
	}
	private User user;
	private ArrayList<User> users = new ArrayList<User>();
	@Override
	public void signUp(User user,List<User> users) {
	//parametre olarak �al���r m� kontrol etmek laz�m
		String nameRegex = "^(\\w{2,})$";
		Pattern pattern = Pattern.compile(nameRegex, Pattern.UNICODE_CHARACTER_CLASS);
		
		System.out.println("Ad�n�z� giriniz:");
		String firstName = scn.nextLine();
		if(pattern.matcher(firstName).matches()) {
			user.setFirstName(firstName);
		}
		else {
			System.out.println("Ge�ersiz ad girdiniz tekrar deneyiniz.");
			return;
		}
		
		
		System.out.println("Soyad�n�z� giriniz:");
		String lastName = scn.nextLine();
		if(pattern.matcher(lastName).matches()) {
			user.setLastName(lastName);
		}
		else {
			System.out.println("Ge�ersiz soyad girdiniz tekrar deneyiniz.");
			return;
		}
		
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(emailRegex, Pattern.UNICODE_CHARACTER_CLASS);
		System.out.println("Emailinizi giriniz:");
		String email = scn.nextLine();
		//email daha �nce kullan�lmam�� dalgas�==>
		boolean emailcheck=false;
				for (User user1 : users) {
					if(user1.getEmail().equals(email)) {
						System.out.println("Girmi� oldu�unuz email daha �nce kullan�lm��t�r.");
						emailcheck=true;
					}
				}
				if(emailcheck) {
					return;
				}
		if(pattern.matcher(email).matches()) {
			user.setEmail(email);
		}
		else {
			System.out.println("Ge�ersiz email girdiniz tekrar deneyiniz.");
			return;
		}
		
		String passwordRegex = "^(\\w{6,})$";
		pattern = Pattern.compile(passwordRegex, Pattern.UNICODE_CHARACTER_CLASS);
		System.out.println("�ifrenizi giriniz:");
		String password = scn.nextLine();
		if(pattern.matcher(password).matches()) {
			user.setPassword(password);
		}
		else {
			System.out.println("Ge�ersiz �ifre girdiniz.�ifre en az 6 haneli olmal�d�r.");
			return;
		}
		userVerification.sendVerification();
		userVerification.completeVerification();
		
		System.out.println("Kayd�n�z ba�ar�yla olu�turulmu�tur.");
		users.add(user);
	}
	
	@Override
	public void signUpWithGoogle(AuthService authManager) {
		//kodlar
		System.out.println("Google hesab� ba�ar�yla girildi.");
		authManager.authUserSuccesful();
		
	}
	/*
	//email ve password sorgusu i�in metot
	public String setEmail() {
		System.out.println("Emailinizi giriniz:");
		return scn.nextLine();
		}
	public String setPassword() {
		System.out.println("�ifrenizi giriniz:");
		return scn.nextLine();
	}*/
	@Override
	public void logIn(String email, String password) {
		//burda set li okuyan metot yapacakt�m ama �imdi
		//daha ger�ekci olsun diye ama bakt���m�zda
		//buras� direkt textbox a reference g�sterilece�i i�in
		//�yle bir metota da gerek yok �uan
		boolean loginCheck = true;
		for (User user2 : users) {
			if(user2.getEmail().equals(email) && user2.getPassword().equals(password)) {
				System.out.println("Giri� ba�ar�l�.");
				loginCheck = false;
			}
			
		}
		if(loginCheck) {
			System.out.println("Giri� ba�ar�s�z.Girmi� oldu�unuz bilgilerle e�le�en hesap yok. Tekrar deneyiniz.");
		}
		
	}
	
	

}
