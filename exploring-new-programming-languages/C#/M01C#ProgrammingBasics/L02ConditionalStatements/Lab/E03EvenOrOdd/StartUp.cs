using System;

namespace EvenOrOdd
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int insertNumber = int.Parse(Console.ReadLine());
            if (insertNumber % 2 == 0)
            {
                Console.WriteLine("even");
            }
            else
            {
                Console.WriteLine("odd");
            }
        }
    }
}
