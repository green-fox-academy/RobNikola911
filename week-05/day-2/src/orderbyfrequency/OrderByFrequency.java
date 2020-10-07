package orderbyfrequency;

import java.util.*;

public class OrderByFrequency {
    public static void main(String[] args) {
        int[] intArray = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3};
        int[] intArray2 = {8, 9, 3, 8, 9, 9, 9, 3, 1, 1};
        orderByFrequency(intArray);
        // return frequencies in ascending order

    }

    private static void orderByFrequency(int[] inputArray) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();
        for (int current : inputArray) {
            int count = map.getOrDefault(current, 0);
            map.put(current, count + 1);
            outputArray.add(current);
        }

        List<Integer> newListForMap = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (newListForMap.size() == 0) {
                newListForMap.add(entry.getKey());
            } else {
                for (int i = 0; i < newListForMap.size(); i++) {
                    if (map.get(newListForMap.get(i)) > entry.getValue()) {
                        newListForMap.add(i, entry.getKey());
                        break;
                    } else if (i == newListForMap.size() - 1) {
                        newListForMap.add(newListForMap.size(), entry.getKey());
                        break;
                    }
                }
            }
        }

        System.out.println(newListForMap);


//        List<Map.Entry<Integer, Integer>> allEntry = new ArrayList<>(map.entrySet());
//
//        List<Map.Entry<Integer, Integer>> sortedAllEntry = new ArrayList<>();

        Map<Integer, Integer> sortedMap = new HashMap<>();
        List<Integer> mapByValue = new ArrayList<>(map.values());
        List<Integer> mapByKey = new ArrayList<>(map.keySet());
        Collections.sort(mapByValue);
        for (int i = 0; i < mapByKey.size(); i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == mapByValue.get(i)) {
                    sortedMap.put(entry.getValue(), entry.getKey());
                }
            }
        }

        System.out.println(map);
        System.out.println(sortedMap.values());
    }
}

