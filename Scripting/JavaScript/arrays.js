/**
 * Created by KNapret on 20.01.2016.
 */

var arr = [];

for(var i =0;i<=100;i++){
    arr[i] = Math.floor(Math.random()*100+1);
    console.log(arr[i]);
}

for( var i=0; i<=100;i++){

    if(arr[i]%2==0){
        arr[i]=arr[i]*2;
    }else{
        arr[i]=arr[i]*3;
    }

    console.log(arr[i]);
}

arr.forEach(function(value, index, array){
    if(value%2==0){
        array[index]=value*2;
    }else{
        array[index]=value*3;
    }
})


//array.filter(function(value){FUNKTION}) liefert ein neues, gefiltertes array (nach Kriterien von Function) zurück




var ungerade = arr.filter(function(value){ //function wird selber geschrieben, je nachdem, was man braucht.
    return value%2!==0;
})

var ungeradeKleiner100 = ungerade.filter(function(value){
    return value <100;
})


var kreis ={
    xPos: 0,
    yPos: 0,
    radius: 20,
    getDurchmesser: function(){return this.radius*2}

}

kreis.fuellfarbe = "yellow";

console.log(kreis.xPos);
console.log(kreis.fuellfarbe);
