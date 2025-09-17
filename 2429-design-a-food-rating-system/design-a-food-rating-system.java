
class FoodRatings {
    private static class Food implements Comparable<Food> {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food other) {
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating); // higher rating first
            }
            return this.name.compareTo(other.name); // lexicographically smaller name
        }
    }

    private Map<String, TreeSet<Food>> cuisineRatings; // cuisine -> foods
    private Map<String, String> foodCuisine;           // food -> cuisine
    private Map<String, Food> foodObjects;             // food -> Food object (to update rating)

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineRatings = new HashMap<>();
        foodCuisine = new HashMap<>();
        foodObjects = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            Food foodObj = new Food(food, rating);
            foodCuisine.put(food, cuisine);
            foodObjects.put(food, foodObj);

            cuisineRatings.putIfAbsent(cuisine, new TreeSet<>());
            cuisineRatings.get(cuisine).add(foodObj);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisine.get(food);
        Food oldFoodObj = foodObjects.get(food);

        // Remove old object
        cuisineRatings.get(cuisine).remove(oldFoodObj);

        // Create new object with updated rating
        Food newFoodObj = new Food(food, newRating);
        cuisineRatings.get(cuisine).add(newFoodObj);

        // Update reference
        foodObjects.put(food, newFoodObj);
    }

    public String highestRated(String cuisine) {
        return cuisineRatings.get(cuisine).first().name;
    }
}