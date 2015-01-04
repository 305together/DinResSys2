<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Tables</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link rel="stylesheet" href="css/public.css">
<link rel="stylesheet" href="css/index.css">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Lumino</span>Admin</a>
				<ul class="user-menu">
					<li class="dropdown pull-right"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><span
							class="glyphicon glyphicon-user"></span> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span>
									Profile</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cog"></span>
									Settings</a></li>
							<li><a href="#"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</ul></li>
				</ul>
			</div>

		</div>
		<!-- /.container-fluid -->
	</nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="order!getAllOrderAdmin"><span
					class="glyphicon glyphicon-dashboard"></span> 订单管理</a></li>
			<li><a href="menu!getAllMenus"><span class="glyphicon glyphicon-th"></span>
					菜单管理</a></li>
			<li><a href="user!getAllUser"><span
					class="glyphicon glyphicon-stats"></span> 客户管理</a></li>
			<li><a href="activity!getAllActivity"><span
					class="glyphicon glyphicon-list-alt"></span> 活动管理</a></li>
		</ul>
	</div>
	<!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a>
				</li>
				<li class="active">订单</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">订单列表</div>
					<!-- Table -->
					<table class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>菜式</th>
								<th>总价</th>
								<th>客户名</th>
								<th>电话</th>
								<th>送餐地址</th>
								<th>备注</th>
								<th>状态</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="orderList" id="p" status="status">
								<tr>
									<td><s:property value="id" /></td>
									<td class="price-td">
										<ul>
											<s:iterator value="menus" id="pi" status="status">
												<li><s:property value="item" />&nbsp;&nbsp;x<s:property
														value="num" />&nbsp;&nbsp;<span class="price">￥<s:property
															value="price" /></span></li>
											</s:iterator>
										</ul>
									</td>
									<td><span class="price">￥<s:property
												value="totalPrice" /></span></td>
									<td><s:property value="userName" /></td>
									<td><s:property value="phone" /></td>
									<td><s:property value="address" /></td>
									<td><s:property value="message" /></td>
									<td><select class="order-status">
											<s:if test="%{status == '订单已提交'}">
												<option value="订单已提交" selected>订单已提交</option>
											</s:if>
											<s:else>
												<option value="订单已提交" >订单已提交</option>
											</s:else>
											<s:if test="%{status == '订单已确认'}">
												<option value="订单已确认" selected>订单已确认</option>
												</s:if>
											<s:else>
												<option value="订单已确认">订单已确认</option>
											</s:else>
											<s:if test="%{status == '在送'}">
												<option value="在送" selected>在送</option>
												</s:if>
											<s:else>
												<option value="在送">在送</option>
											</s:else>
											<s:if test="%{status == '送达'}">
												<option value="送达" selected>送达</option>
												</s:if>
											<s:else>
												<option value="送达">送达</option>
											</s:else>
									</select></td>
								</tr>
							</s:iterator>
							<!-- 
								<tr>
									<td>2</td>
									<td class="price-td">
										<ul>
											<li>扬州炒饭&nbsp;&nbsp;x1&nbsp;&nbsp;<span class="price">￥26</span></li>
											<li>桂林米粉&nbsp;&nbsp;x1&nbsp;&nbsp;<span class="price">￥16</span></li>
											<li>扬州炒饭&nbsp;&nbsp;x1&nbsp;&nbsp;<span class="price">￥10</span></li>
										</ul>
										
									</td>
									<td><span class="price">￥52</span></td>
									<td>alix</td>
									<td>13800138000</td>
									<td>广东五山</td>
									<td>加饭</td>
									<td>
										<select class="order-status">
											<option value="订单已提交">订单已提交</option>
											<option value="订单已确认">订单已确认</option>
											<option value="在送" selected>在送</option>
											<option value="送达">送达</option>
										</select>
									</td>
								</tr>
								 -->
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!--/.row-->


	</div>

	<!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script type="text/javascript" src="../js/public/mock.js"></script>
	<script type="text/javascript" src="../js/mock-data.js"></script>
	<script type="text/javascript" src="js/public.js"></script>
	<script>
		!function($) {
			$(document)
					.on(
							"click",
							"ul.nav li.parent > a > span.icon",
							function() {
								$(this).find('em:first').toggleClass(
										"glyphicon-minus");
							});
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function() {
			if ($(window).width() > 768)
				$('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function() {
			if ($(window).width() <= 767)
				$('#sidebar-collapse').collapse('hide')
		})
	</script>
	<script type="text/javascript" src="js/index.js"></script>
</body>

</html>