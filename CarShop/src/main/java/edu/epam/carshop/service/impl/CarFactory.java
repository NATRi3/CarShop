package edu.epam.carshop.service.impl;

import edu.epam.carshop.dao.impl.CarDaoImpl;
import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.DAOException;
import edu.epam.carshop.exception.ServiceException;
import edu.epam.carshop.util.IdCarCreator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class CarFactory {
    private static final Logger logger = LogManager.getLogger(CarFindShopShopServiceImpl.class);
    public static final CarFactory INSTANCE = new CarFactory();
    private static final CarDaoImpl carDao = new CarDaoImpl();

    private CarFactory(){      }
    public Car create(String model, Brand brand, int year, Color color, BigDecimal price, String number) throws ServiceException {
        if(price.compareTo(BigDecimal.valueOf(0))<=0||year<=1900||year>=2021){
            logger.error("Wrong argument");
            throw new ServiceException("Wrong argument");
        }
        return new Car(new IdCarCreator().idCreator(), model, brand, year, color, price, number);
    }

    public Car create(int id, String model, Brand brand, int year, Color color, BigDecimal price, String number) throws ServiceException {
        if(id<=0||price.compareTo(BigDecimal.valueOf(0))<=0||year<=1900||year>=2021){
            logger.error("Wrong argument");
            throw new ServiceException("Wrong argument");
        }
        Car createdCar = new Car(id, model, brand, year, color, price, number);
        carDao.create(createdCar);
        try {
            return carDao.findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    public Car create(Car car) throws ServiceException {
        if(car.getId()<=0||car.getPrice().compareTo(BigDecimal.valueOf(0))<=0
                ||1990<=car.getYear()||car.getYear()>=2020){
            logger.error("Wrong argument");
            throw new ServiceException("Wrong argument");
        }
        return carDao.create(car);
    }

    public boolean delete(Car car){
        return CarShop.INSTANCE.remove(car.getId());
    }

    public Car update (Car car) throws ServiceException {
        if(car.getId()<=0||car.getPrice().compareTo(BigDecimal.valueOf(0))<=0
                ||1990<=car.getYear()||car.getYear()>=2020){
            logger.error("Wrong argument");
            throw new ServiceException("Wrong argument");
        }
        if(CarShop.INSTANCE.remove(car.getId())){
            CarShop.INSTANCE.add(car);
            return car;
        }
        return null;
    }
}
