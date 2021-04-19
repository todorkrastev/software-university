
namespace SmallShop
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string typeOfProduct = Console.ReadLine();
            string inputCity = Console.ReadLine();
            double quantity = double.Parse(Console.ReadLine());
            double priceOfProduct = 0;

            if (typeOfProduct == "coffee")
            {
                if (inputCity == "Sofia")
                {
                    priceOfProduct = 0.5;
                }
                else if (inputCity == "Plovdiv")
                {
                    priceOfProduct = 0.4;
                }
                else if (inputCity == "Varna")
                {
                    priceOfProduct = 0.45;
                }
                Console.WriteLine(priceOfProduct * quantity);
            }
            else if (typeOfProduct == "water")
            {
                if (inputCity == "Sofia")
                {
                    priceOfProduct = 0.8;
                }
                else if (inputCity == "Plovdiv")
                {
                    priceOfProduct = 0.7;
                }
                else if (inputCity == "Varna")
                {
                    priceOfProduct = 0.7;
                }
                Console.WriteLine(priceOfProduct * quantity);
            }
            else if (typeOfProduct == "beer")
            {
                if (inputCity == "Sofia")
                {
                    priceOfProduct = 1.20;
                }
                else if (inputCity == "Plovdiv")
                {
                    priceOfProduct = 1.15;
                }
                else if (inputCity == "Varna")
                {
                    priceOfProduct = 1.10;
                }
                Console.WriteLine(priceOfProduct * quantity);
            }
            else if (typeOfProduct == "sweets")
            {
                if (inputCity == "Sofia")
                {
                    priceOfProduct = 1.45;
                }   
                else if (inputCity == "Plovdiv")
                {
                    priceOfProduct = 1.30;
                }
                else if (inputCity == "Varna")
                {
                    priceOfProduct = 1.35;
                }
                Console.WriteLine(priceOfProduct * quantity);
            }
            else if (typeOfProduct == "peanuts")
            {
                if(inputCity == "Sofia")
                {
                    priceOfProduct = 1.60;
                }    
                else if (inputCity == "Plovdiv")
                {
                    priceOfProduct = 1.50;
                }
                else if (inputCity == "Varna")
                {
                    priceOfProduct = 1.55;
                }
                Console.WriteLine(priceOfProduct * quantity);
            }
        }
    }
}
