package nLayeredAssigmentForReturnPractice.Authentication;

import nLayeredAssigmentForReturnPractice.entities.concretes.User;

public class GoogleAuthManager implements AuthService {
	
	public void login(String email, String password) {
		System.out.println(email+" ile google �zerinden giri� yap�ld�.");
	}
	public void signup(String email, String password,User user) {
		System.out.println(email+" ile google �zerinden �ye olundu.");
	}

}
