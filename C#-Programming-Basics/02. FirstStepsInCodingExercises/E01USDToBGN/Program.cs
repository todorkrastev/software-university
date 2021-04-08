using System;

namespace USD_to_BGN
{
    class Program
    {
        static void Main(string[] args)
        {
            double USD = double.Parse(Console.ReadLine());
            double BGN = USD * 1.79549;
            Console.WriteLine($"{BGN:f2}");
        }
    }
}
