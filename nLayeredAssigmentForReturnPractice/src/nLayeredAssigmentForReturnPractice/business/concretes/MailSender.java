package nLayeredAssigmentForReturnPractice.business.concretes;

import nLayeredAssigmentForReturnPractice.business.abstracts.SenderServiceForVerification;
import nLayeredAssigmentForReturnPractice.entities.concretes.User;

public class MailSender implements SenderServiceForVerification {

	@Override
	public void send(User user) {
		System.out.println(user.getEmail()+" adresine �yelik do�rulama i�in e-mail g�nderildi.");
		
	}

	@Override
	public void verificationSuccesfulInfoSend(User user) {
		System.out.println(user.getFirstName()+" �yeli�i do�ruland�.");
		
	}

	
}
