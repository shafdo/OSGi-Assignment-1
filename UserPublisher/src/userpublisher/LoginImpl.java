package userpublisher;

import java.util.HashMap;

public class LoginImpl implements Login {

	public boolean loginUser(String username, String password) {
		RegisterImpl user = new RegisterImpl();

		HashMap<String, Object> foundUser = null;

        for (HashMap<String, Object> userObj : user.getUsers()) {
            if (userObj.containsKey("username") && userObj.get("username").equals(username)) {
                foundUser = userObj;
                break;
            }
        }

        if (foundUser != null) {
            // Found user
        	// Check password
        	if(!foundUser.get("password").toString().contentEquals(password)) {
        		System.out.println("Invalid password");
        		return false;
        	}
        	
        	System.out.println("Loggined in successfully");
            return true;
        } 
        
        System.out.println("User not found.");
		return false;
	}
	
}
