package org.example.listinterface.removeduplicateswhilepreservingorder;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class RemoveDuplicate {
    Set<Integer> removeDuplicate(List<Integer> sampleList){

        Set<Integer> hs = new LinkedHashSet<>(sampleList);
        return hs;
    }
}
