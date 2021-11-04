function attachEvents() {
    let getWeatherButton = document.querySelector('#submit');
    getWeatherButton.addEventListener('click', getWeatherHandler);
    let locationInput = document.querySelector('#location');

    let conditions = {
        Sunny: () => '☀',
        'Partly sunny': () => '⛅',
        Overcast: () => '☁',
        Rain: () => '☂',
        Degrees: () => '°'
    };

    function getWeatherHandler() {
        let forecastContainer = document.querySelector('#forecast');
        forecastContainer.style.display = 'block';

        let currentForecastContainer = document.querySelector('#current');
        Array.from(currentForecastContainer.querySelectorAll('div')).forEach((el, i) => {
            i !== 0 ? el.remove() : el;
        });
        let upcomingForecastContainer = document.querySelector('#upcoming');
        Array.from(upcomingForecastContainer.querySelectorAll('div')).forEach((el, i) => {
            i !== 0 ? el.remove() : el;
        });

        fetch('http://localhost:3030/jsonstore/forecaster/locations')
            .then(body => body.json())
            .then(locations => {
                let locationName = locationInput.value;
                let location = locations.find(x => x.name === locationName)
                return fetch(`http://localhost:3030/jsonstore/forecaster/today/${location.code}`)
                    .then(body => body.json())
                    .then(currentWeatherReport => ({ code: location.code, currentWeatherReport }))
            })
            .then(({ code, currentWeatherReport }) => {
                console.log(currentWeatherReport);
                let htmlReport = createCurrentWeatherElement(currentWeatherReport);
                currentForecastContainer.appendChild(htmlReport);

                return fetch(`http://localhost:3030/jsonstore/forecaster/upcoming/${code}`);
            })
            .then(body => body.json())
            .then(upcomingWeatherReport => {
                console.log(upcomingWeatherReport);
                let upcomingForecast = createUpcomingWeatherElement(upcomingWeatherReport);
                upcomingForecastContainer.appendChild(upcomingForecast);
            })
            .catch(err => {
                let errorDiv = document.createElement('div');
                errorDiv.classList.add('label');
                errorDiv.textContent = 'Error';
                currentForecastContainer.appendChild(errorDiv);

            });

        function createUpcomingWeatherElement(weatherReport) {
            let forecastInfoDiv = document.createElement('div');
            forecastInfoDiv.classList.add('forecast-info');

            let day1Html = createDayReport(weatherReport.forecast[0]);
            let day2Html = createDayReport(weatherReport.forecast[1]);
            let day3Html = createDayReport(weatherReport.forecast[2]);

            forecastInfoDiv.appendChild(day1Html);
            forecastInfoDiv.appendChild(day2Html);
            forecastInfoDiv.appendChild(day3Html);
            return forecastInfoDiv;
        }

        function createDayReport(forecast) {
            let upcomingSpan = document.createElement('span');
            upcomingSpan.classList.add('upcoming');

            let symbolSpan = document.createElement('span');
            symbolSpan.classList.add('symbol');
            symbolSpan.textContent = conditions[forecast.condition]();

            let temperatureSpan = document.createElement('span');
            temperatureSpan.classList.add('forecast-data');
            temperatureSpan.textContent =
                `${forecast.low}${conditions.Degrees()}/${forecast.high}${conditions.Degrees()}`;

            let weatherSpan = document.createElement('span');
            weatherSpan.classList.add('forecast-data');
            weatherSpan.textContent = forecast.condition;

            upcomingSpan.appendChild(symbolSpan);
            upcomingSpan.appendChild(temperatureSpan);
            upcomingSpan.appendChild(weatherSpan);

            return upcomingSpan;
        }

        function createCurrentWeatherElement(weatherReport) {
            let forecastsDiv = document.createElement('div');
            forecastsDiv.classList.add('forecasts');

            let conditionSymbolSpan = document.createElement('span');
            conditionSymbolSpan.classList.add('condition', 'symbol');
            conditionSymbolSpan.textContent = conditions[weatherReport.forecast.condition]();

            let conditionSpan = document.createElement('span');
            conditionSpan.classList.add('condition');

            let nameSpan = document.createElement('span');
            nameSpan.classList.add('forecast-data');
            nameSpan.textContent = weatherReport.name;

            let temperatureSpan = document.createElement('span');
            temperatureSpan.classList.add('forecast-data');
            temperatureSpan.textContent =
                `${weatherReport.forecast.low}${conditions.Degrees()}/${weatherReport.forecast.high}${conditions.Degrees()}`;

            let weatherSpan = document.createElement('span');
            weatherSpan.classList.add('forecast-data');
            weatherSpan.textContent = weatherReport.forecast.condition;

            conditionSpan.appendChild(nameSpan);
            conditionSpan.appendChild(temperatureSpan);
            conditionSpan.appendChild(weatherSpan);

            forecastsDiv.appendChild(conditionSymbolSpan);
            forecastsDiv.appendChild(conditionSpan);
            return forecastsDiv;
        }
    }
}

