using System;

namespace _02.BikeRace
{
    class Program
    {
        static void Main(string[] args)
        {
            int juniorsNum = int.Parse(Console.ReadLine());
            int seniorsNum = int.Parse(Console.ReadLine());
            string trace = Console.ReadLine();

            double taxJunior = 0.00;
            double taxSenior = 0.00;

            int totalParticipants = juniorsNum + seniorsNum;

            switch (trace)
            {
                case "trail":
                    taxJunior = 5.5;
                    taxSenior = 7;
                    break;
                case "cross-country":
                    taxJunior = 8;
                    taxSenior = 9.5;
                    break;
                case "downhill":
                    taxJunior = 12.25;
                    taxSenior = 13.75;
                    break;
                case "road":
                    taxJunior = 20;
                    taxSenior = 21.5;
                    break;
            }

            double income = juniorsNum * taxJunior + seniorsNum * taxSenior;

            if (trace == "cross-country" && 50 <= totalParticipants)
            {
                income *= 0.75;
            }
            income *= 0.95;

            Console.WriteLine($"{income:f2}");
        }
    }
}
