
namespace _06.Salary
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int openTabs = int.Parse(Console.ReadLine());
            double salary = double.Parse(Console.ReadLine());

            double facebook = 150;
            double instagram = 100;
            double reddit = 50;

            double fbFee = 0;
            double igFee = 0;
            double rFee = 0;

            for (int i = 0; i <= openTabs; i++)
            {
                string website = Console.ReadLine();

                if (website == "Facebook")
                {
                    fbFee += facebook;
                }
                if (website == "Instagram")
                {
                    igFee += instagram;
                }
                if (website == "Reddit")
                {
                    rFee += reddit;
                }
            }

            double result = salary - (fbFee + igFee + rFee);

            if (result <= 0)
            {
                Console.WriteLine("You have lost your salary.");
            }
            else
            {
                Console.WriteLine(result);
            }
        }
    }
}
