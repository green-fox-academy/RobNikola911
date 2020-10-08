package allabouthashmaps;

import java.util.HashMap;
import java.util.Map;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Double> products = new HashMap<>();
        products.put("Milk", 1.07);
        products.put("Rice", 1.59);
        products.put("Eggs", 3.14);
        products.put("Cheese", 12.60);
        products.put("Chicken Breasts", 9.40);
        products.put("Apples", 2.31);
        products.put("Tomato", 2.58);
        products.put("Potato", 1.75);
        products.put("Onion", 1.10);

        HashMap<String, Integer> shoppingListBob = new HashMap<>();
        shoppingListBob.put("Milk", 3);
        shoppingListBob.put("Rice", 6);
        shoppingListBob.put("Eggs", 2);
        shoppingListBob.put("Cheese", 1);
        shoppingListBob.put("Chicken Breasts", 4);
        shoppingListBob.put("Apples", 1);
        shoppingListBob.put("Tomato", 2);
        shoppingListBob.put("Potato", 1);

        HashMap<String, Integer> shoppingListAlice = new HashMap<>();
        shoppingListAlice.put("Rice", 5);
        shoppingListAlice.put("Eggs", 2);
        shoppingListAlice.put("Chicken Breasts", 10);
        shoppingListAlice.put("Apples", 1);
        shoppingListAlice.put("Tomato", 2);

        System.out.println("How much does Bob pay? " + totalPrice(products, shoppingListBob));
        System.out.println("How much does Alice pay? " + totalPrice(products, shoppingListAlice));
        System.out.println("Who buys more Rice? " + whomore("Alice", shoppingListAlice, "Bob", shoppingListBob, "Rice"));
        System.out.println("Who buys more Potato? " + whomore("Alice", shoppingListAlice, "Bob", shoppingListBob, "Potato"));
        System.out.println("Who buys more different products? " + moreDiff("Alice", shoppingListAlice, "Bob", shoppingListBob));
        System.out.println("Who buys more products? (piece) " + morePiece("Bob", shoppingListBob, "Alice", shoppingListAlice));
        //System.out.println("Who buys more products? (piece) " + morePiece2(shoppingListBob,shoppingListAlice));
        //System.out.println(method(shoppingListBob,shoppingListAlice));
        System.out.println(tryMethod(shoppingListBob));

    }

    private static String tryMethod(HashMap<String, Integer> hm) {
        String result = "";
        for (String each : hm.keySet()) {
            result += each + ", ";
        }
        return result.trim();
    }

    private static String morePiece(String first, HashMap<String, Integer> shoppingListBob, String second, HashMap<String, Integer> shoppingListAlice) {
        int bob = sumOfValues(shoppingListBob);
        int alice = sumOfValues(shoppingListAlice);

        return bob > alice ? first : (bob == alice ? "draw" : second);
    }

    private static int sumOfValues(HashMap<String, Integer> parameter) {
        int sum = 0;
        for (Integer value : parameter.values()) {
            sum += value;
        }
        return sum;
    }

    private static String moreDiff(String nameFirst, HashMap<String, Integer> shoppingListFirst, String nameSecond, HashMap<String, Integer> shoppingListSecond) {
        return shoppingListFirst.size() > shoppingListSecond.size() ? nameFirst : (shoppingListFirst.size() == shoppingListSecond.size() ? "draw" : nameSecond);
    }

    private static String whomore(String firstPersonName, HashMap<String, Integer> shoppingListFirst, String secondPersonName, HashMap<String, Integer> shoppingListSecond, String comparedProduct) {
        if (shoppingListFirst.get(comparedProduct) == null || shoppingListSecond.get(comparedProduct) == null) {
            return "someone did not buy compared product";
        }

        return shoppingListFirst.get(comparedProduct) > shoppingListSecond.get(comparedProduct) ? firstPersonName :
                (shoppingListFirst.get(comparedProduct) == shoppingListSecond.get(comparedProduct) ? "draw" : secondPersonName);
    }

    private static double totalPrice(HashMap<String, Double> products, HashMap<String, Integer> shoppingList) {
        double totalPrice = 0.0;
        for (Map.Entry<String, Double> product : products.entrySet()) {
            for (Map.Entry<String, Integer> boughItem : shoppingList.entrySet()) {
                if (product.getKey().equals(boughItem.getKey())) {
                    totalPrice += product.getValue() * boughItem.getValue();
                }
            }
        }
        return totalPrice;
    }
}