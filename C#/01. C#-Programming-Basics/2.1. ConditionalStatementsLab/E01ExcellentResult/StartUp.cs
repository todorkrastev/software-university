
namespace ExcellentResult
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {

            double insertGrade = double.Parse(Console.ReadLine());
            if (insertGrade >= 5.50)
            {
                Console.WriteLine("Excellent!");
            }
        }
    }
}
