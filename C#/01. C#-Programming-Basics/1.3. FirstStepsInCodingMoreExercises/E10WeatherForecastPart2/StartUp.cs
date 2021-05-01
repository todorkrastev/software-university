using System;

namespace _10.WeatherForecastPart2
{
    class StartUp
    {
        static void Main(string[] args)
        {
            double input = double.Parse(Console.ReadLine());

            if (26 <= input && input <= 35)
            {
                Console.WriteLine("Hot");
            }
            else if (20.1 <= input && input <= 25.9)
            {
                Console.WriteLine("Warm");
            }
            else if (15 <= input && input <= 20)
            {
                Console.WriteLine("Mild");
            }
            else if (12 <= input && input <= 14.9)
            {
                Console.WriteLine("Cool");
            }
            else if (5 <= input && input == 11.9)
            {
                Console.WriteLine("Cold");
            }
            else
            {
                Console.WriteLine("unknown");
            }
        }
    }
}
