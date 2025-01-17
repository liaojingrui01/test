package com.gssx.backstageServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gssx.dao.IAdminDao;
import com.gssx.dao.impl.AdminImpl;
import com.gssx.entity.AdminEnt;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获得 和 数据库 交互的 dao层对象
	IAdminDao admDao = new AdminImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取一个参数 指定 需要被调用的方法
		String op = request.getParameter("op");
		// 判断login
		if ("login".equals(op)) {
			login(request, response);
		} else if ("cusAdd".equals(op)) {
			// cusAdd(request, response);
		} else if ("cusList".equals(op)) {
			// queryListMap(request, response);
		}else if("exit".equals(op)) {
			exit(request,response);
		}
	}

	/**
	 * 登录方法
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//接收客户端传递的参数
		String adm_name = request.getParameter("adm_name");
		String adm_pwd = request.getParameter("adm_pwd");

//封装实体参数
		AdminEnt admEnt = new AdminEnt();
		admEnt.setLoginName(adm_name);
		admEnt.setLoginPwd(adm_pwd);
//调用方法 进行查询操作
		AdminEnt retAdm = admDao.queryAdm(admEnt);
		String adminName=retAdm.getAdminName();
		int adminId=retAdm.getAdminId();
//获得session,放入用户名密码
		HttpSession session=request.getSession();
		session.setAttribute("adminName",adminName);
		session.setAttribute("userpwd",adm_pwd);
		session.setAttribute("adminId",adminId);
//判断
		if (adminName != null) {
			// 存入作用域中
			request.setAttribute("retAdm", retAdm);
			// 跳转 传递到jsp 界面 渲染数据(跳转 分为内部跳转：【可以传递参数】 和 外部 跳转 【数据丢失】);
			request.getRequestDispatcher("/backstage/index.jsp").forward(request, response);
		} else {
			//返回父页面
			request.getRequestDispatcher("/backstage/log.jsp").forward(request, response);	
			//response.sendRedirect("${pageContext.request.contextPath }/backstage/log.jsp");
		}
	}
	public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("adminName");
		session.invalidate();
	     request.getRequestDispatcher("/backstage/log.jsp").forward(request, response);	
	}

}
