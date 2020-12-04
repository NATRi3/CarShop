package edu.epam.carshop.dao;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.DAOException;

import java.math.BigDecimal;
import java.util.List;

public interface CarDao extends BaseDao<Integer, Car> {
    List<Car> findAll() throws DAOException;
    Car findEntityById (Integer id) throws DAOException;
    boolean delete (Car car);
    boolean delete (Integer id);
    Car create (Car car);
    Car update (Car car);
}
