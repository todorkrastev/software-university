using System;

namespace Deposit_Calculator
{
    class Program
    {
        static void Main(string[] args)
        {
            double Depositamount = double.Parse(Console.ReadLine());
            int Term = int.Parse(Console.ReadLine());
            double Annualinterestrate = double.Parse(Console.ReadLine());
            double Totalamount = Depositamount + Term * ((Depositamount * Annualinterestrate / 100) / 12);
            Console.WriteLine(Totalamount);
        }
    }
}
