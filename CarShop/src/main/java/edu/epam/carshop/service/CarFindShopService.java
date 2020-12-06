package edu.epam.carshop.service;

import edu.epam.carshop.dao.impl.CarDaoImpl;
import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.DAOException;
import edu.epam.carshop.exception.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface CarFindShopService {
    public List<Car> findAll() throws ServiceException;
    public List<Car> findAllBy(Brand brand) throws ServiceException;
    public List<Car> findAllBy(Color color) throws ServiceException;
    public Car findCarBy(int id) throws ServiceException ;
    public Car findCarBy(Car car) throws ServiceException ;
    public List<Car> findAllBy(String number) throws ServiceException;
}
