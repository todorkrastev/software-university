using System;

namespace _01.MiningRig
{
    class Program
    {
        static void Main(string[] args)
        {
            int videoCardPrice = int.Parse(Console.ReadLine());
            int jumperPrice = int.Parse(Console.ReadLine());
            double electricity = double.Parse(Console.ReadLine());
            double cardBenefit = double.Parse(Console.ReadLine());

            int videoCard = 13;
            int jumper = 13;
            int systemParts = 1000;

            int totalPrice = (videoCardPrice * videoCard) + (jumperPrice * jumper) + systemParts;
            double totalBenefitCards = (cardBenefit - electricity) * videoCard;
            double result = totalPrice / totalBenefitCards;

            Console.WriteLine(totalPrice);
            Console.WriteLine($"{Math.Ceiling(result)}");
        }
    }
}
