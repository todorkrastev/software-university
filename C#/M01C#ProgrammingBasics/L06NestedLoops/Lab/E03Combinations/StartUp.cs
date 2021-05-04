
namespace _03.Combinations
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int inputNum = int.Parse(Console.ReadLine());
            int count = 0;

            for (int a = 0; a <= inputNum; a++)
            {
                for (int b = 0; b <= inputNum; b++)
                {
                    for (int c = 0; c <= inputNum; c++)
                    {
                        int sum = a + b + c;
                        if (sum == inputNum)
                        {
                            count++;
                        }
                    }
                }
            }
            Console.WriteLine(count);
        }
    }
}
