using System.Collections.Generic;

namespace Exam
{
    class SortAtAge : IComparer<AbstrClass>

    {
        public int Compare(AbstrClass S1, AbstrClass S2)
        {
            if (S1.Age > S2.Age)
            {
                return 1;
            }
            else if (S1.Age < S2.Age)
            {
                return -1;
            }
            return 0;
        }
    }
}
