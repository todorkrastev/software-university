using System;

namespace Fruit_Market
{
    class Program
    {
        static void Main(string[] args)
        {
            //Цена на ягодите в лева – реално число в интервала[0.00 … 10000.00]
            double priceOfTheStrawberriesInBGN = double.Parse(Console.ReadLine());
            //Количество на бананите в килограми – реално число в интервала[0.00 … 1 0000.00]
            double quantityOfTheBananasPerKg = double.Parse(Console.ReadLine());
            //Количество на портокалите в килограми – реално число в интервала[0.00 … 10000.00]
            double quantityOfTheOrangesPerKg = double.Parse(Console.ReadLine());
            //Количество на малините в килограми – реално число в интервала[0.00 … 10000.00]
            double quantityOfTheRaspberriesPerKg = double.Parse(Console.ReadLine());
            //Количество на ягодите в килограми – реално число в интервала[0.00 … 10000.00]
            double quantityOfTheStrawberriesInKg = double.Parse(Console.ReadLine());

            //цената на малините е на половина по - ниска от тази на ягодите;
            double priceOfTheRaspberries = priceOfTheStrawberriesInBGN * 0.5;
            //цената на портокалите е с 40 % по - ниска от цената на малините;
            double priceOfTheOranges = priceOfTheRaspberries * 0.6;
            //цената на бананите е с 80 % по - ниска от цената на малините. 
            double priceOfTheBananas = priceOfTheRaspberries * 0.2;

            double sumStrawberries = priceOfTheStrawberriesInBGN * quantityOfTheStrawberriesInKg;
            double sumRaspberries = priceOfTheRaspberries * quantityOfTheRaspberriesPerKg;
            double sumOranges = priceOfTheOranges * quantityOfTheOrangesPerKg;
            double sumBananas = priceOfTheBananas * quantityOfTheBananasPerKg;

            double sumTotal = sumStrawberries + sumRaspberries + sumOranges + sumBananas;
            Console.WriteLine($"{sumTotal:f2}");
        }
    }
}
