package com.xq.tmall.service;

import java.util.List;

import com.xq.tmall.entity.Admin;
import com.xq.tmall.util.PageUtil;

public interface AdminService {
	boolean add(Admin admin);

	boolean update(Admin admin);

	List<Admin> getList(String admin_name, PageUtil pageUtil);

	Admin get(String admin_name, Integer admin_id);

	Admin login(String admin_name);

	Integer getTotal(String admin_name);
}
