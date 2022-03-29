package modules;

import testdata.DishTestData;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LimitDemo {

    public static void main(String[] args) {

        DishTestData testData = new DishTestData();

        List<DishTestData.Dish> menu = testData.getDishes();

        List<DishTestData.Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
    }
}
