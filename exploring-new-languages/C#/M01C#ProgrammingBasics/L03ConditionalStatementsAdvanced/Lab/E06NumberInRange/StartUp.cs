
namespace NumberInRange
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double inputNumber = double.Parse(Console.ReadLine());

            if (inputNumber >= -100 && inputNumber <= 100 && inputNumber != 0)
            {
                Console.WriteLine("Yes");
            }
            else if (inputNumber <= 100 && inputNumber >= -100 && inputNumber != 0)
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }

        }
    }
}
