
namespace CleverLily
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int ageL = int.Parse(Console.ReadLine());
            double priceWM = double.Parse(Console.ReadLine());
            double priceToys = double.Parse(Console.ReadLine());
            double savings = 0;
            double giftMny = 10;
            int toys = 0;

            for (int i = 1; i <= ageL; i++)
            {
                if (i % 2 == 0)
                {
                    savings += giftMny - 1;
                    giftMny += 10;
                }
                else
                {
                    toys += 1;
                }
            }
            double totalMny = savings + (toys * priceToys);
            double lackExtraMny = totalMny - priceWM;

            if (totalMny >= priceWM)
            {
                Console.WriteLine($"Yes! {lackExtraMny:f2}");
            }
            else
            {
                Console.WriteLine($"No! {Math.Abs(lackExtraMny):f2}");
            }
        }
    }
}
