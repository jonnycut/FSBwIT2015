/**
 * Created by JonnyCut on 22.03.2016.
 */
/**
 * Created by KNapret on 15.03.2016.
 */
var canvas = document.getElementById('myCanvas');
var ctx = canvas.getContext('2d'); // 2D-Kontext
var pause = false;
var idGame;
var alienShot;

var idAlienShot;
var idAlienAttack;
var idShipMoveRight = null;
var idShipMoveLeft = null;
var idMoveDown;

var shooter;
var alien_formation = [];

var images1 =["alien02.png","alien02b.png",null,null,null,null];
var images2 =["alien03.png","alien03b.png",null,null,null,null];
var images3 =["alien04.png","alien04b.png",null,null,null,null];
var images4 =["alien05.png","alien05b.png",null,null,null,null];



class Schuss {

    constructor(posX, posY, alien) {

        this.posX = posX;
        this.posY = posY;
        this.alien = alien;
        this.isAlive = true;
    }

    fly(direction) {
        //Zählt die Y Position des Schusses hoch (bei alienschuss, direction=2) oder runter (ShipShoot, direction = 1)

        if (direction == 1) {
            this.posY = this.posY - 8;
            this.inTouch(direction);
        } else {
            this.posY = this.posY + 4;
            this.inTouch(direction);
        }


    }

    draw() {
        ctx.fillStyle = 'black';
        ctx.fillRect(this.posX, this.posY, 5, 10);
    }

    inTouch(direction) { //löscht ein Alien, wenn es getroffen wird.

        //ToDo: HitBox anpassen!
        if (direction == 1) {
            if (this.posY <= 0) {
                shooter.bullet = null;

            }

            for (let i = 0; i < alien_formation.length; i++) {

                if (alien_formation[i] != null) {
                    if (this.isAlive&&(this.posX <= alien_formation[i].posX + 20 && this.posX >= alien_formation[i].posX) && (this.posY <= alien_formation[i].posY + 13 && this.posY >= alien_formation[i].posY+2)) {
                        this.isAlive=false;
                        alien_formation[i].explode(i);
                        console.log(alien_formation[i]);
                        console.log(this);
                        //alien_formation.splice(i, 1);
                        shooter.bullet = null;

                    }
                }


            }
        } else if (direction == 2) {

            if (this.posY > 380) {
                this.isAlive=false;
                this.alien.bullet = null;
                //Problem: Schuss verschwindet random ca auf Mitte des Canvas....keine Ahnung.
                //ggf. Intervallfunktion in den Schuss integrieren?!
                //clearInterval(idAlienShot);
            }

            if (this.isAlive&&(this.posX >= shooter.shooterX && this.posX <= shooter.shooterX + 22) && (this.posY >= 370&& this.posY <380)) {
                clearInterval(idAlienShot);
                this.isAlive = false;
                this.alien.bullet = null;
                //shooter.explode();
                console.log(this);
                console.log(shooter)
                if(shooter.lives==0){
                    gameOver();
                }else{
                    console.log("Leben runter");
                    shooter.lives--;
                    document.getElementById('lives').innerHTML = shooter.lives;
                }
            }

        }

    }


}


class Schiff {

    constructor(posX) {

        this.shooterX = posX;
        this.posY = 375;
        this.width =20;
        this.height = 13;
        this.bullet = null;
        this.lives = 3;
        this.img = new Image();
        this.img.src = "panzer02.png";
        this.soundShoot = document.getElementById('pShoot');

    }

    moveRight() {//setzt die X Position des Schiffes 10px weiter nach rechts


        if (this.shooterX <= 670) {
            this.shooterX = this.shooterX + 5;


        } else {
            return;
        }


    }

    moveLeft() {//setzt die X Position des Schiffes 10px weiter nach links


        if (this.shooterX >= 10) {

            this.shooterX = this.shooterX - 5;


        } else {
            return;
        }


    }
    explode(){
        var ship = this;

        var exp= function(){
            //Schiff Größe 20x13px;

                ship.img.src='shipExp.png';
                ship.height+=8;
                ship.width+=30;
                ship.posY-=8;


            if(ship.height<60)
                requestAnimationFrame(exp);


        }
        requestAnimationFrame(exp);
    }

