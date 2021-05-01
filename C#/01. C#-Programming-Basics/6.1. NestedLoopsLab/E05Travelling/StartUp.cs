
namespace _05.Travelling
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string command = "";
            double savedMoney = 0.0;
            double sum = 0.0;

            while (command != "End")
            {
                string destination = Console.ReadLine();
                if (destination == "End")
                {
                    break;
                }
                double budget = double.Parse(Console.ReadLine());
             

                while (sum < budget)
                {
                    savedMoney = double.Parse(Console.ReadLine());
                    sum += savedMoney;
                }

                if (budget <= sum)
                {
                    Console.WriteLine($"Going to {destination}!");
                    sum = 0;
                    continue;
                }
            }
        }
    }
}
