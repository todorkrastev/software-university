function foo(arr) {

    // Set values and remove them from the array
    let numOfSongs = arr.shift();
    let listType = arr.pop();

    class song {
        constructor(list_type, song_name, time) {
            this.list_type = list_type;
            this.name = song_name;
            this.time = time;
        }
    }

    let songs = [];
    for (let i = 0; i < arr.length; i++) {
        let songData = arr[i].split('_');
        let [list_type, song_name, time] = [songData[0], songData[1], songData[2]];
        songs.push(new song(list_type, song_name, time)); // add a song with the data above
    }

    if (listType === "all") { // if list type is all return all song names
        return (
            songs.map(song => song.name)
                .join('\n')
        );
    } else { // else return names of songs matching list type
        return (
            songs.filter(song => song.list_type == listType)
                .map(song => song.name)
                .join('\n')
        );
    }
}