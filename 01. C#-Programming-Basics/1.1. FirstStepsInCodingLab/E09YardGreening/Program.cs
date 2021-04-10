using System;

namespace YardGreening
{
    class Program
    {
        static void Main(string[] args)
        {
            double square = double.Parse(Console.ReadLine());
            double expences = square * 7.61;
            double discount = 0.18 * expences;
            double total = expences - discount;
            Console.WriteLine($"The final price is: {total:f2} lv.");
            Console.WriteLine($"The discount is: {discount:f2} lv.");
        }
    }
}