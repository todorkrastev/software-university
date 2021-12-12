
namespace _06.Building
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int numOfFloors = int.Parse(Console.ReadLine());
            int numOfRooms = int.Parse(Console.ReadLine());

            for (int i = 0; i < numOfRooms; i++)
            {
                Console.Write($"L{numOfFloors}{i} ");
            }

            Console.WriteLine();

            for (int i = numOfFloors - 1; i > 0; i--)
            {
                for (int j = 0; j < numOfRooms; j++)
                {
                    if (i % 2 == 0)
                    {
                        Console.Write($"O{i}{j} ");
                    }
                    else if (i % 2 == 1)
                    {
                        Console.Write($"A{i}{j} ");
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
