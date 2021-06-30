using System;

namespace _07.CinemaTickets
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int studentTickets = 0;
            int standardTickets = 0;
            int kidTickets = 0;

            while (true)
            {
                string input = Console.ReadLine();

                if (input == "Finish")
                {
                    break;
                }

                int freeSpots = int.Parse(Console.ReadLine());
                int currentFreeSpots = freeSpots;

                while (currentFreeSpots > 0)
                {
                    string ticketType = Console.ReadLine();

                    if (ticketType == "End")
                    {
                        break;
                    }

                    currentFreeSpots--;

                    if (ticketType == "standard")
                    {
                        standardTickets++;
                    }
                    else if (ticketType == "student")
                    {
                        studentTickets++;
                    }
                    else if (ticketType == "kid")
                    {
                        kidTickets++;
                    }
                }
                double freeSpotsInPercentage = 100 - (currentFreeSpots * 1.0 / freeSpots * 100);
                Console.WriteLine($"{input} - {freeSpotsInPercentage:f2}% full.");
            }
            int totalTickets = standardTickets + kidTickets + studentTickets;
            double studentTicketsInPercentage = studentTickets * 1.0 / totalTickets * 100;
            double standardTicketsInPercentage = standardTickets * 1.0 / totalTickets * 100;
            double kidTicketsInPercentage = kidTickets * 1.0 / totalTickets * 100;

            Console.WriteLine($"Total tickets: {totalTickets}");
            Console.WriteLine($"{studentTicketsInPercentage:f2}% student tickets.");
            Console.WriteLine($"{standardTicketsInPercentage:f2}% standard tickets.");
            Console.WriteLine($"{kidTicketsInPercentage:f2}% kids tickets.");
        }
    }
}
