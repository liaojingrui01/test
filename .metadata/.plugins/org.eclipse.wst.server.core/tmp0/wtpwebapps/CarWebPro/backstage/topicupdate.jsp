<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>最强汽修</title>
<link rel="stylesheet" type="text/css" href="/CarWebPro/backstage/css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="/CarWebPro/backstage/img/coin02.png" /><span><a href="/CarWebPro/backstage/index.jsp" target="index">首页</a>&nbsp;-&nbsp;<a
					href="/CarWebPro/backstage/index.jsp" target="index">预约管理</a>&nbsp;-</span>&nbsp;预约修改
			</div>
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>预约修改信息</span>
				</div>
				<div class="baBody">
					<div class="bbD">
					<form action="${pageContext.request.contextPath }/AppUrl?op=updateCus" method="post">
					<div class="bbD">
						用户ID：<input type="text" class="input3" name="userId" value="${appEnt.userId}"/>
					</div>
					<div class="bbD">
						客户名：<input type="text" class="input3" name="userName" value="${appEnt.userName}"/>
					</div>
					<div class="bbD">
						性别：<select class="input3" name="sex" value="${appEnt.sex}"><option>男</option><option>女</option></select>
					</div>
					<div class="bbD">
						车牌号：<input type="text" class="input3" name="carBrand" value="${appEnt.carBrand}"/>
					</div>
					<div class="bbD">
						车型：<input type="text" class="input3" name="carId" value="${appEnt.carId}"/>
					</div>
					<div class="bbD">
						手机号：<input type="text" class="input3" name="tel" value="${appEnt.tel}"/>
					</div>
					<div class="bbD">
						预约时间：<input type="text" class="input3" name="appointmentTime" value="${appEnt.appointmentTime}"/>
					</div>
					<div class="bbD">
						服务类型：<input type="text" class="input3" name="serviceId" value="${appEnt.serviceId}"/>
					</div>
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">提交</button>
							<a class="btn_ok btn_no" href="${pageContext.request.contextPath }/AppUrl?op=queryCusInfo" target="main">取消</a>
							</form>
						</p>
					</div>
				</div>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>