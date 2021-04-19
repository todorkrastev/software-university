using System;
using System.Security.Cryptography;

namespace SumSeconds
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int firstTime = int.Parse(Console.ReadLine());
            int secondTime = int.Parse(Console.ReadLine());
            int thirdTime = int.Parse(Console.ReadLine());

            int totalTime = firstTime + secondTime + thirdTime;

            int minutes = totalTime / 60;
            int seconds = totalTime % 60;

            if (seconds <= 9)
            {
                Console.WriteLine($"{minutes}:{seconds:d2}");
            }

            else
            {
                Console.WriteLine($"{minutes}:{seconds}");
            }
               
        }
    }
}