package lectures;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import beans.Car;
import mockdata.MockData;

public class Lecture11 {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        String join = "";

        for (String name : names) {
            join += name + ", ";
        }

        System.out.println(join.substring(0, join.length() - 2));

    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        String join = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining("|"));

        System.out.println(join);
    }

    @Test
    public void joiningCarWithStream() throws Exception {
        List<Car> cars = MockData.getCars();

        String join = cars.stream()
                .map(Car::getModel)
                .distinct()
                .collect(Collectors.joining("|"));

        System.out.println(join);
    }
}
