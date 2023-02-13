package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarDaoImpl implements CarDao {
    private static int CARS_COUNT;
    private static List<Car> listOfCars;

    static {
        listOfCars = new ArrayList<>();

        listOfCars.add(new Car(++CARS_COUNT,"Model_1", "series_1"));
        listOfCars.add(new Car(++CARS_COUNT,"Model_2", "series_2"));
        listOfCars.add(new Car(++CARS_COUNT,"Model_3", "series_3"));
        listOfCars.add(new Car(++CARS_COUNT,"Model_4", "series_4"));
        listOfCars.add(new Car(++CARS_COUNT,"Model_5", "series_5"));
    }
//    @Override
//    public List<Car> getListCar(Integer count) {
//        if (count >= CARS_COUNT) {
//            return listOfCars;
//        }
//        return listOfCars.stream().limit(count).collect(Collectors.toList());
//    }
    @Override
    public List<Car> getListCarFull() {
            return listOfCars;
    }
}
