package org.example.setinterface.symmetricdifference;

import java.util.HashSet;
import java.util.Set;

class SymmetricDifference {
    <T> Set<T> symmetricDifference(Set<T> set1,Set<T>set2){
        Set<T> hs = new HashSet<>(set1);

        hs.addAll(set2);

        Set<T> inter = new HashSet<>(set1);
        inter.retainAll(set2);

        hs.removeAll(inter);

        return hs;
    }
}
