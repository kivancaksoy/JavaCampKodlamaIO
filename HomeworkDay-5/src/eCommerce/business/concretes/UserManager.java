package eCommerce.business.concretes;

import eCommerce.business.abstracts.UserCheckService;
import eCommerce.business.abstracts.UserService;
import eCommerce.business.abstracts.VerificationService;
import eCommerce.core.OtherService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private UserCheckService userCheckService;
	private VerificationService verificationService;
	private OtherService otherService;
	


	public UserManager(UserDao userDao, UserCheckService userCheckService, VerificationService verificationService, OtherService otherService) {
		super();
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.verificationService = verificationService;
		this.otherService = otherService;
	}


	@Override
	public void signUp(User user) {
		if(userCheckService.isValidUser(user)) {
			verificationService.sendToVerificationMail(user);
			verificationService.verifyMail(user);
			this.userDao.add(user);
			otherService.signUp("Google ile kayýt yapýldý.");
		} else {
			System.out.println("Kayýt baþarýsýz!");
		}
		
		
		
	}

	//düzenlenebilir!
	@Override
	public void signIn(String email, String password, User user) {
		if(email == null || password == null) {
			System.out.println("Email ve password zorunludur!");
		} else if(email == user.getEmail() && password == user.getPassword()) {
			System.out.println("Giriþ baþarýlý!");
			if (email.contains("@gmail.com")) {
				otherService.signIn("Google ile giriþ yapýldý.");
			}
			
		} else {
			System.out.println("email veya password hatalý!");
		}
	}



}
