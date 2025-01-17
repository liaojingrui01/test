<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>最强汽修</title>
<link rel="stylesheet" type="text/css" href="/CarWebPro/backstage/css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="/CarWebPro/backstage/img/coin02.png" /><span><a href="/CarWebPro/backstage/index.jsp" target="index">首页</a>&nbsp;-&nbsp;<a
					href="/CarWebPro/backstage/index.jsp" target="index">预约管理</a>&nbsp;-</span>&nbsp;预约列表
			</div>
		</div>

		<div class="page">
			<!-- topic页面样式 -->
			<div class="topic">
				
				<!-- topic表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">序号</td>
							<td width="200px" class="tdColor">用户名</td>
							<td width="125px" class="tdColor">性别</td>
							<td width="155px" class="tdColor">车牌号</td>
							<td width="175px" class="tdColor">车型</td>
							<td width="190px" class="tdColor">手机号</td>
							<td width="130px" class="tdColor">预约时间</td>
							<td width="200px" class="tdColor">服务类型</td>
							<td width="130px" class="tdColor">操作</td>
						</tr>
					<c:forEach items="${list}" var="item">
					    <tr>
				         <td>${item.userId}</td>
				         <td>${item.userName}</td>
				         <td>${item.sex}</td>
				         <td>${item.carBrand}</td>
				         <td>${item.carId}</td>
				         <td>${item.tel}</td>
				         <td>${item.appointmentTime}</td>
				         <td>${item.serviceId}</td>
							<td><a href="AppUrl?op=queryById&userId=${item.userId}">
								<img class="operation" src="/CarWebPro/backstage/img/update.png"></a>
								<a href="AppUrl?op=deleteCus&userId=${item.userId}" onclick="javascript:return deleteOne();"> 
								<img class="operation delban" src="/CarWebPro/backstage/img/delete.png"></a>	 </td>
							
						</tr>
						</c:forEach>
					</table>
					
				</div>
				<!-- topic 表格 显示 end-->
			</div>
			<!-- topic页面样式end -->
		</div>

	</div>

</body>
<script type="text/javascript">
	/* 删除数据 */
	function deleteOne(){
		var msg="你真的要 删除数据吗？\n请确认!!";
		//判断点击操作
		if(confirm(msg)==true){
			return true;
		}else{
			return false;
		}
		
	}
</script>

</html>