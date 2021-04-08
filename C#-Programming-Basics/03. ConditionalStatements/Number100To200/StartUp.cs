using System;

namespace Number100To200
{
    class StartUp
    {
        static void Main(string[] args)
        {
            int insertNumber = int.Parse(Console.ReadLine());
            if (insertNumber <= 99)
            {
                Console.WriteLine("Less than 100");
            }
            else if (insertNumber <= 200)
            {
                Console.WriteLine("Between 100 and 200");
            }
            else 
            {
                Console.WriteLine("Greater than 200");
            }
        }
    }
}
