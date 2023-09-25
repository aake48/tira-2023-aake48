package oy.interact.tira.student;

import java.util.Comparator;

import oy.interact.tira.model.Coder;

public class CoderNameComparator implements Comparator<Coder> {

    @Override
    public int compare(Coder coder1, Coder coder2) {
        if (coder1 != null && coder2 != null) {
            return coder1.getCoderName().compareTo(coder2.getCoderName());
        }
        // If one of the coders is null, return -2
        return -2;
    }
}
