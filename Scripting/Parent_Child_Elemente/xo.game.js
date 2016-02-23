/**
 * Created by JonnyCut on 10.02.2016.
 */
"use strict"

var zentrum = document.getElementById('zentrum');

zentrum.nextElementSibling.innerHTML = 'X';
zentrum.previousElementSibling.innerHTML = 'X';

zentrum.parentNode.previousSibling.firstChild.innerHTML = 'X';
zentrum.parentNode.previousSibling.firstChild.nextSibling.innerHTML = 'X';
zentrum.parentNode.previousSibling.lastChild.innerHTML = 'O';



zentrum.parentNode.nextSibling.firstChild.innerHTML = 'O';
zentrum.parentNode.nextSibling.firstChild.nextSibling.innerHTML='X';
zentrum.parentNode.nextSibling.lastChild.innerHTML = 'X';