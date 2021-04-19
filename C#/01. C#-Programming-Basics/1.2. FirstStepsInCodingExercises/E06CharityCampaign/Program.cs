using System;
using System.Globalization;

namespace Charity_Campaign
{
    class Program
    {
        static void Main(string[] args)
        {
            //Броят на дните, в които тече кампанията – цяло число в интервала[0 … 365]
            int numberOfDatesDuringTheCampaign = int.Parse(Console.ReadLine());
            //Броят на сладкарите – цяло число в интервала[0 … 1000]
            int numberOfTheBakers = int.Parse(Console.ReadLine());
            //Броят на тортите – цяло число в интервала[0… 2000]
            int numberOfTheCakes = int.Parse(Console.ReadLine());
            //Броят на гофретите – цяло число в интервала[0 … 2000]
            int numberOfTheWaffles = int.Parse(Console.ReadLine());
            //Броят на палачинките – цяло число в интервала[0 … 2000]
            int numberOfThePancakes = int.Parse(Console.ReadLine());
            //Торта - 45 лв.
            double priceOfTheCakes = 45;
            //Гофрета - 5.80 лв.
            double priceOfTheWaffles = 5.8;
            //Палачинка – 3.20 лв
            double priceOfThePancakes = 3.2;

            double totalResultCakes = numberOfTheCakes * priceOfTheCakes;
            double totalResultWaffles = numberOfTheWaffles * priceOfTheWaffles;
            double totalResultPancakes = numberOfThePancakes * priceOfThePancakes;
            double totalAmountPerDay = (totalResultCakes + totalResultWaffles + totalResultPancakes);
            double totalIncomeOfTheCampaign = totalAmountPerDay * numberOfDatesDuringTheCampaign * numberOfTheBakers;
            double totalProfit = totalIncomeOfTheCampaign - (totalIncomeOfTheCampaign / 8);
            Console.WriteLine(totalProfit);
        }
    }
}
