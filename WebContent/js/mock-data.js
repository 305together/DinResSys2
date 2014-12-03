(function(){
	var Datas = {};
	
	//DinResSys2/menu!getAllMenuType	获取菜式类型
	Datas.allMenuType = [
		'优惠',
		'烧烤',
		'比萨',
		'意式风味'
	];
	Mock.mock('/DinResSys2/menu!getAllMenuType', Datas.allMenuType);
	
	
	//DinResSys2/menu!getActivityMenuImg	返回4张参与了活动的菜式图片
	Datas.activityMenuImg = [
		"@IMAGE(320x213)",
		"@IMAGE(320x213)",
		"@IMAGE(320x213)",
		"@IMAGE(320x213)"
	];
	Mock.mock('/DinResSys2/menu!getActivityMenuImg',Datas.activityMenuImg);
	
	
	//DinResSys2/menu!getMenuByType   根据类型获取菜式
	Datas.menus = {
		'menus':[{
			'id': 1,
			'item': '扬州炒饭',
			'price':  13,
			'saleNum': 30,	//月售30份
			'type':'优惠'
		},{
			'id': 3,
			'item': '牛肉炒饭',
			'price':  20,
			'saleNum': 10,	//月售10份
			'type':'烧烤'
		}]
	}
	Mock.mock('/DinResSys2/menu!getMenuByType', Datas.menus);
	//console.log(JSON.stringify(Mock.mock(Datas.menus), null, 4));
	
	
	//DinResSys2/menu!getAllMenu		获取所有菜式
	Datas.allMenu = {
		'menus':[{
			'id': 1,
			'item': '扬州炒饭',
			'price':  13,
			'saleNum': 30,		//月售30份
			'type': '优惠'
		},{
			'id': 2,
			'item': '面条',
			'price':  13,
			'saleNum': 30,		//月售30份
			'type': '意式风味'
		},{
			'id': 3,
			'item': '三煎比萨',
			'price':  13,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 4,
			'item': '牛肉烧烤',
			'price':  20,
			'saleNum': 10,		//月售10份
			'type':'烧烤'
		},{
			'id': 5,
			'item': '三煎比萨2',
			'price':  13,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 6,
			'item': '三煎比萨3',
			'price':  13,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 7,
			'item': '三煎比萨4',
			'price':  13,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 8,
			'item': '麦辣比萨',
			'price':  13,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		},{
			'id': 9,
			'item': '培根比萨',
			'price':  13,
			'saleNum': 30,		//月售30份
			'type': '比萨'
		}]
	}
	Mock.mock('/DinResSys2/menu!getAllMenu',Datas.allMenu);
	
	
	//appraise!getAppraiseByMenuID		根据菜式ID获取菜式评价		{menuID: '2'}
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
	Mock.mock('/appraise!getAppraiseByMenuID', Datas.menuAppraise);
	
	
	//DinResSys2/user!getLoginStatus			//获取登录状态
	Datas.loginStatus = {
		'status': 2			//返回值1为已登录，2为未登录，其他值为登录异常（随便给个）
	}
	Mock.mock('/DinResSys2/user!getLoginStatus', Datas.loginStatus);
	
	
	//DinResSys2/user!login			//登录		{name:'培明',pwd:'8888888'}
	Datas.loginResult = {
		'status': 1		//返回值1为已登录，2为未登录，其他值为登录异常（随便给个）
	}
	Mock.mock('/DinResSys2/user!login', Datas.loginResult);
	
	
	//DinResSys2/user!register			//登录		{name:'培明',pwd:'8888888', phone:'13800138000', address: '天河区五山'}
	Datas.registerResult = {
		'status': 1		//返回值1为注册成功，2为失败，其他值为登录异常（随便给个）
	}
	Mock.mock('/DinResSys2/user!register', Datas.registerResult);
	
})();


