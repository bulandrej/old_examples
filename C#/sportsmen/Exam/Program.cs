using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Collections;

namespace Exam
{
    // делегат, возвращающий логическое значение
    //public delegate bool Criterion(string str);
    

    class Program
    {

        static void Main(string[] args)
        {
            Console.SetWindowSize(140, 50);  // задаём размер окна консоли
            Console.WriteLine("\n\n--------------------------<экзамен C# Булгаков >-------------------------------------------\n");

            // 1. Создаём коллекцию
            Case<AbstrClass> sp = new Case<AbstrClass>();

            FileInp inp_str = new FileInp();
            string inp = inp_str.ReadFile();   // получаем строку из файла


            // Отделяем строки друг от друга + помещаем их в массив строк:
            string[] TimetableLines = inp.Split(new char[] { '\n' }, StringSplitOptions.RemoveEmptyEntries);
            int j = -1;  //счётчик строк
            foreach (string line in TimetableLines) //перебираем полученные предложения
            {
                j++;  //номер строки

                // 1. убираем лишние пробелы между словами:
                string pattern = "\\s+";
                string replacement = "";
                Regex rgx_w = new Regex(pattern);
                string line_w = rgx_w.Replace(line, replacement);

                // делим строку на слова и записываем в строковый массив
                string[] words = line_w.Split(new char[] { ';' }, StringSplitOptions.RemoveEmptyEntries);

                List<double> OcRes = new List<double>();
                int num_w = -1;  // индекс слова
                // перебираем слова в предложении
                foreach (string w in words)
                {
                    ++num_w;  // счётчик слов
                    switch (num_w)
                    {
                        case 0:   // выделение памяти на объект и вид спорта
                            //t++; // счётчик слов
                            if (String.Compare(w, "гимнаст") == 0)  // если гимнаст
                            {
                                sp[j] = new Gymnasts();
                                sp[j].KindOfSport = w;
                            }
                            else if (String.Compare(w, "пловец") == 0)  // если пловец
                            {
                                sp[j] = new Swimmer();
                                sp[j].KindOfSport = w;
                            }
                             break;

                        case 1:   // имя спортсмена
                            sp[j].Name = w;
                            break;

                        case 2:   // возраст
                            sp[j].Age = Convert.ToInt32(w);
                            break;

                        // время и оценки
                        // Всё, что попадётся в предложении после 3-ёй ';' - является оценками 
                        default:
                            if (num_w > 2)
                                  OcRes.Add(Convert.ToDouble(w));
                               break;
                    } // закрывающая switch
                } // закрывающая foreach по словам
                sp[j].OcenResult = OcRes.ToArray(); // заносим каждый объект в массив   <---------------------------------------------------------------------------------
                if (sp[j] is Gymnasts)
                {
                    sp[j].SetOcen();
                }
            } // закрывающая foreach по строкам


            // отображение считанного из файла массива спортсменов
            int q = 0;
            //foreach (AbstrClass item in sp)
            //{
            //    //Console.WriteLine("Контроль объекта: ");
            //    sp[q].Show();
            //    q++;
            //}

            Console.WriteLine("\nТаблица №1: ");

            Table T1 = new Table(13, 16, 24, 34, "фамилия", "возраст", "вид спорта", "лучший результат");
            T1.Cap_table(T1, "список спортсменов без сортировки");
            q = 0;
            while (q < sp.Length)
            {
                if (sp[q] != null)
                    AbstrClass.Tab(T1, sp[q]); // вывод каждого объекта
                ++q;
            }
            T1.Base_table(T1);

            // сортировка по возрасту
            sp.SortAthletes();

            Console.WriteLine("\n\nТаблица №2: ");

            Table T2 = new Table(13, 16, 24, 34, "фамилия", "возраст", "вид спорта", "лучший результат");
            T1.Cap_table(T2, "список спортсменов, отсортированный по возрасту");
            q = 0;
            while (q < sp.Length)
            {
                if (sp[q] != null)
                    AbstrClass.Tab(T2, sp[q]); // вывод каждого объекта
                ++q;
            }
            T2.Base_table(T2);

            Console.WriteLine("\nСравниваем двух гимнастов по результатам:\n");

            Gymnasts gm = new Gymnasts();
            gm.CompGymnast(sp);

            //Вывод текущего времени
            Console.Write(DateTime.Now.ToString("HH:mm:ss   "));
            //Выводим дату с названием месяца
            Console.WriteLine(DateTime.Now.ToString("dd MMMM yyyy года\n"));
            Console.WriteLine("----------------------------------------<End>----------------------------------------------\n");
            Console.ReadKey();
        }
    }
}
