
namespace _04.Histogram
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            
            int sumP1 = 0;
            int sumP2 = 0;
            int sumP3 = 0;
            int sumP4 = 0;
            int sumP5 = 0;

            double p1 = 0;
            double p2 = 0;
            double p3 = 0;
            double p4 = 0;
            double p5 = 0;

            for (int i = 1; i <= count; i++)
            {
                int num = int.Parse(Console.ReadLine());

                if (num < 200)
                {
                    sumP1 += 1;
                }
                else if (num < 400)
                {
                    sumP2 += 1;
                }
                else if (num < 600)
                {
                    sumP3 += 1;
                }
                else if (num < 800)
                {
                    sumP4 += 1;
                }
                else
                {
                    sumP5 += 1;
                }
            }
            double Sum = sumP1 + sumP2 + sumP3 + sumP4 + sumP5;
            p1 = (sumP1 / Sum) * 100;
            p2 = (sumP2 / Sum) * 100;
            p3 = (sumP3 / Sum) * 100;
            p4 = (sumP4 / Sum) * 100;
            p5 = (sumP5 / Sum) * 100;

            Console.WriteLine($"{p1:f2}%");
            Console.WriteLine($"{p2:f2}%");
            Console.WriteLine($"{p3:f2}%");
            Console.WriteLine($"{p4:f2}%");
            Console.WriteLine($"{p5:f2}%");
        }
    }
}
