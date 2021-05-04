
namespace FishingBoat
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int budget = int.Parse(Console.ReadLine());
            string inputSeason = Console.ReadLine();
            int numberOfFishermen = int.Parse(Console.ReadLine());

            int priceOfShip = 0;
            double discount = 1;

            switch(inputSeason)
            {
                case "Spring":
                    priceOfShip = 3000;
                    break;

                case "Summer":
                    priceOfShip = 4200;
                    break;


                case "Autumn":
                    priceOfShip = 4200;
                    break;

                case "Winter":
                    priceOfShip = 2600;
                    break;
            }
            if (numberOfFishermen <= 6)
            {
                discount = 0.9;
            }
            else if (numberOfFishermen >= 7 && numberOfFishermen <= 11)
            {
                discount = 0.85;
            }
            else
            {
                discount = 0.75;
            }

            double totalPrice = priceOfShip * discount;

            if(numberOfFishermen % 2 == 0 && inputSeason != "Autumn")
            {
                double extraDiscount = 0.95;
                totalPrice *= extraDiscount;
            }

            double surplusLackOfMoney = budget - totalPrice;

            if(budget >= totalPrice)
            {
                Console.WriteLine($"Yes! You have {surplusLackOfMoney:f2} leva left.");
            }
            else
            {
                Console.WriteLine($"Not enough money! You need {(surplusLackOfMoney*-1):f2} leva.");
            }
        }
    }
}
