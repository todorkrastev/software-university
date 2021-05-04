using System;

namespace PetShop
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberofDogs = int.Parse(Console.ReadLine());
            int numberofAnimals = int.Parse(Console.ReadLine());
            double Dogfoodprice = 2.5;
            double Animalfoodprice = 4;
            double Totalprice = (numberofDogs * Dogfoodprice) + (numberofAnimals * Animalfoodprice);
            Console.WriteLine($"{Totalprice} lv.");

        }
    }
}
