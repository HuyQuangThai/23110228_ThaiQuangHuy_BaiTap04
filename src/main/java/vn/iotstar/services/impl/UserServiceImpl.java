package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.entities.User;
import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService  {

	IUserDao userDao = new UserDaoImpl();
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}

	@Override
	public User login(String username, String password) {
		User user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean register(String username, String password) {
		try {
			if (this.findByUserName(username) != null) {
				return false;
			}
			
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			User user = new User(username, password,1,date);
			userDao.insert(user);
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}
}
