package com.xq.tmall.service;

import java.util.List;

import com.xq.tmall.entity.Category;
import com.xq.tmall.util.PageUtil;

public interface CategoryService {
	Integer add(Category category);

	boolean update(Category category);

	List<Category> getList(String category_name, PageUtil pageUtil);

	Category get(Integer category_id);

	Integer getTotal(String category_name);
}
