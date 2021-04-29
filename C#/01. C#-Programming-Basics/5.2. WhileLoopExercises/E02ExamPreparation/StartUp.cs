using System;

namespace _02.ExamPreparation
{
    class StartUp
    {
        static void Main(string[] args)
         {
            int poorGrades = int.Parse(Console.ReadLine());
            string command = "";
            int countPoorGrades = 0;
            int countInputTasks = 0;
            double countGrades = 0;
            string lastTask = "";

            while (command != "Enough")
            {
                command = Console.ReadLine();
                if (command == "Enough")
                {
                    double averageGrade = countGrades / countInputTasks;
                    Console.WriteLine($"Average score: {averageGrade:f2}");
                    Console.WriteLine($"Number of problems: {countInputTasks}");
                    Console.WriteLine($"Last problem: {lastTask}");
                    break;
                }
                int grade = int.Parse(Console.ReadLine());
                lastTask = command;
                countInputTasks++;
                countGrades += grade;

                if (grade <= 4)
                {
                    countPoorGrades++;
                }
                if (poorGrades <= countPoorGrades)
                {
                    Console.WriteLine($"You need a break, {poorGrades} poor grades.");
                    break;
                }
            }
        }
    }
}
