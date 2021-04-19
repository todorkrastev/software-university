
namespace OnTimeForTheExam
{
using System;
    using System.Runtime.InteropServices;

    class StartUp
    {
        static void Main(string[] args)
        {
            int hourOfExam = int.Parse(Console.ReadLine());
            int minuteOfExam = int.Parse(Console.ReadLine());
            int arrivingHour = int.Parse(Console.ReadLine());
            int arrivingMinute = int.Parse(Console.ReadLine());

            int hoursOfExamInMinutes = 60 * hourOfExam;
            int arrivingHourInMinutes = 60 * arrivingHour;

            int arrivingOnTime = (hoursOfExamInMinutes - arrivingHourInMinutes) + (minuteOfExam - arrivingMinute);
            int hours = arrivingOnTime / 60;
            int minutes = arrivingOnTime % 60;

            if (arrivingOnTime >= 0)
            {
                if (arrivingOnTime <= 30 && arrivingOnTime != 0)
                {
                    Console.WriteLine("On time");
                    Console.WriteLine($"{arrivingOnTime} minutes before the start");
                }
                else if (arrivingOnTime >= 60)
                {
                    Console.WriteLine("Early");
                    Console.WriteLine($"{hours}:{minutes:d2} hours before the start");
                }
                else if (arrivingOnTime == 0)
                {
                    Console.WriteLine("On time");
                }
                else
                {
                    Console.WriteLine("Early");
                    Console.WriteLine($"{arrivingOnTime} minutes before the start");
                }
                
            }
            else
            {
                if(arrivingOnTime <= -60)
                {
                    Console.WriteLine("Late");
                    Console.WriteLine($"{(hours*-1)}:{(minutes*-1):d2} hours after the start");
                }
                else
                {
                    Console.WriteLine("Late");
                    Console.WriteLine($"{(arrivingOnTime*-1)} minutes after the start");
                }
            }
        }
    }
}
