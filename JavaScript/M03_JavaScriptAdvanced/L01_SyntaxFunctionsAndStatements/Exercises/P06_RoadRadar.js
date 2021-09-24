function controlSpeedLimt(speed, area) {
    let allowedSpeed = {
        'motorway': 130,
        'interstate': 90,
        'city': 50,
        'residential': 20
    }
    if (speed > allowedSpeed[area]) {
        let speeding = speed - allowedSpeed[area];
        let status = logSpeeding(speeding);
        console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${allowedSpeed[area]} - ${status}`)
    } else {
        console.log(`Driving ${speed} km/h in a ${allowedSpeed[area]} zone`);
    }

    function logSpeeding(speeding) {
        if (speeding <= 20) {
            return 'speeding';
        } else if (speeding <= 40) {
            return 'excessive speeding';
        } else {
            return 'reckless driving';
        }
    }
}
