package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.entities.Category;
import vn.iotstar.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	ICategoryDao cateDao = new CategoryDaoImpl();
	@Override
	public void insert(Category category) {
		cateDao.create(category);
	}
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}
}
