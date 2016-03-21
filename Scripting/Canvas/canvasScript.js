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
var alienShot;
var idShipShot;
var idAlienShot;
var idAlienAttack;
var idShipMoveRight=null;
var idShipMoveLeft=null;
var idMoveDown;
var shooter;
var alien_formation = [];
var level = 80;


class Schuss {

    constructor(posX, posY) {

        this.posX = posX;
        this.posY = posY;
    }

    zeichne(race) {
        //zeichnet den Schuss einen Pixel weiter Oben,
        // bzw. weiter unten (je nach Rasse)
        //race: 1 = ship ; 2 = alien
        lock = true;
        ctx.beginPath();
        ctx.rect(this.posX, this.posY, 2, 10);

        this.inTouch(race);

        ctx.fill();
        if (this.posY < 355)
            ctx.clearRect(this.posX, this.posY + 11, 2, 10);

        if (race == 1) {
            this.posY = this.posY-2;
        } else {
            this.posY = this.posY+1;
        }


        if (this.posY <= 0 || this.posY >= 380) {
            if(race==1){
                clearInterval(idShipShot);
                idShipShot=null;
            }else{
                clearInterval(idAlienShot);
                idAlienShot = null;
            }

      



            lock = false;
            drawCanvas();
        }



    }

    inTouch(race) { //löscht ein Alien, wenn es getroffen wird.

        //ToDo: HitBox anpassen!
        if(race==1){
            for (let i = 0; i < alien_formation.length; i++) {

                if (alien_formation[i] != null) {
                    if ((this.posX <= alien_formation[i].posX + 20 && this.posX >= alien_formation[i].posX) && (this.posY <= alien_formation[i].posY +13 && this.posX >= alien_formation[i].posX - 5)) {
                        alien_formation[i] = null;
                        this.posY =0;
                    }
                }


            }
        } else if (race==2){

            if((this.posX>=shooter.shooterX && this.posX<=shooter.shooterX+20)&&(this.posY>=375)){
                shooter = null;
                gameOver();
            }

        }

    }


}



class Schiff {

    constructor(posX) {

        this.shooterX = posX;
        this.bullet = null;
        this.img = new Image();
        this.img.src = "panzer02.png";

    }

    moveRight() {//setzt die X Position des Schiffes 10px weiter nach rechts


        if (this.shooterX <= 670) {


                ctx.clearRect(this.shooterX, 375, 20, 20);
                this.shooterX = this.shooterX + 5;
                console.log(this.shooterX);
                ctx.drawImage(this.img,this.shooterX,375,20,13);





        }else{
            return;
        }


    }

    moveLeft() {//setzt die X Position des Schiffes 10px weiter nach links


        if (this.shooterX >= 10) {


                ctx.clearRect(this.shooterX,375,20,13);

                this.shooterX = this.shooterX -5;
                console.log(this.shooterX);
                ctx.drawImage(this.img,this.shooterX,375,20,13);


        }else{
            return;
        }


    }

    draw(X) {//zeichnet das Schiff an Position X (Y Position ist beim Schiff nicht veränderbar)

        ctx.drawImage(this.img,X,375,20,13);
    }

    shoot() {//feuert einen Schuss aus aktueller Position +9 (Mitte des Schiffes)
        //mit hilfer der schuss.zeichne() Methode ab
        //der Schuss startet immer auf Y=375 (nicht veränderbar)

        this.bullet = new Schuss(this.shooterX + 9, 375);
        idShipShot = setInterval(function () {
                shooter.bullet.zeichne(1);

        }, 5);

    }
}

class Alien {

    constructor(posX, posY) {
        this.posX = posX;
        this.posY = posY;
        this.bullet = null;
        this.img = new Image();
        this.img.src = "alien03.png";

    }

    move(direction) {//schiebt das Alien 1px weiter nach rechts
        if(direction == "R")
            this.posX++;
        else if(direction =="L")
            this.posX--;

    }

