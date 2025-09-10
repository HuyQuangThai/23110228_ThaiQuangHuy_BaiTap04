package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entities.User;

public interface IUserDao {
	List<User> findAll();
	User findById(int id);
	void insert(User user);
	User findByUserName(String username);
}
