
namespace _04.TrainTheTrainers
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int numOfJury = int.Parse(Console.ReadLine());
            string command = Console.ReadLine();
            double sumOfGrades = 0.0;
            int countOfGrades = 0;
            double finalAssesment = 0.0;
            int sumOfCountOfGrades = 0;

            while (command != "Finish")
            {

                for (int i = 1; i <= numOfJury; i++)
                {
                    double numOfGrades = double.Parse(Console.ReadLine());
                    sumOfGrades += numOfGrades;
                    countOfGrades++;

                }
                Console.WriteLine($"{command} - {(sumOfGrades / countOfGrades):f2}.");
                sumOfCountOfGrades += countOfGrades;
                finalAssesment += sumOfGrades;
                command = Console.ReadLine();
                countOfGrades = 0;
                sumOfGrades = 0.0;
            }
            Console.WriteLine($"Student's final assessment is {(finalAssesment / sumOfCountOfGrades):f2}.");
        }
    }
}
