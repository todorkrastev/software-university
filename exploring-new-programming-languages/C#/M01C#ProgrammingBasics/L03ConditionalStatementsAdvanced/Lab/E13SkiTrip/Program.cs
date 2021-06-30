using System;
using System.Runtime.Intrinsics.X86;

namespace SkiTrip
{
    class Program
    {
        static void Main(string[] args)
        {
            int daysAtHotel = int.Parse(Console.ReadLine());
            string typeOfRoom = Console.ReadLine();
            string review = Console.ReadLine();

            int nightsAtHotel = daysAtHotel - 1;

            double priceOfRoom = 0;
            double totalPrice = 0;
            double discount = 0;

            switch (typeOfRoom)
            {
                case "room for one person":
                    priceOfRoom = 18;
                    break;

                case "apartment":
                    priceOfRoom = 25;
                    if (daysAtHotel >= 0 && daysAtHotel < 10)
                        discount = 0.3;
                    else if (daysAtHotel >= 10 && daysAtHotel <= 15)
                        discount = 0.35;
                    else
                        discount = 0.5;
                    break;

                case "president apartment":
                    priceOfRoom = 35;
                    if (daysAtHotel >= 0 && daysAtHotel < 10)
                        discount = 0.10;
                    else if (daysAtHotel >= 10 && daysAtHotel <= 15)
                        discount = 0.15;
                    else
                        discount = 0.20;
                    break;      
            }
            totalPrice = nightsAtHotel * priceOfRoom - (nightsAtHotel * priceOfRoom * discount);
            if (review == "positive")
                totalPrice *= 1.25;
            else
                totalPrice *= 0.9;
            Console.WriteLine($"{totalPrice:f2}");
        }
    }
}
