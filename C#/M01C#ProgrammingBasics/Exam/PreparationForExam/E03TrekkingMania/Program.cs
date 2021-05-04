using System;

namespace _04.TrekkingMania
{
    class Program
    {
        static void Main(string[] args)
        {
            int groupsNum = int.Parse(Console.ReadLine());

            int musalaCount = 0;
            int montblanCount = 0;
            int kiliCount = 0;
            int k2Count = 0;
            int everestCount = 0;


            for (int i = 1; i <= groupsNum; i++)
            {
                int peopleNum = int.Parse(Console.ReadLine());

                if (peopleNum <= 5 && peopleNum >= 1)
                {
                    musalaCount += peopleNum;
                }
                else if (peopleNum <= 12 && peopleNum >= 6)
                {
                    montblanCount += peopleNum;
                }
                else if (peopleNum <= 25 && peopleNum >= 13)
                {
                    kiliCount += peopleNum;
                }
                else if (peopleNum <= 40 && peopleNum >= 26)
                {
                    k2Count += peopleNum;
                }
                else if (peopleNum <= 1000 && peopleNum >= 41)
                {
                    everestCount += peopleNum;
                }
            }
            int totalPeople = musalaCount + montblanCount + everestCount + k2Count + kiliCount;
            double musalaPercentage = musalaCount * 1.0 / totalPeople * 100;
            double montblanPercentage = montblanCount * 1.0 / totalPeople * 100;
            double kiliPercentage = kiliCount * 1.0 / totalPeople * 100;
            double k2Percentage = k2Count * 1.0 / totalPeople * 100;
            double everestPercentage = everestCount * 1.0 / totalPeople * 100;

            Console.WriteLine($"{musalaPercentage:f2}%");
            Console.WriteLine($"{montblanPercentage:f2}%");
            Console.WriteLine($"{kiliPercentage:f2}%");
            Console.WriteLine($"{k2Percentage:f2}%");
            Console.WriteLine($"{everestPercentage:f2}%");
        }
    }
}
