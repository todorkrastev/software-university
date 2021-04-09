using System;

namespace MetricConverter
{
    class StartUp
    {
        static void Main(string[] args)
        {
            double insertNum = double.Parse(Console.ReadLine());
            string inputUnitOfMeasure = Console.ReadLine();
            string outputUnitOfMeasure = Console.ReadLine();

            if (inputUnitOfMeasure == "m" && outputUnitOfMeasure == "mm")
            {
                insertNum *= 1000;
            }
            else if (inputUnitOfMeasure == "mm" && outputUnitOfMeasure == "m")
            {
                insertNum /= 1000;
            }
            else if (inputUnitOfMeasure == "m" && outputUnitOfMeasure == "cm" )
            {
                insertNum *= 100;
            }
            else if (inputUnitOfMeasure == "cm" && outputUnitOfMeasure == "m")
            {
                insertNum /= 100;
            }
            else if (inputUnitOfMeasure == "cm" && outputUnitOfMeasure == "mm")
            {
                insertNum *= 10;
            }
            else if (inputUnitOfMeasure == "mm" && outputUnitOfMeasure == "cm")
            {
                insertNum /= 10;
            }
            Console.WriteLine($"{insertNum:f3}");

        }
    }
}
