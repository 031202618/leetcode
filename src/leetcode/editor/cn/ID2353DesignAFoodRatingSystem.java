package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ID2353DesignAFoodRatingSystem {

    public static void main(String[] args) {
        FoodRatings solution = new ID2353DesignAFoodRatingSystem().new FoodRatings(
                new String[]{"emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"},
                new String[]{"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"},
                new int[]{2, 6, 18, 6, 5}
        );
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.changeRating("qnvseohnoe", 11);
        solution.highestRated("fajbervsj");
        solution.changeRating("emgqdbo", 3);
        solution.changeRating("jmvfxjohq", 9);
        solution.changeRating("emgqdbo", 14);
        solution.highestRated("fajbervsj");
        solution.highestRated("snaxol");
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FoodRatings {

        Map<String, Queue<int[]>> cuisines2Food;
        Map<String, Integer> food2Rating;
        Map<String, Integer> food2Id;
        Map<String, String> food2Cuisine;
        Map<Integer, String> id2Food;


        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            cuisines2Food = new HashMap<>();
            food2Rating = new HashMap<>();
            id2Food = new HashMap<>();
            food2Cuisine = new HashMap<>();
            food2Id = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                String cuisine = cuisines[i];
                String food = foods[i];
                int rating = ratings[i];
                Queue<int[]> ints = cuisines2Food.get(cuisine);
                if (ints == null) {
                    ints = new PriorityQueue<>((x, y) -> x[0] == y[0] ? foods[x[1]].compareTo(foods[y[1]]) : y[0] - x[0]);
                }
                ints.add(new int[]{rating, i});
                cuisines2Food.put(cuisine, ints);
                food2Cuisine.put(food, cuisine);
                id2Food.put(i, food);
                food2Id.put(food, i);
            }
        }

        public void changeRating(String food, int newRating) {
            String cusine = food2Cuisine.get(food);
            Queue<int[]> ints = cuisines2Food.get(cusine);
            food2Rating.put(food, newRating);
            ints.add(new int[]{newRating, food2Id.get(food)});
//            if (fd.equals(food)) {
//                ints.poll();
//                ints.add(new int[]{newRating, id});
//            } else {
//                food2Rating.put(food, newRating);
//            }
        }

        public String highestRated(String cuisine) {
            Queue<int[]> ints = cuisines2Food.get(cuisine);
            while (true) {
                int[] peek = ints.peek();
                int rate = peek[0];
                int foodId = peek[1];
                Integer newRate = food2Rating.get(id2Food.get(foodId));
                if (newRate != null && newRate != rate) {
                    ints.poll();
                } else {
                    return id2Food.get(foodId);
                }
            }
        }
    }

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
//leetcode submit region end(Prohibit modification and deletion)


} 