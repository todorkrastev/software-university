using System;

namespace _01.TrapeziodArea
{
    class StartUp
    {
        static void Main(string[] args)
        {
            double a = double.Parse(Console.ReadLine());
            double b = double.Parse(Console.ReadLine());
            double h = double.Parse(Console.ReadLine());

            double areaOfTrapeziod = (a + b) * h / 2;

            Console.WriteLine($"{areaOfTrapeziod:f2}");
        }
    }
}
