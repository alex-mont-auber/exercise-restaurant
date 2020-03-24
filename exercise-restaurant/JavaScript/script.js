
// START FASE 1

const   FiveEur = 5, 
        TenEur = 10,
        TwentyEur = 20,
        FivetyEur = 50,
        HundredEur = 100,
        TwoHunEuro = 200,
        FiveHunEur = 500;

let TotalPriceMenu = 0,
    Menu = [], 
    Price = [],
    MaxCounter = 0,
    count = 0,
    UserContinue,
    UserResponse,
    UserSelection = [];

// END FASE 1

// START FASE 2 and 3

console.log("Bienvenido al Restaurante JavaEat!");
console.log("Antes de empezar, realizaremos el menu.");


label:
do {
    if(MaxCounter === 0){
        let e = prompt("Primer Plato: ");
        Menu.push(e) 
        let i  = parseInt(prompt("Y el precio: "));
        Price.push(i)
        MaxCounter++;
    } else if(MaxCounter >= 1 && MaxCounter < 4){
        let e = prompt("Siguiente Plato: ");
        Menu.push(e);
        let i = parseInt(prompt("Y el precio: "));
        Price.push(i);
        MaxCounter++;
    } else {
        let e = prompt("Ultimo Plato: ");
        Menu.push(e);
        let i = parseInt(prompt("Y el precio: "));
        Price.push(i);
        break label;
    }
} while(MaxCounter <= 5);

console.log("Aqui tiene el menu con los precios respectivamente: ");
console.log(Menu);
console.log(Price);

for(let e = 0; e < Menu.length; e++){
    for(let i = 0; i < Price.length; i++){
        if(e === i){
            console.log(Menu[e] + "........" + Price[i] + "€");
        }
    } 
}

let e = prompt("Que quieres de entrante para comer?");
if(UserResponse == ""){
    console.log("Tienes que elegir algo del menu!");
} else {
    UserSelection.push(e);
    console.log(UserSelection);
    count++;
}

label:
while(count < 5) {
    UserContinue = prompt("Quieres pedir algo mas? (responde si o no)");
    if (UserContinue === "Si" || UserContinue === "si" || UserContinue === "sI" || UserContinue === "SI") {
            if(count < 4){
                let e = prompt("Que mas quieres para comer?");
                UserSelection.push(e); 
                count++;
            } else if (count === 4){
                let y = prompt("Por ultimo?");
                UserSelection.push(y); 
                count++;
            } else {
                console.log("Error Switch IF/IF ELSE/ ELSE");
                break label;
            }
    } else if(UserContinue === "No" || UserContinue === "no" || UserContinue === "nO" || UserContinue === "NO"){
        break label;
    } else if(UserContinue === "") {
        console.log("Tienes que decir si o no!");
        break;
    } else {
        console.log("Error read input in loop While, breaking loop...");
        break label;
    }    
} 

if(UserSelection === ""){
    console.log("No hay nada en la seleccion!");
} else {
    console.log("Muy bien, repasemos...");
    console.log("Usted ha pedido: ");
    for(let e = 0; e < UserSelection.length; e++){
        console.log(UserSelection[e] + ", ");
        for(let y = 0; y < Menu.length; y++){
            if(e === y){
                TotalPriceMenu += Prices[y]
            }
        }
    }
    if(UserSelection[e] === Menu[y]){
        for(let x = 0; x < Price.length; x++){
            if(y === x) {
                TotalPriceMenu += Price[x];
            }
        }
    } else {
        console.log("Bug");
        break;
    }
}


/*

if(UserSelection === ""){
    console.log("No hay nada en la seleccion!");
} else {
    console.log("Muy bien, repasemos...");
    console.log("Usted ha pedido: ");
    for(let e = 0; e < UserSelection.length; e++){
        console.log(UserSelection[e] + ", ");
        for(let y = 0; y < Menu.length; y++){
            for(let i = 0; i < Price.length; i++){
                if(Menu[y] === UserSelection[e]){
                    console.log(Price[i]);
                    console.log(Price);
                    console.log(Menu[y]);
                    console.log(UserSelection[e]);
                    console.log(TotalPriceMenu);
                    TotalPriceMenu += Price[i];
                }
            }
        }
    }
}*/

console.log("TEST: " + TotalPriceMenu);

// END FASE 2 and 3