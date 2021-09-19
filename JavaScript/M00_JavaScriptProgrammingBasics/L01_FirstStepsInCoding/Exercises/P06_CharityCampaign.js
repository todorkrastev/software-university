function charityCampaign(a, b, c, d, e) {
    let priceCake = 45;
    let priceWaffles = 5.80;
    let pricePancakes = 3.20;

    let numberCampaignDays = Number(a);
    let numberConfectioners = Number(b);
    let numberCakes = Number(c);
    let numberWaffles = Number(d);
    let numberPancakes = Number(e);

    let cake = numberCakes * priceCake;
    let waffles = numberWaffles * priceWaffles;
    let pancakes = numberPancakes * pricePancakes;

    let totalPriceOneDay = (cake + waffles + pancakes) * numberConfectioners;
    let totalPriceCampaign = totalPriceOneDay * numberCampaignDays;
    let total = totalPriceCampaign - (totalPriceCampaign / 8);

    console.log(total);
}
