/*(function(){
	var Datas = {};
	
	//DinResSys2/menu!getAllMenuType	获取菜式类型
	Datas.allMenuType = [
		'优惠',
		'烧烤',
		'比萨',
		'意式风味',
		'炒饭',
		'泰式菜',
		'韩国料理',
		'越南菜'
	];
	Mock.mock('/DinResSys2/menu!getAllMenuType', Datas.allMenuType);
	
	
	//DinResSys2/menu!getActivityMenuImg	返回4张参与了活动的菜式图片
	Datas.activityMenuImg = [
//		"@IMAGE(320x213)",
//		"@IMAGE(320x213)",
//		"@IMAGE(320x213)",
//		"@IMAGE(320x213)"
		'img/index/1.jpg',
		'img/index/2.jpg',
		'img/index/3.jpg'
	];
	Mock.mock('/DinResSys2/menu!getActivityMenuImg',Datas.activityMenuImg);
	
	
	//console.log(JSON.stringify(Mock.mock(Datas.menus), null, 4));
	
	
	//DinResSys2/menu!getAllMenu		获取所有菜式
	Datas.allMenu = {
		'menus':[{
			'id': 1,
			'item': '扬州炒饭',
			'price':  13,
			'hasPromotion': true,
			'saleNum': 30,		//月售30份
			'type': '优惠'
		},{
			'id': 2,
			'item': '面条',
			'price':  13,
			'hasPromotion': true,
			'saleNum': 30,		//月售30份
			'type': '意式风味'
		},{
			'id': 3,
			'item': '三煎比萨',
			'price':  13,
			'hasPromotion': false,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 4,
			'item': '牛肉烧烤',
			'price':  20,
			'hasPromotion': false,
			'saleNum': 10,		//月售10份
			'type':'烧烤'
		},{
			'id': 5,
			'item': '三煎比萨2',
			'price':  13,
			'hasPromotion': false,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 6,
			'item': '三煎比萨3',
			'price':  13,
			'hasPromotion': false,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 7,
			'item': '三煎比萨4',
			'price':  13,
			'hasPromotion': false,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 8,
			'item': '麦辣比萨',
			'price':  13,
			'hasPromotion': false,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 9,
			'item': '培根比萨',
			'price':  13,
			'hasPromotion': false,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		}]
	}
	Mock.mock('/DinResSys2/menu!getAllMenu',Datas.allMenu);
	
	
	//DinResSys2/appraise!getAppraiseByMenuID		根据菜式ID获取菜式评价		{menu.id: '2'}
	Datas.menuAppraise = {
		'num':3,
		'scope': 2.8,		//菜式分数1~5，保留一位小数
		'praiseLevels':['40%', '30%', '20%', '5%', '5%'],		//5星评价、4星、3星、2星、1星分别对应百分比是40%、30%、20%、5%、5%
		'appraises':[{					//各个用户评论，只评了星级的（5星之类的）却没有留言的不列出。
			'name':'培明',				//评价人
			'msg': '还不错',				//评价内容
			'date': '2014.11.30'			//评价时间
		},{
			'name':'杰勇',
			'msg': '挺美味的',
			'date': '2014.11.30'
		},{
			'name':'刁辉',
			'msg': '偏清淡',
			'date': '2014.11.30'
		}]
	}
	Mock.mock('/DinResSys2/appraise!getAppraiseByMenuID', Datas.menuAppraise);
	
	
	//DinResSys2/user!getLoginStatus			//获取登录状态
	Datas.loginStatus = {
		'status': 1			//返回值1为已登录，2为未登录，其他值为登录异常（随便给个）
	}
	Mock.mock('/DinResSys2/user!getLoginStatus', Datas.loginStatus);
	
	
	//DinResSys2/user!login			//登录		{user.name:'培明',user.password:'8888888'}
	Datas.loginResult = {
		'status': 1		//返回值1为已登录，2为未登录，其他值为登录异常（随便给个）
	}
	Mock.mock('/DinResSys2/user!login', Datas.loginResult);
	
	
	//DinResSys2/user!register			//注册		{user.name:'培明',user.password:'8888888', user.tel:'13800138000', address.ad: '天河区五山'}
	Datas.registerResult = {
		'status': 1		//返回值1为注册成功，2为失败，其他值为登录异常（随便给个）
	}
	Mock.mock('/DinResSys2/user!register', Datas.registerResult);
	
	
	//DinResSys2/user!getUserInfo		//获取客户信息
	Datas.userInfo = {
		phone: '13800138000',
		addresses: [{		//返回的第一个address必须为默认地址
			'id': 1,		//address的id
			'address': '华农万家',	//具体地址
			'isDefault': true		//返回值true表示该地址为默认地址, false为非默认地址
		},{
			'id': 2,
			'address': '五山天河',
			'isDefault': false
		}]
	}
	Mock.mock('/DinResSys2/user!getUserInfo', Datas.userInfo);
	
	
	//DinResSys2/address!setDefaultAddress			//设置默认地址		{address.id: 1}
	Datas.setDefaultAddressResult = {	
		'status': 1		//返回值1为设置成功，2为失败，其他值为登录异常（随便给个）
	}
	Mock.mock('/DinResSys2/address!setDefaultAddress', Datas.setDefaultAddressResult);
	
	
	//DinResSys2/address!addAddress			//新增地址（新增的地址不是默认地址）		{address.ad: '天河五山'}
	Datas.addAddressResult = {	
		'status': 1,		//返回值1为设置成功，2为失败，其他值为登录异常（随便给个）
		'address': {
			'id':3,
			'address': '天河五山',
			'isDefault': false
		}
	}
	Mock.mock('/DinResSys2/address!addAddress', Datas.addAddressResult);
	
	
	//DinResSys2/order!commitOrderResult			//提交订单		{phone: '13800138000', addressID:1, remark: '加饭，多谢', menus:{1:3,2:1}}
	Datas.commitOrderResult = {	
		'status': 1		//返回值1为提交成功，2为失败，其他值为登录异常（随便给个）
	}
	Mock.mock('/DinResSys2/order!commitOrderResult', Datas.commitOrderResult);
	
	//DinResSys2/order!getAllOrder			//获取所有订单	
	Datas.getAllOrderResult = {
		orders:[{
			id: 1,
			date: '2014.9.30',				//下单时间
			status: '送达',					//订单状态：订单已提交、订单已确认、在送、送达
			menus:[{
				'id': 7,
				'item': '三煎比萨4',
				'price':  13,
				'num': 2,			//2份三煎比萨4
				'saleNum': 30,		//月售30份
				'type': '比萨'
			},{
				'id': 8,
				'item': '麦辣比萨',
				'price':  13,
				'num': 2,			//2份麦辣比萨
				'saleNum': 30,		//月售30份
				'type': '比萨'
			}]
		},{
			id: 2,
			date: '2014.9.30',				//下单时间
			status: '在送',					//订单状态：订单已提交、订单已确认、在送、送达
			menus:[{
				'id': 1,
				'item': '三煎比萨4',
				'price':  13,
				'num': 3,			//3份三煎比萨4
				'saleNum': 30,		//月售30份
				'type': '比萨'
			},{
				'id': 2,
				'item': '麦辣比萨',
				'price':  13,
				'num': 1,			//3份
				'saleNum': 30,		//月售30份
				'type': '比萨'
			},{
				'id': 3,
				'item': '培根比萨',
				'price':  13,
				'num': 2,			//3份
				'saleNum': 30,		//月售30份
				'type': '比萨'
			}]
		}]
	}
	Mock.mock('/DinResSys2/order!getAllOrder', Datas.getAllOrderResult);
	
	
	//DinResSys2/appraise!addAppraise			//添加对菜式的评论		{menuId:1, appraise.praiseLevel: 4, appraise.detail:'挺美味的'}
	Datas.addAppraiseResult = {
		'status': 1		//返回值1为提交成功，2为失败，其他值为登录异常（随便给个）
	}
	Mock.mock('/DinResSys2/appraise!addAppraise', Datas.addAppraiseResult)
	
	
	*//**
	 * 后台admin start
	 *//*
	//DinResSys2/admin/activity!addActivity		//新增活动					{'activity.activityName': '双12','activity.describe': '在12.12号全场折扣','activity.beginTime': '2014-12-11 23:59','activity.endTime': '2014-12-12 23:59','promotion':80}
	Datas.addActivityResult = {
		'status': 1		//返回值1为提交成功，2为失败
	}
	Mock.mock('/DinResSys2/admin/activity!addActivity', Datas.addActivityResult);
	
	
	//DinResSys2/admin/activity!changeActivity		//新增活动					{'activity.id':1,'activity.activityName': '双12','activity.describe': '在12.12号全场折扣','activity.beginTime': '2014-12-11 23:59','activity.endTime': '2014-12-12 23:59','promotion':80}
	Datas.changeActivityResult = {
		'status': 1		//返回值1为提交成功，2为失败
	}
	Mock.mock('/DinResSys2/admin/activity!changeActivity', Datas.changeActivityResult);

	//DinResSys2/admin/order!changeStatus			//改变订单状态			{'id':1, status: '在送'}
	Datas.changeStatusResult = {
		'status': 1		//返回值1为提交成功，2为失败
	}
	Mock.mock('/DinResSys2/admin/order!changeStatus', Datas.changeStatusResult);
	
	//DinResSys2/admin/type!addMenuType			//增加菜式类型		{'type.typeName':'比萨'}
	Datas.addMenuTypeResult = {
		'status':1 		//返回值1为提交成功，2为失败
	}
	Mock.mock('/DinResSys2/admin/type!addMenuType', Datas.addMenuTypeResult);
	
	//DinResSys2/admin/user!changeUserInfo		//修改用户账号或者密码		{'user.id': 1, 'user.name': 'derek', 'user.password': '6666'}
	Datas.changeUserInfoResult = {				
		'status': 1			//返回值1为提交成功，2为失败
	}
	Mock.mock('/DinResSys2/admin/user!changeUserInfo', Datas.changeUserInfoResult);
	*//**
	 * 后台admin end
	 *//*
})();


*/