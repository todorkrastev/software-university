
namespace InvalidNumber
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int inputNumber = int.Parse(Console.ReadLine());

            if (inputNumber >= 100 && inputNumber <= 200 || inputNumber == 0)
            {
                Console.WriteLine("");
            }
            else
                Console.WriteLine("invalid");
        }
    }
}
