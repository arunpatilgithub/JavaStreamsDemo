package testdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

import static testdata.DishTestData.Type.*;


public class DishTestData {

    public enum Type { MEAT, FISH, OTHER }

    public List<Dish> getDishes() {

        return Arrays.asList(
                new Dish("pork", false, 800, MEAT),
                new Dish("beef", false, 700, MEAT),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, OTHER),
                new Dish("rice", true, 350, OTHER),
                new Dish("season fruit", true, 120, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH) );
    }

    @Getter
    @AllArgsConstructor
    public class Dish {

        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final testdata.DishTestData.Type type;

        @Override
        public String toString() {
            return name;
        }

    }
}
