package com.walker.services;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.walker.daos.LoginDao;
import com.walker.models.Employee;

public class LoginService {
	private LoginDao login = new LoginDao();
	
	public Employee getEmployeeCredrentials(String username, String enteredPassword){
//		String newSalt = BCrypt.gensalt();
//		System.out.println("Salt:  " + newSalt);

		try {
			// Get salt from users table by the given username
			// Re-encrypt using the entered password and the retrieved salt
			String hashedPW = "";
			String salt = login.getSalt(username);
//			System.out.println(salt);
			hashedPW = BCrypt.hashpw(enteredPassword, salt);
//			hashedPW = BCrypt.hashpw(enteredPassword, newSalt); // generate hashedPW
//			System.out.println("hashedPW:   " + hashedPW); // Needs to match database pw_hash
	
			// Get the hashed password from the database based on that user
			String db_password = "";
			db_password = login.getPWHash(username, db_password);
//			System.out.println("DB Hashed user_password:   " + db_password);   // Debug
			
			// Compare the hashed password based off the entered password with the hashed 
			// 		password in the database
			if(hashedPW.equals(db_password)) {
				return login.getUser(username);
			} else {
				System.out.println("Invalid Credintials!");
				return null;
			}

		} catch (IOException e) {
			System.out.println("Invalid Credintials!");
			return null;	// user not found
			// log - User not found while hashing employee salt
		}
	}
}
