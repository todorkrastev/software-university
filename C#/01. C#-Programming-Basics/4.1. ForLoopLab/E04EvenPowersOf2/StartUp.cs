using System;

namespace EvenPowersOf2
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            for (int i = 0; i <= num; i++)
            {
                if (i % 2 == 0)
                {
                    double result = Math.Pow(2, i);
                    Console.WriteLine(result);
                }
            }
        }
    }
}
