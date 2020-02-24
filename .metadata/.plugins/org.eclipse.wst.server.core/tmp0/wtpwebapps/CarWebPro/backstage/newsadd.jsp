<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>配件添加</title>
<link rel="stylesheet" type="text/css" href="./css/css.css" />
<script type="text/javascript" src="./js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="/CarWebPro/backstage/img/coin02.png" /><span><a href="/CarWebPro/backstage/index.jsp" target="index">首页</a>&nbsp;-&nbsp;<a
					href="/CarWebPro/backstage/index.jsp" target="index">新闻管理</a>&nbsp;-</span>&nbsp;新闻添加
			</div>
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>添加</span>
				</div>
				<div class="baBody">
      <form action="${pageContext.request.contextPath }/NewsUrl?op=newsAdd" method="post" >
					<div class="bbD">
						新闻标题(varchar)：<input type="text" class="input3" name="tiltle" />
					</div>
					<div class="bbD">
						新闻内容(varchar)：<input type="text" class="input3" name="countent" />
					</div>
					<div class="bbD">
						发布时间(datetime)：<input type="text" class="input3" name="releaseTime" />
					</div>
					<div class="bbD">
						发布ID (varchar)：<input type="text" class="input3" name="staffId" />
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">提交</button>
							<a class="btn_ok btn_no" href="${pageContext.request.contextPath }/NewsUrl?op=queryNewsInfo" target="main">取消</a>

						</p>
					</div>
				</form>
				</div>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>