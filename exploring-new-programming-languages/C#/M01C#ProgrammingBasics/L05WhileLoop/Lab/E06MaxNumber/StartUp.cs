
namespace _06.MaxNumber
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            int biggestNum = int.MinValue;

            while (input != "Stop")
            {
                int inputNum = int.Parse(input);
                if (biggestNum < inputNum)
                {
                    biggestNum = inputNum;
                }
                    input = Console.ReadLine();
            }
            Console.WriteLine(biggestNum);
        }
    }
}
