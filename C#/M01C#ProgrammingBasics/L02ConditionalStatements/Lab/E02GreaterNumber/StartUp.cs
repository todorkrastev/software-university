
namespace GreaterNumber
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int numOne = int.Parse(Console.ReadLine());
            int numTwo = int.Parse(Console.ReadLine());
            if (numOne > numTwo)
            {
                Console.WriteLine(numOne);
            }
            else
            {
                Console.WriteLine(numTwo);
            }
        }
    }
}
