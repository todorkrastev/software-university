
namespace NumberSequence
{
    using System;
    using System.Xml.Schema;

    class StartUp
    {
        static void Main(string[] args)
        {
            int smallestNum = int.MaxValue;
            int biggestNum = int.MinValue;

            int count = int.Parse(Console.ReadLine());

            for (int i = 0; i < count; i++)
            {
                int num = int.Parse(Console.ReadLine());

                if (num > biggestNum)
                {
                    biggestNum = num;
                }

                if (num < smallestNum)
                {
                    smallestNum = num;
                }

            }
            Console.WriteLine($"Max number: {biggestNum}");
            Console.WriteLine($"Min number: {smallestNum}");
        }
    }
}
