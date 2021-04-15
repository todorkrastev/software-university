
namespace _08.FuelTank
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string gasType = Console.ReadLine().ToLower();
            double litres = double.Parse(Console.ReadLine());

            if (gasType == "gasoline" || gasType == "diesel" || gasType == "gas")
            {
                if (25 <= litres)
                {
                    Console.WriteLine($"You have enough {gasType}.");
                }
                else
                {
                    Console.WriteLine($"Fill your tank with {gasType}!");
                }  
            }
            else
            {
                Console.WriteLine($"Invalid fuel!");
            }

        }
    }
}
