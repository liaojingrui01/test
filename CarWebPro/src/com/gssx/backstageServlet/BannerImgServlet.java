package com.gssx.backstageServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gssx.dao.IBannerImgDao;
import com.gssx.dao.impl.BannerDaoImpl;
import com.gssx.entity.BannerImgEnt;
import com.gssx.util.DBUtils;
import com.gssx.util.UploadUtil;

public class BannerImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//��ȡ�ӿ� ����
	IBannerImgDao banDao = new BannerDaoImpl();
	//���տͻ��˵�get��ʽ����
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
	}
    //Post ����ִ�з���
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ı��봦��
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//���� ���� ����ָ������
		String op = request.getParameter("op");
		//�ж�
		if (("queryBanner").equals(op)) {
			queryBanner(request, response);
		}else if(("updateBan").equals(op)) {
			updateBan(request, response);
		}else if(("queryById").equals(op)) {
			queryById(request, response);
		}else if(("deleteBan").equals(op)) {
			deleteBan(request, response);
		}else if(("banAdd").equals(op)) {
			banAdd(request, response);
		}else if(("saveBanner").equals(op)) {
			saveBanner(request, response);
		}
	}
	/**
	 * ��ѯͼƬ�б�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryBanner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������� ����
		BannerImgEnt banEnt =new BannerImgEnt();
		//���ò�ѯ����
		List<BannerImgEnt> list = banDao.queryList(banEnt);
		//����ѯ�����Ľ�� ���뵽��������
		request.setAttribute("list", list);
		request.getRequestDispatcher("/backstage/banner.jsp").forward(request, response);
	}
	/**
	 * �޸�ͼƬ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateBan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ ��Ҫ�޸ĵ�����
		//String bannerId = request.getParameter("bannerId");
		//String bannerName = request.getParameter("bannerName");
		//String bannerImg = request.getParameter("bannerImg");
		UploadUtil uploadUtil = new UploadUtil();

		HashMap<String, String> map = uploadUtil.upload(request);
		
		
		//��װ �� ����ʵ����
		BannerImgEnt banEnt = new BannerImgEnt(
				Integer.parseInt(map.get("bannerId")),
				map.get("bannerName"),
				map.get("bannerImg"));
		
		//�����޸ķ���
		boolean bool = banDao.updateBan(banEnt);
		if(bool) {
			//ˢ�� �б�����
			queryBanner(request, response);
		}else {
			
		}
	}
	/**
	 * ͨ��ID ��ѯ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡIDֵ
		String bannerId = request.getParameter("bannerId");
		BannerImgEnt banEnt = banDao.queryById(Integer.parseInt(bannerId));
		//���� ������ ��ת���޸Ľ���
		request.setAttribute("banEnt", banEnt);
		request.getRequestDispatcher("/backstage/bannerupdate.jsp").forward(request, response);
	}

	  /**
	   * �h��ͼƬ��Ϣ
	   * @param request
	   * @param response
	   * @throws ServletException
	   * @throws IOException
	   */
	public void deleteBan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡID
		String bannerId =request.getParameter("bannerId");
		//����ɾ�� ����
		boolean bool =	banDao.deleteBan(Integer.parseInt(bannerId));
		
		//�ж���ת
		if (bool) {
			//ɾ���ɹ��� ���¼��� �б�����
			queryBanner(request, response);
		}else {
			//ɾ��ʧ�� ����...
		}

	}
	/**
	 * ����ͼƬ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void banAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	//������ӵĲ���
	    	String bannerName = request.getParameter("bannerName");
	    	String bannerImg = request.getParameter("bannerImg");
	    	
	    	//���� dao������� ���� ����
	    	BannerImgEnt banEnt = new BannerImgEnt();
	    	//��������ת��
	    	banEnt.setBannerName(bannerName);
	    	banEnt.setBannerImg(bannerImg);
	    	boolean bool = banDao.saveBan(banEnt);
	    	if (bool) {
	    		//��ת ���ݵ�jsp ���� ��Ⱦ����(��ת ��Ϊ�ڲ���ת�������Դ��ݲ�����  ��  �ⲿ ��ת �����ݶ�ʧ��);
	    		request.getRequestDispatcher("/backstage/banner.jsp").forward(request, response);
			}else {
	    		request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
	    	
	    }
	    
	public void saveBanner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UploadUtil uploadUtil = new UploadUtil();

		HashMap<String, String> map = uploadUtil.upload(request);
		// ������Ӧ���ݵ� ���� ����
		response.setContentType("text/html;charset=utf-8");
		// �����ص�ͼƬ ���� �������ݿ���
		// ��ȡ���� ������ ������
		DBUtils db = new DBUtils();
		// �������Ӷ���
		Connection conn = null;
		// ����Ԥ������
		PreparedStatement ps = null;
		// ����ȡ�����ݵ� �����
		ResultSet rs = null;
		// �ɹ� ʧ��״̬
		boolean bool = false;
		// ���� ��Ҫִ�е�sql ���
		String sql = "insert into bannerImg(bannerName,bannerImg)" + " VALUES (?,?)";
		// �������ݿ� Ԥ����ִ��
		conn = db.conn();
		try {
			ps = conn.prepareStatement(sql);
			// ��ֵ
			ps.setString(1, map.get("bannerName"));
			ps.setString(2, map.get("bannerImg"));
			/*
			 * ps.setString(4, cusEnt.getEmail()); ps.setInt(5, cusEnt.getAddress_id());
			 * ps.setInt(6, cusEnt.getActive()); ps.setString(7, cusEnt.getCreate_date());
			 * ps.setString(8, cusEnt.getLast_update());
			 */
			// �ж��Ƿ� ִ�гɹ�
			int upNum = ps.executeUpdate();
			if (upNum > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().println(map.toString());
		queryBanner(request, response);
		
	}

}