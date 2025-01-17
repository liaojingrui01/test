package com.gssx.backstageServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gssx.dao.INewsDao;
import com.gssx.dao.impl.NewsImpl;
import com.gssx.entity.AppointmentEnt;
import com.gssx.entity.BannerImgEnt;
import com.gssx.entity.NewsEnt;


public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       INewsDao newsDao = new NewsImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");    	
    	String op = request.getParameter("op");
    	if (("updateNews").equals(op)) {
    		updateNews(request, response);
		}else if(("deleteNews").equals(op)) {
			deleteNews(request, response);
		}else if(("queryById").equals(op)) {
			queryById(request, response);
		}else if(("queryNewsInfo").equals(op)) {
			queryNewsInfo(request, response);
		}else if(("newsAdd").equals(op)) {
			newsAdd(request, response);
		}
	}
	
	public void updateNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		
		// 获取 需要修改的数据
		String newsId = request.getParameter("newsId");
		String tiltle = request.getParameter("tiltle");
		String countent = request.getParameter("countent");
		String releaseTime = request.getParameter("releaseTime");
		String staffId = request.getParameter("staffId");
		
		
		//封装 到 对象实体中
		    NewsEnt newsEnt = new NewsEnt(
				Integer.parseInt(newsId), 
				tiltle, 
				countent, 
				releaseTime, 
				Integer.parseInt(staffId)
				);
		
		//调用修改方法
		boolean bool = newsDao.updateCus(newsEnt);
		
		if(bool) {
			//刷新 列表界面
			queryNewsInfo(request, response);
		}else {
			
		}
	}
	
	public void deleteNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取ID
		String newsId =request.getParameter("newsId");
		//调用删除 方法
		boolean bool =	newsDao.deleteCus(Integer.parseInt(newsId));
		
		//判断跳转
		if (bool) {
			//删除成功后 重新加载 列表界面
			queryNewsInfo(request, response);
		}else {
			//删除失败 界面...
		}

	}
	
	/**
	 * 查询 顾客列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryNewsInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建条件对象
		NewsEnt newsEnt = new NewsEnt();
		// 调用查询 方法
		List<NewsEnt> list = newsDao.queryList(newsEnt);

		// 将查询出来的结果 存入 作用域中
		request.setAttribute("list", list);

		// 界面 跳转
		request.getRequestDispatcher("/backstage/news.jsp").forward(request, response);

	}
	
	
	public void newsAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String tiltle = request.getParameter("tiltle");
		String countent = request.getParameter("countent");
		String releaseTime = request.getParameter("releaseTime");
		String staffId = request.getParameter("staffId");
		
		//封装 到 对象实体中
		NewsEnt appEnt = new NewsEnt(				
				tiltle, 
				countent, 
				releaseTime, 
				Integer.parseInt(staffId));
		boolean bool = newsDao.saveCus(appEnt);
		if (bool) {
    		//跳转 传递到jsp 界面 渲染数据(跳转 分为内部跳转：【可以传递参数】  和  外部 跳转 【数据丢失】);
			//request.setAttribute("retMsg","预约申请成功!!!!");
			//request.getRequestDispatcher("/backstage/news.jsp").forward(request, response);
			//queryNewsInfo(request, response);
			queryNewsInfo(request, response);
		}else {
    		//request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	
	public void queryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取ID值
		String newsId = request.getParameter("newsId");
		int NewsId=Integer.parseInt(newsId);
		NewsEnt newsEnt = newsDao.queryById(NewsId);
		//存入 作用域 跳转到修改界面
		request.setAttribute("newsEnt", newsEnt);
		request.getRequestDispatcher("/backstage/newsupdate.jsp").forward(request, response);
	}
}
