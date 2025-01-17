<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

<head>
<meta name="renderer" content="webkit">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>最强汽修有限公司</title>
<link href="/CarWebPro/carOfficial/css/bootstrap.css" rel="stylesheet">
<script src="/CarWebPro/carOfficial/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="/CarWebPro/carOfficial/css/meteinfo_ui.css"
	id="metuimodule" data-module="1" />
<link rel="stylesheet" type="text/css" href="/CarWebPro/carOfficial/css/metinfo.css" />

<script src="/CarWebPro/carOfficial/js/jQuery1.7.2.js" type="text/javascript"></script>
<script src="/CarWebPro/carOfficial/js/metinfo_ui.js" type="text/javascript"></script>
<script src="/CarWebPro/carOfficial/js/ch.js" type="text/javascript"></script>
<!--[if IE]>
<script src="./public/js/html5.js" type="text/javascript"></script>
<![endif]-->
</head>

<body>
	<div class="m-nav">
		<nav class="inner">
			<ul class="list-none">
				<li id="nav_10001" style='width: 123px;'><a href="${pageContext.request.contextPath }/indexUrl?op=queryBunner"
					title='网站首页' class='nav'><span>网站首页</span></a></li>
				<li id='nav_1' style='width: 123px;'><a href='javascript:;'
					0 title='关于我们' class='hover-none nav'><span>关于我们</span></a></li>
				<li id='nav_2' style='width: 123px;'><a href='javascript:;'
					title='信息中心' class='hover-none nav'><span>信息中心</span></a></li>
				<li id='nav_3' style='width: 123px;'><a href='javascript:;'
					title='恒达汽修产品' class='hover-none nav'><span>最强汽修产品</span></a></li>
				<li id='nav_4' style='width: 122px;' class='navdown'><a
					href='${pageContext.request.contextPath }/CarUrl?op=carservice' title='服务车型' class='hover-none nav'><span>服务车型</span></a></li>
				<li id='nav_34' style='width: 122px;'><a href='javascript:;'
					title='在线招聘' class='hover-none nav'><span>在线招聘</span></a></li>
				<li id='nav_11' style='width: 122px;'><a href='${pageContext.request.contextPath }/carOfficial/booking.jsp'
					title='在线预约 ' class='hover-none nav'><span>在线预约 </span></a></li>
				<li id='nav_18' style='width: 122px;'><a href='javascript:;'
					title='联系我们' class='hover-none nav'><span>联系我们</span></a></li>
			</ul>
		</nav>
	</div>



	<header>
		<div class="inner top">

			<a href="./../" title="汽配公司" id="web_logo"> <img
				src="/CarWebPro/carOfficial/img/1363847903.png" style="width: 210px; height: 55px;"
				alt="汽配公司" title="汽配公司" style="margin:0px 0px 0px 10px;" />
			</a>

			<div class="top-seo">
				<div class="tpseotxt">
					<p>&nbsp;020-5856-1762</p>
				</div>
			</div>
		</div>
	</header>

	<div class="inner met_flash">
		<div class="flash">
			<img src='/CarWebPro/carOfficial/img/1363850250.jpg' width='980' alt='' height='300'>
		</div>
	</div>

	<div class="sidebar inner">

		<div class="sb_nav">

			<h3 class='title line'>联系方式</h3>
			<div class="active editor b-r">
				<div>电话：020-5856-1762</div>
				<div>手机：15521389512</div>
				<div>QQ：913405314</div>
				<div>联系人：谭先生</div>
				<div>邮箱：hengdaqixiu@163.com</div>
				<div>邮编：404100</div>
				<div class="clear"></div>
			</div>

		</div>

		<div class='sb_box '>
			<h3 class="title">
				<div class="position">
					当前位置：<a href="./../" title="网站首页">网站首页</a> &gt; <a href=../cases/ >服务车型</a>
				</div>
				<span>服务车型</span>
			</h3>
			<div class="clear"></div>

			<div class="active tupAple" id="imglist">
				<ul class='list-none metlist'>
				<c:forEach items="${list}" var="item">
					<li class='list' style='width: 231px; margin-left: 10px; margin-right: 10px;'>
					
						<a href='#' title='${item.carName}' target='_self' class='img' onclick="javascript:return edit('${item.carImg}','${item.carName}')">
						<img src='uploadFile/${item.carImg}' alt='${item.carName}' title='${item.carName}' width='210'height='130' /></a>
						<h3>
							<a href='#' title='${item.carName}' target='_self'>${item.carName}</a>
						</h3>
					
					</li>
					</c:forEach>
				</ul>
				<div class="clear"></div>
			</div>
			<div id="flip">
				<div class='digg4 metpager_8'>
					<span class='disabled disabledfy'><b>«</b></span><span
						class='disabled disabledfy'>‹</span><span class='current'>1</span><span
						class='disabled disabledfy'>›</span><span
						class='disabled disabledfy'><b>»</b></span>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin-top:100px;">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
        
      </div>
      <div class="modal-body" style="height:340px">
      <div class="col-md-1"></div>
        <img   class="col-md-10" id="imageId"width='400px' height='300px' />
        <div class="col-md-1"></div>
      </div>
    </div>
  </div>
</div>

		<footer class="inner">
			<div class="foot-nav">
				<a 0 title='关于我们'>关于我们</a><span> |</span> <a title='客户留言'>客户留言</a><span>|
					<span> <a
						href='${pageContext.request.contextPath }/carOfficial/booking.jsp'
						title='在线预约'>在线预约</a><span>| </span> <a title='人才招聘'>人才招聘</a><span>|
							<a title='网站地图'>联系我们</a>
			</div>
			<div class="foot-text">
				<p>最强汽修有限公司版权所有 2017-2018 备案号：渝ICP备13004606</p>
				<p>电话：020-5856-1762</p>
			</div>
		</footer>


	<script src="/CarWebPro/carOfficial/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/CarWebPro/carOfficial/js/bootstrap.js"></script>
 <script>
 	function edit(carImg,carName){
 		var h1 = document.getElementById('myModalLabel');
 		h1.innerHTML = carName;
 		img='uploadFile/'+carImg;
 		$("#imageId").attr("src",img);
 		$('#myModal').modal('show');

 	}
 </script>
</body>

</html>