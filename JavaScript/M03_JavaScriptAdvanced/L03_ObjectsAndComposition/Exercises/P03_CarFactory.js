function assembleCar(car) {
    const printCar = {};

    function getEngine(power) {
        if (0 < power && power <= 90) {
            return { power: 90, volume: 1800 };
        } else if (90 < power && power <= 120) {
            return { power: 120, volume: 2400 };
        } else if (120 < power && power <= 200) {
            return { power: 200, volume: 3500 };
        }
    }

    const wheelsSize = car.wheelsize % 2 == 0 ? car.wheelsize - 1 : car.wheelsize;
    printCar.model = car.model;
    printCar.engine = getEngine(car.power);
    printCar.carriage = {
        type: car.carriage,
        color: car.color
    };
    printCar.wheels = new Array(4).fill(wheelsSize, 0, 4);

    return printCar;

    /*   const storageEngines = [
           { power: 90, volume: 1800 },
           { power: 120, volume: 2400 },
           { power: 200, volume: 3500 },
       ];
       const storageCarriage = [
           { type: "hatchback", color: "" },
           { type: "coupe", color: "" },
       ];
       const getWheels = s => {
           return s % 2 === 0 ? new Array(4).fill(s - 1) : new Array(4).fill(s);
       };
   
       return {
           model: car.model,
           engine: storageEngines.reduce((a, v) =>
               Math.abs(a.power - car.power) < Math.abs(v.power - car.power) ? a : v
           ),
           carriage: {
               type: car.carriage,
               color: car.color
           },
           wheels: getWheels(car.wheelsize)
       }; */
}
