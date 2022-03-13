package eCommerce.business.concretes;

import eCommerce.business.abstracts.VerificationService;
import eCommerce.entities.concretes.User;

public class VerificationManager implements VerificationService {

	@Override
	public void sendToVerificationMail(User user) {
		System.out.println(user.getEmail() + " adresine doðrulama e-postasý gönderildi.");
		
	}

	@Override
	public void verifyMail(User user) {
		System.out.println(user.getEmail() + " adresi doðrulandý.");
		
		
	}

	

}
