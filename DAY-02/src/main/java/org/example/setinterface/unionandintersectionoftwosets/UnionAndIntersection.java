package org.example.setinterface.unionandintersectionoftwosets;

import java.util.LinkedHashSet;
import java.util.Set;

public class UnionAndIntersection {

//    Set<T> unionOfSets(Set<T> set1, Set<T> set2){
//        Set<T> hs1 = new LinkedHashSet<>(set1);
//
//       hs1.addAll(set2);
//
//       return hs1;
//    }

<T> Set<T> unionOfSets(Set<T> set1, Set<T> set2){
    Set<T> hs1 = new LinkedHashSet<>(set1);

    hs1.addAll(set2);

    return hs1;
}

   <T> Set<T> intersectionOfSets(Set<T> set1, Set<T> set2){

//        Set<T> hs2 = new LinkedHashSet<>(set1);
//
//        hs2.retainAll(set2);
//
//        return hs2;
//    }

        Set<T> hs2 = new LinkedHashSet<>(set1);

        hs2.retainAll(set2);

        return hs2;
    }

}
