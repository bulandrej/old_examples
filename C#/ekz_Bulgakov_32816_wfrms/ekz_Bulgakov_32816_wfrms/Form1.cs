using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace ekz_Bulgakov_32816_wfrms
{
    public partial class Form1 : Form
    {
        List<Student> students = new List<Student>();
        private string str_path = Application.StartupPath; // путь по умолчанию - bin-debug
        public Form1()
        {InitializeComponent();
            // маски открываемых файлов
            openFileDialog1.Filter = "Текстовый файл|*.txt|Все файлы|*.*";
            // устанавливаем начальную папку
            saveFileDialog1.InitialDirectory = Application.StartupPath;
            saveFileDialog1.Filter = "Текстовый файл|*.txt";
            // расширение файлов для сохранения по умолчанию
            saveFileDialog1.DefaultExt = "txt";
            timer1.Start();
            timer2.Start();
            comboBox1.SelectedIndex = 0;
            // определяем видимость контролов:
            comboBox1.Visible = false;
            button2.Visible = false;
            button6.Visible = false;
            button1.Visible = false;
            button5.Visible = false;
            dataGridView1.Visible = false;
            chart1.Visible = false;
            treeView1.Visible = true;
        }

        // метод для построения дерева с файлами из папки проекта по умолчанию
        void BuildTreeView(string directoryName, TreeNode ParentNode)
        {
           try
            {
                string path = Application.StartupPath; // путь по умолчанию - bin-debug
                treeView1.Nodes.Clear();
                treeView1.Nodes.Add(path); 
                string[] Files = Directory.GetFiles(path);
                    foreach (string f in Files)
                    {
                        string r = f.Substring(f.LastIndexOf('\\') + 1);
                        ((TreeNode)treeView1.Nodes[0]).Nodes.Add(f);
                    }
            }
            catch (UnauthorizedAccessException)
            { ParentNode.Nodes.Add("Отказано в доступе"); }
           comboBox1.Visible = true;
           button2.Visible = true;
           button6.Visible = true;
           button1.Visible = true;
           button5.Visible = true;
           dataGridView1.Visible = true;
           chart1.Visible = false;
           treeView1.Visible = true;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            // вывод текста в statusStrip
            toolStripStatusLabel1.Text = "Выполнил Булгаков А.А., текущие дата и время: "+ DateTime.Now;
        }
        // кнопка ОБ АВТОРЕ
        private void button3_Click(object sender, EventArgs e)
        {
            (new Form2()).ShowDialog();
        }

        // метод разбиения строки с разделителем
        private string SplitLine(string str, char ch, int x)
        {
            string[] string_arr = str.Split(new char[] { ch });
            int n = -1;
            foreach (string s in string_arr)
            {
                n++;
            }
            string result_str = "";
            if (x == 1)
                result_str = string_arr[0];
            else if (x == 2)
                result_str = string_arr[n];
            else
            {
                MessageBox.Show("Неверный входной параметр №3 метода SplitLine");
                return result_str;
            }
            return result_str;
        }

        // обработчик события выбора элемента списка treeView1
        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            string path_tmp = treeView1.SelectedNode.FullPath;
            // получаем первую подстроку
            string str1 = SplitLine(path_tmp, ':', 1);            
            // получаем последнюю подстроку:
            string str2 = SplitLine(path_tmp, ':', 2);            
            // получаем путь:
            string path = str1 + ":" + str2;

            try
            { 
            // получаем файл в List
            students = FileInList(path);
            ConvList(students);
            // выводим содержимое в datagridView
            ListInDVG(students);
            }
            catch(Exception)
            {
                MessageBox.Show("Выбирайте для обработки файл *.txt \n с необходимой информацией!");
            }
        }

        // метод чтения из файла в List
        private List<Student> FileInList(string filename)
        {
            List<Student> temp = new List<Student>();
            using (StreamReader f = new StreamReader(filename))
            {
                string[] str;
                temp.Clear();
                int n = -1;
                while (!f.EndOfStream)
                {
                    n++;
                    str = f.ReadLine().Split(';');
                    foreach (var tmp in str)
                    {
                        string[] s = tmp.Split(',');
                        temp.Add(new Student(s[0], s[1], int.Parse(s[2])));
                    }
                }
            }
            return temp;
        }

        // метод вывода из List в datagridView
        private void ListInDVG(List<Student> students)
        {
            // получаем количество необходимых строк
            dataGridView1.RowCount = 0;
            int n = 0;
            foreach (var st in students)
            {
                n = dataGridView1.RowCount++;
                dataGridView1[0, n].Value = st.Name;
                dataGridView1[1, n].Value = st.Group;
                dataGridView1[2, n].Value = st.Ocen.ToString();
            }
        }

        // Обработчик пункта контекстного меню ЦВЕТ
        private void цветToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (colorDialog1.ShowDialog() == DialogResult.OK)
                this.BackColor = colorDialog1.Color;
        }

        // Обработчик пункта контекстного меню ШРИФТ
        private void шрифтToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (fontDialog1.ShowDialog() == DialogResult.OK)
                this.Font = fontDialog1.Font;
        }

        // кнопка ДОБАВИТЬ СТУДЕНТА
        private void button1_Click(object sender, EventArgs e)
        {
            // добавление строк
            dataGridView1.RowCount++;
        }

        // Таймер на 2 минуты ВЕДОМОСТИ В ДЕКАНАТ
        private void timer2_Tick(object sender, EventArgs e)
        {
            MessageBox.Show("Срочно сдать ведомости в деканат!");
        }

        // кнопка ОБНОВИТЬ СОДЕРЖИМОЕ СПИСКА
        private void button5_Click(object sender, EventArgs e)
        {
            try
            {
                if (dataGridView1.RowCount != 0)
                    FillList();
                else
                    MessageBox.Show("Вначале выберите файл для отображения в таблице!");
            }
            catch (Exception)
            {
                MessageBox.Show("Проверьте список студентов, в данных есть ошибка!");
            }
        }
        // метод заполнения списка из dataGridView1
        private void FillList()
        {
            string st_Box = "";
            int r = dataGridView1.RowCount; //получаем количество строк (студентов)
            students.Clear(); // Очищаем список
            // перебираем все строки dataGridView1
            for (int i = 0; i<r; i++)
            {
                string Name = dataGridView1.Rows[i].Cells[0].Value.ToString();
                string Group = dataGridView1.Rows[i].Cells[1].Value.ToString();
                int Ocen = Convert.ToInt32(dataGridView1.Rows[i].Cells[2].Value);
                // добавляем студента в список:
                students.Add(new Student(Name, Group, Ocen));
                if (i == 0)
                    st_Box += ConvElList(students[i]);
                else
                    st_Box += "; " + ConvElList(students[i]);
            }
        }

        // конвертер элемента List-а в строку
        private string ConvElList(Student s)
        {
           return (s.Name + "," + s.Group + "," + s.Ocen);
        }

        // Конвертер List к строковому виду 
        private string ConvList(List<Student> students)
        {
            string st_Box = "";
            int r = students.Count();  //получаем количество студентов в списке
            // перебираем список
            for (int i = 0; i < r; i++)
            {
               // добавляем студента в список:
                if (i == r-1)
                    st_Box += ConvElList(students[i]);
                else
                    st_Box += ConvElList(students[i]) + ";";
            }
            return st_Box;
        }
        // пункт меню СОХРАНИТЬ
         private void сохранитьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(students.Count != 0)
            { 
                if (saveFileDialog1.ShowDialog() == DialogResult.OK)  // если пользователь подтвердил свой выбор
                {
                    using (StreamWriter f = new StreamWriter(saveFileDialog1.FileName))
                    {
                        string temp = ConvList(students);
                        // запись текущей строки в файл
                        f.WriteLine(temp);
                    }
                }
                GetListFiles();
            }
            else
            {
                MessageBox.Show("В списке студентов отсутствуют записи!");
            }
        }
         // пункт меню ОТКРЫТЬ
         private void открытьToolStripMenuItem_Click(object sender, EventArgs e)
         {
             GetListFiles();
         }
         // метод получения списка файлов в treeView
         private void GetListFiles()
         {
             treeView1.Nodes.Clear();
             treeView1.Nodes.Add(str_path);
             BuildTreeView(str_path, treeView1.Nodes[0]);
             chart1.Visible = false;
         }
         // Пункт меню ЦВЕТ ФОНА
         private void цветФонаToolStripMenuItem_Click(object sender, EventArgs e)
         {
             if (colorDialog1.ShowDialog() == DialogResult.OK)
             {
                 this.BackColor = colorDialog1.Color;
             }
         }
         // Пункт меню ПАРАМЕТРЫ ШРИФТА
         private void параметрыШрифтаToolStripMenuItem_Click(object sender, EventArgs e)
         {
             if (fontDialog1.ShowDialog() == DialogResult.OK) this.Font = fontDialog1.Font;
         }
        // кнопка ОПРЕДЕЛИТЬ СТУДЕНТА СОГЛАСНО УСЛОВИЮ
         private void button2_Click(object sender, EventArgs e)
         {
             try
             {
                 if (students.Count != 0)
                 {
                     ClearCellColor();
                     if (comboBox1.SelectedIndex == 0)
                         FindBest();
                     else
                         FindWorst();
                 }
                 else
                     MessageBox.Show("Сначала необходимо заполнить список данными!");
             }
             catch(Exception)
             {
                 MessageBox.Show("Проверьте таблицу, в ней есть ошибка!");
             }
         }

         // Найти ХУДШЕГО по оценке
         private void FindWorst()
         {
             int ocen = Int32.MaxValue;
             for (int i = 0; i < students.Count; i++)
             {
                 ocen = (students[i].Ocen < ocen) ? students[i].Ocen : ocen;
             }
             SetColor(ocen, Color.Red);
         }

         // Найти ЛУЧШЕГО по оценке
         private void FindBest()
         {
             int ocen = 0;
             for (int i = 0; i < students.Count; i++)
             {
                 ocen = (students[i].Ocen > ocen) ? students[i].Ocen : ocen;
             }
             SetColor(ocen, Color.Green);
         }

         // метод УСТАНОВКИ ЦВЕТА ЯЧЕЕК
         private void SetColor(int ocen, Color color)
         {
             for (int i = 0; i < dataGridView1.RowCount; i++)
             {
                 if (students[i].Ocen == ocen)
                 {
                     dataGridView1[0, i].Style.BackColor = color;
                     dataGridView1[1, i].Style.BackColor = color;
                     dataGridView1[2, i].Style.BackColor = color;
                 }
             }
         }

         // метод СБРОСа ЦВЕТОВ всех ячеек dataGridView1 в "по умолчанию"
         private void ClearCellColor()
         {
             for (int i = 0; i < dataGridView1.RowCount; i++)
             {
                 for (int j = 0; j < dataGridView1.ColumnCount; j++)
                 {
                     dataGridView1[j, i].Selected = false;
                     dataGridView1[j, i].Style.BackColor = DefaultBackColor;
                 }
             }
         }

         // кнопка ПОСТРОИТЬ ДИАГРАММУ
         private void button6_Click(object sender, EventArgs e)
         {
             if (students.Count != 0)
             {
                 treeView1.Visible = false;
                 dataGridView1.Visible = true;
                 chart1.Visible = true;
                 BuildDiagr();
             }
             else
                 MessageBox.Show("В списке студентов нет ни одной записи!\nСначала введите данные, либо загрузите \nданные из файла, затем обновите список!", "ВНИМАНИЕ!", MessageBoxButtons.OK, MessageBoxIcon.Warning);
         }

         // метод отображения диаграммы
         private void BuildDiagr()
         {
             chart1.Series[0].Points.Clear();
             var ocens = from stud in students 
                         group stud by stud.Ocen 
                         into d select new { Rating = d.Key, Count = d.Count() };
             var list = ocens.ToList();
             foreach (var item in list)
             {
                 chart1.Series[0].Points.AddXY(item.Rating, item.Count);
                 // комментарий для каждого пункта диаграммы
                 chart1.Series[0].ToolTip = "Количество #VALX";
             }
         }
    }
}
