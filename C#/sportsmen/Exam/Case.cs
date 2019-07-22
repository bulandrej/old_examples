using System.Collections.Generic;
using System.Linq;
using System.Collections;

namespace Exam
{
    class Case<T> : IEnumerable
        where T : AbstrClass
    {
        List<AbstrClass> athletes = new List<AbstrClass>();

        public AbstrClass this[int i]
        {
            get { return (AbstrClass)athletes[i]; }
            set
            {
                if (i > -1) athletes.Add(value);
            }
        }

        public void Add(AbstrClass f)
        {
            athletes.Add(f);
        }

        public int Length
        {
            get { return athletes.Count; }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return athletes.GetEnumerator();
        }
        // сортировка массива спортсменов по возрасту
        public void SortAthletes()
        {
            SortAtAge sa = new SortAtAge();
            athletes.Sort( 0, athletes.Count(), sa);
        }
    }
}
