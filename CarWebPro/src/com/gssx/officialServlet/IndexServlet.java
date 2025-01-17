package com.gssx.officialServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gssx.dao.IBannerImgDao;
import com.gssx.dao.IStockDao;
import com.gssx.dao.impl.BannerDaoImpl;
import com.gssx.dao.impl.StockDaoImpl;
import com.gssx.entity.BannerImgEnt;
import com.gssx.entity.StockEnt;


public class IndexServlet extends HttpServlet {

	
	//获取接口 对象
	IBannerImgDao banDao = new BannerDaoImpl();
	IStockDao stoDao=new StockDaoImpl();
		
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op =request.getParameter("op");
		if ("queryBunner".equals(op)) {
			queryBunner(request, response);
		}
	}

	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryBunner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建条件 对象
		BannerImgEnt banEnt =new BannerImgEnt();
		StockEnt stoEnt=new StockEnt();
		//调用查询方法
		List<BannerImgEnt> list = banDao.queryList(banEnt);
		//将查询出来的结果 存入到作用域中
		request.setAttribute("list", list);
		
		//调用查询方法
		List<StockEnt> list1 = stoDao.queryList(stoEnt);
		//将查询出来的结果 存入到作用域中
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("/carOfficial/index.jsp").forward(request, response);
		
		
	}
}
