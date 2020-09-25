var test = document.getElementById('eyeball1');
var test2 = document.getElementById('eyeball2');

document.addEventListener('mousemove',mouse_move)

function mouse_move(event)
{

    var posX = event.pageX;
    var posY = event.pageY;

    var testx = posX / 1264 * 70;
    var testy = posY / 768 * 70;

    test.style.left = 550 + testx  + 'px';
    test.style.top = 250 + testy + 'px';

    test2.style.left = 550 + testx + 90 + 'px' ;
    test2.style.top = 250 + testy + 'px';

	


}



