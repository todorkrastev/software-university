
namespace _03.OddEvenPosition
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());

            double oddMax = double.MinValue;
            double oddMin = double.MaxValue;
            double evenMax = double.MinValue;
            double evenMin = double.MaxValue;

            double oddSum = 0;
            double evenSum = 0;

            for (int i = 1; i <= count; i++)
            {
                double num = double.Parse(Console.ReadLine());

                if (i % 2 == 0)
                {
                    evenSum += num;

                    if (num > evenMax)
                    {
                        evenMax = num;
                    }

                    if (num < evenMin)
                    {
                        evenMin = num;
                    }
                }
                else if (i % 2 == 1)
                {
                    oddSum += num;

                    if (num > oddMax)
                    {
                        oddMax = num;
                    }

                    if (num < oddMin)
                    {
                        oddMin = num;
                    }
                }
            }

            Console.WriteLine($"OddSum={oddSum:f2},");

            if (oddSum == 0)
            {
                Console.WriteLine("OddMin=No,");
                Console.WriteLine("OddMax=No,");
            }
            else
            {
                Console.WriteLine($"OddMin={oddMin:f2},");
                Console.WriteLine($"OddMax={oddMax:f2},");
            }   
            Console.WriteLine($"EvenSum={evenSum:f2},");

            if (evenSum == 0)
            {
                Console.WriteLine("EvenMin=No,");
                Console.WriteLine("EvenMax=No");
            }
            else
            {
                Console.WriteLine($"EvenMin={evenMin:f2},");
                Console.WriteLine($"EvenMax={evenMax:f2}");
            } 
        }
    }
}
