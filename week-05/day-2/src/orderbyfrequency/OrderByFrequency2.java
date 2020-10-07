package orderbyfrequency;

import java.util.*;

public class OrderByFrequency2 {
    public static void main(String[] args) {
        List example1 = new ArrayList();
        example1.addAll(List.of(1, 1, 1, 2, 2, 3));
        List example2 = new ArrayList();
        example2.addAll(List.of(8, 9, 3, 8, 9, 9, 9, 3, 1, 1));

        System.out.println(orderByFrequency(example1));
    }

    public static List orderByFrequency(List items) {
        //Approach:
    /*
    -Creation of hashmap for calculating of occurances
    -creation of tempArraylist for sorting of values
    -creation of finalArray for adding of keys, which equals the values from tempArraylist
     */

        HashMap<Object, Integer> occurencesMap = new HashMap<>();
        for (Object item : items) {
            if (occurencesMap.containsKey(item)) {
                occurencesMap.put(item, occurencesMap.get(item) + 1);
            } else {
                occurencesMap.put(item, 1);
            }
        }

        List tempList = new ArrayList();
        for (Map.Entry<Object, Integer> entry : occurencesMap.entrySet()) {
            tempList.add(entry.getValue());
        }

        Collections.sort(tempList);

        List finalOrder = new ArrayList();
        for (int i = 0; i < tempList.size(); i++) {
            for (Map.Entry<Object, Integer> entry : occurencesMap.entrySet()) {
                if (entry.getValue() == tempList.get(i)) {
                    finalOrder.add(i, entry.getKey());
                    occurencesMap.remove(entry.getKey());
                    break;
                }
            }
        }
        return finalOrder;
    }
}
