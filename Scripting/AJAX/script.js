/**
 * Created by JonnyCut on 02.03.2016.
 */
    "use strict"
// ein XMLHttpRequest Objekt anlegen
var timer =0;

setInterval(function(){


    var xmlhttp = new XMLHttpRequest();

    // Festlegen der Übertragungsmethode, der aufzurufenden Ressource
    // true steht für asynchrone Datenübertragung
    xmlhttp.open('GET', 'server.php?name=max', true);


    // registrieren des Listeners, der bei erfolgter Antwort in die Konsole schreibt
    xmlhttp.addEventListener('readystatechange', function() {

        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            console.log(xmlhttp.responseText);
            document.querySelector('div').innerHTML=xmlhttp.responseText + timer;
        }

    });

    // AJAX Anfrage absenden
    xmlhttp.send();
    timer++;

    if(timer ==60){
        timer = 0;
    }
},1000);