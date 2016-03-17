/**
 * Created by KNapret on 15.03.2016.
 */
var canvas = document.getElementById('myCanvas');
var pauseDiv = document.getElementById('pause')
var lostDiv = document.getElementById('gameover');
var ctx = canvas.getContext('2d'); // 2D-Kontext
var pause = false;
var lock = false;
var shoot;
var id;
var idMoveDown;
var shooter;
var alien_formation = [];


class Schuss {

    constructor(posX, posY) {

        this.posX = posX;
        this.posY = posY;
        console.log(this.posX);
        console.log(this.posY);

    }

    zeichne(race) {
        //zeichnet den Schuss einen Pixel weiter Oben,
        // bzw. weiter unten (je nach Rasse)
        //race: 1 = ship ; 2 = alien
        lock = true;
        console.log(this.posY);
        ctx.beginPath();
        ctx.rect(this.posX, this.posY, 2, 10);

        this.inTouch();

        ctx.fill();
        if (this.posY < 355)
            ctx.clearRect(this.posX, this.posY + 11, 2, 10);

        if (race == 1) {
            this.posY--;
        } else {
            this.posY++;
        }


        if (this.posY <= 0 || this.posY >= 380) {
            clearInterval(id);
            drawCanvas();
            lock = false;
        }


    }

    inTouch() { //löscht ein Alien, wenn es getroffen wird.

        //ToDo: HitBox anpassen!

        for (let i = 0; i < alien_formation.length; i++) {

            if (alien_formation[i] != null) {
                if ((this.posX <= alien_formation[i].posX + 9 && this.posX >= alien_formation[i].posX - 5) && (this.posY <= alien_formation[i].posY + 5 && this.posX >= alien_formation[i].posX - 5)) {
                    alien_formation[i] = null;
                    this.posY =0;
                }
            }


        }
    }


}



class Schiff {

    constructor(posX) {

        this.shooterX = posX;
        this.bullet = null;
    }

    moveRight() {//setzt die X Position des Schiffes 10px weiter nach rechts

        if (this.shooterX <= 360) {
            ctx.clearRect(this.shooterX, 375, 20, 20);

            this.shooterX = this.shooterX + 10;


            ctx.beginPath();
            ctx.fillStyle = 'black';
            ctx.rect(this.shooterX, 375, 20, 20);
            ctx.fill();


        }


    }

    moveLeft() {//setzt die X Position des Schiffes 10px weiter nach links

        if (this.shooterX >= 15) {
            ctx.clearRect(this.shooterX, 375, 20, 20);

            this.shooterX = this.shooterX - 10;


            ctx.beginPath();
            ctx.fillStyle = 'black';
            ctx.rect(this.shooterX, 375, 20, 20);
            ctx.fill();
        }


    }

    draw(X) {//zeichnet das Schiff an Position X (Y Position ist beim Schiff nicht veränderbar)

        ctx.beginPath();
        ctx.fillStyle = 'black';
        ctx.rect(X, 375, 20, 20);
        ctx.fill();
    }

    shoot() {//feuert einen Schuss aus aktueller Position +9 (Mitte des Schiffes)
        //mit hilfer der schuss.zeichne() Methode ab
        //der Schuss startet immer auf Y=375 (nicht veränderbar)

        this.bullet = new Schuss(this.shooterX + 9, 375);
        id = setInterval(function () {
            shooter.bullet.zeichne(1);
        }, 1);

    }
}

class Alien {

    constructor(posX, posY) {
        this.posX = posX;
        this.posY = posY;
        this.bullet = null;

    }

    moveRight() {//schiebt das Alien 1px weiter nach rechts

        this.posX++;

    }

    moveLeft() {//schiebt das Alien 1px weiter nach links

        this.posX--;
    }

    movedown() {//schiebt das Alien 10px weiter nach unten

        this.posY = this.posY + 10;
        console.log(this.posY)

    }

    shoot() {//feuert einen Schuss vom Alien aus ab (mit hilfe der schuss.shoot())

        this.bullet = new Schuss(this.posX, this.posY);
        id = setInterval(function () {
            this.bullet.zeichne(2); //anpassen, von wem der Schuss kommt. Im moment "this = undefined"
        }, 1);

    }

    draw() {//zeichnet das Alien an seiner X und Y Position. 11px breit, 10px hoch, grün.

        ctx.beginPath();
        ctx.fillStyle = 'green';
        ctx.rect(this.posX, this.posY, 11, 10);
        ctx.fill();


    }
}

