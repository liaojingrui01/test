<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<%
	Object name = session.getAttribute("adminName");
	if(name==null){
		response.sendRedirect("log.jsp");
	}
%>
<html>
<head>
<meta charset="utf-8">
		<title>最强汽修CRM首页</title>
	</head>
	<frameset rows="100,*" cols="*" scrolling="No" framespacing="0" frameborder="no" border="0">
		<frame src="${pageContext.request.contextPath }/backstage/inc/head.jsp" name="headmenu" id="mainFrame" title="mainFrame">
			<!-- 引用头部 -->
			<!-- 引用左边和主体部分 -->
			<frameset rows="100*" cols="220,*" scrolling="No" framespacing="0" frameborder="no" border="0">
				<frame src="${pageContext.request.contextPath }/backstage/inc/left.jsp" name="leftmenu" id="mainFrame" title="mainFrame">
				<frame src="${pageContext.request.contextPath }/backstage/main.jsp" name="main" scrolling="yes" noresize="noresize" id="rightFrame" title="rightFrame">
			</frameset>
	</frameset>

</html>