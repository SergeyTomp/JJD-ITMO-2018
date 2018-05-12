package hw12;

import java.util.Comparator;
import java.util.Map;

class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }
    @Override
    public int compare(String a, String b) {
        return base.get(b).compareTo(base.get(a));
    }
}
