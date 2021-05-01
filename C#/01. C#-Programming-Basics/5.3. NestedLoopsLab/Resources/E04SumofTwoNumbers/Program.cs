using System;

namespace _04.SumofTwoNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());
            int magicNum = int.Parse(Console.ReadLine());
            int combinationNum = 0;
            
            for (int i = start; i <= end; i++)
            {
                for (int j = start; j <= end; j++)
                {
                    int sum = i + j;
                    combinationNum++;
                    if (sum == magicNum)
                    {
                        Console.WriteLine($"Combination N:{combinationNum} ({i} + {j} = {magicNum})");
                        return;
                    }
                }
            }
            Console.WriteLine($"{combinationNum} combinations - neither equals {magicNum}");
        }
    }
}
