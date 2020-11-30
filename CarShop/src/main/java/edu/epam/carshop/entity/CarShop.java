/*package edu.epam.carshop.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CarShop {
    private static final Logger logger = LogManager.getLogger(CarShop.class);
    private ArrayList<Car> cars = new ArrayList<Car>();

    public CarShop() {

    }

    public CarShop(List<Car> cars){
            this.cars= (ArrayList<Car>) cars;
    }

    public void addCar(Car car) {
            cars.add(car);
    }

    public void removeCar(int id){
        if (!cars.isEmpty()) {
            for(Car car: cars){
                if(car.getId()==id){
                    cars.remove(car);
                    logger.info("Car removed.");
                    return;
                }
            }
            logger.info("Car not found.");
        }
        else{
            logger.info("Garage is empty.");
        }
    }

    public Car getCar(int id) {
        if (!cars.isEmpty()) {
            for(Car car: cars){
                if(car.getId()==id){
                    return car;
                }
            }
            logger.info("Car not found.");
        }
        else{
            logger.info("Garage is empty.");
        }
        logger.info("Car wasn't found");
        return null;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
}*/

