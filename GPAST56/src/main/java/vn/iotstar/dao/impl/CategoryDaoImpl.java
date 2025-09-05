package vn.iotstar.dao.impl;

import java.util.List;

import vn.iotstar.config.JPAConfig;
import vn.iotstar.entities.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.iotstar.dao.ICategoryDao;

public class CategoryDaoImpl implements ICategoryDao {
@Override
	
	public void create(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query  = enma.createNamedQuery("Category.findAll", Category.class);		
		return query.getResultList();
	}
}
