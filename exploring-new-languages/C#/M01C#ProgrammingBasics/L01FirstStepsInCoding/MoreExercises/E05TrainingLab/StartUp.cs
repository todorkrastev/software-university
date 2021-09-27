using System;

namespace _05.TrainingLab
{
    class StartUp
    {
        static void Main(string[] args)
        {
            double width = double.Parse(Console.ReadLine());
            double height = double.Parse(Console.ReadLine());
            width = 100 * width;
            height = 100 * height - 100;


            int countWidth = 0;
            int countHeight = 0;

            while (120 <= width)
            {
                width -= 120;
                countWidth++;
            }
            while (70 <= height)
            {
                height -= 70;
                countHeight++;
            }

            int result = countHeight * countWidth - 3;
            Console.WriteLine(result);
        }
    }
}
