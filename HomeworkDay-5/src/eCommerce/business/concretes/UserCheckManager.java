package eCommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import eCommerce.business.abstracts.UserCheckService;
import eCommerce.entities.concretes.User;

public class UserCheckManager implements UserCheckService {
	List<String> emailList = new ArrayList<String>();
	

	@Override
	public boolean checkFirstName(User user) {
		if (user.getFirstName().length() > 1) {
			return true;
		} else {
			System.out.println("Ýsim en az 2 karakterden oluþmalýdýr!");
			return false;
		}
		
	}

	@Override
	public boolean checkLastName(User user) {
		if (user.getLastName().length() > 1) {
			return true;
		} else {
			System.out.println("Soyad en az 2 karakterden oluþmalýdýr!");
			return false;
		}
		
	}

	@Override
	public boolean checkEmail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		
		if (pattern.matcher(user.getEmail()).find()) {
			return true;
		} else {
			System.out.println("Uygun formatta mail adresi giriniz!");
			return false;
		}
		
	}

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().length() >= 6) {
			return true;
		} else {
			System.out.println("Password en az 6 karakterden oluþmalýdýr!");
			return false;
		}
			
	}

	@Override
	public boolean isCurrentEmail(User user) {
		if (!emailList.contains(user.getEmail())) {
			return true;
		} else {
			System.out.println("e-posta adresi sistemde mevcut!");
			return false;
		}
		
	}

	@Override
	public boolean isValidUser(User user) {
		if (checkFirstName(user) && checkLastName(user) && checkPassword(user) && checkEmail(user) 
				&& isCurrentEmail(user)) {
			emailList.add(user.getEmail());
			return true;
		}
		return false;
	}



}
