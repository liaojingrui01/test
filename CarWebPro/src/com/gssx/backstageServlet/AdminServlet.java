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
	// ��� �� ���ݿ� ������ dao�����
	IAdminDao admDao = new AdminImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// ��ȡһ������ ָ�� ��Ҫ�����õķ���
		String op = request.getParameter("op");
		// �ж�login
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
	 * ��¼����
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//���տͻ��˴��ݵĲ���
		String adm_name = request.getParameter("adm_name");
		String adm_pwd = request.getParameter("adm_pwd");

//��װʵ�����
		AdminEnt admEnt = new AdminEnt();
		admEnt.setLoginName(adm_name);
		admEnt.setLoginPwd(adm_pwd);
//���÷��� ���в�ѯ����
		AdminEnt retAdm = admDao.queryAdm(admEnt);
		String adminName=retAdm.getAdminName();
		int adminId=retAdm.getAdminId();
//���session,�����û�������
		HttpSession session=request.getSession();
		session.setAttribute("adminName",adminName);
		session.setAttribute("userpwd",adm_pwd);
		session.setAttribute("adminId",adminId);
//�ж�
		if (adminName != null) {
			// ������������
			request.setAttribute("retAdm", retAdm);
			// ��ת ���ݵ�jsp ���� ��Ⱦ����(��ת ��Ϊ�ڲ���ת�������Դ��ݲ����� �� �ⲿ ��ת �����ݶ�ʧ��);
			request.getRequestDispatcher("/backstage/index.jsp").forward(request, response);
		} else {
			//���ظ�ҳ��
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