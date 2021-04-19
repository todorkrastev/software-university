using System;

namespace GodzillaVSKong
{
    class StartUp
    {
        static void Main(string[] args)
        {
            double Budget = double.Parse(Console.ReadLine());
            int numOfWalkon = int.Parse(Console.ReadLine());
            double priceOfUniformPerWalkon = double.Parse(Console.ReadLine());

            double sceneryOfMovie = Budget * 0.10;

            double moneyNeededforUniform = numOfWalkon * priceOfUniformPerWalkon;


            if (numOfWalkon > 150)

            {
                double discountPriceOfUniformPerWalkon = moneyNeededforUniform * 0.1;
                moneyNeededforUniform -= discountPriceOfUniformPerWalkon;
            }
            double sumOfSceneryAndUniform = sceneryOfMovie + moneyNeededforUniform;

            if (sumOfSceneryAndUniform > Budget)
            {
                double lackOfMoney = sumOfSceneryAndUniform - Budget;
                Console.WriteLine("Not enough money!");
                Console.WriteLine($"Wingard needs {lackOfMoney:f2} leva more.");
            }
            else
            {
                double sumOfSceneryAndUniformPlanB = sceneryOfMovie + moneyNeededforUniform;
                double surplus = Budget - sumOfSceneryAndUniformPlanB;
                Console.WriteLine("Action!");
                Console.WriteLine($"Wingard starts filming with {surplus:f2} leva left.");
            }

        }
    }
}
