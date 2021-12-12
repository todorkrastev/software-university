
namespace _06.Cake
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int widthCake = int.Parse(Console.ReadLine());
            int lengthCake = int.Parse(Console.ReadLine());
            int sumOfCake = widthCake * lengthCake;

            string command = "";

            while (0 <= sumOfCake)
            {
                command = Console.ReadLine();

                if (command == "STOP" && 0 <= sumOfCake)
                {
                    Console.WriteLine($"{sumOfCake} pieces are left.");
                    return;
                }

                int pieceOfCake = int.Parse(command);
                sumOfCake -= pieceOfCake;

            }
            Console.WriteLine($"No more cake left! You need {Math.Abs(sumOfCake)} pieces more.");
        }
    }
}
