
namespace _09.Moving
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int width = int.Parse(Console.ReadLine());
            int lenght = int.Parse(Console.ReadLine());
            int height = int.Parse(Console.ReadLine());

            int m3Apartment = width * lenght * height;
            int sumBoxes = 0;

            string command = Console.ReadLine();

            while (command != "Done")
            {
                int boxes = int.Parse(command);
                sumBoxes += boxes;

                if (sumBoxes > m3Apartment)
                {
                    Console.WriteLine($"No more free space! You need {Math.Abs(m3Apartment - sumBoxes)} Cubic meters more.");
                    break;
                }

                command = Console.ReadLine();

                if (command == "Done" && sumBoxes < m3Apartment)
                {
                    Console.WriteLine($"{m3Apartment - sumBoxes} Cubic meters left.");
                    break;
                }
            }
        }
    }
}
