using System;
using System.Diagnostics;

namespace Project_Creations
{
    class Program
    {
        static void Main(string[] args)
        {
            string nameArchitect = Console.ReadLine();
            int project = int.Parse(Console.ReadLine());
            int time  = project * 3;
            Console.WriteLine($"The architect {nameArchitect} will need {time} hours to complete {project} project/s.");
        }
    }
}
