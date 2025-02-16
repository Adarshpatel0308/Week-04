package org.example.setinterface.convertset_to_sortedlist;

import java.util.*;


class Convert{
    <T extends Comparable<T>> List<T> SortedList(Set<T> hs){

        List<T> result = new ArrayList<>(hs);

        Collections.sort(result);

        return result;
    }
}
