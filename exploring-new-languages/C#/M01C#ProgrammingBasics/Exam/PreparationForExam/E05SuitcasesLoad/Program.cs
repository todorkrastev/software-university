using System;

namespace _05.SuitcasesLoad
{
    class Program
    {
        static void Main(string[] args)
        {
            double capacityTrunk = double.Parse(Console.ReadLine());
            string command = Console.ReadLine();
            int count = 0;
            double sum = 0.00;

            while (command != "End")
            {
                double suitcaseCapacity = double.Parse(command);
                count++;

                if (count % 3 == 0)
                {
                    suitcaseCapacity *= 1.10;
                }

                sum += suitcaseCapacity;

                if (capacityTrunk < sum)
                {
                    Console.WriteLine("No more space!");
                    count--;
                    break;
                }


                command = Console.ReadLine();
            }

            if (sum <= capacityTrunk)
            {
                Console.WriteLine("Congratulations! All suitcases are loaded!");
            }

            Console.WriteLine($"Statistic: {count} suitcases loaded.");
        }
    }
}
