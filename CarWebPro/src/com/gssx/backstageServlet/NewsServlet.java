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
		
		

		
		// ��ȡ ��Ҫ�޸ĵ�����
		String newsId = request.getParameter("newsId");
		String tiltle = request.getParameter("tiltle");
		String countent = request.getParameter("countent");
		String releaseTime = request.getParameter("releaseTime");
		String staffId = request.getParameter("staffId");
		
		
		//��װ �� ����ʵ����
		    NewsEnt newsEnt = new NewsEnt(
				Integer.parseInt(newsId), 
				tiltle, 
				countent, 
				releaseTime, 
				Integer.parseInt(staffId)
				);
		
		//�����޸ķ���
		boolean bool = newsDao.updateCus(newsEnt);
		
		if(bool) {
			//ˢ�� �б�����
			queryNewsInfo(request, response);
		}else {
			
		}
	}
	
	public void deleteNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡID
		String newsId =request.getParameter("newsId");
		//����ɾ�� ����
		boolean bool =	newsDao.deleteCus(Integer.parseInt(newsId));
		
		//�ж���ת
		if (bool) {
			//ɾ���ɹ��� ���¼��� �б�����
			queryNewsInfo(request, response);
		}else {
			//ɾ��ʧ�� ����...
		}

	}
	
	/**
	 * ��ѯ �˿��б�
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryNewsInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ������������
		NewsEnt newsEnt = new NewsEnt();
		// ���ò�ѯ ����
		List<NewsEnt> list = newsDao.queryList(newsEnt);

		// ����ѯ�����Ľ�� ���� ��������
		request.setAttribute("list", list);

		// ���� ��ת
		request.getRequestDispatcher("/backstage/news.jsp").forward(request, response);

	}
	
	
	public void newsAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String tiltle = request.getParameter("tiltle");
		String countent = request.getParameter("countent");
		String releaseTime = request.getParameter("releaseTime");
		String staffId = request.getParameter("staffId");
		
		//��װ �� ����ʵ����
		NewsEnt appEnt = new NewsEnt(				
				tiltle, 
				countent, 
				releaseTime, 
				Integer.parseInt(staffId));
		boolean bool = newsDao.saveCus(appEnt);
		if (bool) {
    		//��ת ���ݵ�jsp ���� ��Ⱦ����(��ת ��Ϊ�ڲ���ת�������Դ��ݲ�����  ��  �ⲿ ��ת �����ݶ�ʧ��);
			//request.setAttribute("retMsg","ԤԼ����ɹ�!!!!");
			//request.getRequestDispatcher("/backstage/news.jsp").forward(request, response);
			//queryNewsInfo(request, response);
			queryNewsInfo(request, response);
		}else {
    		//request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	
	public void queryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡIDֵ
		String newsId = request.getParameter("newsId");
		int NewsId=Integer.parseInt(newsId);
		NewsEnt newsEnt = newsDao.queryById(NewsId);
		//���� ������ ��ת���޸Ľ���
		request.setAttribute("newsEnt", newsEnt);
		request.getRequestDispatcher("/backstage/newsupdate.jsp").forward(request, response);
	}
}