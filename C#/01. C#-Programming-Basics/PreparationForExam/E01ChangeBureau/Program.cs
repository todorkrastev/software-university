using System;

namespace _01.ChangeBureau
{
    class Program
    {
        static void Main(string[] args)
        {
            int bitcoinNum = int.Parse(Console.ReadLine());
            double chineseNum = double.Parse(Console.ReadLine());
            double commission = double.Parse(Console.ReadLine());

            double bitcoin = 1168;
            double chinese = 0.15;
            double dollar = 1.76;
            double euro = 1.95;

            double converter = (((chineseNum * chinese * dollar) + (bitcoin * bitcoinNum)) / euro);
            double result = converter - (converter * commission / 100);


            Console.WriteLine($"{result:f2}");

        }
    }
}
