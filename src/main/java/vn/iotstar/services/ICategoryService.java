package vn.iotstar.services;

import java.util.List;

import vn.iotstar.entities.Category;

public interface ICategoryService {
	void insert(Category category);
	List<Category> findAll();
	List<Category> findByUserId(int id);
}
