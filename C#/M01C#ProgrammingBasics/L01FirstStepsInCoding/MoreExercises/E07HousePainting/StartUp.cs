using System;

namespace _07.HousePainting
{
    class StartUp
    {
        static void Main(string[] args)
        {
            double widthOfHouse = double.Parse(Console.ReadLine());
            double lengthOfHouse = double.Parse(Console.ReadLine());
            double heightOfHouse = double.Parse(Console.ReadLine());

            double areaOfWindow = 1.5 * 1.5;
            double areaOfEntrance = 1.2 * 2;

            double wallsResult = (2 * (widthOfHouse * lengthOfHouse)) - 2 * (areaOfWindow) + (2 * (widthOfHouse * widthOfHouse)) - areaOfEntrance;

            double greenPaintNeeded = wallsResult / 3.4;

            double roofResult = (2 * (widthOfHouse * lengthOfHouse)) + (2 * (widthOfHouse * heightOfHouse / 2));

            double redPaintNeeded = roofResult / 4.3;

            Console.WriteLine($"{greenPaintNeeded:f2}");
            Console.WriteLine($"{redPaintNeeded:f2}");



        }
    }
}
