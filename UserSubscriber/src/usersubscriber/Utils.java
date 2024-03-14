package usersubscriber;

import java.util.HashMap;
import java.util.Scanner;

import userpublisher.LoginImpl;
import userpublisher.RegisterImpl;


public class Utils {

	Scanner s = new Scanner(System.in);
	
	public boolean AccountExists() {
		System.out.print("Do you have an account (Y/n): ");
		char isAccExist = s.next().charAt(0);
		
		if(isAccExist == 'Y' || isAccExist == 'y') {
			return true;
		}
		
		return false;
	}
	
	public Boolean RegisterInterface() {
		RegisterImpl registrationHandler = new RegisterImpl();
		
		System.out.println("====================== Registration Interface ======================");
		System.out.println("[I] Note: Enter 99 to go back to previous menu.");
		
		// Get username
		System.out.print("Username: ");
		String username = s.next();
		if(username.contentEquals("99")) { return false; }
		
		// Check user exists
		HashMap<String, Object> foundUser = null;
		for (HashMap<String, Object> userObj : registrationHandler.getUsers()) {
            if (userObj.containsKey("username") && userObj.get("username").equals(username)) {
                foundUser = userObj;
                break;
            }
        }
		
		if (foundUser == null) {
			System.out.println("User already exists. Try another username.");
			return false;
		}
		
		// Get Password
		System.out.print("Password: ");
		String password = s.next();
		if(password.contentEquals("99")) return false;
		
		// Get Role
		System.out.print("Role: ");
		String role = s.next();
		if(role.contentEquals("99")) return false;
		
		// Register api call
		HashMap user = registrationHandler.registerUser(username, password, role);
		
		System.out.println("Account created suucessfully.");
		System.out.println("---------------------------------\n");
		
		return true;
		
	}
	
	public Boolean LoginInterface() {
		LoginImpl loginHandler = new LoginImpl();
		
		System.out.println("====================== Login Interface ======================");
		System.out.println("[I] Note: Enter 99 to go back to previous menu.");
		
		// Get username
		System.out.print("Username: ");
		String username = s.next();
		if(username.contentEquals("99")) { return false; }
		
		// Get Password
		System.out.print("Password: ");
		String password = s.next();
		if(password.contentEquals("99")) return false;
		
		// Login api call
		boolean login = loginHandler.loginUser(username, password);
				
		return login;
	}
	
}
