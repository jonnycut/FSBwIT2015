/**
 * Created by JonnyCut on 02.03.2016.
 */
    "use strict"
// ein XMLHttpRequest Objekt anlegen
var xmlhttp = new XMLHttpRequest();

// Festlegen der Übertragungsmethode, der aufzurufenden Ressource
// true steht für asynchrone Datenübertragung
xmlhttp.open('GET', 'server.php?name=max', true);


// registrieren des Listeners, der bei erfolgter Antwort in die Konsole schreibt
xmlhttp.addEventListener('readystatechange', function() {

    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
        console.log(xmlhttp.responseText);
        document.querySelector('div').innerHTML+=xmlhttp.responseText;
    }

});

// AJAX Anfrage absenden
xmlhttp.send();