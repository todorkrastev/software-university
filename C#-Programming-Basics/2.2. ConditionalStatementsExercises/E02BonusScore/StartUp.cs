using System;

namespace BonusScore
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int Score = int.Parse(Console.ReadLine());
            double bonus = 0.0;

            if (Score <= 100)
            {
                bonus = 5;
            }
            else if (Score > 1000)
            {
                bonus = Score * 0.10;
            }
            else
            {
                bonus = Score * 0.2;
            }
            if (Score % 2 == 0)
            {
                bonus += 1;
            }
            else if (Score % 10 == 5)
            {
                bonus += 2;
            }
            Console.WriteLine(bonus);
            Console.WriteLine(Score + bonus);
        }
    }
}
