package com.xq.tmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xq.tmall.entity.Admin;
import com.xq.tmall.util.PageUtil;

@Mapper
public interface AdminMapper {
	Integer insertOne(@Param("admin") Admin admin);

	Integer updateOne(@Param("admin") Admin admin);

	List<Admin> select(@Param("admin_name") String admin_name, @Param("pageUtil") PageUtil pageUtil);

	Admin selectOne(@Param("admin_name") String admin_name, @Param("admin_id") Integer admin_id);

	Admin selectByLogin(@Param("admin_name") String admin_name);

	Integer selectTotal(@Param("admin_name") String admin_name);
}