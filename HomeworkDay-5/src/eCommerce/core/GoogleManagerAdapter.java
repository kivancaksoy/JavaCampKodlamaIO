package eCommerce.core;

import eCommerce.GoogleAccount.GoogleManager;

public class GoogleManagerAdapter implements OtherService{

	@Override
	public void signUp(String message) {
		GoogleManager googleManager = new GoogleManager();
		googleManager.signUp(message);
		
	}

	@Override
	public void signIn(String message) {
		GoogleManager googleManager = new GoogleManager();
		googleManager.signIn(message);
		
	}
	

}
