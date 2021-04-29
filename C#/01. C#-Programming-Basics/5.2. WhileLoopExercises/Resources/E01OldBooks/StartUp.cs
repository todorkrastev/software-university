
namespace _01.OldBooks
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string requiredBook = Console.ReadLine();
            int count = 0;

            while (requiredBook != "No More Books")
            {
                string inputBook = Console.ReadLine();
                if (inputBook == "No More Books")
                {
                    Console.WriteLine("The book you search is not here!");
                    Console.WriteLine($"You checked {count} books.");
                    break;
                }
                else if (inputBook == requiredBook)
                {
                    Console.WriteLine($"You checked {count} books and found it.");
                    break;
                }
                count++;
            }
        }
    }
}
