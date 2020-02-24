<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员注册-有点</title>
<link rel="stylesheet" type="text/css" href="/CarWebPro/backstage//css/css.css" />
<script type="text/javascript" src="/CarWebPro/backstage//js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="/CarWebPro/backstage/img/coin02.png" /><span><a  href="/CarWebPro/backstage/index.jsp" target="index">首页</a>&nbsp;-&nbsp;<a
					 href="/CarWebPro/backstage/index.jsp" target="index">公共管理</a>&nbsp;-</span>&nbsp;修改车型
			</div>
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>管理车型</span>
				</div>
				<form method="post" action="${pageContext.request.contextPath }/CarUrl?op=update" enctype="multipart/form-data">
				<div class="baBody">
					<input type="hidden" name="carId" value="${car.carId }"/>
					<div class="bbD">
						车型名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3" name="carName" value="${car.carName}"/>
					</div>
					
					<div class="bbD">
						车型图片：
						<div class="vipHead vipHead1">
							<img src="uploadFile/${car.carImg}" />
							<p class="vipP">更换图片</p>
							<input class="file1" type="file" name="carImg"/>
						</div>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button type="submit" class="btn_ok btn_yes">提交</button>
							<a class="btn_ok btn_no" href="${pageContext.request.contextPath }/CarUrl?op=findall&name" target="main" >取消</a>
						</p>
					</div>
				</div>
				</form>
			</div>
			<!-- 会员注册页面样式end -->
		</div>
	</div>
</body>
</html>