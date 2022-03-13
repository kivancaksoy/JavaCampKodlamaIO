package eCommerce;

import eCommerce.business.abstracts.UserService;
import eCommerce.business.concretes.UserCheckManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.business.concretes.VerificationManager;
import eCommerce.core.GoogleManagerAdapter;
import eCommerce.dataAccess.concretes.HibernateUserDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(), new UserCheckManager(), new VerificationManager(), new GoogleManagerAdapter());
		User user = new User(1, "Kývanç", "Aksoy", "kvnc.asdas@gmail.com", "Password1");
		User user2 = new User(2, "Kývanç2", "Aksoy2", "bgm.asdas@hotmail.com", "Password2");
				
		//userService.signUp(user);
		//userService.signUp(user2);
		userService.signIn("kvnc.asdas@gmail.com", "Password1", user);
	}

}
