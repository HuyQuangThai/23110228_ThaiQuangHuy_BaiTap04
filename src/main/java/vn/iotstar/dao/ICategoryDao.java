package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entities.Category;

public interface ICategoryDao {
	void create(Category category);
	void update(Category category);
	List<Category> findByUserId (int id);
	List<Category> findAll();
}
