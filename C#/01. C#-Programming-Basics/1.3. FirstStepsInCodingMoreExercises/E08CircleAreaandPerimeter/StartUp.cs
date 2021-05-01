
namespace _08.CircleAreaandPerimeter
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double input = double.Parse(Console.ReadLine());

            double areaOfCircuit = Math.PI * input * input;
            double perimeterOfCircuit = 2 * Math.PI * input;

            Console.WriteLine($"{areaOfCircuit:f2}");
            Console.WriteLine($"{perimeterOfCircuit:f2}");


        }
    }
}
