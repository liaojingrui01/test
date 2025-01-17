package com.gssx.dao;

import java.util.List;

import com.gssx.entity.NewsEnt;

public interface INewsDao {
	/**
	 * 添加信息
	 * @param cusEnt
	 * @return
	 */
	public boolean saveCus(NewsEnt appEnt);
	
	/**
	 * 删除信息
	 * @param customer_id
	 * @return
	 */
	public boolean deleteCus(int newsId);
	
	/**
	 * 修改信息
	 * @param cusEnt
	 * @return
	 */
	public boolean updateCus(NewsEnt newsEnt);
	
	
	
	
	public List<NewsEnt> queryList(NewsEnt newsEnt);

	public NewsEnt queryById(int newsId);
}
