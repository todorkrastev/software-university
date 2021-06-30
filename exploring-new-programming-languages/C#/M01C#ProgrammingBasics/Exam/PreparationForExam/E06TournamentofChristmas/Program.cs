using System;

namespace _06.TournamentofChristmas
{
    class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            string command = "";
            int winCount = 0;
            int lostCount = 0;
            double sum = 0.00;
            double totalSum = 0.00;
            int totalWin = 0;
            int totalLose = 0;

            for (int i = 1; i <= days; i++)
            {
                command = Console.ReadLine();
                while (command != "Finish")
                {
                    string result = Console.ReadLine();
                    if (result == "win")
                    {
                        sum += 20;
                        winCount++;
                    }
                    else if (result == "lose")
                    {
                        lostCount++;
                    }
                    command = Console.ReadLine();
                }

                if (lostCount < winCount)
                {
                    sum *= 1.10;
                }
                totalWin += winCount;
                totalLose += lostCount;
                totalSum += sum;
                winCount = 0;
                lostCount = 0;
                sum = 0;
            }
            //At the end of the championship, if the wins are more than losts -> increase the money with 20 %;
            if (totalLose < totalWin)
            {
                totalSum *= 1.20;
                Console.WriteLine($"You won the tournament! Total raised money: {totalSum:f2}");
            }
            else if (totalLose > totalWin)
            {
                Console.WriteLine($"You lost the tournament! Total raised money: {totalSum:f2}");
            }
        }
    }
}
