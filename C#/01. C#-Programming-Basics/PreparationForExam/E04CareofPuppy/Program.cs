using System;

namespace _05.CareofPuppy
{
    class Program
    {
        static void Main(string[] args)
        {
            int food = int.Parse(Console.ReadLine());
            food *= 1000;
            string command = Console.ReadLine();
            int sum = 0;

            while (command != "Adopted")
            {
                int foodPerMeal = int.Parse(command);
                sum += foodPerMeal;
                command = Console.ReadLine();
            }
            if (sum <= food)
            {
                Console.WriteLine($"Food is enough! Leftovers: {Math.Abs(food - sum)} grams.");
            }
            else if (food < sum)
            {
                Console.WriteLine($"Food is not enough. You need {Math.Abs(food - sum)} grams more.");
            }
        }
    }
}
