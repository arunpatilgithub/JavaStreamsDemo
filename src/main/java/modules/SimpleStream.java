package modules;

import testdata.DishTestData;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SimpleStream {

    public static void main(String[] args) {

        DishTestData testData = new DishTestData();

        List<DishTestData.Dish> dishes = testData.getDishes();
        dishes.stream().forEach(System.out::println);

    }
}
