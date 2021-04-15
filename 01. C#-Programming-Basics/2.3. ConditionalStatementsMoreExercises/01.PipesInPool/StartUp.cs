
namespace _01.PipesInPool
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int poolVolume = int.Parse(Console.ReadLine());
            int pipeOne = int.Parse(Console.ReadLine());
            int pipeTwo = int.Parse(Console.ReadLine());
            double hours = double.Parse(Console.ReadLine());

            double result = pipeOne * hours + pipeTwo * hours;
            double resultInPercentage = result / poolVolume * 100;
            double pipeOneInPercantage = pipeOne * hours / result * 100;
            double pipeTwoInPercantage = pipeTwo * hours / result * 100;

            double overflow = result - poolVolume;


            if (result <= poolVolume)
            {
                Console.WriteLine($"The pool is {resultInPercentage:f2}% full. Pipe 1: {pipeOneInPercantage:f2}%. Pipe 2: {pipeTwoInPercantage:f2}%.");
            }
            else
            {
                Console.WriteLine($"For {hours} hours the pool overflows with {overflow} liters.");
            }
                
        }
    }
}
