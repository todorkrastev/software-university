
namespace _05.DivideWithoutRemainder
{
using System;
    using System.Diagnostics.CodeAnalysis;

    class StartUp
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());

            double sumP1 = 0;
            double sumP2 = 0;
            double sumP3 = 0;

            for (int i = 1; i <= count; i++)
            {
                int num = int.Parse(Console.ReadLine());

                if (num % 2 == 0)
                {
                    sumP1++;
                }
                if (num % 3 == 0)
                {
                    sumP2++;
                }
                if (num % 4 == 0)
                {
                    sumP3++;
                }
            }
            double p1 = sumP1 / count * 100;
            double p2 = sumP2 / count * 100;
            double p3 = sumP3 / count * 100;

            Console.WriteLine($"{p1:f2}%");
            Console.WriteLine($"{p2:f2}%");
            Console.WriteLine($"{p3:f2}%");
        }
    }
}
