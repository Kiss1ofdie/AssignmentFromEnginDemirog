
public class InstructorManager extends UserManager{
	
	public void startToCourse(String courseName) {
		System.out.println(courseName+" Kursu ba�lat�ld�.");
	}
	public void addToProgLanugage(String progLanguage) {
		System.out.println(progLanguage+" programlama dili eklendi");
	}
	public  void changeToProgLanguage(String progLanguage) {
		System.out.println(progLanguage+" programlama dili olarak de�i�tirildi");
	}
	public void addToBranch(String branch) {
		System.out.println(branch+" bran�lar�n�za eklendi");
	}
	public void changeToBranch(String branch){
		System.out.println(branch+" olarak bran��n�z de�i�tirildi.");
	}
	public void addToShortBio() {
		System.out.println("K�sa biyo�rafiniz eklendi.");
	}
	public void changeToShortBio() {
		System.out.println("K�sa biyo�rafiniz de�i�tirildi.");
	}
}
