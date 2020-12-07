package edu.epam.carshop.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class CarShop implements Shop<Car>{
    private static final Logger logger = LogManager.getLogger(CarShop.class);
    public static final CarShop INSTANCE = new CarShop();
    private List<Car> cars = new ArrayList<Car>();

    private CarShop() { }

    public List<Car> getCars(){
        return new ArrayList<>(cars);
    }


    @Override
    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public void remove(int idList){
        cars.remove(cars.get(idList));
    }

    @Override
    public Car get(int idList) {
        return cars.get(idList);
    }

    @Override
    public void set(List<Car> cars) {
        this.cars = cars;
    }
}

