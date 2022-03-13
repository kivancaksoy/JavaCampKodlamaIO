package eCommerce.business.abstracts;



import eCommerce.entities.concretes.User;

public interface UserCheckService {

	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkEmail(User user);
	boolean checkPassword(User user);
	boolean isCurrentEmail(User user);
	boolean isValidUser(User user); 
	
}
