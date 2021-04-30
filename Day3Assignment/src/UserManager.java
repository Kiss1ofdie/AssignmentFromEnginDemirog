
public class UserManager {
	public void addToCreditCard(CreditCard creditCard) {
		System.out.println("Say�n "+creditCard.ownerFullName+" kredi kart� bilgileriniz eklendi.");
	}
	public void changeToCreditCard(CreditCard creditCard) {
		System.out.println("Say�n "+creditCard.ownerFullName+" kredi kart� bilgileriniz kaydedildi.");
	}
	public void addToAddress() {
		System.out.println("Adres bilgileriniz eklendi.");
	}
	public void changeToAddress() {
		System.out.println("Adres bilgileriniz de�i�tirildi.");
	}
	public void saveToInfoPreferences() {
		System.out.println("Bilgilendirme tercihleri kaydedildi.");
	}
	public void linkToMyTeachableAcc() {
		System.out.println("Myteachable hesab�n�z ba�land�.");
	}
	public void unlinkToMyTeachableAcc() {
		System.out.println("Myteachable hesab�n�z�n ba�lant�s� kald�r�ld�.");
	}
	
}
