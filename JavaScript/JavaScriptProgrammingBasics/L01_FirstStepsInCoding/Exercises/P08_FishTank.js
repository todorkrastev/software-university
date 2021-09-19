function fishTank(length, width, height, percentage) {
    let value = length * width * height;
    let liters = value * 0.001;
    let prov = percentage * 0.01;
    let total = liters * (1 - prov);

    console.log(total.toFixed(3));
}
