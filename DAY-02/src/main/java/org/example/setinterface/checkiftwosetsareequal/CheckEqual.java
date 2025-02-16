package org.example.setinterface.checkiftwosetsareequal;

import java.util.Set;

class CheckEqual {
    boolean checkEqual(Set<Integer> set1, Set<Integer> set2){
        if(set1.size() != set2.size()){
            return false;
        }
        return (set1.containsAll(set2));
    }
}
