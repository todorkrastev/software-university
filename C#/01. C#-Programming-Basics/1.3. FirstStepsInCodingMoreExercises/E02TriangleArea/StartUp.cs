
namespace _02.TriangleArea
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double a = double.Parse(Console.ReadLine());
            double h = double.Parse(Console.ReadLine());

            double areaOfTriangle = a * h / 2;

            Console.WriteLine($"{areaOfTriangle:f2}");
        }
    }
}
