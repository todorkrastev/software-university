using System;
using System.Dynamic;

namespace Fish_Tank
{
    class Program
    {
        static void Main(string[] args)
        {
            //Дължина в см – цяло число в интервала[10 … 500]
            int lengthInCm = int.Parse(Console.ReadLine());
            //Широчина в см – цяло число в интервала[10 … 300]
            int widthInCm = int.Parse(Console.ReadLine());
            //Височина в см – цяло число в интервала[10… 200]
            int heightInCm = int.Parse(Console.ReadLine());
            //Процент  – реално число в интервала[0.000 … 100.000]
            double perCent = double.Parse(Console.ReadLine());

            double volumeOfFishTank = lengthInCm * widthInCm * heightInCm;
            double totalAmountOfLitres = volumeOfFishTank * 0.001;
            double perCentCalculation = perCent * 0.01;
            double totalAmountOfLitresUsableArea = totalAmountOfLitres * (1 - perCentCalculation);
            Console.WriteLine(totalAmountOfLitresUsableArea);   
        }
    }
}
