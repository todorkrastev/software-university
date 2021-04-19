
namespace Vacation_Book_List
{
using System;
    class Program
    {
        static void Main(string[] args)
        {
            //От конзолата се четат 3 реда:
            //Брой страници в текущата книга – цяло число в интервала[1…1000];
            int numberOfPages = int.Parse(Console.ReadLine());
            //Страници, които може да прочита за 1 час – реално число в интервала[1.00…1000.00];
            double PagesperHour = double.Parse(Console.ReadLine());
            //Броя на дните, за които трябва да прочете книгата – цяло число в интервала[1…1000];
            int NumberofDates = int.Parse(Console.ReadLine());
            //1.изчисляваме общото време за четене на книгата: 212 / 20 = 10.6 часа
            double Totalhoursreading = numberOfPages / PagesperHour;
            //2.получения резултат делим на броя дни, за да получим необходимите часове на ден: 10.6 часа / 2 дни = 5.3 часа на ден
            double Result = Totalhoursreading / NumberofDates;
            Console.WriteLine(Result);
        }
    }
}
