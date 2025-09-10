package vn.iotstar.services;

import java.util.List;

import vn.iotstar.entities.User;

public interface IUserService {
	List<User> findAll();
	User findById(int id);
	void insert(User user);
	User findByUserName(String username);
	User login(String username, String password);
	boolean register(String username, String password);
}
