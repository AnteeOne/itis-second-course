var ball = document.getElementById('ball');
ball.style.top = 210 + 'px';
var xBound = window.innerWidth;
var yBound = window.innerHeight;

var speed = 10;
var secondHeigth = 200;

var x0 = 10;
var y0 = 10;

setInterval(screenSaver,30);

var x = 1;
var y = 1;

function screenSaver(){
	var posX = ball.offsetLeft;
	var posY = ball.offsetTop;


	if(posX + ball.offsetWidth > xBound || posX < 0){
		x*=-1;
	}

	if(posY + ball.offsetHeight > yBound || posY < 0){
		y*=-1;
	}

	x0 += x*speed;
	y0 +=  y*speed;
	ball.style.top = y0 + 'px';
	ball.style.left = x0 + 'px';

	


}


