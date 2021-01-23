package edu.epam.carshop.service;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.FileReaderException;
import edu.epam.carshop.exception.ServiceException;
import edu.epam.carshop.service.impl.CarFactory;
import edu.epam.carshop.service.impl.CarFindShopShopServiceImpl;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class CarFactoryTest {
    public static final CarFindShopService carFindShopService = new CarFindShopShopServiceImpl();
    public static ArrayList<Car> expected = new ArrayList<Car>();

    @AfterMethod
    public static void cleanCarShop(){
        CarShop.INSTANCE.set(new ArrayList<Car>());
        expected = new ArrayList<Car>();
    }

    @Test
    public void testCreateUpdateDelete() throws ServiceException {
        boolean result = true;
        Car car = new Car(756443, "Polo", Brand.WV, 2008, Color.WHITE, BigDecimal.valueOf(13000), "9952");
        CarFactory.INSTANCE.create(car);
        expected.add(car);
        if(!(carFindShopService.findAll().equals(expected))){
            result = false;
        }
        Car carUpdated = new Car(756443, "Polo", Brand.WV, 2008, Color.RED, BigDecimal.valueOf(13000), "9952");
        if(!(CarFactory.INSTANCE.update(carUpdated).equals(carUpdated))){
            result = false;
        }
        CarFactory.INSTANCE.delete(carUpdated);
        if(!(carFindShopService.findAll().equals(null))) {
            result = false;
        }
        Assert.assertTrue(result);
    }
}