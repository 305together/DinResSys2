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
		<link rel="stylesheet" href="css/menu.css">

		<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

	</head>

	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><span>Lumino</span>Admin</a>
					<ul class="user-menu">
						<li class="dropdown pull-right">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> User <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a>
								</li>
								<li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a>
								</li>
								<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
								</li>
							</ul>
						</li>
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
				<li><a href="order!getAllOrderAdmin"><span class="glyphicon glyphicon-dashboard"></span> 订单管理</a>
				</li>
				<li class="active"><a href="menu!getAllMenus"><span class="glyphicon glyphicon-th"></span> 菜单管理</a>
				</li>
				<li><a href="user!getAllUser"><span class="glyphicon glyphicon-stats"></span> 客户管理</a>
				</li>
				<li><a href="activity!getAllActivity"><span class="glyphicon glyphicon-list-alt"></span> 活动管理</a>
				</li>
			</ul>
		</div>
		<!--/.sidebar-->

		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="#"><span class="glyphicon glyphicon-home"></span></a>
					</li>
					<li class="active">菜单</li>
				</ol>
			</div>
			<!--/.row-->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">菜单列表</div>
						<!-- Table -->
						<table class="table">
							<thead>
								<tr>
									<th>ID</th>
									<th>菜式名</th>
									<th>描述</th>
									<th>图片</th>
									<th>优惠折扣</th>
									<th>单价</th>
									<th>月售</th>
									<th>类型</th>
									<th>参与活动</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
								<s:iterator value="menuList" id="p" status="status">
									<td><s:property value="#p.id"/></td>
									<td><s:property value="#p.item"/></td>
									<td><s:property value="#p.dec"/></td>
									<s:if test="%{#p.img != null}">
									<td><img src="/DinResSys2/${p.img}" alt="" width='50'/></td>
									</s:if>
									<s:else>
									<td><img src="" alt="" /></td>
									</s:else>
									<td><s:property value="#p.dis"/></td>
									<td><span class="price">￥<s:property value="#p.price"/></span></td>
									<td><s:property value="#p.salenum"/></td>
									<td><s:property value="#p.type"/></td>
									<td><s:property value="#p.activity"/></td>
									<td>
										<span class='add'><a href="#">新增</a></span>
										<span class='delete'><a href="/DinResSys2/admin/menu!delete?id=${p.id}">删除</a></span>
										<span class="change"><a href="#">修改</a></span>
										
									</td>
								</tr>
								</s:iterator>
								<!-- <tr>
									<td>2</td>
									<td>至尊比萨</td>
									<td>美味鲜橙多汁的比萨</td>
									<td><img src="" alt="" /></td>
									<td>90</td>
									<td><span class="price">￥52</span></td>
									<td>31</td>
									<td>比萨</td>
									<td>双11</td>
									<td>
										<span class='add'><a href="#">新增</a></span>
										<span class='delete'><a href="/DinResSys2/admin/menu!delete?id=2">删除</a></span>
										<span class="change"><a href="#">修改</a></span>
									</td>
								</tr>
								 -->
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">菜单类型</div>
						<!-- Table -->
						<table class="table">
							<tr>
								<td>
									类型：
									<s:iterator value="typeList" id="p" status="status">
									<s:property value="#p.typeName"/>、
									</s:iterator>
								</td>
							</tr>
							<tr>
								<td><input id="menu-type" class="form-control" placeholder="填写类型"></td>
								<td><span class="add-menu-type"><a href="#">新增</a></span></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!--/.row-->


		</div>

		<div id="menuModal" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">菜式信息</h4>
					</div>
					<div class="modal-body">
						<div class="form-group has-success">
							<form action="/DinResSys2/admin/menu!addMenu" enctype="multipart/form-data" method="post">
								<input id="item" name='menu.item' class="form-control" type='text' placeholder="菜式名">
								<input id="price" name='menu.price' class="form-control" type='number' placeholder="单价">
								<input id="describe" name='menu.descri' class="form-control" type='text' placeholder="描述">
								<label for="picture">图片：</label>
								<input id='picture' name='menuImg' type='file' class="form-control">
								<label for="type">类型：</label>
								<select name="typeName" id="type">
								<s:iterator value="typeList" id="p" status="status">
									<option selected><s:property value="#p.typeName"/></option>
									</s:iterator>
								</select><br />
								<label for="activityName">参与活动：</label>
								<select name="activityName" id='activityName'>
									<option value="不参与活动" selected>不参与活动</option>
									<s:iterator value="activityTables" id="p" status="status">
									<option><s:property value="#p.activityName"/></option>
									</s:iterator>
								</select>  
								<input id='menuId' name='menu.id' type="text" style="display: none;" value=""/>
							</form>
						</div>					
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button class="commit-menu btn btn-primary" type="button">提交</button>
					</div>
				</div>
			</div>
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
		<script type="text/javascript" src="../js/public/mock.js" ></script>
		<script type="text/javascript" src="../js/mock-data.js" ></script>
		<script type="text/javascript" src="js/public.js" ></script>
		<script>
			! function($) {
				$(document).on("click", "ul.nav li.parent > a > span.icon", function() {
					$(this).find('em:first').toggleClass("glyphicon-minus");
				});
				$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
			}(window.jQuery);

			$(window).on('resize', function() {
				if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
			})
			 $(window).on('resize', function() {
				if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
			})
		</script>
		<script type="text/javascript" src="js/menu.js"></script>
	</body>

</html>