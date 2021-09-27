
namespace _01.ReadText
{
using System;
    using System.Reflection.Metadata.Ecma335;

    class StartUp
    {
        static void Main(string[] args)
        {
            while (true)
            {
                string txt = Console.ReadLine();
                if (txt == "Stop")
                {
                    break;
                }
                Console.WriteLine(txt);
            }
        }
    }
}
