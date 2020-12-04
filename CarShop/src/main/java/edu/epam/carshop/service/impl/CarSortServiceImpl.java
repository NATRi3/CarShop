package edu.epam.carshop.service.impl;

import edu.epam.carshop.dao.impl.CarDaoImpl;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.exception.DAOException;
import edu.epam.carshop.exception.SortServiceException;
import edu.epam.carshop.service.CarSortService;
import edu.epam.carshop.util.CarComparator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.List;

public class CarSortServiceImpl implements CarSortService {
    private static final Logger logger = LogManager.getLogger(CarSortServiceImpl.class);

    public void carShopSortByBrand() throws SortServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> carList;
        try {
            carList = carDao.findAll();
            if (carList!=null){
                carList.sort(CarComparator.BRAND);
                carDao.updateAll(carList);
            }else {
                logger.error("CarShop is empty.");
                throw new SortServiceException("CarShop is empty.");
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    public void carShopSortById() throws SortServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> carList;
        try {
            carList = carDao.findAll();
            if (carList!=null){
                carList.sort(CarComparator.ID);
                carDao.updateAll(carList);
            }else {
                logger.error("CarShop is empty.");
                throw new SortServiceException("CarShop is empty.");
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    public void carShopSortByModel() throws SortServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> carList;
        try {
            carList = carDao.findAll();
            if (carList!=null){
                carList.sort(CarComparator.MODEL);
                carDao.updateAll(carList);
            }else {
                logger.error("CarShop is empty.");
                throw new SortServiceException("CarShop is empty.");
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    public void carShopSortByPrice() throws SortServiceException {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> carList;
        try {
            carList = carDao.findAll();
            if (carList!=null){
                carList.sort(CarComparator.PRICE);
                carDao.updateAll(carList);
            }else {
                logger.error("CarShop is empty.");
                throw new SortServiceException("CarShop is empty.");
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
