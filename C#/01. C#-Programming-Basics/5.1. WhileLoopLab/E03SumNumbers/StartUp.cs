using System;

namespace _03.SumNumbers
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
           
            int sum = 0;

            while (sum < num)
            {
                int countNum = int.Parse(Console.ReadLine());
                sum += countNum;    
            }
            Console.WriteLine(sum);
        }
    }
}
