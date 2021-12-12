
namespace WeekendOrWorkingDay
{
        using System;
    class StartUp
    {
        static void Main(string[] args)
    {
        string inputDay = Console.ReadLine();

        switch (inputDay)
        {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    Console.WriteLine("Working day");
                    break;

                case "Saturday":
                case "Sunday":
                    Console.WriteLine("Weekend");
                    break;

                default:
                    Console.WriteLine("Error");
                    break;
            }
    }
}
}
