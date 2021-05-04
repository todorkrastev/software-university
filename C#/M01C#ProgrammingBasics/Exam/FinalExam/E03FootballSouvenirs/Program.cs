using System;

namespace _03.FootballSouvenirs
{
    class Program
    {
        static void Main(string[] args)
        {
            string team = Console.ReadLine();
            string souvenir = Console.ReadLine();
            int numPurchasedSouvenirs = int.Parse(Console.ReadLine());

            double priceSouvenirs = 0.00;

            if (team == "Argentina")
            {
                switch (souvenir)
                {
                    case "flags":
                        priceSouvenirs = 3.25;
                        break;
                    case "caps":
                        priceSouvenirs = 7.20;
                        break;
                    case "posters":
                        priceSouvenirs = 5.10;
                        break;
                    case "stickers":
                        priceSouvenirs = 1.25;
                        break;
                    default:
                        Console.WriteLine("Invalid stock!");
                        return;
                }
                Console.WriteLine($"Pepi bought {numPurchasedSouvenirs} {souvenir} of {team} for {(priceSouvenirs * numPurchasedSouvenirs):f2} lv.");
            }

            else if (team == "Brazil")
            {
                switch (souvenir)
                {
                    case "flags":
                        priceSouvenirs = 4.20;
                        break;
                    case "caps":
                        priceSouvenirs = 8.50;
                        break;
                    case "posters":
                        priceSouvenirs = 5.35;
                        break;
                    case "stickers":
                        priceSouvenirs = 1.20;
                        break;
                    default:
                        Console.WriteLine("Invalid stock!");
                        return;
                }
                Console.WriteLine($"Pepi bought {numPurchasedSouvenirs} {souvenir} of {team} for {(priceSouvenirs * numPurchasedSouvenirs):f2} lv.");
            }
            else if (team == "Croatia")
            {
                switch (souvenir)
                {
                    case "flags":
                        priceSouvenirs = 2.75;
                        break;
                    case "caps":
                        priceSouvenirs = 6.90;
                        break;
                    case "posters":
                        priceSouvenirs = 4.95;
                        break;
                    case "stickers":
                        priceSouvenirs = 1.10;
                        break;
                    default:
                        Console.WriteLine("Invalid stock!");
                        return;
                }
                Console.WriteLine($"Pepi bought {numPurchasedSouvenirs} {souvenir} of {team} for {(priceSouvenirs * numPurchasedSouvenirs):f2} lv.");
            }
            else if (team == "Denmark")
            {
                switch (souvenir)
                {
                    case "flags":
                        priceSouvenirs = 3.10;
                        break;
                    case "caps":
                        priceSouvenirs = 6.50;
                        break;
                    case "posters":
                        priceSouvenirs = 4.80;
                        break;
                    case "stickers":
                        priceSouvenirs = 0.90;
                        break;
                    default:
                        Console.WriteLine("Invalid stock!");
                        return;
                }
                Console.WriteLine($"Pepi bought {numPurchasedSouvenirs} {souvenir} of {team} for {(priceSouvenirs * numPurchasedSouvenirs):f2} lv.");
            }
            else
            {
                Console.WriteLine("Invalid country!");
                return;
            }
        }
    }
}
