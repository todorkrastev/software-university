using System;

namespace _02.AndProcessors
{
    class Program
    {
        static void Main(string[] args)
        {
            int numCPU = int.Parse(Console.ReadLine());
            int employeesNum = int.Parse(Console.ReadLine());
            int workingDays = int.Parse(Console.ReadLine());

            int workingHours = 8;
            int timeNeededAssembling = 3;
            double priceCPU = 110.10;

            int totalHours = employeesNum * workingDays * workingHours;
            double totalCPUs = Math.Floor(totalHours * 1.0 / timeNeededAssembling);
            double profitCPUs = totalCPUs - numCPU;

            if (totalCPUs < numCPU)
            {
                double losses = profitCPUs * priceCPU;
                Console.WriteLine($"Losses: -> {Math.Abs(losses):f2} BGN");
            }
            else if (numCPU <= totalCPUs)
            {
                double profit = profitCPUs * priceCPU;
                Console.WriteLine($"Profit: -> {Math.Abs(profit):f2} BGN");
            }
        }
    }
}
