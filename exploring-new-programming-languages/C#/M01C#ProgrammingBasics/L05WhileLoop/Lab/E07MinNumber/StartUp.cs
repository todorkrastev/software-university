
namespace _07.MinNumber
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {

            string input = Console.ReadLine();
            int smallestNum = int.MaxValue;

            while (input != "Stop")
            {
                int inputNum = int.Parse(input);
                if (inputNum < smallestNum)
                {
                    smallestNum = inputNum;
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(smallestNum);
        }
    }
}

