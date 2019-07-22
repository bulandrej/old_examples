using System;

namespace Exam
{
    class Gymnasts: AbstrClass
    {
        Random rand = new Random();

        private double ring; // оценка за кольца
        private double brus; // оценка за брусья
        private double gamp; // оценка за прыжок

        public double Ring
        {
            get { return ring; }
            set { ring = value; }
        }
        public double Brus
        {
            get { return brus; }
            set { brus = value; }
        }
        public double Gamp
        {
            get { return gamp; }
            set { gamp = value; }
        }

        public override double[] OcenResult { get; set; }
        public double this[int i]
        {
            get
            {
                if (i > 0 && i <= OcenResult.Length)
                    return OcenResult[i];
                else return 0.0;
            }
        }

        //public Gymnasts(){}

        public Gymnasts() 
        {
            name = base.name;
            age = base.age;
            kindOfSport = base.kindOfSport;
            if (OcenResult != null)
            { 
            Ring = OcenResult[0];
            Brus = OcenResult[1];
            Gamp = OcenResult[2];
            }
        }
        public Gymnasts(string name, int age, string kindOfSport, double ring, double brus, double gamp)
            : base(name, age, kindOfSport)
        {
            this.ring = ring;
            this.brus = brus;
            this.gamp = gamp;
        }
        public override void SetOcen() // инициализация оценок гимнаста  <------------------------------------------------------
        {
            if (OcenResult != null)
            {
                Ring = OcenResult[0];
                Brus = OcenResult[1];
                Gamp = OcenResult[2];
            }
        }

        // метод вычисления средней суммы баллов гимнаста
        public double Average()
        {
            return ((ring + brus + gamp) / 3);
        }


        // поиск лучшего результата
        public override double BestResult()
        {
            double res = 0;
            if (ring >= brus)
            {
              if (ring >= gamp)
                res = ring;
              else
                  res = gamp;
            }
            else if (brus >= gamp)
                res = brus;
            else
                res = gamp;
            return res;
        }

        // метод ввода фамилии гимнаста для сравнения
        public AbstrClass InpGymnast(Case<AbstrClass> spmen)
        {
            AbstrClass X = new Gymnasts();
            Console.Write("\nВведите фамилию гимнаста: ");
            string s;
            s = Console.ReadLine();
            for (int i = 0; i < spmen.Length; i++)
			{
			 if (s==spmen[i].Name&&spmen[i] is Gymnasts)
                 return spmen[i];
			}
                Console.WriteLine("\nне нашлось гимнастов с указанной фамилией.");
                string yes = "";
                int j = 0;

                do
                {
                    for (; ; )
                    {
                        j = rand.Next(0, spmen.Length);
                        if (spmen[j].KindOfSport == "гимнаст")
                            break;
                    }
                    Console.WriteLine("\n\n" + spmen[j].Name + " подойдёт? (нажмите \"y\" для подтверждения, либо другую кнопку для перехода дальше)");
                    yes = Console.ReadLine();
                    if (yes == "y" || yes == "Y" || yes == "н" || yes == "Н")
                        //X = spmen[j];
                        return spmen[j];
                } while (yes != "y" || yes != "Y" || yes != "н" || yes != "Н");
            return X;
        }

        // сравниваем результаты гимнастов
        public static bool operator <(Gymnasts one, Gymnasts two)
        {
            if (one.BestResult()<two.BestResult())
            return true;
            else return false;
        }

        public static bool operator >(Gymnasts one, Gymnasts two)
        {
            if (one.BestResult() > two.BestResult())
                return true;
            else return false;
        }

        public void CompGymnast(Case<AbstrClass> spmen)
        {
            Gymnasts Sp1 = (Gymnasts)InpGymnast(spmen);
            Gymnasts Sp2 = (Gymnasts)InpGymnast(spmen);
            if(Sp1>Sp2)
                {
                Console.WriteLine("\n\n-------------------------------------------------------------------------");
                Console.WriteLine("\nу гимнаста " + Sp1.Name + " лучший результат выше, чем у "+ Sp2.Name);
                Console.WriteLine("\n-------------------------------------------------------------------------");
                }
            else if (Sp2 > Sp1)
                {
                Console.WriteLine("\n\n-------------------------------------------------------------------------");
                Console.WriteLine("\nу гимнаста " + Sp2.Name + " лучший результат выше, чем у " + Sp1.Name);
                Console.WriteLine("\n-------------------------------------------------------------------------");
                }
            else
                {
                Console.WriteLine("\n\n-------------------------------------");
                Console.WriteLine("\nлучшие результаты гимнастов равны!");
                Console.WriteLine("\n-------------------------------------");
                }
        }

        public override void Show() // отображение объекта в строковом виде  <----------------------------- убрать после отладки--------------------------
        {
            Console.WriteLine(kindOfSport + "   " + name + ",\t  возраст " + age + " лет;\tоценки: кольца - " + Ring + ", брусья - " + Brus + ", прыжок - " + Gamp + ".");
        }
    }
}