    draw(X) {//zeichnet das Schiff an Position X (Y Position ist beim Schiff nicht veränderbar)

        ctx.drawImage(this.img, X, this.posY, this.width,this.height);
    }

    shoot() {//feuert einen Schuss aus aktueller Position +9 (Mitte des Schiffes)
        //mit hilfer der schuss.zeichne() Methode ab
        //der Schuss startet immer auf Y=375 (nicht veränderbar)
        if (this.bullet == null) {
            this.soundShoot.play();
            this.bullet = new Schuss(this.shooterX + 9, 375);
            let fire= function () {
                if(shooter.bullet!= null){
                    shooter.bullet.fly(1);
                    requestAnimationFrame(fire);
                }

            }
            requestAnimationFrame(fire)

        }


    }
}

class Alien {


    constructor(posX, posY,art) {
        this.posX = posX;
        this.posY = posY;
        this.with = 20;
        this.height = 13;
        this.isExploding = false;
        this.bullet = null;
        this.art = art;
        switch (art) {
            case 1:
                this.images = images1;
                break;
            case 2:
                this.images = images2;
                break;
            case 3:
                this.images = images3;
                break;
            case 4:
                this.images = images4;
                break;
            default:
                this.images = images1;
                break;

        }
        this.img = new Image();
        this.img.src = this.images[0];

    }

    move(direction) {//schiebt das Alien 1px weiter nach rechts
        if (direction == "R"&&! this.isExploding){

            this.posX++;
            let newBild = this.images[Math.floor(Math.random()*this.images.length)];
            if(newBild!=null)
                this.img.src= newBild;

        }


        else if (direction == "L"&&! this.isExploding){
            this.posX--;
            let newBild = this.images[Math.floor(Math.random()*this.images.length)];
            if(newBild!=null)
                this.img.src= newBild;

        }


    }

    moveLeft() {//schiebt das Alien 1px weiter nach links

        this.posX--;
    }

    movedown() {//schiebt das Alien 10px weiter nach unten

        this.posY = this.posY + 10;


    }
    explode(index){
        var alien = this;
        this.isExploding = true;


        var exp= function(){
            //alien Größe 20x13px;

            alien.img.src='exp_g.png';
            alien.height+=8;
            alien.with+=8;
            alien.posX -=4;
            alien.posY-=4;

            if(alien.height<60)
                requestAnimationFrame(exp);
            if(alien.height>=60){
                console.log(index);
                alien_formation.splice(index,1);

            }

        }
        requestAnimationFrame(exp);


    }


    shoot() {//feuert einen Schuss vom Alien aus ab (mit hilfe der schuss.shoot())
        let alien = this;

        if (this.bullet == null) {

            let bullet = this.bullet = new Schuss(this.posX, this.posY, alien);
            let fire = function(){
                if(alien.bullet !=null){
                    alien.bullet.fly(2);
                    requestAnimationFrame(fire);
                }

            }
            requestAnimationFrame(fire);
        }


    }

    draw() {//zeichnet das Alien an seiner X und Y Position. 20px breit, 13px hoch.

        ctx.drawImage(this.img, this.posX, this.posY, this.with, this.height);
    }
}

function gameMove(level) { //sorgt für die Bewegung der Aliens
    let direction = "R";

    //ToDo: Bewegung nach rechts und links!

    idMoveDown = setInterval(function () {
    // runter


        for (let i = 0; i < alien_formation.length; i++) {
            if (alien_formation[i] != null) {

                alien_formation[i].move(direction);

                if (alien_formation[i].posX >= 680&&!alien_formation[i].isExploding) {
                    alien_formation[i].posX--;
                    for (let a = 0; a < alien_formation.length; a++) {
                            alien_formation[a].movedown();
                        if(a>i&&direction=="R"){
                            alien_formation[a].move(direction);
                            console.log("Schiebe " + direction)
                        }

                    }
                    direction = "L";
                }



                if (alien_formation[i].posX <= 0&&!alien_formation[i].isExploding) {
                    alien_formation[i].posX++;
                    for (let a = 0; a < alien_formation.length; a++) {
                            alien_formation[a].movedown();
                        if(a>i&&direction=="L"){
                            alien_formation[a].move(direction);
                            console.log("schiebe "+direction)
                        }

                    }
                    direction = "R";
                }

                if (alien_formation[i].posY >= 370) {
                    gameOver();
                }
            }
        }


        if (!getInvasion()) {
            clearInterval(idMoveDown);
            clearInterval(idAlienAttack);


            level = level - 10;
            if(level <10)
                level = 10;
            console.log("Level UP!  "+level);
            start(level);
        }

    }, level)


}

