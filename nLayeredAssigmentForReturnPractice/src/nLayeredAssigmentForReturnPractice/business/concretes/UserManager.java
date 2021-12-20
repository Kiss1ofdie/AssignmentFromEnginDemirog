package nLayeredAssigmentForReturnPractice.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import nLayeredAssigmentForReturnPractice.Core.Adapters.AuthServiceAdapter;
import nLayeredAssigmentForReturnPractice.business.abstracts.SenderServiceForVerification;
import nLayeredAssigmentForReturnPractice.business.abstracts.UserService;
import nLayeredAssigmentForReturnPractice.dataAccess.abstracts.UserDao;
import nLayeredAssigmentForReturnPractice.entities.concretes.User;

public class UserManager implements UserService {
	//private ArrayList<User> users = new ArrayList<User>();
	//Mant�ken bunu d��arda tutmal�y�m ��nk� �rne�in==>User arraylist i
	//UserManager class � �a��rd�k bu mailSender ve facebookAuth kullan�yor
	//kullan�c�y� olu�turdu yeni arraylist olu�turdu bunda bilgisini tuttu
	//�imdi biz smsSender ve googleAuth kullanmak istiyoruz bu class�
	//tekrar �a��raca��z o zaman ba�ka bir class �rne�i olu�turdu�umuz
	//i�in bamba�ka bir arraylist tutacak bunu istemiyorum b�t�n userlar�n
	//ortak tutuldu�u arraylist istiyoruz o y�zden bunu mainde �a��r�r�m
	//zaten sqle ge�ince bunlar� direkt sql de yapaca��z.
	
	AuthServiceAdapter authServiceAdapter;
	SenderServiceForVerification senderServiceForVerification;
	UserDao userDao;
	
	public UserManager(AuthServiceAdapter authServiceAdapter, SenderServiceForVerification senderServiceForVerification, UserDao userDao) {
		this.authServiceAdapter = authServiceAdapter;
		this.senderServiceForVerification = senderServiceForVerification;
		this.userDao = userDao;
	}
	
	
	
