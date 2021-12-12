using System;

namespace FruitShop
{
    class Program
    {
        static void Main(string[] args)
        {
            string inputFruit = Console.ReadLine();
            string inputDayOfWeek = Console.ReadLine();
            double inputQuantity = double.Parse(Console.ReadLine());

            if (inputDayOfWeek == "Monday" || inputDayOfWeek == "Tuesday" || inputDayOfWeek == "Wednesday" || inputDayOfWeek == "Thursday" || inputDayOfWeek == "Friday")
            {
                switch (inputFruit)
                {
                    case "banana":
                        double priceOfBanana = 2.5;
                        double resultOfBanana = priceOfBanana * inputQuantity;
                        Console.WriteLine($"{resultOfBanana:F2}");
                        break;

                    case "apple":
                        double priceOfApple = 1.2;
                        double resultOfApple = priceOfApple * inputQuantity;
                        Console.WriteLine($"{resultOfApple:F2}");
                        break;

                    case "orange":
                        double priceOfOrange = 0.85;
                        double resultOfOrange = priceOfOrange * inputQuantity;
                        Console.WriteLine($"{resultOfOrange:F2}");
                        break;

                    case "grapefruit":
                        double priceOfGrapefruit = 1.45;
                        double resultOfGrapefruit = priceOfGrapefruit * inputQuantity;
                        Console.WriteLine($"{resultOfGrapefruit:F2}");
                        break;

                    case "kiwi":
                        double priceOfKiwi = 2.70;
                        double resultOfKiwi = priceOfKiwi * inputQuantity;
                        Console.WriteLine($"{resultOfKiwi:F2}");
                        break;

                    case "pineapple":
                        double priceOfPineapple = 5.50;
                        double resultOfPineapple = priceOfPineapple * inputQuantity;
                        Console.WriteLine($"{resultOfPineapple:F2}");
                        break;

                    case "grapes":
                        double priceOfGrapes = 3.85;
                        double resultOfGrapes = priceOfGrapes * inputQuantity;
                        Console.WriteLine($"{resultOfGrapes:F2}");
                        break;

                    default:
                        Console.WriteLine("error");
                        break;
                }
            }
            else if (inputDayOfWeek == "Saturday" || inputDayOfWeek == "Sunday")
            {
                switch (inputFruit)
                {
                    case "banana":
                        double priceOfBanana = 2.70;
                        double resultOfBanana = priceOfBanana * inputQuantity;
                        Console.WriteLine($"{resultOfBanana:F2}");
                        break;

                    case "apple":
                        double priceOfApple = 1.25;
                        double resultOfApple = priceOfApple * inputQuantity;
                        Console.WriteLine($"{resultOfApple:f2}");
                        break;

                    case "orange":
                        double priceOfOrange = 0.90;
                        double resultOfOrange = priceOfOrange * inputQuantity;
                        Console.WriteLine($"{resultOfOrange:f2}");
                        break;

                    case "grapefruit":
                        double priceOfGrapefruit = 1.60;
                        double resultOfGrapefruit = priceOfGrapefruit * inputQuantity;
                        Console.WriteLine($"{resultOfGrapefruit:f2}");
                        break;

                    case "kiwi":
                        double priceOfKiwi = 3.00;
                        double resultOfKiwi = priceOfKiwi * inputQuantity;
                        Console.WriteLine($"{resultOfKiwi:f2}");
                        break;

                    case "pineapple":
                        double priceOfPineapple = 5.60;
                        double resultOfPineapple = priceOfPineapple * inputQuantity;
                        Console.WriteLine($"{resultOfPineapple:f2}");
                        break;

                    case "grapes":
                        double priceOfGrapes = 4.20;
                        double resultOfGrapes = priceOfGrapes * inputQuantity;
                        Console.WriteLine($"{resultOfGrapes:f2}");
                        break;

                    default:
                        Console.WriteLine("error");
                        break;

                }
            }
            else
            {
                Console.WriteLine("error");
            }    
        }
    }
}
