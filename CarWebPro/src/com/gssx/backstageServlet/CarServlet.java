package com.gssx.backstageServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gssx.dao.ICarDao;
import com.gssx.dao.impl.CarDaoImpl;
import com.gssx.entity.ServicecarEnt;
import com.gssx.util.DBUtils;
import com.gssx.util.UploadUtil;


/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ICarDao car=new  CarDaoImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op=request.getParameter("op");
		if(op.equals("findall")) {
			findall(request, response);
		}else if(op.equals("delete")) {
			delete(request, response);
		}else if(op.equals("add")) {
			add(request, response);
		}else if(op.equals("findbyid")) {
			findbyid(request, response);
		}else if(op.equals("query")) {
			querylikename(request, response);
		}else if(op.equals("update")) {
			updateCar(request, response);
		}else if(op.equals("carservice")) {
			carservice(request,response);
		}
	}
	public void carservice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<ServicecarEnt> list=new ArrayList<ServicecarEnt>();
		list=car.querylist();
		request.setAttribute("list",list);
		request.getRequestDispatcher("/carOfficial/cases.jsp").forward(request, response);
	}
	public void findall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ServicecarEnt> list=new ArrayList<ServicecarEnt>();
		list=car.querylist();
		request.setAttribute("list",list);
		
		//跳转到成功界面，請求轉發
		request.getRequestDispatcher("/backstage/vip.jsp").forward(request, response);	
	}
	
	public void findbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("carId");
		int carId=Integer.parseInt(strId.trim());
		ServicecarEnt carEnt=car.queryById(carId);
		request.setAttribute("car", carEnt);		
		//跳转到成功界面，請求轉發
		request.getRequestDispatcher("/backstage/vipupdate.jsp").forward(request, response);	
	}
	public void querylikename(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("carName");
		List<ServicecarEnt> list=new ArrayList<ServicecarEnt>();
		list=car.querylikeName(name);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/backstage/vip.jsp").forward(request, response);	
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String strId = request.getParameter("carId");
		
		int carId=Integer.parseInt(strId.trim());
		boolean bool=car.delete(carId);
		if(bool) {
			findall(request,response);
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UploadUtil uploadUtil = new UploadUtil();

		HashMap<String, String> map = uploadUtil.upload(request);
		// 设置响应数据的 内容 类型
		response.setContentType("text/html;charset=utf-8");
		// 将返回的图片 名称 存入数据库中
		// 获取数据 库链接 公共类
		DBUtils db = new DBUtils();
		// 定义链接对象
		Connection conn = null;
		// 定义预编译类
		PreparedStatement ps = null;
		// 定义取出数据的 结果集
		ResultSet rs = null;
		// 成功 失败状态
		boolean bool = false;
		// 定义 需要执行的sql 语句
		String sql = "insert into servicecar(carName,carImg)" + " VALUES (?,?)";
		// 链接数据库 预编译执行
		conn = db.conn();
		try {
			ps = conn.prepareStatement(sql);
			// 赋值
			ps.setString(1, map.get("carName"));
			ps.setString(2, map.get("carImg"));
			/*
			 * ps.setString(4, cusEnt.getEmail()); ps.setInt(5, cusEnt.getAddress_id());
			 * ps.setInt(6, cusEnt.getActive()); ps.setString(7, cusEnt.getCreate_date());
			 * ps.setString(8, cusEnt.getLast_update());
			 */
			// 判断是否 执行成功
			int upNum = ps.executeUpdate();
			if (upNum > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().println(map.toString());
		//跳转到成功界面，請求轉發
		findall(request,response);
	}
	
	/**
	 * 修改图片信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateCar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取 需要修改的数据
		//String bannerId = request.getParameter("bannerId");
		//String bannerName = request.getParameter("bannerName");
		//String bannerImg = request.getParameter("bannerImg");
		UploadUtil uploadUtil = new UploadUtil();

		HashMap<String, String> map = uploadUtil.upload(request);
		
		
		//封装 到 对象实体中
		ServicecarEnt carEnt = new ServicecarEnt(
				Integer.parseInt(map.get("carId")),
				map.get("carName"),
				map.get("carImg"));
		
		//调用修改方法
		boolean bool = car.update(carEnt);
		if(bool) {
			//刷新 列表界面
			findall(request, response);
		}else {
			
		}
	}
}
