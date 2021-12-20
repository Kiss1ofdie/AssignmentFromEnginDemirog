package nLayeredAssigmentForReturnPractice.dataAccess.abstracts;

import java.util.List;

import nLayeredAssigmentForReturnPractice.entities.concretes.User;

public interface UserDao {
	//DAO = data access object or it can use data access layer
	void add(User user);//sadece bu metotu yazaca��m 
	void update(User user);
	void delete(User user);
	User get(int userId);
	List<User> getAll();//b�t�n kullan�c�lar�n getirildi�i liste
	
	//buray� sadece sim�lasyon olarak kullan�yorum daha sql ile
	//�al��maya ba�lamad�k ��nk� sadece �ok katmanl� mimari
	//konseptini yakalabilmek i�in yap�yorum.
	
	
	
}