    moveLeft() {//schiebt das Alien 1px weiter nach links

        this.posX--;
    }

    movedown() {//schiebt das Alien 10px weiter nach unten

        this.posY = this.posY + 10;
        console.log(this.posY)

    }

    shoot() {//feuert einen Schuss vom Alien aus ab (mit hilfe der schuss.shoot())

        let bullet = this.bullet = new Schuss(this.posX, this.posY);

        idAlienShot = setInterval(function () {
            bullet.zeichne(2);

        },1);

    }

    draw() {//zeichnet das Alien an seiner X und Y Position. 20px breit, 13px hoch.

        ctx.drawImage(this.img,this.posX,this.posY,20,13);
    }
}

function gameMove() { //sorgt für die Bewegung der Aliens
    let direction = "R";
    //ToDo: Bewegung nach rechts und links!

    idMoveDown = setInterval(function () { // runter



        for (let i = 0; i < alien_formation.length; i++) {
            if (alien_formation[i] != null) {
                alien_formation[i].move(direction);

                if(alien_formation[i].posX >=680){
                    direction ="L";
                    for(let a=0;a<alien_formation.length;a++){
                        if(alien_formation[a] != null)
                            alien_formation[a].movedown();
                    }

                }
                if(alien_formation[i].posX<=0){
                    direction = "R";
                    for(let a=0;a<alien_formation.length;a++){
                        if(alien_formation[a] != null)
                            alien_formation[a].movedown();
                    }
                }

                if (alien_formation[i].posY >= 380) {
                    gameOver();
                }
            }
        }


        drawCanvas();
        if(shooter.bullet!=null){
            shooter.bullet.zeichne(1);
        }

        if(!getInvasion()){
            clearInterval(idMoveDown);
            clearInterval(idAlienAttack);
            level = level -10;
            start();
        }

    }, level)


}

function alien_attack(){

    idAlienAttack = setInterval(function(){
        let rambo = alien_formation[Math.floor(Math.random()*alien_formation.length)];
        if(rambo!=null)
            rambo.shoot();
    },1000);

}

function gameOver(){
    console.log("LOST");
    clearInterval(idMoveDown);
    lostDiv.style.display = "block";

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
    window.addEventListener('keyup',keyUpListener);
    window.addEventListener('keydown', pauseListener);


    shooter = new Schiff(300);

    let positionX = 30;

    for (let i = 0; i < 12; i++) {

        alien_formation[i] = new Alien(positionX + 20, 10);
        positionX += 50;
    }



        drawCanvas();
        gameMove();
        alien_attack();



}

var keyUpListener = function(e){
    let key = e.keyCode;

    if (key == 39) { // Pfeil-rechts
        clearInterval(idShipMoveRight);
        idShipMoveRight=null;


    } else if (key == 37) { //Pfeil-links
        clearInterval(idShipMoveLeft);
        idShipMoveLeft=null;

    }
}


var generalListener = function (e) {

    let key = e.keyCode; //speichert den KeyCode des Events

    window.addEventListener('keydown', pauseListener);


    if (pause == false) {

        if (key == 39&&idShipMoveRight ==null) { // Pfeil-rechts

            idShipMoveRight = setInterval(function(){

                shooter.moveRight();
                console.log(shooter.shooterX);
            },16)



        } else if (key == 37&&idShipMoveLeft==null) { //Pfeil-links
            idShipMoveLeft = setInterval(function(){
                shooter.moveLeft()
                console.log(shooter.shooterX);

            },16)



        } else if (key == 32) { //Space, nur schießen, wenn kein Schuss unterwegs

            if (lock == false) {
                shoot=shooter.shoot();


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


    for (let i = 0; i < alien_formation.length; i++) {
        if (alien_formation[i] != null)
            alien_formation[i].draw();

    }

    shooter.draw(shooter.shooterX);
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







