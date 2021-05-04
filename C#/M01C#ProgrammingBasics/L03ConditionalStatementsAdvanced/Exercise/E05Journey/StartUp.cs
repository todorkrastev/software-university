
namespace Journey
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string inputSeason = Console.ReadLine().ToLower();
            string destination = "";
            string accomodation = "";

            if(budget <= 100)
            {
                destination = "Bulgaria";
                
                switch(inputSeason)
                {
                    case "summer":
                        budget *= 0.3;
                        accomodation = "Camp";
                        break;

                    case "winter":
                        budget *= 0.7;
                        accomodation = "Hotel";
                        break;
                }
            }
            else if(budget <= 1000)
            {
                destination = "Balkans";

                switch(inputSeason)
                {
                    case "summer":
                        budget *= 0.4;
                        accomodation = "Camp";
                        break;

                    case "winter":
                        budget *= 0.8;
                        accomodation = "Hotel";
                        break;
                }
            }
            else
            {
                destination = "Europe";
                accomodation = "Hotel";
                budget *= 0.9;
            }

            Console.WriteLine($"Somewhere in {destination}");
            Console.WriteLine($"{accomodation} - {budget:f2}");
        }
    }
}
