package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface UserService {
	void signUp(User user);
	void signIn(String email, String password, User user);

}
