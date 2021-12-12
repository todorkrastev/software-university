
namespace _01.NumberPyramid
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int numberForPrint = 1;

            for (int row = 1; row <= n; row++)
            {
                for (int numbersPerRow = 1; numbersPerRow <= row; numbersPerRow++)
                {
                    Console.Write($"{numberForPrint} ");
                    numberForPrint++;
                    if (numberForPrint > n)
                    {
                        break;
                    }
                }
                Console.WriteLine();
                if (numberForPrint > n)
                {
                    break;
                }
            }
        }
    }
}