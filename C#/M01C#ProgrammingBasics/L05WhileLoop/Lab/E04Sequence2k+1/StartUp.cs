
namespace _04.Sequence2k_1
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            int startCounting = 1;

            while (startCounting <= num)
            {
                Console.WriteLine(startCounting);
                startCounting = (startCounting * 2) + 1;
            }
        }
    }
}
