using System;

namespace _08.GraduationPt._2
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            int grade = 0;
            double averageGrade = 0.0;
            int isExcluded = 0;

            while (true)
            {
                double gradePerYear = double.Parse(Console.ReadLine());
                averageGrade += gradePerYear;
                grade++;
                if (gradePerYear < 4)
                {
                    isExcluded++;
                    if (1 < isExcluded)
                    {
                        Console.WriteLine($"{name} has been excluded at {grade - 1} grade");
                        break;
                    }
                }
                if (12 <= grade)
                {
                    double finalAverageGrade = averageGrade / grade;
                    Console.WriteLine($"{name} graduated. Average grade: {finalAverageGrade:f2}");
                    break;
                }
            }
        }
    }
}
