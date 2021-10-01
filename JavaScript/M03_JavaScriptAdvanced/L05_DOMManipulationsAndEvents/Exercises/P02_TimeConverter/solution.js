function attachEventsListeners() {
    let timeValues = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    };

    function timeConverter(time, type) {
        const inDays = time / timeValues[type];

        return {
            days: inDays,
            hours: inDays * timeValues.hours,
            minutes: inDays * timeValues.minutes,
            seconds: inDays * timeValues.seconds
        };
    }

    const daysInput = document.getElementById('days');
    const hoursInput = document.getElementById('hours');
    const minutesInput = document.getElementById('minutes');
    const secondsInput = document.getElementById('seconds');

    document.getElementById('daysBtn').addEventListener('click', onConvert);
    document.getElementById('hoursBtn').addEventListener('click', onConvert);
    document.getElementById('minutesBtn').addEventListener('click', onConvert);
    document.getElementById('secondsBtn').addEventListener('click', onConvert);

    function onConvert(ev) {
        let input = ev.currentTarget.parentElement.querySelector('input[type="text"]');
        const output = timeConverter(Number(input.value), input.id);
        daysInput.value = output.days;
        hoursInput.value = output.hours;
        minutesInput.value = output.minutes;
        secondsInput.value = output.seconds;
    }



    // modification of the first option

    // let timeValues = {
    //     days: 1,
    //     hours: 24,
    //     minutes: 1440,
    //     seconds: 86400
    // };

    // function timeConverter(time, type) {
    //     const inDays = time / timeValues[type];

    //     return {
    //         days: inDays,
    //         hours: inDays * timeValues.hours,
    //         minutes: inDays * timeValues.minutes,
    //         seconds: inDays * timeValues.seconds
    //     };
    // }

    // const inputs = Object
    //     .keys(timeValues)
    //     .map(timeValue => document.getElementById(timeValue))
    //     .reduce((a, c) => Object.assign(a, { [c.id]: c }), {});

    // document.querySelector('main').addEventListener('click', onConvert);

    // function onConvert(ev) {
    //     if (ev.target.tagName == 'INPUT' && ev.target.type == 'button') {
    //         let input = ev.target.parentElement.querySelector('input[type="text"]');
    //         const output = timeConverter(Number(input.value), input.id);
    //         Object.keys(output).forEach(k => inputs[k].value = output[k]);
    //     }
    // }



    // second option

    // const htmlData = {
    //     buttons: Array.from(document.querySelectorAll("input[type='button']")),
    //     fields: Array.from(document.querySelectorAll("input[type='text']")),
    // }

    // const fillObj = (seconds, minutes, hours, days) => ({
    //     seconds,
    //     minutes,
    //     hours,
    //     days,
    // })
    // const types = {
    //     seconds: v => fillObj(v, v / 60, v / 3600, v / 86400),
    //     minutes: v => fillObj(v * 60, v, v / 60, v / 1440),
    //     hours: v => fillObj(v * 3600, v * 60, v, v / 24),
    //     days: v => fillObj(v * 86400, v * 1440, v * 24, v),
    // }

    // htmlData.buttons.forEach(x =>
    //     x.addEventListener("click", () => {
    //         const [typeOfUnits, value] = [
    //             x.previousElementSibling.id,
    //             x.previousElementSibling.value,
    //         ]
    //         const data = types[typeOfUnits](value)

    //         htmlData.fields.map(y => (y.value = data[y.id]))
    //     })
    // )
}
