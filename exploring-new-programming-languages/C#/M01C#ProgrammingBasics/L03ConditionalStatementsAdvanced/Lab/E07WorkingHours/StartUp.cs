
namespace WorkingHours
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int hour = int.Parse(Console.ReadLine());
            string dayOfWeek = Console.ReadLine();

            if (hour >= 10 && hour <= 18 && dayOfWeek != "Sunday")

            switch (dayOfWeek)
            {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                case "Saturday":
                        Console.WriteLine("open");
                        break;
            }
            else
            {
                Console.WriteLine("closed");
            }
        }
    }
}
