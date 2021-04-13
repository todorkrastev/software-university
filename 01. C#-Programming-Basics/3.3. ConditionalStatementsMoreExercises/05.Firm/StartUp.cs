using System;

namespace _05.Firm
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int hoursNeeded = int.Parse(Console.ReadLine());
            int day = int.Parse(Console.ReadLine());
            int numEmployees = int.Parse(Console.ReadLine());

            double trainingEmployees = (day * 0.9) * 8;
            int overtime = numEmployees * (2 * day);
            double workingOnProject = Math.Floor(trainingEmployees + overtime);
            double diff = Math.Abs(workingOnProject - hoursNeeded);

            if (hoursNeeded <= workingOnProject)
            {
                Console.WriteLine($"Yes!{diff} hours left.");
            }
            else
            {
                Console.WriteLine($"Not enough time!{diff} hours needed.");
            }
        }
    }
}
