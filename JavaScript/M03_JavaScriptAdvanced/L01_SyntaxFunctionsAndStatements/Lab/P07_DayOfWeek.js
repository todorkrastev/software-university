function printNum(dayOfWeek) {
    let result;
    switch (dayOfWeek) {
        case 'Monday':
            result = 1;
            break;
        case 'Tuesday':
            result = 2;
            break;
        case 'Wednesday':
            result = 3;
            break;
        case 'Thursday':
            result = 4;
            break;
        case 'Friday':
            result = 5;
            break;
        case 'Saturday':
            result = 6;
            break;
        case 'Sunday':
            result = 7;
            break;
        default:
            result = 'error';
            break;
    }
    console.log(result);

   /* const days = {
        Monday: 1,
        Tuesday: 2,
        Wednesday: 3,
        Thursday: 4,
        Friday: 5,
        Saturday: 6,
        Sunday: 7,
    }

    return days[d] || "error" */
}
