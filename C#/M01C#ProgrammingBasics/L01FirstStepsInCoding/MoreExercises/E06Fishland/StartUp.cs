
namespace _06.Fishland
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double mackerelPrice = double.Parse(Console.ReadLine());
            double spratPrice = double.Parse(Console.ReadLine());
            double bonitoKG = double.Parse(Console.ReadLine());
            double scadKG = double.Parse(Console.ReadLine());
            double musselKG = double.Parse(Console.ReadLine());

            double bonitoPrice = mackerelPrice * 1.60;
            double scadPrice = spratPrice * 1.80;
            double musselPrice = 7.5;

            double result = bonitoKG * bonitoPrice + scadKG * scadPrice + musselKG * musselPrice;

            Console.WriteLine($"{result:f2}");



        }
    }
}
