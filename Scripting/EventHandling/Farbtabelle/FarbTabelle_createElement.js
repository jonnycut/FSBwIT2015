/**
 * Created by JonnyCut on 10.02.2016.
 */

    "use strict"

var tbody = document.getElementsByTagName('tbody')[0];


for(let i = 0; i<16; i++){
    let tr = document.createElement('tr');

    for(let i = 0; i<16; i++){
        let td = document.createElement('td');
        tr.appendChild(td)
    }

    tbody.appendChild(tr);
}

var div = document.querySelector('div');

div.addEventListener('click',function(e){
    let actFarbe = e.target.style.backgroundColor;
    if (actFarbe== 'coral'){
        e.target.style.backgroundColor = 'white';
    }else{
        e.target.style.backgroundColor = 'coral';
    }


});

