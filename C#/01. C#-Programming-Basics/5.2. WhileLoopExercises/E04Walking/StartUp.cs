using System;
using System.Reflection.Metadata.Ecma335;

namespace _04.Walking
{
    class StartUp
    {
        static void Main(string[] args)
        {

            int countOfSteps = 0;
            int sumOfSteps = 0;
            string goingHome = "";
            int target = 10000;

            while (true)
            {
                string input = Console.ReadLine();
                if (input == "Going home")
                {
                    input = Console.ReadLine();
                    countOfSteps = int.Parse(input);
                    sumOfSteps += countOfSteps;
                    if (10000 <= sumOfSteps)
                    {
                        Console.WriteLine($"Goal reached! Good job!");
                        Console.WriteLine($"{sumOfSteps - target} steps over the goal!");
                        break;
                    }
                    else
                    {
                        Console.WriteLine($"{target - sumOfSteps} more steps to reach goal.");
                        break;
                    }
                }
                countOfSteps = int.Parse(input);
                sumOfSteps += countOfSteps;

                if (10000 <= sumOfSteps)
                {
                    Console.WriteLine($"Goal reached! Good job!");
                    Console.WriteLine($"{sumOfSteps - target} steps over the goal!");
                    break;
                } 
            }
        }
    }
}
