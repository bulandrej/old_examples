package com.company;

import java.util.Comparator;

public class ResultRaceComparator implements Comparator<Horse> {
    public int compare(Horse h1, Horse h2) {
        if ((h1.getResultRace() - h2.getResultRace())>0) {
            return (1);
        } else if ((h1.getResultRace() - h2.getResultRace())<0) {
            return (-1);
        } else return (0);
    }
}




