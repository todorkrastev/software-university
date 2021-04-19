
namespace Volleyball
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string year = Console.ReadLine();
            int holidays = int.Parse(Console.ReadLine());
            int weekendsHome = int.Parse(Console.ReadLine());

            int weekendsPerYear = 48;

            double playHolidays = holidays * (2.0 / 3.0);
            double playWeekendsSofia = (weekendsPerYear - weekendsHome) * (3.0 / 4.0);
            double playInTotal = Math.Floor(playWeekendsSofia + weekendsHome + playHolidays);
            double playInTotalLeap = Math.Floor((playWeekendsSofia + weekendsHome + playHolidays) * 1.15);

            switch(year)
            {
                case "leap":
                    Console.WriteLine(playInTotalLeap);
                    break;

                case "normal":
                    Console.WriteLine(playInTotal);
                    break;
            }
        }
    }
}
