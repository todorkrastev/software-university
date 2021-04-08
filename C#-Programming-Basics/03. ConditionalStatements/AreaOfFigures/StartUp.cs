
namespace AreaOfFigures
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string typeOfFigure = Console.ReadLine();
            if (typeOfFigure == "square")
            {
                double sideSqaure = double.Parse(Console.ReadLine());
                double areaofSquare = sideSqaure * sideSqaure;
                Console.WriteLine($"{areaofSquare:f3}");
            }
            else if (typeOfFigure == "rectangle")
            {
                double sideRectangleA = double.Parse(Console.ReadLine());
                double sideRectangleB = double.Parse(Console.ReadLine());
                double areaOfRectangle = sideRectangleA * sideRectangleB;
                Console.WriteLine($"{areaOfRectangle:f3}");
            }
            else if (typeOfFigure == "circle")
            {
                double radiusOfCircle = double.Parse(Console.ReadLine());
                double areaOfCircle = Math.PI * radiusOfCircle * radiusOfCircle;
                Console.WriteLine($"{areaOfCircle:F3}");
            }
            else if(typeOfFigure == "triangle")
            {
                double sideOfTriangle = double.Parse(Console.ReadLine());
                double heightOfTriangle = double.Parse(Console.ReadLine());
                double areaOfTriangle = (sideOfTriangle * heightOfTriangle) / 2;
                Console.WriteLine($"{areaOfTriangle:F3}");
            }
            else
            {
                Console.WriteLine("Insert correct information!");
            }
        }
    }
}
