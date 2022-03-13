package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface VerificationService {
	void sendToVerificationMail(User user);
	void verifyMail(User user);

}
