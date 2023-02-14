package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private int CARS_COUNT;
    private List<Car> listOfCars;
    @Autowired
    public CarDaoImpl(List<Car> listOfCars) {
        this.listOfCars = listOfCars;
        listOfCars.add(new Car(++CARS_COUNT,"Model_1", "series_1"));
        listOfCars.add(new Car(++CARS_COUNT,"Model_2", "series_2"));
        listOfCars.add(new Car(++CARS_COUNT,"Model_3", "series_3"));
        listOfCars.add(new Car(++CARS_COUNT,"Model_4", "series_4"));
        listOfCars.add(new Car(++CARS_COUNT,"Model_5", "series_5"));
    }

    @Override
    public List<Car> getListCar(Integer count) {
        //count =0;
        if (count == null || count <= 0 || count > CARS_COUNT) {
            System.out.println("все пять" + listOfCars.toString());
            return listOfCars;
        } else {
            return listOfCars.subList(0, count);
        }
    }
}
