using System;

namespace _07.FlowerShop
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int magnolia = int.Parse(Console.ReadLine());
            int hyiacinth = int.Parse(Console.ReadLine());
            int rose = int.Parse(Console.ReadLine());
            int cactus = int.Parse(Console.ReadLine());
            int giftPrice = int.Parse(Console.ReadLine());

            double magnoliaPrice = 3.25;
            double hyiacinthPrice = 4.00;
            double rosePrice = 3.50;
            double cactusPrice = 8;

            double income = (magnolia * magnoliaPrice + hyiacinth * hyiacinthPrice + rose * rosePrice + cactus * cactusPrice) * 0.95;

            double diff = Math.Abs(income - giftPrice);

            if (giftPrice <= income)
            {
                Console.WriteLine($"She is left with {Math.Floor(diff)} leva.");
            }
            else
            {
                Console.WriteLine($"She will have to borrow {Math.Ceiling(diff)} leva.");
            }
        }
    }
}
