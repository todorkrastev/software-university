
namespace NewHouse
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string typeOfFlowers = Console.ReadLine();
            int quantityOfFlowers = int.Parse(Console.ReadLine());
            int budget = int.Parse(Console.ReadLine());
            double priceOfFlowers = 0;
            double discount = 1;

            switch(typeOfFlowers)
            {
                case "Roses":
                    priceOfFlowers = 5;
                    if(quantityOfFlowers > 80)
                    {
                        discount = 0.9;
                    }
                    break;


                case "Dahlias":
                    priceOfFlowers = 3.80;
                    if(quantityOfFlowers > 90)
                    {
                        discount = 0.85;
                    }
                    break;

                case "Tulips":
                    priceOfFlowers = 2.80;
                    if (quantityOfFlowers > 80)
                    {
                        discount = 0.85;
                    }
                    break;

                case "Narcissus":
                    priceOfFlowers = 3;
                    if(quantityOfFlowers < 120)
                    {
                        discount = 1.15;
                    }
                    break;

                case "Gladiolus":
                    priceOfFlowers = 2.50;
                    if(quantityOfFlowers < 80)
                    {
                        discount = 1.20;
                    }
                    break;
            }
            double totalPrice = quantityOfFlowers * priceOfFlowers * discount;


            if(budget >= totalPrice)
            {
                double surplusMoney = budget - totalPrice;
                Console.WriteLine($"Hey, you have a great garden with {quantityOfFlowers} {typeOfFlowers} and {surplusMoney:f2} leva left.");
            }
            else
            {
                double lackOfMoney = totalPrice - budget;
                Console.WriteLine($"Not enough money, you need {lackOfMoney:f2} leva more.");
            }
        }
    }
}
