
namespace _02.Password
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            string password = Console.ReadLine();
            string checkPassword = Console.ReadLine();


            while (checkPassword != password)
            {
                checkPassword = Console.ReadLine();
            }
            Console.WriteLine($"Welcome {name}!");
        }
    }
}
