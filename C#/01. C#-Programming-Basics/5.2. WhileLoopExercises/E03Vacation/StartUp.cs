using System;

namespace _03.Vacation
{
    class StartUp
    {
        static void Main(string[] args)
        {
            double moneyNeeded = double.Parse(Console.ReadLine());
            double currentMoney = double.Parse(Console.ReadLine());

            int daysCounter = 0;
            int spendCounter = 0;

            while (currentMoney < moneyNeeded)
            {
                string input = Console.ReadLine();
                double moneySavedSpend = double.Parse(Console.ReadLine());

                if (input == "spend")
                {
                    currentMoney = Math.Max((currentMoney - moneySavedSpend), 0.00);
                    spendCounter++;
                    daysCounter++;
                }

                else
                {
                    currentMoney += moneySavedSpend;
                    spendCounter = 0;
                    daysCounter++;
                }
                if (spendCounter == 5)
                {
                    Console.WriteLine("You can't save the money.");
                    Console.WriteLine(daysCounter);
                    return;
                }
            }
            Console.WriteLine($"You saved the money for {daysCounter} days.");
        }
    }
}
