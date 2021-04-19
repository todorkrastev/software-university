
namespace ToyShop
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double priceOfPuzzle = 2.60;
            double priceOfTalkingDoll = 3.00;
            double priceOfTeddyBear = 4.10;
            double priceOfSmurf = 8.20;
            double priceOfLorry = 2.00;

            double priceOfExcursion = double.Parse(Console.ReadLine());
            int numberOfPuzzles = int.Parse(Console.ReadLine());
            int numberOfTalkingDolls = int.Parse(Console.ReadLine());
            int numberOfTeddyBears = int.Parse(Console.ReadLine());
            int numberOfSmurfs = int.Parse(Console.ReadLine());
            int numberOfLorries = int.Parse(Console.ReadLine());

            int totalUnitsOfOrderToys = numberOfPuzzles + numberOfTalkingDolls + numberOfTeddyBears + numberOfSmurfs + numberOfLorries;

            double totalPriceToys = (priceOfPuzzle * numberOfPuzzles) + (priceOfTalkingDoll * numberOfTalkingDolls) + (priceOfTeddyBear * numberOfTeddyBears) + (priceOfSmurf * numberOfSmurfs) + (priceOfLorry * numberOfLorries);

            if (totalUnitsOfOrderToys >= 50)
            {
                double totalPriceDiscount = totalPriceToys - (totalPriceToys * 0.25);
                double finalPriceAfterRentCosts = totalPriceDiscount - (totalPriceDiscount * 0.10);
          
                if (finalPriceAfterRentCosts >= priceOfExcursion)
                {
                   
                    Console.WriteLine($"Yes! {finalPriceAfterRentCosts - priceOfExcursion:f2} lv left.");
                }
                else if (finalPriceAfterRentCosts < priceOfExcursion)
                {
                    Console.WriteLine($"Not enough money! {priceOfExcursion - finalPriceAfterRentCosts:f2} lv needed.");
                }
            }
            else
            {
                double finalPrice = totalPriceToys - (totalPriceToys * 0.10);
                if (finalPrice >= priceOfExcursion)
                {
                    Console.WriteLine($"Yes! {finalPrice - priceOfExcursion:f2} lv left.");
                }
                else if (finalPrice < priceOfExcursion)
                {
                    Console.WriteLine($"Not enough money! {priceOfExcursion - finalPrice:f2} lv needed.");
                }

            }
        }
    }
}