function alien_attack() {

    idAlienAttack = setInterval(function () {
        let rambo = alien_formation[Math.floor(Math.random() * alien_formation.length)];
        if (rambo != null)
            rambo.shoot();
    }, 1500);

}

function gameOver() {
    let lostDiv = document.getElementById('gameover');
    console.log("LOST");
    clearInterval(idMoveDown);
    clearInterval(idGame);
    clearInterval(idAlienAttack)
    lostDiv.style.display = "block";

}

function getInvasion() {

    let invasion = false;

    for (let i = 0; i < alien_formation.length; i++) {
        if (alien_formation[i] != null) {
            invasion = true;
        }
    }

    return invasion;

}


function start(level) { //Startfunktion, erstellt das Schiff und das AlienArray

    window.addEventListener('keydown', generalListener);
    window.addEventListener('keyup', keyUpListener);
    window.addEventListener('keydown', pauseListener);




    shooter = new Schiff(300);

    document.getElementById('lives').innerHTML = shooter.lives;

    let positionX = 30;
    let positionY = 10;
    let art =1;

    for (let i = 1; i <= 48; i++) {

        alien_formation[i-1] = new Alien(positionX + 20, positionY,art);
        positionX += 50;

        if(i%12==0){
            art++;
            positionY +=30;
            positionX = 30;
        }


    }


    drawCanvas();
    gameMove(level);
    alien_attack();


}

var keyUpListener = function (e) {

    //nötig für eine weiche Bewegung des Schiffes!
    let key = e.keyCode;

    if (key == 39) { // Pfeil-rechts
        clearInterval(idShipMoveRight);

        idShipMoveRight = null;


    } else if (key == 37) { //Pfeil-links
        clearInterval(idShipMoveLeft);
        idShipMoveLeft = null;

    }
}


var generalListener = function (e) {

    let pauseDiv = document.getElementById('pause')
    let key = e.keyCode; //speichert den KeyCode des Events


    window.addEventListener('keydown', pauseListener);


    if (pause == false) {

        if (key == 39 && idShipMoveRight == null) { // Pfeil-rechts

            idShipMoveRight = setInterval(function () {
                shooter.moveRight();
            }, 16)


        } else if (key == 37 && idShipMoveLeft == null) { //Pfeil-links
            idShipMoveLeft = setInterval(function () {
                shooter.moveLeft()


            }, 16)


        } else if (key == 32) { //Space, nur schießen, wenn kein Schuss unterwegs


            if (shooter.bullet == null)
                shooter.shoot();


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


var pauseListener = function (e) {
     //bei "P" wird der Schussintevall und AlienIntervall unterbrochen,
    // Pause angezeigt und der Eventlistener wieder entfernt
    let pauseDiv = document.getElementById('pause')
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

function drawCanvas() {
    //löscht das aktuelle Canvas und zeichnet es neu. Nutzt die .draw() Methoden von Alien und Schiff

    //idGame = setInterval(function () {

    var game = function (){

        canvas.width = canvas.width;

        for (let i = 0; i < alien_formation.length; i++) {

            alien_formation[i].draw();
            if (alien_formation[i].bullet != null) {
                alien_formation[i].bullet.draw();
            }

        }

        shooter.draw(shooter.shooterX);
        if (shooter.bullet != null)
            shooter.bullet.draw();

        requestAnimationFrame(game)
    }
    requestAnimationFrame(game);

    //},16) //1 Bild pro mS, entspricht 62,5 FPS
}


start(50);


/*<--------------------------------------------------- ABLAGE ------------------------------------------------------->*/
//ToDo
//Automaten einbauen
//Zustand_Opa_Automat bei GameOver();
//Zustand OA bei pause;
//Übergabe Score an OA Spieler;
//Aliens unterschiedliche Bilder
//Abschussliste je Spiel nach Alilen id a1 - a6 (innerHTML);
//Leben updaten (id p1) (innerHTML);