attachEvents();



// second option


// const getData = async (uri) => {
//     const data = await fetch(`http://localhost:3030/jsonstore/forecaster/${uri}`);
//     if (data.ok == false) throw new Error();
//     const deserialized = data.json();
//     if (deserialized == false) throw new Error();

//     return deserialized;
// };

// const getCode = (arr, n) => {
//     const location = arr.find(x => x.name === n);

//     if (location === undefined) throw new Error();

//     return location.code;
// };

// const symbols = {
//     Sunny: '&#x2600;',
//     'Partly sunny': '&#x26C5;',
//     Overcast: '&#x2601;',
//     Rain: '&#x2614;',
//     Degrees: '&#176;',
// };

// function tomorrowTemplate({ forecast, name }) {
//     const wrapper = document.createElement('div');
//     wrapper.className = 'forecasts';

//     wrapper.innerHTML =
//         `<span class="condition symbol">${symbols[forecast.condition]}</span><span class="condition"><span class="forecast-data">${name}</span><span class="forecast-data">${forecast.high}&#176;/${forecast.low}&#176;</span><span class="forecast-data">${forecast.condition}</span></span>`;

//     return wrapper;
// }

// function dayTemplate({ condition, high, low }) {
//     const wrapper = document.createElement('span');
//     wrapper.className = 'upcoming';

//     wrapper.innerHTML = `<span class="symbol">${symbols[condition]}</span><span class="forecast-data">${high}&#176;/${low}&#176;</span><span class="forecast-data">${condition}</span>`;

//     return wrapper;
// }

// const outputVisibility = (display) => document.getElementById('forecast').style.display = display;

// const clearSections = () => {
//     document.getElementById('current').innerHTML = `<div class="label">Current conditions</div>`;
//     document.getElementById('upcoming').innerHTML = `<div class="label">Three-day forecast</div>`;
// };

// async function displayData(name) {
//     const html = {
//         tmrwOutput: document.getElementById(`current`),
//         threeDayOutput: document.getElementById(`upcoming`),
//         forecastMain: document.getElementById('forecast'),
//     };

//     outputVisibility('block');
//     clearSections();

//     try {
//         const initialNfo = await getData('locations');
//         const code = getCode(initialNfo, name);
//         const tomorrowNfo = await getData(`today/${code}`);
//         const threeDayNfo = await getData(`upcoming/${code}`);

//         html.tmrwOutput.appendChild(tomorrowTemplate(tomorrowNfo));

//         Object.values(threeDayNfo.forecast)
//             .forEach(x => html.threeDayOutput.appendChild(dayTemplate(x)))

//     } catch (e) {
//         html.tmrwOutput.appendChild(document.createTextNode('Error'));
//     }
// }

// function attachEvents() {
//     const inputField = document.getElementById('location');

//     document.getElementById('submit').addEventListener('click', () => displayData(inputField.value));
// }

// attachEvents();



// third option


// function attachEvents() {
//     document.getElementById('submit').addEventListener('click', getWeather);
// }

