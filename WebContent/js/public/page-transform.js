/**
 * 依赖Toast,zepto
 * @param {Object} fromPage		父页面
 * @param {Object} loding	loading中的回调
 * @param {Object} after
 * @param {Object} speed, loading动画时间，为负数时表示不使用loading动画
 */


$(function(){
	var Module = (function(){
		
		var modules = {};
		
		function  init(){
			
		}
		
		function notify(){
			if(arguments.length==1){
				arguments[0].update();
				return;
			}
			for(var i=0; i<arguments.length-1; i++){
				arguments[i].update(arguments[arguments.length-1]);
			}
		}
		function notifyAll(){
			
		}
		function update(args){
			
		}
		/**
		 * 
		 * @param {Object} toPage	pageid
		 * @param {Object} loadingCallback loading动画开始后立即执行回调
		 * @param {Object} afterCallback	页面切换完后执行回调
		 */
		function pageNext(toPage, loadingCallback, afterCallback){
			Toast.load();
			var  that = this;
			setTimeout(function(){
				loadingCallback && loadingCallback();
				that.modules[toPage] && (that.modules[toPage].from = that.moduleName);
				var from = $('#'+that.moduleName), to = $('#'+toPage);
				from.removeClass('page-active').addClass("page-prev page-out");
				to.removeClass('page-prev page-active').addClass("page-next");
				//debugger;
				$('.page-wrap').one("transitionend", '.page-out', function(){
					$(this).removeClass("page-out");
					afterCallback && afterCallback();
					Toast.hide();
				})
				$('.page-wrap').one("transitionend", '.page-in',function(){
					$(this).removeClass("page-in");
					afterCallback && afterCallback();
					Toast.hide();
				})
				to.height();		//强制回流，使下面的语句顺利执行
				setTimeout(function(){
					to.removeClass("page-next").addClass("page-active page-in");
				},0);
			},500)
		}
		function pagePrev(toPage, loadingCallback, afterCallback){
			Toast.load();
			var  that = this;
			setTimeout(function(){
				loadingCallback && loadingCallback();
				that.modules[toPage] && (that.modules[toPage].from = that.moduleName);
				var from = $('#'+that.moduleName), to = $('#'+toPage);
				from.removeClass('page-active').addClass("page-next page-out");
				to.removeClass('page-next page-active').addClass("page-prev");
				$('.page-wrap').on("transitionend", '.page-out', function(){
					$(this).removeClass("page-out");
					afterCallback && afterCallback();
					Toast.hide();
				})
				$('.page-wrap').on("transitionend", '.page-in',function(){
					$(this).removeClass("page-in");
					afterCallback && afterCallback();
					Toast.hide();
				})
				setTimeout(function(){
					to.removeClass("page-prev").addClass("page-active page-in");
				},0);
			},500)
		}
		Object.extend = function(parent, obj){
			function TmpObj(){
				for(var i in obj){
					if(obj.hasOwnProperty(i)){
						this[i] = obj[i];
					}
				}	
			}
			TmpObj.prototype = parent;
			var o = new TmpObj();
			return o;
		}
		return {
			moduleName:"",		//必须赋值，且moduleName与页面id要一致
			from:"",		//从哪个页面跳转过来
			modules: modules,		//所有模块在init时就应该保存到了modules中了
			init:init,
			notify:notify,
			notifyAll:notifyAll,
			update:update,		//各个模块根据数据更新页面
			pageNext:pageNext,
			pagePrev:pagePrev
		}
	})();
	
	/**
	 * 首页模块
	 */
	var indexModule = Object.extend(Module, {
		moduleName: 'index',
		init:function(){
			var that = this;
			that.modules[that.moduleName] = that;
			
			$('.order-wrap').tap(function(){
				that.pageNext("dishes");
			})
			$('.my-order-wrap').tap(function(){
				that.pageNext('my-center');
			})
			
			$.ajax({
				type:"get",
				url: '/menu!getAllMenuType',
				dataType: 'json',
				success:function(data, status, jqXHR) {
					var n = data.length;
					var uls = "", lis = "";
					for(var i = 0, k = Math.ceil(n/4); i<k; i++){
						uls+="<ul>";
						lis="";
						for(var j = i*4; j<i*4+4 && j<n ; j++){
							//uls+='<li>'+data[j]+'</li>';
							lis = lis + "<li class='"+(Math.random()>0.5?"type-lighthigh":"type-yellowhigh")+"'>"+data[j]+"</li>";
						}
						uls+=lis+"</ul>";
					}
					uls+='<span class="triangle-border"><span class="triangle"></span></span>';
					$('#index .order-type').html(uls);
				}
			})
			$.ajax({
				type:"get",
				url:"/menu!getActivityMenuImg",
				async:true,
				dataType:'json',
				success:function(data, status, jqXHR){
					var $wrap = $('.swipe-wrap'),
					swips = "";
					
					data.forEach(function(ele, index){
						swips = swips + '<div class="swipe"><img src="'+ele+'" alt="" /></div>'
					})
					$wrap.html(swips);
				}
			});
			
			
		},
		update:function(){
			
		}
	})
	indexModule.init();
	
	
	/**
	 * 菜单选择模块
	 */
	var dishesModule = Object.extend(Module, {
		moduleName:"dishes",
		init:function(){
			var that = this;
			that.modules[that.moduleName] = that;
			
			that.allMenuObj = {};	//独有属性，allMenu，格式如{1(id):{id:1,item:'adsf',price:11, ....},id:{....}}
			that.allMenuArray = []; //独有属性，allMenu，格式如[{id:1,item:'adsf',price:11, ....},{....}]
			that.menuType = [];	//独有属性，menuType，格式如[{type:'优惠',num:3(菜式数量)},{...}]
			that.orders = {};	//独有属性，orders为当前所点菜单对象，格式如{id:buyNum,id:buyNum...}
			that.totalPrice = 0; 	//dishesModule独有属性totalPrice
			Object.observe(that, function(changes){		//对其进行监控
				changes.forEach(function(change) {
			        console.log(change.type, change.name, change.oldValue);
					if(change.name=="totalPrice"){
						$('#dishes .total-price, #shop-cart .total-price, #order-info .total-price').html("￥"+that.totalPrice);
					}
			    });
			})
			
			initSideType();
			menuScroll = new  IScroll("#menu-wrap",{
				bounce: true,
				probeType: 2,
				mouseWheel: true
			})
			sideScroll = new IScroll('#side-type-wrap', {
				bounce: true,
				mouseWheel: true
			});
			
			menuScroll.on('scrollEnd',function(){
				var y = 0;
				for(var i=0; i<that.menuType.length-1; i++){
					y = Math.abs(this.y);
					if(y>=(that.menuType[i].start-1)*81 && y<(that.menuType[i+1].start-1)*81){
						$('#side-type-wrap li').eq(i).addClass('type-active').siblings().removeClass('type-active');
						return ;
					}
				}
			})
			
			function initSideType(){
				//初始化侧边栏
				$.ajax({
					type:"get",
					url: '/menu!getAllMenuType',
					dataType: 'json',
					success:function(data, status, jqXHR) {
						var n = data.length,
							lis = '';
						data.forEach(function(ele, index){
							that.menuType.push({type:ele, num: 0, start: 0});
							if(index == 0){
								lis += '<li class="type-active">'+ele+'</li>';					
							}else{
								lis += '<li>'+ele+'</li>';					
							}
						})
						initMenu();
						$("#dishes .side-type ul").html(lis);
						setTimeout(function(){
							sideScroll.refresh();
						}, 0);
					}
				})
			}
			
			
			
			function initMenu(){
				//初始化菜式
				$.ajax({
					type:"get",
					url: '/menu!getAllMenu',
					dataType: 'json',
					success:function(data, status, jqXHR) {
						var menus = data.menus,
							lis = "";
						that.allMenuArray = menus = sortMenu(menus);
						menus.forEach(function(ele, index){
							that.allMenuObj[ele.id] = ele;
							lis += '<li><span class="menu-name">'+ele.item+'</span><span class="appraise-btn">评论></span><span class="sale-num">月售'+ele.saleNum+'</span><span class="price"><span class="price-btn">￥'+ele.price+'</span></span></li>';
						})
						$('#menu-wrap ul').html(lis);
						setTimeout(function () {
					        menuScroll.refresh();
					    }, 0);
					}
				})
			}
			
			//点击侧边栏菜式类型
			$('#dishes .side-type').on('tap', 'li', function(){
				var index = $(this).index();
				console.log(that.menuType[index].start);
				menuScroll.scrollToElement(document.querySelector('#menu-wrap li:nth-child('+that.menuType[index].start+')'));
				
				$(this).addClass("type-active").siblings().removeClass('type-active');
				
			})
			
			//点击评论||价格||-（减号）			//未完成状态，没有把当前状态保存到that.orders中
			$('#dishes #menu-wrap').on('tap', '.appraise-btn, .price-btn, .delete-num', function(){
				var classes = this.classList;
				var index;
				if(classes.contains('appraise-btn')){
					index = $(this).parent().index();
					that.pageNext('appraise',function(){
						that.notify(that.modules['appraise'],{index:index, id:that.allMenuArray[index].id, item:that.allMenuArray[index].item})
					});
				}else if(classes.contains('price-btn')){
					that.totalPrice += parseInt($(this).html().substring(1));
					var $next = $(this).next();
					if($next.is('.price-num')){
						$next.html(parseInt($next.html())+1);
					}else{
						var html = '<span class="price-num">1</span><span class="delete-num">一</span>';
						$(this).parent().append($(html));
					}
					
					index = $(this).parent().parent().index();
					var	id = that.allMenuArray[index].id;
					that.orders[id]=!!that.orders[id]?++that.orders[id]:1;
					console.log(that.orders);
				}else if(classes.contains('delete-num')){
					var $prev = $(this).prev();
					var currentNum = parseInt($prev.html())-1;
					that.totalPrice -= parseInt($(this).parent().find('.price-btn').html().substring(1));				
					index = $(this).parent().parent().index();
					if(currentNum>0){
						$prev.html(currentNum);	
					}else{
						$prev.remove();
						$(this).remove();
					}
					var	id = that.allMenuArray[index].id;
					--that.orders[id]==0? (delete that.orders[id]):'';
					console.log(that.orders);
				}
			})
			
			//返回 
			$('#dishes .nav-back').tap(function(){
				that.pagePrev('index')
			})
			
			//去结算
			$('#dishes .confirm-dishes-btn').tap(function(){
				if(that.totalPrice == 0){
					Toast.show('请先点餐')
					return;
				}
				that.pageNext('shop-cart',function(){
					that.notify(that.modules['shop-cart'],{orders:that.orders, menus:that.allMenuObj})
				});
			})
			
			function sortMenu(menus){
				var tmp = [];
				that.menuType.forEach(function(typeObj, i){
					menus.forEach(function(menu, j){
						if(typeObj.type==menu.type){
							tmp.push(menu);
							that.menuType[i].num++;
						}
					})
				})
				
				that.menuType.forEach(function(typeObj, i){
					var k;
					
					if(i==0){
						that.menuType[0].start = 1;
					}else{
						k = 0;
						for(var j=0; j<i; j++){
							k += that.menuType[j].num;
						}
						that.menuType[i].start = k+1;
					}
				})
				console.log(that.menuType)
				
				return tmp;
			}
			
		},
		update: function(args){
			
		}
	})
	dishesModule.init();
	
	
	/**
	 * 	购物车模块 
	 */
	var shopCartModule = Object.extend(Module, {
		moduleName:"shop-cart",
		init:function(){
			var that = this;
			that.modules[that.moduleName] = that;
			
			//返回 
			$('#shop-cart .nav-back').tap(function(){
				that.pagePrev(that.from);
			})
			
			//确认美食
			$("#shop-cart .confirm-btn").tap(function(){
				that.pageNext('order-info');
			})
		},
		update:function(args){
			var orders = args.orders,
				menusObj = args.menus;
			var totalPrice = 0, lis='', price = 0, num = 0, totalNum = 0;
			for(var id in orders){
				if(orders.hasOwnProperty(id)){
					price = menusObj[id].price,
					num = orders[id];
					totalNum += num;
					lis += '<li><span class="menu-name">'+menusObj[id].item+'</span><span class="buy-num">x'+num+'</span><span class="price">￥'+price+'</span></li>';
					totalPrice += price*num;
				}
			}
			this.modules['dishes'].totalPrice = totalPrice;
			$('#shop-cart .total-num').html(totalNum);
			$('#shop-cart .main ul').html(lis);
		}
	})
	shopCartModule.init();
	
	
	/**
	 * 评论模块
	 */
	var appraiseModule = Object.extend(Module, {
		moduleName:"appraise",
		init:function(){
			var that = this;
			that.modules[that.moduleName] = that;
			
			//返回 
			$('#appraise .nav-back').tap(function(){
				that.pagePrev(that.from);
			})
		},
		update:function(args){	//必须饮食item和id
			$appraise = $('#appraise');
			$appraise.find('.menu-name').html(args.item);
			console.log(args);
			$.ajax({
				type:"get",
				url: '/appraise!getAppraiseByMenuID',
				data:{
					id: args.id
				},
				dataType: 'json',
				success:function(data, status, jqXHR) {
					var lis = '',appraises = data.appraises;
					appraises.forEach(function(appraise, i){
						lis += '<li><span class="guest-name">'+appraise.name+'</span><span class="guest-date">&nbsp;&nbsp;&nbsp;&nbsp;'+appraise.date+'</span><p class="guest-msg">'+appraise.msg+'</p></li>';
					})
									
					$appraise.find('.scope').html(data.scope);
					$appraise.find('.appraise-num').html(data.num+'人评价');
					$appraise.find('.percent').each(function(i, ele){
						ele.innerHTML = '&nbsp;&nbsp;' + data.praiseLevels[i];
					})
					$appraise.find('.message ul').html(lis);
					
				}
			})
		}
	})
	appraiseModule.init();

})