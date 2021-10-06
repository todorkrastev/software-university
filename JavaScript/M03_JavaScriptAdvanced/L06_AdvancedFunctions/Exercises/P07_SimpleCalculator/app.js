function calculator() {
    let num1;
    let num2;
    let result;

    function init(n1, n2, r) {
        num1 = document.querySelector(n1);
        num2 = document.querySelector(n2);
        result = document.querySelector(r);
    }

    function add() {
        result.value = Number(num1.value) + Number(num2.value);
    }

    function subtract() {
        result.value = Number(num1.value) - Number(num2.value);
    }

    return {
        init,
        add,
        subtract
    };



    // second opiton


    // const html = { s1: "", s2: "", output: "" };

    // function calc(a, b, sign) {
    //     const signs = { "+": (a, b) => a + b, "-": (a, b) => a - b };

    //     return signs[sign](Number(a), Number(b));
    // }

    // return {
    //     init: (a, b, c) => {
    //         html.s1 = document.querySelector(a);
    //         html.s2 = document.querySelector(b);
    //         html.output = document.querySelector(c);
    //     },
    //     add: () =>
    //         (html.output.value = calc(html.s1.value, html.s2.value, "+")),
    //     subtract: () =>
    //         (html.output.value = calc(html.s1.value, html.s2.value, "-")),
    // };
}
