
namespace _05.Coins
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double sum = double.Parse(Console.ReadLine());
            int coins = 0;

            while (sum > 0)
            {
                sum = Math.Round(sum, 2);

                if (sum >= 3)
                {
                    sum -= 2;
                    coins++;
                }
                else if (sum >= 2)
                {
                    sum -= 2;
                    coins++;
                }
                else if (sum >= 1)
                {
                    sum -= 1;
                    coins++;
                }
                else if (sum >= 0.50)
                {
                    sum -= 0.50;
                    coins++;
                }
                else if (sum >= 0.20)
                {
                    sum -= 0.20;
                    coins++;
                }
                else if (sum >= 0.10)
                {
                    sum -= 0.10;
                    coins++;
                }
                else if (sum >= 0.05)
                {
                    sum -= 0.05;
                    coins++;
                }
                else if (sum >= 0.02)
                {
                    sum -= 0.02;
                    coins++;
                }
                else if (sum >= 0.01)
                {
                    sum -= 0.01;
                    coins++;
                }
            }
            Console.WriteLine(coins);
        }
    }
}
