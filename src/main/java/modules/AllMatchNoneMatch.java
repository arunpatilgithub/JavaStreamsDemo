package modules;

import testdata.DishTestData;

public class AllMatchNoneMatch {

    public static void main(String[] args) {

        boolean isHealthy = new DishTestData().getDishes().stream()
                .allMatch(d -> d.getCalories() < 1000);

        isHealthy = new DishTestData().getDishes().stream()
                .noneMatch(d -> d.getCalories() >= 1000);

    }
}
