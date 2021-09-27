
namespace DayOFWeek
{
    using System;
    class StartUp
    {
        static void Main(string[] args)
        {
            int dayOfWeek = int.Parse(Console.ReadLine());
            string result = "";

            switch (dayOfWeek)
            {
                case 1:
                    result = "Monday";
                    break;

                case 2:
                    result = "Tuesday";
                    break;

                case 3:
                    result = "Wednesday";
                    break;

                case 4:
                    result = "Thursday";
                    break;

                case 5:
                    result = "Friday";
                    break;

                case 6:
                    result = "Saturday";
                    break;

                case 7:
                    result = "Sunday";
                    break;

                default:
                    result = "Error";
                    break;
            }
            Console.WriteLine(result);
        }
    }
}
