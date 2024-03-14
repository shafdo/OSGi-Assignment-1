package userpublisher;

import java.util.HashMap;
import java.util.List;

public interface Register {
	public HashMap registerUser(String username, String password, String role);
	public List<HashMap<String, Object>> getUsers();
}
