
namespace _09.WeatherForecast
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            if (input == "sunny")
            {
                Console.WriteLine($"It's warm outside!");
            }
            else
            {
                Console.WriteLine($"It's cold outside!");
            }
        }
    }
}
