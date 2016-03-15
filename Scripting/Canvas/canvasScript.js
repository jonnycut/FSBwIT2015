/**
 * Created by KNapret on 15.03.2016.
 */
var canvas = document.getElementById('myCanvas');
var ctx = canvas.getContext('2d'); // 2D-Kontext

ctx.beginPath();
ctx.fillStyle = 'black';
ctx.rect(200, 375, 20, 20);
ctx.fill();


feuer();


function feuer() {
    var x = 375;

    var shoot = setInterval(function () {
        console.log(x)

        ctx.beginPath();
        ctx.rect(210, x, 2, 10);
        ctx.fill();
        if(x<355)
            ctx.clearRect(210,x+11,2,10);

        x--;

        if (x <= 0){

            clearInterval(shoot);
            canvas.width = canvas.width;

            ctx.beginPath();
            ctx.fillStyle = 'black';
            ctx.rect(200, 375, 20, 20);
            ctx.fill();

        }


    }, 0.1);
}

