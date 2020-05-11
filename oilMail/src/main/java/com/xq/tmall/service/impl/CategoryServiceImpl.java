package com.xq.tmall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xq.tmall.dao.CategoryMapper;
import com.xq.tmall.entity.Category;
import com.xq.tmall.service.CategoryService;
import com.xq.tmall.service.PropertyService;
import com.xq.tmall.util.PageUtil;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	private CategoryMapper categoryMapper;

	@Resource(name = "categoryMapper")
	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	@Autowired
	private PropertyService propertyService;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public boolean add(Category category) {
		boolean p = propertyService.addList(category.getPropertyList());
		return categoryMapper.insertOne(category) > 0 && p;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public boolean update(Category category) {
		propertyService.deleteByCategoryId(category.getCategory_id());
		propertyService.addList(category.getPropertyList());
		return categoryMapper.updateOne(category) > 0;
	}

	@Override
	public List<Category> getList(String category_name, PageUtil pageUtil) {
		return categoryMapper.select(category_name, pageUtil);
	}

	@Override
	public Category get(Integer category_id) {
		return categoryMapper.selectOne(category_id);
	}

	@Override
	public Integer getTotal(String category_name) {
		return categoryMapper.selectTotal(category_name);
	}
}
