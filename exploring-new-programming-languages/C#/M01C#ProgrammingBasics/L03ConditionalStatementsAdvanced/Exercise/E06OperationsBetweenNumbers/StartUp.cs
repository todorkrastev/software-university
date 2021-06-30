
namespace OperationsBetweenNumbers
{
using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            double inputNumber1 = double.Parse(Console.ReadLine());
            double inputNumber2 = double.Parse(Console.ReadLine());
            string inputSymbol = Console.ReadLine();

            double sum = 0;
           
            switch(inputSymbol)
            {
                case "+":
                    sum = inputNumber1 + inputNumber2;
                    break;

                case "-":
                    sum = inputNumber1 - inputNumber2;
                    break;

                case "*":
                    sum = inputNumber1 * inputNumber2;
                    break;

                case "/":
                    sum = inputNumber1 / inputNumber2;
                    break;

                case "%":
                    sum = inputNumber1 % inputNumber2;
                    break;
            }
            if(inputSymbol == "+" || inputSymbol == "-" || inputSymbol == "*")
            {
                if(inputNumber1 == 0 || inputNumber2 == 0)
                {
                    Console.WriteLine($"Cannot divide {inputNumber1} by zero");
                }
                else if(sum % 2 == 0)
                {
                    Console.WriteLine($"{inputNumber1} {inputSymbol} {inputNumber2} = {sum} - {"even"}");
                }
                else
                {
                    Console.WriteLine($"{inputNumber1} {inputSymbol} {inputNumber2} = {sum} - {"odd"}");
                }
            }
            else if(inputSymbol == "/")
            {
                if(inputNumber1 == 0 || inputNumber2 == 0)
                {
                    Console.WriteLine($"Cannot divide {inputNumber1} by zero");
                }
                else
                {
                    Console.WriteLine($"{inputNumber1} {inputSymbol} {inputNumber2} = {sum:f2}");
                }
            }
            else if(inputSymbol == "%" && inputNumber1 == 0 || inputNumber2 == 0)
            {
                Console.WriteLine($"Cannot divide {inputNumber1} by zero");                
            }
            else
            {
                Console.WriteLine($"{inputNumber1} {inputSymbol} {inputNumber2} = {sum}");
            }
        }
    }
}
