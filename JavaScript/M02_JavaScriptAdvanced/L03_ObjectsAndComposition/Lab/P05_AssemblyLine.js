function createAssemblyLine() {
    return {
        hasClima: (object) => {
            object.temp = 21;
            object.tempSettings = 21;
            object.adjustTemp = function () {
                this.temp < this.tempSettings ? this.temp++ : this.temp--;
            }
        },
        hasAudio: (object) => {
            object.currentTrack = {
                name: null,
                artist: null
            };
            object.nowPlaying = function () {
                if (this.currentTrack !== null) {
                    console.log(`Now playing '${this.currentTrack.name}' by ${this.currentTrack.artist}`);
                }
            }
        },
        hasParktronic: (object) => {
            object.checkDistance = function (distance) {
                console.log(
                    distance < 0.1 ? 'Beep! Beep! Beep!' :
                        distance >= 0.1 && distance < 0.25 ? 'Beep! Beep!' :
                            distance >= 0.25 && distance < 0.5 ? 'Beep!' : '');
            }
        }
    }

    // second option

    /* return {
         hasClima: obj =>
             Object.assign(obj, {
                 temp: 21,
                 tempSettings: 21,
                 adjustTemp: function () {
                     if (this.temp !== this.tempSettings) {
                         this.temp < this.tempSettings ? (this.temp += 1) : (this.temp -= 1);
                     }
                 },
             }),
         hasAudio: obj =>
             Object.assign(obj, {
                 currentTrack: null,
                 nowPlaying: function () {
                     if (this.currentTrack !== null) {
                         console.log(
                             `Now playing '${this.currentTrack.name}' by ${this.currentTrack.artist});
                     }
                 },
             }),
         hasParktronic: obj =>
             Object.assign(obj, {
                 checkDistance: function (d) {
                     const distances = {
                         [d < 0.1]: "Beep! Beep! Beep!",
                         [0.1 <= d && d < 0.25]: "Beep! Beep!",
                         [0.25 <= d && d < 0.5]: "Beep!",
                     }
                     console.log((Object.entries(distances).find(x => x[0] === 'true') || ['true', ""])[1]);
                 },
             }),
     } */
}
