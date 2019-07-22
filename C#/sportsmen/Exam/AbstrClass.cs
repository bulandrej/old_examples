namespace Exam
{
    public abstract class AbstrClass
    {

        protected string name;
        protected int age;
        protected string kindOfSport;
        public string Name
        {
            get { return name; }
            set { name = value; }
        }
        public int Age
        {
            get { return age; }
            set { age = value; }
        }
        public string KindOfSport
        {
            get { return kindOfSport; }
            set { kindOfSport = value; }
        }

        public AbstrClass()
        {
            name = "*";
            age = 0;
            kindOfSport = "*";
        }

        public AbstrClass(string name = "Не задано", int age = 0, string kindOfSport = "Не задано")
        {
            this.name = name;
            this.age = age;
            this.kindOfSport = kindOfSport;
        }
        public abstract double BestResult(); // метод определения лучшего результата

        public abstract double[] OcenResult { get; set; } // массив для оценок

        public abstract void SetOcen();
        public abstract void Show(); // отображение объекта в строковом виде

        internal static void Tab(Table T, AbstrClass X)
        {
            T.Show_str_tab('║', T, X.Name, X.Age.ToString(), X.KindOfSport, (X.BestResult()).ToString());  // последняя колонка - лучший результат
        }
    }
}
