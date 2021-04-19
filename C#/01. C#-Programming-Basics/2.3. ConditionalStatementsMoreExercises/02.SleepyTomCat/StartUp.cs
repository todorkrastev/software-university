using System;

namespace _02.SleepyTomCat
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int freeDays = int.Parse(Console.ReadLine());

            int workdays = 365 - freeDays;
            int hoursOfPlay = workdays * 63 + freeDays * 127;
            int result = Math.Abs(30000 - hoursOfPlay);
            double hours = result / 60;
            double minutes = result % 60;

            if (30000 <= hoursOfPlay)
            {
                Console.WriteLine("Tom will run away");
                Console.WriteLine($"{hours} hours and {minutes} minutes more for play");
            }
            else
            {
                Console.WriteLine("Tom sleeps well");
                Console.WriteLine($"{hours} hours and {minutes} minutes less for play") ;
            }
        }
    }
}
