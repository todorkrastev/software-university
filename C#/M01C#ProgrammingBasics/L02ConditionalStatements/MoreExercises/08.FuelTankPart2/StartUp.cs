
namespace _08.FuelTankPart2
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string typeOfGas = Console.ReadLine();
            double litres = double.Parse(Console.ReadLine());
            string cardOwnership = Console.ReadLine();

            double gasolinePrice = 2.22;
            double dieselPrice = 2.33;
            double gasPrice = 0.93;

            double gasolineDiscount = 0.18;
            double dieselDiscount = 0.12;
            double gasDiscount = 0.08;

            double sum = 0.00;

            if (cardOwnership == "Yes")
            {
                switch (typeOfGas)
                {
                    case "Gasoline":
                        sum = (gasolinePrice - gasolineDiscount) * litres;
                        break;
                    case "Diesel":
                        sum = (dieselPrice - dieselDiscount) * litres;
                        break;
                    case "Gas":
                        sum = (gasPrice - gasDiscount) * litres;
                        break;
                }
            }
            else if (cardOwnership == "No")
            {
                switch (typeOfGas)
                {
                    case "Gasoline":
                        sum = gasolinePrice * litres;
                        break;
                    case "Diesel":
                        sum = dieselPrice * litres;
                        break;
                    case "Gas":
                        sum = gasPrice * litres;
                        break;
                }
            }

            if (20 <= litres && litres <= 25)
            {
                sum *= 0.92;
            }
            else if (25 < litres)
            {
                sum *= 0.9;
            }
            Console.WriteLine($"{sum:f2} lv.");
        }
    }
}

