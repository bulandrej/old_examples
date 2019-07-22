using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FunctionCalc
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.Text +="  "+ DateTime.Now.ToLongTimeString();
            timer1.Start();
            timer2.Start();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            this.Text = "Вычисление значения функции  " + DateTime.Now.ToLongTimeString();
        }

        private void timer2_Tick(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form2 aboutAuthor = new Form2();
            aboutAuthor.ShowDialog();
        }

        private void Form1_FormClosing(object sender, FormClosedEventArgs e)
        {
            MessageBox.Show("До новых встреч!", "Пока!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // блок вычислений:
            try
            {
                double X = Convert.ToDouble(textBox1.Text);
                double Y = Convert.ToDouble(textBox2.Text);
                double result = Math.Pow((Math.Sin(X) * Math.Sin(X) + 1), 3) - Math.Sqrt(Math.Abs(Y-3)/3.01);
                textBox3.Text = result.ToString("f2");
            }  // если произошла ошибка при вводе:
            catch
            {
                MessageBox.Show("Всё пропало, шеф!", "Ашыпка.");
                textBox3.Text = "Введите верные данные";
            }
        }
    }
}
