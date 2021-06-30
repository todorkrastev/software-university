
namespace _01.MatchTickets
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string categoryTicket = Console.ReadLine();
            int peopleNum = int.Parse(Console.ReadLine());

            double vipTicket = 499.99;
            double normalTicket = 249.99;

            double moneyForTicketAfterTransport = 0.00;
            double calc = 0.00;
            double diff = 0.00;

            if (1 <= peopleNum && peopleNum <= 4)
            {
                moneyForTicketAfterTransport = budget * 0.25;
            }
            else if (5 <= peopleNum && peopleNum <= 9)
            {
                moneyForTicketAfterTransport = budget * 0.4;
            }
            else if (10 <= peopleNum && peopleNum <= 24)
            {
                moneyForTicketAfterTransport = budget * 0.5;
            }
            else if (25 <= peopleNum && peopleNum <= 49)
            {
                moneyForTicketAfterTransport = budget * 0.6;
            }
            else if (50 <= peopleNum)
            {
                moneyForTicketAfterTransport = budget * 0.75;
            }

            if (categoryTicket == "Normal")
            {
                calc = normalTicket * peopleNum;
                diff = moneyForTicketAfterTransport - calc;

                if (calc <= moneyForTicketAfterTransport)
                {
                    Console.WriteLine($"Yes! You have {Math.Abs(diff):f2} leva left." );
                }
                else if (moneyForTicketAfterTransport < calc)
                {
                    Console.WriteLine($"Not enough money! You need {Math.Abs(diff):f2} leva.");
                }
            }
            else if (categoryTicket == "VIP")
            {
                calc = vipTicket * peopleNum;
                diff = moneyForTicketAfterTransport - calc;

                if (calc <= moneyForTicketAfterTransport)
                {
                    Console.WriteLine($"Yes! You have {Math.Abs(diff):f2} leva left.");
                }
                else if (moneyForTicketAfterTransport < calc)
                {
                    Console.WriteLine($"Not enough money! You need {Math.Abs(diff):f2} leva.");
                }
            }
        }
    }
}
