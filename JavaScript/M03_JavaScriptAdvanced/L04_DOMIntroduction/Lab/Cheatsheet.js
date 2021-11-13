// Selecting DOM elements
const element = document.getElementById('content');
document.querySelector('#content');
document.querySelector('.site-content aside button.btn.create');
document.querySelectorAll('#content li');
document.querySelectorAll('ul li');

// Get/Set content
element.textContent;
element.value;

// Traversing DOM
element.parentElement;
element.children;

// Create element
const para = document.createElement('p');

// Adding to DOM
element.appendChild(para);

// Removing from DOM
para.remove();

// Events
element.addEventListener('click', e => {
    console.log(e.target);
});
element.removeEventListener('click', someFunc);

// maybe
e.preventDefault(); // Buttons in Forms send the form when clicked, reloading the page

// Hide or show elements in HTML using display property
document.getElementById("element").style.display = "none"; // hide
document.getElementById("element").style.display = "block";  // show

// HTML Attributes
elem1.setAttribute('name', 'myName');
elem1.getAttribute('name');
elem1.classList.add('test');
elem1.classList.remove('test');

// Styling <=> CSS
elem1.style.setProperty('font-weight', 'bold');
elem1.style.getPropertyValue('font-weight');

// function for creating elements
function e(type, attributes, ...content) {
    const result = document.createElement(type);

    for (let [attr, value] of Object.entries(attributes || {})) {
        if (attr.substring(0, 2) == 'on') {
            result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
        } else {
            result[attr] = value;
        }
    }

    content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

    content.forEach(e => {
        if (typeof e == 'string' || typeof e == 'number') {
            const node = document.createTextNode(e);
            result.appendChild(node);
        } else {
            result.appendChild(e);
        }
    });

    return result;
}

// function for creating elements
// -> it gives the opportuinuty to set data attribute 
// -> example -> e('button', { 'setData-id': id }, 'Button Name');
function e(type, attributes, ...content) {
    const result = document.createElement(type);

    for (let [attr, value] of Object.entries(attributes || {})) {
        if (attr.substring(0, 2) == 'on') {
            result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
        } else if (attr.substring(0, 3) == 'set') {
            result.setAttribute(attr.substring(3).toLocaleLowerCase(), value);
        } else {
            if (typeof value == 'object') {
                for (let [subAttr, subValue] of Object.entries(value)) {
                    result[attr][subAttr] = subValue;
                }
            } else {
                result[attr] = value;
            }
        }
    }

    content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

    content.forEach(e => {
        if (typeof e == 'string' || typeof e == 'number') {
            const node = document.createTextNode(e);
            result.appendChild(node);
        } else {
            result.appendChild(e);
        }
    });

    return result;
}


// 0.1 Отделете повече време да си прочетете условието, целта е не само да се прочете
// а да се разбере, това ще ви спести адски много проблеми
// 0.2 НЕ СПЕКУЛИРАЙТЕ с условието, не е мястото на изпита да изпадаме в спекулации, за
// как трябва да е
// 0.3 Не пробвайте нови неща на изпита, използвайте си подходите които са ви най ясни
// и сте ползвали и тествали преди

// 1. Прочетете си пак условието, дума по дума, картинка по картинка ако трябва
// 2. Ако е DOM задача, погледнете да не използвате неща които judge не разбира, ако
// изпаднете в ситуации където при вас работи а в judge не, шанса е че ползвате нещо
// от което judge не разбира
// 3. Нулеви тестове - понякога в judge има повече нулеви тестове от колкото в условието,
// но през нормалния екран не се вижда минали ли са или не, погледнете в details, ако имаме
// нулеви тестове които не минават, може лесно да се ориентираме къде имаме грешка.
// Ако задачата е DOM обаче, може да е объркващо да разберем грешката така че, ако не
// разбирате от теста бързо къде е проблема, може да пропуснем тази стъпка
// 4. Ако сме изхабили 20-30 минути в търсене на грешка, а ни остават още задачи за решаване
// тук е време да оставим задачата до където е и да отидем да решим останалите,
// после ще се върнем като сме изкарали точките си, ако сте решили всичко или се връщате
// на задачата пак, изчистете всичко от мозъка си, може да вземете 1-2 мин почивка и почнете
// пак от условието
// 5. Може да ползваме същите подходи като при unit test-ването, все пак Judge прави 
// Unit testing на кода ни
// 6. Тук вече може да спекулираме


// 5 UNIT TESTING
// Trivial cases
// 1. All 'bad' exit conditions - 'throws' and 'returns' for special values signifying work could not be done
//      ...1 test for each check leading to such a condition
// 2. All 'good' exit condition - where the function received correct values and managed to complete its work
//      2.a Some simple correct values we can think of - it's a good idea to check with at least 2 different   
//          values so we don't fall for default return values
//      2.b Edge cases:
//          2.b.1 Edge cases that come from the data type we're using for example for Numbers - integers,
//          floating point numbers, positive, negative, NaN, numbers above max allowed values etc. Alternatively for arrays it could be
//          an empty array, an array with 1 element or an array with many elements
//          2.b.2 Edge cases that come from the specification for example using a number as an index -
//          check it's an Integer, check it's >= 0, check it's < length of whatever we should search in
// Non Trivial Cases
// 3. Check the source code to ensure we have full code coverage - that we have tests checking every row and
// expression/statement in that row i.e. line coverage
// 4. Non-trivial Edge cases - for every statement/expression try to think of a way it can be implemented to work
// almost correctly, this will let us think of non-standard edge cases to test
// For example if we're asked to check if something is a number, the correct check might be
// typeof num === 'number', but someone could write it as !isNaN(Number(num)) which would introduce
// edge cases with invalid logic, write tests to differentiate the correct implementation from the almost correct one
