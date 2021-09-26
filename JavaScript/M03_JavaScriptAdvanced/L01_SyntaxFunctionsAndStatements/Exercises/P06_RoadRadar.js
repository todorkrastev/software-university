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

    /*  const limits = {
          motorway: 130,
          interstate: 90,
          city: 50,
          residential: 20,
      }
      const getStatus = n => {
          const status = {
              [n > 40]: "reckless driving",
              [n > 20 && n <= 40]: "excessive speeding",
              [n <= 20]: "speeding",
          }
  
          return status["true"]
      }
      const speedDiff = speed - limits[area]
  
      return speedDiff > 0
          ? `The speed is ${speedDiff} km/h faster than the allowed speed of ${limits[area]} - ${getStatus(speedDiff)}`
          : `Driving ${speed} km/h in a ${limits[area]} zone`  */
}
