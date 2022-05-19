package client.model.user;

import shared.objects.user.User;

public interface ManageUser
{
	void add(User user);
	User get(String username);
	 boolean login(String username, String password);
	User getLoggedUser();
	void logout();

}
