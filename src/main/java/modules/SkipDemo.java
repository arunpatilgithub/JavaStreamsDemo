package modules;

import testdata.DishTestData;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SkipDemo {

    public static void main(String[] args) {

        DishTestData testData = new DishTestData();

        List<DishTestData.Dish> menu = testData.getDishes();

        List<DishTestData.Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());

    }
}
