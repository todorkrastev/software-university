using System;

namespace _06.PassengersPerFlight
{
    class Program
    {
        static void Main(string[] args)
        {
            int airlineCompanyNum = int.Parse(Console.ReadLine());
            string command = Console.ReadLine();
            int sumPassangers = 0;
            double averageNumPassangers = 0.00;
            int countFlights = 0;
            int numPassangers = 0;
            double maxAverageNum = double.MinValue;
            string finalNameAirlineCompany = "";


            for (int i = 1; i <= airlineCompanyNum; i++)
            {
                numPassangers = int.Parse(Console.ReadLine());
                string nameAirlineCompany = command;

                while (true)
                {
                    countFlights++;
                    sumPassangers += numPassangers;
                    command = Console.ReadLine();
                    if (command == "Finish")
                    {
                        break;
                    }
                    numPassangers = int.Parse(command);
                }

                averageNumPassangers = sumPassangers * 1.0 / countFlights;
                Console.WriteLine($"{nameAirlineCompany}: {Math.Floor(averageNumPassangers)} passengers.");
                if (maxAverageNum <= averageNumPassangers)
                {
                    finalNameAirlineCompany = nameAirlineCompany;
                    maxAverageNum = averageNumPassangers;
                }

                sumPassangers = 0;
                countFlights = 0;
                command = Console.ReadLine();
            }
            Console.WriteLine($"{finalNameAirlineCompany} has most passengers per flight: {Math.Floor(maxAverageNum)}");
        }
    }
}
