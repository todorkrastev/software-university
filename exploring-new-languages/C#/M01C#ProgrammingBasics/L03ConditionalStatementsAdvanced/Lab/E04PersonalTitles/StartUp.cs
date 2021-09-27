
namespace PersonalTitles
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double inputAge = double.Parse(Console.ReadLine());
            string inputGender = Console.ReadLine();

            if (inputGender == "m" && inputAge >= 16)
            {
                Console.WriteLine("Mr.");
            }

            else if (inputGender == "m" && inputAge < 16)
            {
                Console.WriteLine("Master");
            }
            else if (inputGender == "f" && inputAge >= 16)
            {
                Console.WriteLine("Ms.");
            }
            else
            {
                Console.WriteLine("Miss");
            }
               
        }
    }
}
