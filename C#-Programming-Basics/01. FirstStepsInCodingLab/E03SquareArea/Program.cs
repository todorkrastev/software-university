using System;

namespace SquareArea
{
    class Program
    {
        static void Main(string[] args)
        {
            var side = int.Parse(Console.ReadLine());
            var area = side * side;
            Console.WriteLine(area);
        }
    }
}
