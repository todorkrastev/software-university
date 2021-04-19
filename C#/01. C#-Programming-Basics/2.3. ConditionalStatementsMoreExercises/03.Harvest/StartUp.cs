using System;

namespace _03.Harvest
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int grapevine = int.Parse(Console.ReadLine());
            double grapes = double.Parse(Console.ReadLine());
            int litresNeeded = int.Parse(Console.ReadLine());
            int workers = int.Parse(Console.ReadLine());

            double sumGrapes = grapevine * grapes;
            double wine = sumGrapes * 0.4 / 2.5;

            double diff = Math.Abs(wine - litresNeeded);
            double wineWorkers = diff / workers;

            if (litresNeeded < wine)
            {
                Console.WriteLine($"Good harvest this year! Total wine: {Math.Floor(wine)} liters.");
                Console.WriteLine($"{Math.Ceiling(diff)} liters left -> {Math.Ceiling(wineWorkers)} liters per person.");
            }
            else
            {
                Console.WriteLine($"It will be a tough winter! More {Math.Floor(diff)} liters wine needed.");
            }
        }
    }
}
