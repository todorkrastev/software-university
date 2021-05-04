using System;

namespace SpeedInfo
{
    class StartUp
    {
        static void Main(string[] args)
        {
            double Speed = double.Parse(Console.ReadLine());

            if (Speed <= 10)
            {
                Console.WriteLine("slow");
            }    
            else if (Speed <= 50)
            {
                Console.WriteLine("average");
            }
            else if (Speed <= 150)
            {
                Console.WriteLine("fast");
            }
            else if (Speed <= 1000)
            {
                Console.WriteLine("ultra fast");
            }
            else
                Console.WriteLine("extremely fast");
        }
    }
}
