
namespace _02.HalfSumElement
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            
            int biggestNum = int.MinValue;
            int sum = 0;

            for (int i = 0; i < count; i++)
            {
                int num = int.Parse(Console.ReadLine());
                sum += num;

                if (num > biggestNum)
                {
                    biggestNum = num;
                }
            }
            int sumWithoutBiggestNum = sum - biggestNum;
            if (sumWithoutBiggestNum == biggestNum)
            {
                Console.WriteLine("Yes");
                Console.WriteLine($"Sum = {biggestNum}");
            }
            else
            {
                int diff = Math.Abs(biggestNum - sumWithoutBiggestNum);
                Console.WriteLine("No");
                Console.WriteLine($"Diff = {diff}");
            }
        }
    }
}
