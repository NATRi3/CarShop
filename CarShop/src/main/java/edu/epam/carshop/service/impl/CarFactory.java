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
import java.util.List;

public class CarFactory {
    private static final Logger logger = LogManager.getLogger(CarFindShopShopServiceImpl.class);
    public static final CarFactory INSTANCE = new CarFactory();
    private static final CarDaoImpl carDao = new CarDaoImpl();

    private CarFactory(){      }
    public Car create(String model, Brand brand, int year, Color color, BigDecimal price, String number) throws ServiceException {
        return create(new IdCarCreator().idCreator(),model,brand,year,color,price,number);
    }

    public Car create(int id, String model, Brand brand, int year, Color color, BigDecimal price, String number) throws ServiceException {
        Car createdCar = new Car(id, model, brand, year, color, price, number);
        return create(createdCar);
    }

    public Car create(Car car) throws ServiceException {
        if(car.getId()<=0||car.getPrice().compareTo(BigDecimal.valueOf(0))<=0
                ||1990>=car.getYear()||car.getYear()>2020){
            logger.error("Wrong argument");
            throw new ServiceException("Wrong argument");
        }
        return carDao.create(car);
    }

    public boolean delete(Car car) throws ServiceException {
        return carDao.delete(car.getId());
    }

    public Car update (Car carUpdate) throws ServiceException {
        if(carUpdate.getId()<=0||carUpdate.getPrice().compareTo(BigDecimal.valueOf(0))<=0
                ||1990>=carUpdate.getYear()||carUpdate.getYear()>2020){
            logger.error("Wrong argument");
            throw new ServiceException("Wrong argument");
        }
        return carDao.update(carUpdate);
    }
}
