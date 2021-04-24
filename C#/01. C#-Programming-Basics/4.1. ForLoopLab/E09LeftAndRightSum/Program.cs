using System;

namespace LeftAndRightSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            int resultLeft = 0;
            int resultRight = 0;
            

            for (int i = 0; i < count; i++)
            {
                int numLeft = int.Parse(Console.ReadLine());
                resultLeft += numLeft;
            }

            for (int i = 0; i < count; i++)
            {
                int numRight = int.Parse(Console.ReadLine());
                resultRight += numRight;
            }

            if (resultLeft == resultRight)
            {
                Console.WriteLine($"Yes, sum = {resultLeft}");
            }
            else
            {
                int totalResult = resultLeft - resultRight;
                Console.WriteLine($"No, diff = {Math.Abs(totalResult)}");
            }
        }
    }
}
