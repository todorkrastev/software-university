
namespace WorldSwimmingRecords
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double recordInSeconds = double.Parse(Console.ReadLine());
            double distanceInMeters = double.Parse(Console.ReadLine());
            double timeInSecondsPerMeter = double.Parse(Console.ReadLine());

            double resistanceOfWaterInEvery15MetersInSeconds = 12.5;
            double slowdownOfResistanceInMeters = 15;

            double timeNeededToSwimTheRequiredDistance = distanceInMeters * timeInSecondsPerMeter;
            double timeIncludingTheResistance = Math.Floor(distanceInMeters / slowdownOfResistanceInMeters) * resistanceOfWaterInEvery15MetersInSeconds;
            double finalTime = timeNeededToSwimTheRequiredDistance + timeIncludingTheResistance;

            if (recordInSeconds > finalTime)
            {
                Console.WriteLine($"Yes, he succeeded! The new world record is {finalTime:f2} seconds.");
            }
            else
            {
                double lackOfSeconds = finalTime - recordInSeconds;
                Console.WriteLine($"No, he failed! He was {lackOfSeconds:f2} seconds slower.");
            }
               
        }
    }
}
