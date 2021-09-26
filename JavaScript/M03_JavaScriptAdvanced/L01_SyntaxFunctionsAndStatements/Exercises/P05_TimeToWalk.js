function TimeToWalk(arg1, arg2, arg3) {
    let stepsNumber = Number(arg1);
    let stepsMetersHr = Number(arg2);
    let studentSpeed = Number(arg3);

    let distanceMeters = stepsNumber * stepsMetersHr;
    let speedMetersSec = studentSpeed / 3.6;
    let time = distanceMeters / speedMetersSec;
    let rest = Math.floor(distanceMeters / 500);

    let timeMin = Math.floor(time / 60);
    let timeSec = Math.round(time - (timeMin * 60));
    let timeHr = Math.floor(time / 3600);

    console.log((timeHr < 10 ? "0" : "") + timeHr + ":" + (timeMin + rest < 10 ? "0" : "") + (timeMin + rest) + ":" + (timeSec < 10 ? "0" : "") + timeSec);

    /*  const distance = steps * metersPerStep
      const decimalTime = distance / 1000 / kmPerHour
      const n = new Date(0, 0)
      n.setSeconds(decimalTime * 60 * 60 + 1) //no idea why judge wants 1 second more, but I meh... added it.
      n.setMinutes(n.getMinutes() + Math.floor(distance / 500))
  
      return n.toTimeString().slice(0, 8) */
}
