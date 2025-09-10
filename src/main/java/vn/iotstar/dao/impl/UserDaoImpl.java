package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import vn.iotstar.config.JPAConfig;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.entities.Category;
import vn.iotstar.entities.User;

public class UserDaoImpl implements IUserDao {
	EntityManager enma = null;
	TypedQuery<User> query = null;
	@Override
	public List<User> findAll() {
		enma = JPAConfig.getEntityManager();
		query = enma.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		enma = JPAConfig.getEntityManager();
		User user = enma.find(User.class, id);
		return user;
	}

	@Override
	public void insert(User user) {
		enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(user);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public User findByUserName(String username) {
		User user = null;
		try {
			enma = JPAConfig.getEntityManager();
			String jpql = "SELECT u FROM User u WHERE u.username = :username";
			query = enma.createQuery(jpql, User.class);
			query.setParameter("username", username);	
			user = query.getSingleResult();
		} catch (NoResultException e) {
		    user = null;
		}
		return user;
	}
}
