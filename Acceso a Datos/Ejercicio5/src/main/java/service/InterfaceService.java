package service;

import modelo.User;

public interface InterfaceService {

	public void changePass(Integer id, String pass, String passNew);

	public User register(User user);

	public User login(String login, String pass);

	public User consult(Integer id);
}