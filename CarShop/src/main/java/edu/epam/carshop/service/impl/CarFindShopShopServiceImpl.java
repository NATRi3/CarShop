package edu.epam.carshop.service.impl;

import edu.epam.carshop.dao.impl.CarDaoImpl;
import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.DAOException;
import edu.epam.carshop.exception.ServiceException;
import edu.epam.carshop.service.CarFindShopService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class CarFindShopShopServiceImpl implements CarFindShopService {
    private static final Logger logger = LogManager.getLogger(CarFindShopShopServiceImpl.class);

    @Override
    public List<Car> findAll() throws ServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> carList = null;
        try {
            carList = carDao.findAll();
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return carList;
    }

    @Override
    public List<Car> findAllBy(Brand brand) throws ServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> result = null;
        try {
            List <Car> carList = carDao.findAll();
            result = carList.stream().filter(car -> car.getBrand().equals(brand))
                                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return result;
    }

    @Override
    public List<Car> findAllBy(Color color) throws ServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> result = null;
        try {
            List <Car> carList = carDao.findAll();
            result = carList.stream().filter(car -> car.getColor().equals(color))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return result;
    }

    @Override
    public Car findCarBy(int id) throws ServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        Car result = null;
        try {
            if (carDao.findEntityById(id)!=null){
                result=carDao.findEntityById(id);
            } else {
                logger.info("Car not found.");
            }
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return result;
    }

    @Override
    public Car findCarBy(Car car) throws ServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        Car result = null;
        try {
            if (!carDao.findEntityById(car.getId()).equals(car)){
                result=carDao.findEntityById(car.getId());
            } else {
                logger.info("Car not found.");
            }
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return result;
    }

    @Override
    public List<Car> findCarBy(String number) throws ServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> result = null;
        try {
            List <Car> carList = new ArrayList<>(carDao.findAll());
            result = carList.stream().filter(car -> car.getNumber().equals(number))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return result;
    }
}