	@Override
	public void signUp(User user, List<User> users) {
		String nameRegex = "^\\p{L}{2,}$";
		String emailRegex = "^([\\p{L}\\d(?=\\S+$)\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?$";
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(.*[@#$%^&+=])?(?=\\S+$).{6,}$";
		Pattern pattern = Pattern.compile(nameRegex, Pattern.UNICODE_CHARACTER_CLASS);
		//Gereken regex kodlar�m�z
		//regex kodlar�nda regex101 sitesinde /b�yle �al���yor
		//kodda ise //b�yle okuyor 
		//kodda // olunca okumuyor de�il java dili b�yle �al���yor
		//o y�zden // b�yle kals�n / b�yle de�il.
		if(!pattern.matches(nameRegex, user.getFirstName())) {
			System.out.println("Kullan�c� ad� ge�erli de�il.L�tfen ge�erli bir ad giriniz.");
			return ;
		}
		else if(!pattern.matches(nameRegex, user.getLastName())) {
			System.out.println("Kullan�c� soyad� ge�erli de�il. L�tfen ge�erli bir soyad giriniz.");
			return ;
		}
		
		boolean checkEmail = true;
		for (User user2 : users) {
			if(user.getEmail()==user2.getEmail()) {
				checkEmail = false;
			}
		}
		
		if(!checkEmail) {
			System.out.println("Girilen e-mail daha �nce kullan�lmam�� olmal�.L�tfen daha �nce kullan�lmam�� e-mail giriniz.");
			return ;
		}
		else if(!pattern.matches(emailRegex, user.getEmail())) {
			System.out.println("Girmi� oldu�unuz e-mail ge�erli de�il.L�tfen ba�ka bir e-mail giriniz.");
			return ;
		}
		else if(!pattern.matches(passwordRegex, user.getPassword())) {
			System.out.println("Girmi� oldu�unuz �ifre ge�erli de�il."
					+ "�ifre en az 6 karakterden ve bir k���k bir b�y�k harf ve"
					+ "rakam i�ermek zorundad�r."
					+ "L�tfen ge�erli bir �ifre giriniz.");
			return ;
		}
		
		senderServiceForVerification.send(user);
		senderServiceForVerification.verificationSuccesfulInfoSend(user);
		
		users.add(user);
		userDao.add(user);
		//bunlar� yapt�ktan sonra gerek olmad���n� d���n�yorum
		//mainde testten sonra tekrar bir bakar�m e�er hata varsa
		//user li newletece�iz nas�l olacak tam bilmiyorum
		//yeni user i users(arraylist)e ekleyece�iz
	}

	@Override
	public void login(String email, String password, List<User> users) {
		
		boolean check=false;
		for (User user : users) {
			if((email == user.getEmail()) && (password == user.getPassword()))
				check = true;
			
		}

		if(check)
				System.out.println("Giri� ba�ar�l�.");
		else
				System.out.println("B�yle bir hesap bulunmamaktad�r.L�tfen bilgilerinizi kontrol edip tekrar deneyiniz.");
			
		
				
		
		
	}

	@Override
	public void signUpWithAnotherApp(String email, String password,User user, List<User> users) {
		String nameRegex = "^\\p{L}{2,}$";
		String emailRegex = "^([\\p{L}\\d(?=\\S+$)\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?$";
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(.*[@#$%^&+=])?(?=\\S+$).{6,}$";
		Pattern pattern = Pattern.compile(nameRegex, Pattern.UNICODE_CHARACTER_CLASS);
		//Gereken regex kodlar�m�z
		
		if(!pattern.matches(nameRegex, user.getFirstName())) {
			System.out.println("Kullan�c� ad� ge�erli de�il.L�tfen ge�erli bir ad giriniz.");
			return ;
		}
		else if(!pattern.matches(nameRegex, user.getLastName())) {
			System.out.println("Kullan�c� soyad� ge�erli de�il. L�tfen ge�erli bir soyad giriniz.");
			return ;
		}
		
		boolean checkEmail = true;
		for (User user2 : users) {
			if(user.getEmail()==user2.getEmail()) {
				checkEmail = false;
			}
		}
		
		if(!checkEmail) {
			System.out.println("Girilen e-mail daha �nce kullan�lmam�� olmal�.L�tfen daha �nce kullan�lmam�� e-mail giriniz.");
			return ;
		}
		else if(!pattern.matches(emailRegex, user.getEmail())) {
			System.out.println("Girmi� oldu�unuz e-mail ge�erli de�il.L�tfen ba�ka bir e-mail giriniz.");
			return ;
		}
		else if(!pattern.matches(passwordRegex, user.getPassword())) {
			System.out.println("Girmi� oldu�unuz �ifre ge�erli de�il."
					+ "�ifre en az 6 karakterden ve bir k���k bir b�y�k harf ve"
					+ "rakam i�ermek zorundad�r."
					+ "L�tfen ge�erli bir �ifre giriniz.");
			return ;
		}
		
		senderServiceForVerification.send(user);
		senderServiceForVerification.verificationSuccesfulInfoSend(user);
		
		users.add(user);
		userDao.add(user);
		
		authServiceAdapter.signup(email, password, user);
		
	}

	@Override
	public void loginUpWithAnotherApp(String email, String password, List<User> users) {
		boolean check=false;
		for (User user : users) {
			if((email == user.getEmail())&& (password == user.getPassword())) {
				check = true;
			}
		}
		if(check)
			authServiceAdapter.login(email, password);
		else
			System.out.println("B�yle bir hesap bulunmamaktad�r.L�tfen bilgilerinizi kontrol edip tekrar deneyiniz.");
		
	}
	
	
	
	
	
	
	

}
