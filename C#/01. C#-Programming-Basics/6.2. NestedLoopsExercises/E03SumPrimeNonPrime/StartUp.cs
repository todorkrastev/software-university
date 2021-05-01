
namespace _03.SumPrimeNonPrime
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            string command = Console.ReadLine();
            int sumPrime = 0;
            int sumComposite = 0;

            while (command != "stop")
            {
                int num = int.Parse(command);
                if (num < 0)
                {
                    Console.WriteLine($"Number is negative.");
                }
                else
                {
                    int count = 0;
                    for (int i = 1; i <= num; i++)
                    {
                        if (num % i == 0)
                        {
                            count++;
                        }
                    }
                    if (count == 2)
                    {
                        sumPrime += num;
                    }
                    else
                    {
                        sumComposite += num;
                    }
                }
                command = Console.ReadLine();
            }
            Console.WriteLine($"Sum of all prime numbers is: {sumPrime}");
            Console.WriteLine($"Sum of all non prime numbers is: {sumComposite}");
        }
    }
}
