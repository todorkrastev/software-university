function fuel(distance, passengers, price) {
    let increaseFuel = passengers * 0.100;
    let fuel = (distance / 100) * (7 + increaseFuel);
    let money = fuel * price;
    console.log(`Needed money for that trip is ${money.toFixed(2)}lv.`);
}
