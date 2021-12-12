using System;

namespace _04.CatFood
{
    class Program
    {
        static void Main(string[] args)
        {
            int catsNum = int.Parse(Console.ReadLine());

            double priceFoodPerKG = 12.45;
            int countG1 = 0;
            int countG2 = 0;
            int countG3 = 0;
            double totalSum = 0.00;

            for (int i = 1; i <= catsNum; i++)
            {
                double foodPerCat = double.Parse(Console.ReadLine());

                if (100 <= foodPerCat && foodPerCat < 200)
                {
                    countG1++;
                }
                else if (200 <= foodPerCat && foodPerCat < 300)
                {
                    countG2++;
                }
                else if (300 <= foodPerCat && foodPerCat < 400)
                {
                    countG3++;
                }
                totalSum += foodPerCat;
            }
            double finalPrice = (totalSum / 1000) * priceFoodPerKG;

            Console.WriteLine($"Group 1: {countG1} cats.");
            Console.WriteLine($"Group 2: {countG2} cats.");
            Console.WriteLine($"Group 3: {countG3} cats.");
            Console.WriteLine($"Price for food per day: {finalPrice:f2} lv.");

        }
    }
}
