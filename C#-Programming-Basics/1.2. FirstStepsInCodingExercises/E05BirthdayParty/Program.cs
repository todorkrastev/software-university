using System;

namespace Birthday_Party
{
    class Program
    {
        static void Main(string[] args)
        {
            //От конзолата се четe 1 ред:
            //Наем за залата – реално число в интервала[100.00..10000.00]
            double rentOfTheHall = double.Parse(Console.ReadLine());
            //Торта  – цената ѝ е 20 % от наема на залата
            double priceOfTheCake = rentOfTheHall * 0.2;
            //Напитки – цената им е 45 % по - малко от тази на тортата 
            //(с 45% по-малка от цената на cake, т.е. те са 55% от цената на cake)
            double priceOfTheBeverage = priceOfTheCake - (priceOfTheCake * 0.45);
            //Аниматор – цената му е 1 / 3 от цената за наема на залата
            double salaryOfTheAnimator = rentOfTheHall / 3;
            double requiredBudget = rentOfTheHall + priceOfTheCake + priceOfTheBeverage + salaryOfTheAnimator;
            Console.WriteLine(requiredBudget);
        }
    }
}
