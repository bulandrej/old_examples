using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam
{
    class Swimmer : AbstrClass
    {
        // поле-массив с результатами заплывов
        public override double[] OcenResult { get; set; }

        public override void SetOcen() // оценки уже инициализированы напрямую
        {
            ;
        }

        //public Swimmer(){}
        public Swimmer() 
        {
            name = base.name;
            age = base.age;
            kindOfSport = base.kindOfSport;
        }
        public Swimmer(string name, int age, string kindOfSport, double[] resSwim) 
            : base(name, age, kindOfSport)
        {
            this.OcenResult = OcenResult;
        }

        // метод вычисления лучшего результата
        public override double BestResult()
        {
            double res = 10;
            for (int i = 0; i < OcenResult.Length; i++)
            {
                if (res > OcenResult[i])
                    res = OcenResult[i];
            }
            return res;
        }

        // средний результат за указанные заплывы
        public double AvgSwim(params int[] NSwim)
        {
            double res = 0.0;
            // если массив пустой - сразу выходим с нулевым результатом
            if (NSwim.Length == 0)
                return res;
            // если не пустой - перебираем номера заплывов
            int n = 0;
            foreach (int item in NSwim)
            {
                n++;
                // проверка на диапазон:
                if ((0 <= (item - 1)) && ((item - 1) < NSwim.Length))
                {
                    res += NSwim[item - 1];
                }
                else
                {
                    Console.WriteLine("\nпараметру № {0} присвоен некорректный номер заплыва, равный {1}\n", n, item);
                }
            }
            return (double)(res / n);
        }

        public override void Show() // отображение объекта в строковом виде
        {
            string tmp = "";
            int i = 0;
            int Len = OcenResult.Length;
            while (i < Len)
            {
                if (i != 0)
                    tmp += ", " + OcenResult[i].ToString();
                else
                    tmp += OcenResult[i].ToString();
                i++;
            }
            Console.WriteLine(kindOfSport + "    " + name + ",\t  возраст " + age + " лет;\tоценки: " + tmp + "."); 
        }
    }
}
