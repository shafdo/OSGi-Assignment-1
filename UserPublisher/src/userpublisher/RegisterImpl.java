package userpublisher;

import java.util.HashMap;
import java.util.List;

public class RegisterImpl implements Register {

	@Override
	public HashMap registerUser(String username, String password, String role) {
		UserDataSource user = new UserDataSource();
		HashMap createdUser = user.addUser(username, password, role.toLowerCase());
		return createdUser;
	}
	
	@Override
	public List<HashMap<String, Object>> getUsers() {
		UserDataSource user = new UserDataSource();
		List<HashMap<String, Object>> users = user.getUsers();
		return users;
	}
	
}
