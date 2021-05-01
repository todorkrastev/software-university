using System;

namespace _05.ChristmasGifts
{
    class Program
    {
        static void Main(string[] args)
        {
            string command = Console.ReadLine();

            int countKids = 0;
            int countAdults = 0;

            double toyPrice = 5.00;
            double sweaterPrice = 15.00;

            while (command != "Christmas")
            {
                int age = int.Parse(command);

                if (age <= 16 && 1 <= age)
                {
                    countKids++;
                }
                else if (age <= 130 && 17 <= age)
                {
                    countAdults++;
                }

                command = Console.ReadLine();
            }
            double totalPriceToys = countKids * toyPrice;
            double totalPriceSweaters = countAdults * sweaterPrice;

            Console.WriteLine($"Number of adults: {countAdults}");
            Console.WriteLine($"Number of kids: {countKids}");
            Console.WriteLine($"Money for toys: {totalPriceToys}");
            Console.WriteLine($"Money for sweaters: {totalPriceSweaters}");
        }
    }
}
