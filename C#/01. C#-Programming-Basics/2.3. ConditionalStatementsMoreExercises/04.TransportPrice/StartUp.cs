using System;

namespace _04.TransportPrice
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int km = int.Parse(Console.ReadLine());
            string day = Console.ReadLine();
            double taxiInitialPrice = 0.70;
            double taxiDailyPrice = 0.79;
            double taxiNightPrice = 0.90;
            double busPrice = 0.09;
            double trainPrice = 0.06;

            if (day == "day" && 20 <= km && km <= 99)
            {
                Console.WriteLine($"{km * busPrice:f2}");
            }
            else if (day == "night" && 20 <= km && km <= 99)
            {
                Console.WriteLine($"{km * busPrice:f2}");
            }
            else if (day == "day" && 100 <= km && km <= 5000)
            {
                Console.WriteLine($"{km * trainPrice:f2}");
            }
            else if (day == "night" && 100 <= km && km <= 5000)
            {
                Console.WriteLine($"{km * trainPrice:f2}");
            }
            else if (day == "day" && km < 20 && 0 < km)
            {
                Console.WriteLine($"{taxiInitialPrice + (km * taxiDailyPrice):f2}");
            }
            else if (day == "night" && km < 20 && 0 < km)
            {
                Console.WriteLine($"{taxiInitialPrice + (km * taxiNightPrice):f2}");
            }
        }
    }
}
