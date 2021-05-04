using System;

namespace Radians_to_Degrees
{
    class Program
    {
        static void Main(string[] args)
        {
            double Rad = double.Parse(Console.ReadLine());
            double Deg = Rad * 180 / Math.PI;
            Console.WriteLine(Math.Round(Deg));
        }
    }
}
