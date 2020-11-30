package edu.epam.carshop;

import edu.epam.carshop.entity.Car;
import edu.epam.carshop.exception.DAOException;
import edu.epam.carshop.service.CarShopDao;

import java.util.List;

public class App {
    public static void main(String[] args) throws DAOException {
        CarShopDao carShopDao = new CarShopDao();
        try {
            carShopDao.connect();
            List<Car> list = carShopDao.findAll();
            for(Car i:list){
                System.out.println(i);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        finally {
            carShopDao.close();
        }
    }
}
