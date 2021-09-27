
namespace SumNumbers
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            int result = 0;
            

            for (int i = 0; i < count; i++)
            {
                int num = int.Parse(Console.ReadLine());
                result += num;
            }
            Console.WriteLine(result);
        }
    }
}
