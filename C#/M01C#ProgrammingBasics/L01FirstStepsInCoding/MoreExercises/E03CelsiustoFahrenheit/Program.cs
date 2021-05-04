using System;

namespace _03.CelsiustoFahrenheit
{
    class Program
    {
        static void Main(string[] args)
        {
            double inputCelsius = double.Parse(Console.ReadLine());

            double CelsiusToFahrenheit = inputCelsius * 9 / 5 + 32;

            Console.WriteLine($"{CelsiusToFahrenheit:f2}");
            
        }
    }
}
