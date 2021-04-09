using System;

namespace Time_15Minutes
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int hour = int.Parse(Console.ReadLine());
            int minute = int.Parse(Console.ReadLine());

            hour *= 60;
            int additionalTime = 15;
            int totalTime = minute + hour + additionalTime;
            int finalHour = totalTime / 60;
            int finalMinutes = totalTime % 60;

            if (finalHour >= 24)
            {
                finalHour = 0;
                Console.WriteLine($"{finalHour}:{finalMinutes:d2}");
            }
            else
                Console.WriteLine($"{finalHour}:{finalMinutes:d2}");
        }
    }
}
