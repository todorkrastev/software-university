
namespace TradeCommissions
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string inputCity = Console.ReadLine();
            double volumeOfSales = double.Parse(Console.ReadLine());

            if (volumeOfSales <= 500 && volumeOfSales >= 0)
            {
                switch(inputCity)
                {
                    case "Sofia":
                        double commissionRateSofia = 0.05;
                        double finalCommissionSofia = volumeOfSales * commissionRateSofia;
                        Console.WriteLine($"{finalCommissionSofia:f2}");
                        break;

                    case "Varna":
                        double commissionRateVarna = 0.045;
                        double finalCommissionVarna = volumeOfSales * commissionRateVarna;
                        Console.WriteLine($"{finalCommissionVarna:f2}");
                            break;

                    case "Plovdiv":
                        double commissionRatePlovdiv = 0.055;
                        double finalCommissionPlovdiv = volumeOfSales * commissionRatePlovdiv;
                        Console.WriteLine($"{finalCommissionPlovdiv:f2}");
                        break;

                    default:
                        Console.WriteLine("error");
                        break;
                }
            }
            else if (volumeOfSales > 500 && volumeOfSales <= 1000)
            {
                switch (inputCity)
                {
                    case "Sofia":
                        double commissionRateSofia = 0.07;
                        double finalCommissionSofia = volumeOfSales * commissionRateSofia;
                        Console.WriteLine($"{finalCommissionSofia:f2}");
                        break;

                    case "Varna":
                        double commissionRateVarna = 0.075;
                        double finalCommissionVarna = volumeOfSales * commissionRateVarna;
                        Console.WriteLine($"{finalCommissionVarna:f2}");
                        break;

                    case "Plovdiv":
                        double commissionRatePlovdiv = 0.08;
                        double finalCommissionPlovdiv = volumeOfSales * commissionRatePlovdiv;
                        Console.WriteLine($"{finalCommissionPlovdiv:f2}");
                        break;

                    default:
                        Console.WriteLine("error");
                        break;

                }

            }
            else if (volumeOfSales > 1000 && volumeOfSales <= 10000)
            {
                switch (inputCity)
                {
                    case "Sofia":
                        double commissionRateSofia = 0.08;
                        double finalCommissionSofia = volumeOfSales * commissionRateSofia;
                        Console.WriteLine($"{finalCommissionSofia:f2}");
                        break;

                    case "Varna":
                        double commissionRateVarna = 0.10;
                        double finalCommissionVarna = volumeOfSales * commissionRateVarna;
                        Console.WriteLine($"{finalCommissionVarna:f2}");
                        break;

                    case "Plovdiv":
                        double commissionRatePlovdiv = 0.12;
                        double finalCommissionPlovdiv = volumeOfSales * commissionRatePlovdiv;
                        Console.WriteLine($"{finalCommissionPlovdiv:f2}");
                        break;

                    default:
                        Console.WriteLine("error");
                        break;
                }
            }
            else if (volumeOfSales > 10000)
            {
                switch(inputCity)
                {
                    case "Sofia":
                        double commissionRateSofia = 0.12;
                        double finalCommissionSofia = volumeOfSales * commissionRateSofia;
                        Console.WriteLine($"{finalCommissionSofia:f2}");
                        break;

                    case "Varna":
                        double commissionRateVarna = 0.13;
                        double finalCommissionVarna = volumeOfSales * commissionRateVarna;
                        Console.WriteLine($"{finalCommissionVarna:f2}");
                        break;

                    case "Plovdiv":
                        double commissionRatePlovdiv = 0.145;
                        double finalCommissionPlovdiv = volumeOfSales * commissionRatePlovdiv;
                        Console.WriteLine($"{finalCommissionPlovdiv:f2}");
                        break;

                    default:
                        Console.WriteLine("error");
                        break;
                }
            }
            else
                Console.WriteLine("error");
        }
    }
}
