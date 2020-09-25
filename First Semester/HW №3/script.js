var content = document.getElementById( 'content' );
var btns = content.getElementsByTagName( 'button' );
btns[0].onclick = function() {
  content.style.backgroundColor = 'red';
};
btns[1].onclick = function() {
  content.style.backgroundColor = 'green';
};
btns[2].onclick = function() {
  content.style.backgroundColor = 'blue';
};
btns[3].onclick = function() {
  bg();
};

var r = 0,
g = 0,
b = 0;

function bg () {
  
	if (r <= 255 && g == 0 && b == 0) {
		r ++;
	}

	if (r == 255 && b == 0 && g <= 255) {
		g ++;
	}

	if (r == 255 && g == 255 && b <= 255) {
		b ++;
	}

	if (b == 255 && g == 255 && r > 0) {
		r --;
	}

	if (r == 0 && b == 255 && g > 0) {
		g --;
	}

	if (r == 0 && g == 0 && b > 0) {
		b --;
	}

	setTimeout(function() {
		bg();
	}, 10);

	content.style.backgroundColor = 'rgb('+r+','+g+','+b+')';
}	