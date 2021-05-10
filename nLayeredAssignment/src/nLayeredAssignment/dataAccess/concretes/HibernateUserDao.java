package nLayeredAssignment.dataAccess.concretes;

import java.util.List;

import nLayeredAssignment.dataAccess.abstracts.UserDao;
import nLayeredAssignment.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName()+" Hibernate ile eklendi.");
		
	}

	@Override
	public void changeUserInfo(User user) {
		System.out.println(user.getFirstName()+" Adl� kullan�c�n�n bilgileri Hibernate ile de�i�tirildi");
		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName()+" Adl� kullan�c� Hibernate ile silindi.");
		
	}

	
	
	

}
