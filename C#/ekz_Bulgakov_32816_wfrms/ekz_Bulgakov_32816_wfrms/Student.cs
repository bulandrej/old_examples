using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ekz_Bulgakov_32816_wfrms
{
    class Student
    {
        public string Name { get; set; }
        public string Group { get; set; }
        public int Ocen { get; set; }
        
        // конструктор с параметрами
        public Student(string Name, string Group, int Ocen)
        {
            this.Name = Name;
            this.Group = Group;
            this.Ocen = Ocen;
        }
        
        public string Show()
        {
            return (this.Name + ", " + this.Group + ", " + this.Ocen + ". ");
        }
    }
}
