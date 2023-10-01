package oy.interact.tira.student;

import java.util.Comparator;

import oy.interact.tira.model.Coder;

public class CoderFullNameComparator implements Comparator<Coder> {

    @Override
    public int compare(Coder coder1, Coder coder2) {

        if (coder1 != null && coder2 != null) {
            return coder1.getFullName().compareTo(coder2.getFullName());
        }
        // If one of the coders is null, return -2
        return -2;
    }
}
