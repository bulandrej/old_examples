package com.company;
import java.util.Comparator;

public class AgeComparator implements Comparator<UO> {
    public int compare(UO uo1, UO uo2) {
        if ((uo1.getAge() - uo2.getAge()) > 0) {
            return (-1);
        } else if ((uo1.getAge() - uo2.getAge()) < 0) {
            return (1);
        } else return (0);
    }
}