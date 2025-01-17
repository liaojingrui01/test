<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>配件管理</title>
<link rel="stylesheet" type="text/css" href="/CarWebPro/backstage/css/css.css" />
<script type="text/javascript" src="./js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="./js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<span><a href="/CarWebPro/backstage/index.jsp" target="index">首页</a>&nbsp;-&nbsp;<a href="/CarWebPro/backstage/index.jsp" target="index">配件管理</a>&nbsp;-</span>&nbsp;库存配件管理
			</div>
		</div>

		<div class="page">
			<!-- topic页面样式 -->
			<div class="topic">
				<div class="conform">
					<form>

						<div class="cfD">
							
							
							<a class="addA addA1" href="${pageContext.request.contextPath }/backstage/peijianadd.jsp">添加</a>
						</div>
					</form>
				</div>
				<!-- topic表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">序号</td>
							<td width="200px" class="tdColor">配件名</td>
							<td width="125px" class="tdColor">商标</td>
							<td width="155px" class="tdColor">企业</td>
							<td width="175px" class="tdColor">图片</td>
							<td width="190px" class="tdColor">汽车类型</td>
							<td width="130px" class="tdColor">型号</td>
							<td width="200px" class="tdColor">价格</td>
							<td width="140px" class="tdColor">作用</td>
							<td width="160px" class="tdColor">参数</td>
							<td width="160px" class="tdColor">操作</td>

						</tr>
						<c:forEach items="${list}" var="item">
							<tr>
								<td>${item.partsId}</td>
								<td>${item.partsName}</td>
								<td>${item.brand}</td>
								<td>${item.enterprise}</td>
								<td>
									<div class="onsImg">
										<img src="uploadFile/${item.imge}">
									</div>

								</td>
								<td>${item.carType}</td>
								<td>${item.typeNum}</td>
								<td>${item.price}</td>
								<td>${item.effect}</td>
								<td>${item.num}</td>
								<td><a href="StoUrl?op=queryById&partsId=${item.partsId}">
										<img class="operation"
										src="/CarWebPro/backstage/img/update.png"> <a
											href="StoUrl?op=deleteStock&partsId=${item.partsId}"
											onclick="javascript:return deleteOne();"> <img
												class="operation delban"
												src="/CarWebPro/backstage/img/delete.png"></a></td>
							</tr>
						</c:forEach>
					</table>
					<div class="paging">此处是分页</div>
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