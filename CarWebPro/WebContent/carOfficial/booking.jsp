<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>

	<head>
		<meta name="renderer" content="webkit">
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>最强汽修有限公司</title>

		<link rel="stylesheet" type="text/css" href="./css/meteinfo_ui.css" id="metuimodule" data-module="1" />
		<link rel="stylesheet" type="text/css" href="./css/metinfo.css" />
		<script src="./js/jQuery1.7.2.js" type="text/javascript"></script>
		<script src="./js/metinfo_ui.js" type="text/javascript"></script>
		<script src="./js/ch.js" type="text/javascript"></script>
		<!--[if IE]>
<script src="./public/js/html5.js" type="text/javascript"></script>
<![endif]-->
	</head>

	<body>
		<div class="m-nav">
		<nav class="inner">
			<ul class="list-none">
				<li id="nav_10001" style='width: 123px;' class='navdown'><a
					href="${pageContext.request.contextPath }/indexUrl?op=queryBunner" title='网站首页' class='nav'><span>网站首页</span></a></li>
				<li id='nav_1' style='width: 123px;'><a 
					0 title='关于我们' class='hover-none nav'><span>关于我们</span></a></li>
				<li id='nav_2' style='width: 123px;'><a
					title='信息中心' class='hover-none nav'><span>信息中心</span></a></li>
				<li id='nav_3' style='width: 123px;'><a 
					title='恒达汽修产品' class='hover-none nav'><span>最强汽修产品</span></a></li>
				<li id='nav_4' style='width: 122px;'><a href='${pageContext.request.contextPath }/CarUrl?op=carservice'
					title='服务车型' class='hover-none nav'><span>服务车型</span></a></li>
				<li id='nav_34' style='width: 122px;'><a 
					title='在线招聘' class='hover-none nav'><span>在线招聘</span></a></li>
				<li id='nav_11' style='width: 122px;'><a href='${pageContext.request.contextPath }/carOfficial/booking.jsp'
					title='在线预约' class='hover-none nav'><span>在线预约</span></a></li>
				<li id='nav_18' style='width: 122px;'><a 
					title='联系我们' class='hover-none nav'><span>联系我们</span></a></li>
			</ul>
		</nav>
	</div>

		<header>
			<div class="inner top">

				<a href="./../" title="汽配公司" id="web_logo">
					<img src="./img/1363847903.png" style="width: 210px; height: 55px;" alt="汽配公司" title="汽配公司" style="margin:0px 0px 0px 10px;" />
				</a>

				<div class="top-seo">
					<div class="tpseotxt">
						<p>
							&nbsp;020-5856-1762</p>
					</div>
				</div>
			</div>
		</header>

		<div class="inner met_flash">
			<div class="flash">
				<img src='img/1363850250.jpg' width='980' alt='' height='300'></div>
		</div>

		<div class="sidebar inner">

			<div class="sb_nav">

				<h3 class='title line'>联系方式</h3>
				<div class="active editor b-r">
					<div> 电话：020-5856-1762</div>
					<div> 手机：15521389512</div>
					<div> QQ：913405314</div>
					<div> 联系人：谭先生</div>
					<div> 邮箱：hengdaqixiu@163.com</div>
					<div> 邮编：404100</div>
					<div class="clear"></div>
				</div>

			</div>

			<div class='sb_box b-r'>
				<h3 class="title">
			<div class="position">当前位置：<a href="./../" title="网站首页">网站首页</a> &gt; <a href=../feedback/ >在线预约</a></div>
			<span>在线预约</span>
		</h3>
				<div class="clear"></div>

				<div class="active" id="feedback">
					<script language='javascript'>
						function Checkfeedback() {
							if (document.myform.para16.value.length == 0) {
								alert('详细说明 不能为空');
								document.myform.para16.focus();
								return false;
							}
						}
					</script>
					<form id="frmAddBooking" action="${pageContext.request.contextPath }/QiantaiUrl?op=appAdd" method='POST' name='myform'   target='_self'>
						
						<span>${retMsg }</span>
						<table class='feedback_table'>
							<tr>
								<td class='text'>姓名:</td>
								<td class='input'><input maxlength="10" name="userName" type='text' size='30' class='input-text' /><span class='info' id="name">*</span></td>
							</tr>
							<tr>
								<td class='text'>性别:</td>
								<td class='input'>
									<input name='sex' type='radio' id='para18' value='男' checked='checked' />
									<label for='para18'>男</label> 
									<input name='sex' type='radio' id='para28' value='女' />
									<label for='para28'>女</label> 
									<span class='info' id="sex"></span><span></span></td>
							</tr>
							<tr>
								<td class='text'>车牌:</td>
								<td class='input'><input maxlength="10" name='carBrand' type='text' size='30' class='input-text' /><span class='info' id="licensePlateNumber">*</span></td>
							</tr>
							<tr>
								<td class='text'>车型:</td>
								<td>&nbsp;&nbsp;
									<select style="width: 160spx;" class="input" name="carId">
										<option value="1">小型车</option>
										<option value="2">微型车</option>
										<option value="3">紧凑车型</option>
										<option value="4">CDV车型</option>
										<option value="5">MPV车型</option>
										<option value="6">SUV车型</option>
										<option value="7">三厢车型</option>
										<option value="8">豪华车型</option>
										
									</select>
								</td>
								
							</tr>
							<tr>
								<td class='text'>手机:</td>
								<td class='input'><input name="tel" maxlength='11' type='text' size='30' class='input-text' /><span id="phone" class='info'></span><span></span></td>
							</tr>
							
							<tr>
								<td class='text'>预约时间:</td>
								<td class='input'>
									<input name="appointmentTime"  type="datetime-local"  /><span  class='info' id="appointmentTime"></span>
								</td>
							</tr>
							<tr>
								<td class='text'>服务类型:</td>
								<td>&nbsp;&nbsp;
									<select style="width: 160spx;" class="input" name="serviceId">
										<option value="1">&nbsp;&nbsp;修车</option>
										<option value="2">&nbsp;&nbsp;保养</option>
									</select>
								</td>
								
							</tr>
							<!-- <tr>
								<td class='text'>验证码</td>
								<td class='input'><input name='code' onKeyUp='pressCaptcha(this)' type='text' class='code'  size='6' maxlength='8' style='width:50px' />
								<img align='absbottom' src='img/code.jpg' onclick=this.src='../member/ajax.php?action=code&' +Math.random()
										style='cursor: pointer;' title='看不清？点击更换验证码' /><span id="code" class="info"></span></td>
							</tr> -->
							<tr>
								<td class='text'></td>
								<td class='submint'>
									<input id="btnSubmit" type="submit" name='Submit' value='提交信息' class='submit button orange'>
								</td>
							</tr>
						</table>
					</form>

				</div>
			</div>
			<div class="clear"></div>
		</div>

		</div>
		<div class="clear"></div>
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
	<script type="text/javascript" src="./js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript">
			$(function(){
				$("#btnSubmit").click(function(){
					var name=$("input[name=clientName]").val();
					var phone=$("input[name=telephone]").val();
					var appointmentTime=$("input[name=appointmentTime]").val();
					var code=$("input[name=code]").val();
					var licensePlateNumber=$("input[name=licensePlateNumber]").val();
					//alert(licensePlateNumber)
					var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
					if(name==""){
						$("#name").text("请输入姓名");
						return false; 
					}
					$("#name").text("");
					/* if(!myreg.test(phone)) 
					{ 
					   $("#phone").text("请输入有效的手机号码！");
					    return false; 
					}  $("#phone").text(""); */
					
					var is= isVehicleNumber(licensePlateNumber);
					/* if(!is){
						$("#licensePlateNumber").text("请输入正确的车牌号码");
						return false;
					}
					$("#licensePlateNumber").text(""); */
					
					if(appointmentTime.length<3){
						//alert("错")
						$("#appointmentTime").text("请选择预约时间");
						return false; 
					}
					$("#appointmentTime").text("");
					
					/* if(code==""){
						
						$("#code").text("请选择预约时间");
						return false; 
					} */
					$("#code").text("");
					
					//可以提交
					//$("#frmAddBooking").submit();
					
				})
				
			});
			
			//正则表达式验证车牌号码是否正确
			  function isVehicleNumber(vehicleNumber) {
			      var result = false;
			      if (vehicleNumber.length == 7){
			        var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
			        result = express.test(vehicleNumber);
			      }
			      return result;
			  }
			
		</script>
	</body>
</html>