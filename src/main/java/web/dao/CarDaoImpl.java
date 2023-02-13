package web.dao;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDaoImpl implements CarDao {
    private static final List<Car> getListCar = new ArrayList<>();

    static {
        getListCar.add(new Car("Model_1", "series_1", 2001));
        getListCar.add(new Car("Model_2", "series_1", 2002));
        getListCar.add(new Car("Model_3", "series_1", 2003));
        getListCar.add(new Car("Model_4", "series_1", 2004));
        getListCar.add(new Car("Model_5", "series_1", 2005));
    }
    @Override
    public List<Car> getListCar(int count) {
        if (count == 0) {
            return getListCar;
        }
        return getListCar.stream().limit(count).collect(Collectors.toList());
    }
}
