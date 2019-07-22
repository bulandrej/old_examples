using System;

namespace Exam
{
    class Table
    {
        // Таблица на 4 колонки
        private static string z1;
        private static string z2;
        private static string z3;
        private static string z4;
        private static int wd1;
        private static int wd2;
        private static int wd3;
        private static int wd4;
        public Table(int wd_1, int wd_2, int wd_3, int wd_4, string z_1, string z_2, string z_3, string z_4)
        {
            wd1 = wd_1;
            wd2 = wd_2;
            wd3 = wd_3;
            wd4 = wd_4;
            z1 = z_1;
            z2 = z_2;
            z3 = z_3;
            z4 = z_4;
        }
        // метод для рисования горизонтальной линии с ограничителями с обеих сторон и разделителями внутри
        public void Horiz_line(char a, Table T, char c, char b)
        {
            int i = 0;
            while (i <= (Table.wd1 + Table.wd2 + Table.wd3 + Table.wd4) + 4)
            {
                if (i == 0)
                    Console.Write(a);
                else if (i == (Table.wd1 + Table.wd2 + Table.wd3 + Table.wd4) + 4)
                    Console.Write(c);
                else
                {
                    if (i == Table.wd1 + 1)
                        Console.Write(b);
                    else
                        if (i == (Table.wd1 + Table.wd2) + 2)
                            Console.Write(b);
                        else
                            if (i == (Table.wd1 + Table.wd2 + Table.wd3) + 3)
                                Console.Write(b);
                            else
                                if (i == (Table.wd1 + Table.wd2 + Table.wd3 + Table.wd4) + 4)
                                    Console.Write(b);
                                else
                                    Console.Write('=');
                }
                i++;
            }
            Console.WriteLine("");
        }

        // Метод для вывода заголовка
        internal void Inscript_out(char a, Table T, string Zagolov)
        {
            int i = 0;
            int size = Zagolov.Length;     // получаем длину надписи в заголовке
            int dop = (Table.wd1 + Table.wd2 + Table.wd3 + Table.wd4 + 3 - size);

            Console.Write(a);       //символ-ограничитель слева
            Console.BackgroundColor = ConsoleColor.DarkCyan; // цвет фона
            while (i < dop / 2)
            {
                Console.Write(" ");
                i++;
            }
            Console.ForegroundColor = ConsoleColor.White;
            Console.Write(Zagolov); //выводим надпись нужного цвета
            Console.ResetColor();
            Console.BackgroundColor = ConsoleColor.DarkCyan; // цвет фона
            i = 0;
            int dop2 = 0;
            if (dop % 2 != 0)
                dop2 = (dop / 2) + dop % 2;
            else
                dop2 = (dop / 2);
            while (i < dop2)
            {
                Console.Write(" ");
                i++;
            }
            Console.ResetColor();
            Console.WriteLine(a);   //символ-ограничитель справа

        }
        // Метод для вывода одной колонки
        public void One_col(char a, int wd, string z)
        {
            int size = z.Length;     // получаем длину надписи в колонке
            int dop = (wd - 1 - size);  // считаем позиции с пробелами
            int i = 0;
            while (i <= dop / 2)
            {
                Console.Write(" ");
                i++;
            }
            if (String.Compare(z, "пловец") == 0)
                Console.ForegroundColor = ConsoleColor.Cyan;
            else if (String.Compare(z, "гимнаст") == 0)
                Console.ForegroundColor = ConsoleColor.Yellow;
            else if (String.Compare(z, "возраст") == 0)
                Console.ForegroundColor = ConsoleColor.Red;
            else
                Console.ForegroundColor = ConsoleColor.Gray;
            Console.Write(z); //выводим надпись заданного цвета
            Console.ResetColor();
            i = 0;
            int dop2 = 0;
            if (dop % 2 != 0)
                dop2 = (dop / 2) + dop % 2;
            else
                dop2 = (dop / 2);
            while (i < dop2)
            {
                Console.Write(" ");
                i++;
            }
            Console.Write(a);     //символ-разделитель
        }
        // Метод для вывода подзаголовка
        public void Subtitle_out(char a, Table T)
        {
            Console.Write(a);     //символ-ограничитель слева
            T.One_col(a, Table.wd1, Table.z1);
            T.One_col(a, Table.wd2, Table.z2);
            T.One_col(a, Table.wd3, Table.z3);
            T.One_col(a, Table.wd4, Table.z4);
            Console.WriteLine("");
        }
        // Метод для вывода всей шапки таблицы
        public void Cap_table(Table X, string Zagolov)
        {
            Horiz_line('╔', X, '╗', '=');    // верхняя горизонтальная
            Inscript_out('║', X, Zagolov);   // вывод заголовка
            Horiz_line('╠', X, '╣', '╦');    // сепаратор
            Subtitle_out('║', X);            // вывод подзаголовков
            Horiz_line('╠', X, '╣', '╬');    // нижняя горизонтальная
        }
        // Метод для вывода информации об одном рейсе в одну строку
        public void Show_str_tab(char a, Table T, string pole1, string pole2, string pole3, string pole4)
        {
            Console.Write(a);     //символ-ограничитель слева
            T.One_col(a, Table.wd1, pole1);
            T.One_col(a, Table.wd2, pole2);
            T.One_col(a, Table.wd3, pole3);
            T.One_col(a, Table.wd4, pole4);
            Console.WriteLine("");
        }
        // Метод для вывода основания таблицы
        public void Base_table(Table X) //
        {
            Horiz_line('╚', X, '╝', '╩');    // основание таблицы
            Console.WriteLine("");
        }
    }
}
