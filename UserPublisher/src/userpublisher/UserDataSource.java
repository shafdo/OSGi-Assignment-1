package userpublisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDataSource {

	// Global users
		public static List<HashMap<String, Object>> users = new ArrayList<>();
		
		public HashMap addUser(String username, String password, String role) {
			// TODO Auto-generated method stub
			HashMap<String, Object> person = new HashMap<>();
			person.put("username", username);
			person.put("password", password);
			person.put("role", role);
			
			// Append the object
			users.add(person);
			return person;
		}

		public List<HashMap<String, Object>> getUsers() {
			// TODO Auto-generated method stub
			return users;
		}
	
}
