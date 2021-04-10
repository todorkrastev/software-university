using System;

namespace PasswordGuess
{
    class StartUp
    {
        static void Main(string[] args)
        {
            string insertPassword = Console.ReadLine();
            if (insertPassword == "s3cr3t!P@ssw0rd")
            {
                Console.WriteLine("Welcome");
            }
            else
            {
                Console.WriteLine("Wrong password!");
            }
        }
    }
}
