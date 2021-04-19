
namespace FruitOrVegetable
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string typeOfProduct = Console.ReadLine();

                switch (typeOfProduct)
                {
                    case "banana":
                    case "apple":
                    case "kiwi":
                    case "cherry":
                    case "lemon":
                    case "grapes":
                        Console.WriteLine("fruit");
                        break;
                
                    case "tomato":
                    case "cucumber":
                    case "pepper":
                    case "carrot":
                        Console.WriteLine("vegetable");
                        break;

                default:
                    Console.WriteLine("unknown");
                    break;
            }
        }
    }
}
