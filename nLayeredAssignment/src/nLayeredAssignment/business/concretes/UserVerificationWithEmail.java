package nLayeredAssignment.business.concretes;

import nLayeredAssignment.business.abstracts.UserVerificationService;

public class UserVerificationWithEmail implements UserVerificationService {

	@Override
	public void sendVerification() {
		System.out.println("�yelik do�rulama linki emailinize g�nderildi.");
		
	}

	@Override
	public void completeVerification() {
		System.out.println("�yeli�iniz Email ile do�ruland�.");
		
	}

}
