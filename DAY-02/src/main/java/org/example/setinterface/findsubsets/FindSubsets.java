package org.example.setinterface.findsubsets;

import java.util.HashSet;
import java.util.Set;
class FindSubsets {

         <T> boolean checkSubset(Set<T> subset, Set<T> superset) {
            // Use the containsAll() method to check if all elements of subset are in superset
            return superset.containsAll(subset);
        }
    }
