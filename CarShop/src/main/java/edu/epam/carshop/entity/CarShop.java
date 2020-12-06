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
    public boolean remove(int id){
        boolean result = false;
        if (!cars.isEmpty()) {
            for(int i = 0; i<cars.size();i++){
                if(cars.get(i).getId()==id){
                    cars.remove(cars.get(i));
                   // logger.info("Car removed.");
                    result = true;
                }
            }
           // logger.info("Car not found.");
        }
        else{
       //     logger.info("Garage is empty.");
        }
        return result;
    }

    @Override
    public Car get(int id) {
        Car result = null;
        if (!cars.isEmpty()) {
            for(Car car: cars){
                if(car.getId()==id){
                    result = car;
                }
            }
            if(result == null) {
                logger.info("Car not found.");
            }
        }
        else{
            logger.info("Garage is empty.");
        }
        return result;
    }

    @Override
    public void set(List<Car> cars) {
        this.cars = cars;
    }
}

