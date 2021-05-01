using System;

namespace _04.FoodForPets
{
    class Program
    {
        static void Main(string[] args)
        {
            int daysNum = int.Parse(Console.ReadLine());
            double foodTotalAmount = double.Parse(Console.ReadLine());
            int count = 0;
            double sumDC = 0.00;
            double biscuit = 0.00;
            int result = 0;
            int dogSum = 0;
            int catSum = 0;
            

            for (int i = 1; i <= daysNum; i++)
            {
                int dogFood = int.Parse(Console.ReadLine());
                int catFood = int.Parse(Console.ReadLine());
                sumDC = dogFood + catFood;
                count++;

                if (count % 3 == 0)
                {
                    sumDC *= 0.10;
                    biscuit += sumDC;
                }

                dogSum += dogFood;
                catSum += catFood;
                result = dogSum + catSum;
            }

            double foodTotalPercentage = (result) * 1.0 / foodTotalAmount * 100;
            double dogPercentage = dogSum * 1.0 / result * 100;
            double catPercentage = catSum * 1.0 / result * 100;

            Console.WriteLine($"Total eaten biscuits: {Math.Round(biscuit)}gr.");
            Console.WriteLine($"{foodTotalPercentage:f2}% of the food has been eaten.");
            Console.WriteLine($"{dogPercentage:f2}% eaten from the dog.");
            Console.WriteLine($"{catPercentage:f2}% eaten from the cat.");
        }
    }
}
