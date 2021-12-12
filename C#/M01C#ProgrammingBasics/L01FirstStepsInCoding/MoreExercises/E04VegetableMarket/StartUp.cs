
namespace _04.VegetableMarket
{
using System;
    using System.Transactions;

    class StartUP
    {
        static void Main(string[] args)
        {
            double priceVeg = double.Parse(Console.ReadLine());
            double priceFruit = double.Parse(Console.ReadLine());

            int vegTotalKg = int.Parse(Console.ReadLine());
            int fruitTotalKg = int.Parse(Console.ReadLine());

            double totalSum = priceVeg * vegTotalKg + priceFruit * fruitTotalKg;
            double BGNtoEUR = totalSum / 1.94;

            Console.WriteLine($"{BGNtoEUR:f2}");
        }
    }
}
