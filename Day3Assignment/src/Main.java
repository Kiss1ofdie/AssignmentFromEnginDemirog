
public class Main {

	public static void main(String[] args) {//kodlar�n �al���p �al��mad���n�n denemesini yap�yorum 
		User user1 = new User();
		user1.set(1);
		user1.setaddress("�stanbul");
		user1.setcreditCard(new CreditCard("9999","Ahmet",999));
		user1.setemail("blablabla@gmail.com");
		user1.setfirstName("Ahmet");
		user1.setlastName("Y�ld�z");
		
		System.out.println(user1.getaddress());
		
		User user2 = new User(2,"Veli","Keskin","bla@gmail.com","�ank�r�",new CreditCard("9999","Veli",999));
		
		System.out.println(user2.getcreditCardOwnerName());
		
		Student student1 = new Student();
		student1.setemail("student@gmail.com");
		
		System.out.println(student1.getemail());
		
		Student student2 = new Student(4,"��renci","��renemeyen","bbbb@gmail.com", "Antalya",new CreditCard("1111","��renci",999),"Java and REACT kursu","Yaz�l�mc� community aboneli�i" );
		
		System.out.println(student2.getjoinedCourse());
		
		Instructor instructor1 = new Instructor();
		instructor1.setbranch("Frontend Developer");
		
		System.out.println(instructor1.getbranch());
		
		Instructor instructor2 = new Instructor(5,"Engin","Demiro�","Engindemirog@gmail.com","Ankara",new CreditCard("1111", "Engin", 999), "Java and React","C# , java and more","software consultant","blablabla");
		System.out.println(instructor2.getprogLanguage());
		
		
		UserManager userManager = new UserManager();
		userManager.addToCreditCard(new CreditCard("99999","Samet S�NMEZ",999));
		
		StudentManager studentManager = new StudentManager();
		studentManager.addToAddress();
		studentManager.addToCourse("C# Angular");
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.linkToMyTeachableAcc();
		instructorManager.addToProgLanugage("Java");
		
		
		
	}

}
