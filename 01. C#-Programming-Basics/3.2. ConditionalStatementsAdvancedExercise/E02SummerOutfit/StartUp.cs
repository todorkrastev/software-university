
namespace SummerOutfit
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int inputDegreesInCelsius = int.Parse(Console.ReadLine());
            string inputTimeOfDay = Console.ReadLine();
            string outfit = "";
            string shoes = "";

            if (inputDegreesInCelsius >= 10 && inputDegreesInCelsius <= 18)
            {
                switch (inputTimeOfDay)
                {
                    case "Morning":
                        outfit = "Sweatshirt";
                        shoes = "Sneakers";
                        break;

                    case "Afternoon":
                        outfit = "Shirt";
                        shoes = "Moccasins";
                        break;

                    case "Evening":
                        outfit = "Shirt";
                        shoes = "Moccasins";
                        break;
                }
            }
            else if (inputDegreesInCelsius > 18 && inputDegreesInCelsius <= 24)
            {
                switch (inputTimeOfDay)
                {
                    case "Morning":
                        outfit = "Shirt";
                        shoes = "Moccasins";
                        break;

                    case "Afternoon":
                        outfit = "T-Shirt";
                        shoes = "Sandals";
                        break;

                    case "Evening":
                        outfit = "Shirt";
                        shoes = "Moccasins";
                        break;
                }
            }
            else
            {
                switch (inputTimeOfDay)
                {
                    case "Morning":
                        outfit = "T-Shirt";
                        shoes = "Sandals";
                        break;

                    case "Afternoon":
                        outfit = "Swim Suit";
                        shoes = "Barefoot";
                        break;

                    case "Evening":
                        outfit = "Shirt";
                        shoes = "Moccasins";
                        break;
                }
            }
            Console.WriteLine($"It's {inputDegreesInCelsius} degrees, get your {outfit} and {shoes}.");
        }
    }
}