// async function getWeather() {

//     const availableDivCurrent = document.querySelector('.forecasts');
//     const availableDivUpcoming = document.querySelector('.forecast-info');


//     if (availableDivCurrent) {
//         availableDivCurrent.remove();
//     }

//     if (availableDivUpcoming) {
//         availableDivUpcoming.remove();
//     }

//     const input = document.getElementById('location');

//     const cityName = input.value;
//     let code = '';
//     try {
//         code = await getCode(cityName);
//     } catch (error) {
//         alert('Error');
//         document.querySelector('#upcoming').style.display = 'block';
//         document.getElementById('current').style.display = 'block';
//         input.value = '';
//     }
//     const [current, upcoming] = await Promise.all([getCurrent(code), getUpcoming(code)]);

//     let symbol = '&#x2600;';
//     if (current.forecast.condition == 'Partly sunny') {
//         symbol = '&#x26C5;';
//     } else if (current.forecast.condition == 'Overcast') {
//         symbol = '&#x2601;';
//     } else if (current.forecast.condition == 'Rain') {
//         symbol = '&#x2614;';
//     }

//     document.querySelector('#forecast').style.display = 'block';

//     const divForecasts = createEl('div', 'forecasts');
//     const spanSymbol = createEl('span', 'condition symbol', symbol);
//     const spanCondition = createEl('span', 'condition');

//     const spanFirstData = createEl('span', 'forecast-data', current.name);
//     const spanSecondData = createEl('span', 'forecast-data', `${current.forecast.low}&#176;/${current.forecast.high}&#176;`);
//     const spanThirdData = createEl('span', 'forecast-data', current.forecast.condition);

//     divForecasts.appendChild(spanSymbol);
//     divForecasts.appendChild(spanCondition);
//     spanCondition.appendChild(spanFirstData);
//     spanCondition.appendChild(spanSecondData);
//     spanCondition.appendChild(spanThirdData);
//     document.querySelector('#current').appendChild(divForecasts);

//     const divForecastUpcoming = createEl('div', 'forecast-info');
//     document.querySelector('#upcoming').appendChild(divForecastUpcoming);

//     upcoming.forecast.map(d => {

//         let symbol = '&#x2600;';
//         if (d.condition == 'Partly sunny') {
//             symbol = '&#x26C5;';
//         } else if (d.condition == 'Overcast') {
//             symbol = '&#x2601;';
//         } else if (d.condition == 'Rain') {
//             symbol = '&#x2614;';
//         }

//         const spanUpcoming = createEl('span', 'upcoming');
//         const spanSymbol = createEl('span', 'symbol', symbol);
//         const spanFirstData = createEl('span', 'forecast-data', `${d.low}&#176;/${d.high}&#176;`);
//         const spanSecondData = createEl('span', 'forecast-data', d.condition);

//         divForecastUpcoming.appendChild(spanUpcoming);
//         spanUpcoming.appendChild(spanSymbol);
//         spanUpcoming.appendChild(spanFirstData);
//         spanUpcoming.appendChild(spanSecondData);
//         input.value = '';
//     });

// }

// function createEl(type, className, text) {
//     const el = document.createElement(type);
//     if (className) {
//         el.className = className;
//     }
//     if (text) {
//         el.innerHTML = text;
//     }
//     return el;
// }

// async function getCode(cityName) {
//     const url = 'http://localhost:3030/jsonstore/forecaster/locations';
//     const response = await fetch(url);
//     const data = await response.json();
//     return data.find(x => x.name.toLowerCase() === cityName.toLowerCase()).code;
// }

// async function getCurrent(code) {
//     const url = 'http://localhost:3030/jsonstore/forecaster/today/' + code;
//     const response = await fetch(url);
//     const data = await response.json();
//     return data;
// }

// async function getUpcoming(code) {
//     const url = 'http://localhost:3030/jsonstore/forecaster/upcoming/' + code;
//     const response = await fetch(url);
//     const data = await response.json();
//     return data;
// }

// attachEvents();
