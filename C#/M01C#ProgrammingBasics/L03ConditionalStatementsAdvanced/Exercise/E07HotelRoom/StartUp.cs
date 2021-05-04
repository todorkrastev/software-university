
namespace HotelRoom
{
using System;

    class StartUp
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine();
            int numOfNights = int.Parse(Console.ReadLine());

            
            double pricePerNightStudio = 0;
            double pricePerNightApartment = 0;
            double discountStudio = 0;
            double discountApartment = 0;
            string accomodation = "";          

            if (month == "May" || month == "October")
            {
                pricePerNightStudio = 50;
                pricePerNightApartment = 65;
                if (numOfNights > 7 && numOfNights <= 14)
                {
                    discountStudio = 0.95;
                    pricePerNightStudio *= discountStudio;
                }
                else if(numOfNights > 14)
                {
                    discountStudio = 0.7;
                    pricePerNightStudio *= discountStudio;
                }
            }
            else if(month == "June" || month == "September")
            {
                pricePerNightStudio = 75.20;
                pricePerNightApartment = 68.7;
                if(numOfNights > 14)
                {
                    discountStudio = 0.8;
                    pricePerNightStudio *= discountStudio;
                }
            }
            else
            {
                pricePerNightStudio = 76;
                pricePerNightApartment = 77;
            }

            if(numOfNights > 14)
            {
                discountApartment = 0.9;
                pricePerNightApartment *= discountApartment;
            }

            double totalPriceStudio = pricePerNightStudio * numOfNights;
            double totalPriceApartment = pricePerNightApartment  * numOfNights;

            Console.WriteLine($"Apartment: {totalPriceApartment:f2} lv.");
            Console.WriteLine($"Studio: {totalPriceStudio:f2} lv.");
        }
    }
}
