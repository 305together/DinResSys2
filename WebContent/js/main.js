document.addEventListener("DOMContentLoaded", function() {
	window.mySwipe = new Swipe(document.getElementById('slider'), {
		speed: 400,
		auto: 2000,
		continuous: true,
		disableScroll: false,
		stopPropagation: false,
		callback: function(index, elem) {},
		transitionEnd: function(index, elem) {}
	});
	sideScroll = new IScroll('#side-type-wrap', {
		mouseWheel: true
	});
	menuScroll = new  IScroll("#menu-wrap",{
		mouseWheel: true
	})
	document.querySelector("#menu-wrap").addEventListener('touchstart',function(){
		
	},false);
	
})
