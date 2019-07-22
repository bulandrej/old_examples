using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Exam
{
    class FileInp
    {
        private string strfile;
        public string StrFile
        {
            get { return strfile; }
            set { value = strfile; }
        }

        public string ReadFile()   // Чтение текста из файла
        {
            // строка StringBuilder - приёмник считанной из файла информации
            StringBuilder txt_input = new StringBuilder("");
            try
            {
                string input = null;
                // Запрос на ввод пути к файлу, который нужно прочитать:
                //Console.Write("Введите полный путь к файлу: ");
                //string f_name = Console.ReadLine();
                // FileStream f_inp = new FileStream(f_name, FileMode.Open);
                // автоматическое чтение файла, предварительно помещённого по указанному в программе пути
                FileStream f_inp = new FileStream("D:\\sportsmen.txt", FileMode.Open);
                StreamReader sr_inp = new StreamReader(f_inp);

                int i = 0;
                while ((input = sr_inp.ReadLine()) != null)
                {
                    if (!string.IsNullOrEmpty(input.Trim()))
                    {
                        string firstLineWord = input.Split(new char[] { '\n' }, StringSplitOptions.RemoveEmptyEntries)[0];
                        if (txt_input.Length > 0)
                            txt_input.Append("\n" + firstLineWord);
                        else
                            txt_input.Append(firstLineWord);
                        ++i;
                    }
                }
                // преобразуем StringBuilder в string:
                strfile = txt_input.ToString();
                return strfile;
            }
            catch (IOException err_open)
            {
                Console.WriteLine(err_open.ToString() + "\n");
                return err_open.Message;
            }
        }
    }
}