function gameMove() { //sorgt für die Bewegung der Aliens

    //ToDo: Bewegung nach rechts und links!

    idMoveDown = setInterval(function () { // runter

        for (let i = 0; i < alien_formation.length; i++) {
            if (alien_formation[i] != null) {
                alien_formation[i].movedown();

                if (alien_formation[i].posY >= 380) {
                    console.log("LOST");
                    clearInterval(idMoveDown);
                    lostDiv.style.display = "block";
                }


            }
        }

        drawCanvas();
        console.log("INVASION!")

        if(!getInvasion()){
            clearInterval(idMoveDown);
            start();
        }

    }, 1000)


}

function getInvasion(){

    let invasion = false;

    for(let i=0;i<alien_formation.length;i++){
        if(alien_formation[i]!=null){
            invasion = true;
        }
    }

    return invasion;

}


function start() { //Startfunktion, erstellt das Schiff und das AlienArray

    window.addEventListener('keydown', generalListener);
    window.addEventListener('keydown', pauseListener);


    shooter = new Schiff(210);

    let positionX = 30;

    for (let i = 0; i < 7; i++) {

        alien_formation[i] = new Alien(positionX + 20, 10);
        alien_formation[i].draw();
        positionX += 50;
    }

    drawCanvas();
    gameMove();
}


var generalListener = function (e) {

    let key = e.keyCode; //speichert den KeyCode des Events

    window.addEventListener('keydown', pauseListener);


    if (pause == false) {

        if (key == 39) { // Pfeil-rechts
            shooter.moveRight();
            console.log(shooter.shooterX);

        } else if (key == 37) { //Pfeil-links

            shooter.moveLeft()
            console.log(shooter.shooterX);

        } else if (key == 32) { //Space, nur schießen, wenn kein Schuss unterwegs

            if (lock == false) {
                shooter.shoot();


            }


        }
    } else {
        if (key == 80) { //Taste "P"
            console.log("Pause entfernt")
            pause = false;
            pauseDiv.style.display = 'none';

            if (shooter.bullet != null) {

                if (shooter.bullet.posY != 375) {
                    id = setInterval(function () {
                        shooter.bullet.zeichne(1);
                    }, 1);


                }
            }

            gameMove();


        }
    }


}


var pauseListener = function (e) {//bei "P" wird der Schussintevall und AlienIntervall unterbrochen,
    // Pause angezeigt und der Eventlistener wieder entfernt

    let key = e.keyCode;
    if (key == 80) {
        clearInterval(id);
        clearInterval(idMoveDown);
        console.log("Pause gesetzt");
        pause = true;
        //div "pause" anzeigen
        pauseDiv.style.display = 'block';
        window.removeEventListener('keydown', pauseListener);

    }

}

function drawCanvas() { //löscht das aktuelle Canvas und zeichnet es neu. Nutzt die .draw() Methoden von Alien und Schiff

    canvas.width = canvas.width;
    shooter.draw(shooter.shooterX);

    for (let i = 0; i < alien_formation.length; i++) {
        if (alien_formation[i] != null)
            alien_formation[i].draw();
    }


}


start();




/*<--------------------------------------------------- ABLAGE ------------------------------------------------------->*/
/*function schuss(){
 let y = 375;
 let x = shooterX+10;




 let id = setInterval(feuer,1);









 function feuer() {


 lock = true;
 console.log(y)
 ctx.beginPath();
 ctx.rect(x, y, 2, 10);
 ctx.fill();
 if(y<355)
 ctx.clearRect(x,y+11,2,10);

 y--;
 if (y <= 0){
 clearInterval(id);
 canvas.width = canvas.width;
 ctx.beginPath();
 ctx.fillStyle = 'black';
 ctx.rect(shooterX, 375, 20, 20);
 ctx.fill();
 lock = false;
 }





 }

 }*/

/*function moveRight() {
 if (shooterX <= 360) {
 ctx.clearRect(shooterX, 375, 20, 20);

 shooterX = shooterX + 10;


 ctx.beginPath();
 ctx.fillStyle = 'black';
 ctx.rect(shooterX, 375, 20, 20);
 ctx.fill();


 }


 }

 function moveLeft() {
 if (shooterX >= 15) {
 ctx.clearRect(shooterX, 375, 20, 20);

 shooterX = shooterX - 10;


 ctx.beginPath();
 ctx.fillStyle = 'black';
 ctx.rect(shooterX, 375, 20, 20);
 ctx.fill();
 }

 }*/







