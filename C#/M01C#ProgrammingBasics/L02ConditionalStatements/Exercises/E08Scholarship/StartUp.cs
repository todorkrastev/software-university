
namespace Scholarship
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double incomeInBGN = double.Parse(Console.ReadLine());
            double averageGrades = double.Parse(Console.ReadLine());
            double minimumWage = double.Parse(Console.ReadLine());

            double socialScholarship = 0;
            double scholarshipForExcellentGrades = 0;
            socialScholarship = Math.Floor(minimumWage * 0.35);
            scholarshipForExcellentGrades = Math.Floor(averageGrades * 25);

            if (minimumWage >= incomeInBGN && averageGrades >= 5.5 && scholarshipForExcellentGrades >= socialScholarship)
            {
                Console.WriteLine($"You get a scholarship for excellent results {scholarshipForExcellentGrades} BGN");
            }
            else if (minimumWage >= incomeInBGN && averageGrades >= 5.5 && socialScholarship > scholarshipForExcellentGrades)
            {
                Console.WriteLine($"You get a Social scholarship {socialScholarship} BGN");
            }
            else if (incomeInBGN > minimumWage && averageGrades >= 5.5)
                Console.WriteLine($"You get a scholarship for excellent results {scholarshipForExcellentGrades} BGN");
            else if (minimumWage >= incomeInBGN && averageGrades > 4.5)
                Console.WriteLine($"You get a Social scholarship {socialScholarship} BGN");
            else
            {
                Console.WriteLine($"You cannot get a scholarship!");
            }
        }
    }
}

