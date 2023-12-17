package design;

import java.util.*;

public class M2353DesignFoodRatingSystem {
    private final Map<String, Food> foods;
    private final Map<String, TreeSet<Food>> cuisines;

    public M2353DesignFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = new HashMap<>();
        this.cuisines = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            this.foods.put(food.getName(), food);
            this.cuisines.computeIfAbsent(food.getCuisine(), val -> new TreeSet<>()).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food curr = foods.get(food);
        TreeSet<Food> currFoods = cuisines.get(curr.getCuisine());
        currFoods.remove(curr);
        curr.setRating(newRating);
        currFoods.add(curr);
    }

    public String highestRated(String cuisine) {
        return cuisines.get(cuisine).first().getName();
    }

    private static class Food implements Comparable<Food> {
        private String name;
        private String cuisine;
        private int rating;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food o) {
            return o.rating == this.rating ? this.name.compareTo(o.name) : o.rating - this.rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getName() {
            return this.name;
        }

        public String getCuisine() {
            return this.cuisine;
        }
    }
}
