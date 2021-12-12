
namespace Cinema
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string typeOfFilmShow = Console.ReadLine();
            int numberOfRows = int.Parse(Console.ReadLine());
            int numberOfLines = int.Parse(Console.ReadLine());

            double priceOfTicket = 0;

            switch(typeOfFilmShow)
            {
                case "Premiere":
                    priceOfTicket = 12;
                    break;

                case "Normal":
                    priceOfTicket = 7.5;
                    break;

                case "Discount":
                    priceOfTicket = 5;
                    break;
            }
            double totalIncome = (numberOfLines * numberOfRows) * priceOfTicket;
            Console.WriteLine($"{totalIncome:f2}");
        }
    }
}
