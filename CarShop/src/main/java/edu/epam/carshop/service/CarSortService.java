package edu.epam.carshop.service;

import edu.epam.carshop.dao.impl.CarDaoImpl;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.exception.DAOException;
import edu.epam.carshop.exception.SortServiceException;
import edu.epam.carshop.util.CarComparator;

import java.util.List;

public interface CarSortService {
    public void carShopSortByBrand() throws SortServiceException;
    public void carShopSortById() throws SortServiceException;
    public void carShopSortByModel() throws SortServiceException;
    public void carShopSortByPrice() throws SortServiceException;
}
