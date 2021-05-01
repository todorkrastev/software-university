
namespace _02.EqualSumsEvenOddPosition
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int numFirst = int.Parse(Console.ReadLine());
            int numSecond = int.Parse(Console.ReadLine());

            for (int i = numFirst; i <= numSecond; i++)
            {
                int currNum = i;
                int evenSum = 0;
                int oddSum = 0;
                int count = 0;

                while (currNum != 0)
                {
                    int digit = currNum % 10;
                    if (count % 2 == 0)
                    {
                        evenSum += digit;
                    }
                    else
                    {
                        oddSum += digit;
                    }

                    currNum = currNum / 10;
                    count++;
                }
                if (evenSum == oddSum)
                {
                    Console.Write($"{i} ");
                }
            }
        }
    }
}
