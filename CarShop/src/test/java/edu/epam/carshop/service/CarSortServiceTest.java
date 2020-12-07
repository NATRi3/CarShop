package edu.epam.carshop.service;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.FileReaderException;
import edu.epam.carshop.exception.ServiceException;
import edu.epam.carshop.exception.SortServiceException;
import edu.epam.carshop.reader.FileShopReader;
import edu.epam.carshop.service.impl.CarFactory;
import edu.epam.carshop.service.impl.CarFindShopShopServiceImpl;
import edu.epam.carshop.service.impl.CarSortServiceImpl;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class CarSortServiceTest {
    public static final CarFindShopService carFindShopService = new CarFindShopShopServiceImpl();
    public static ArrayList<Car> expected = new ArrayList<Car>();
    @BeforeMethod
    public static void createCarShop() throws FileReaderException, ServiceException {
        CarFactory.INSTANCE.create(756443, "Polo", Brand.WV, 2008, Color.WHITE, BigDecimal.valueOf(13000), "9952");
        CarFactory.INSTANCE.create(245124, "Corolla", Brand.TOUOTA, 2004, Color.RED, BigDecimal.valueOf(20000), "6533");
    }

    @AfterMethod
    public static void cleanCarShop(){
        CarShop.INSTANCE.set(new ArrayList<Car>());
        expected = new ArrayList<Car>();
    }


    @Test
    public void testCarShopSortByBrand() throws SortServiceException, ServiceException {
        CarSortServiceImpl carSortService = new CarSortServiceImpl();
        carSortService.carShopSortByBrand();
        expected.add(new Car(245124, "Corolla", Brand.TOUOTA, 2004, Color.RED, BigDecimal.valueOf(20000), "6533"));
        expected.add(new Car(756443, "Polo", Brand.WV, 2008, Color.WHITE, BigDecimal.valueOf(13000), "9952"));
        Assert.assertEquals(carFindShopService.findAll(),expected);
    }

    @Test
    public void testCarShopSortById() throws SortServiceException, ServiceException {
        CarSortServiceImpl carSortService = new CarSortServiceImpl();
        carSortService.carShopSortByBrand();
        expected.add(new Car(245124, "Corolla", Brand.TOUOTA, 2004, Color.RED, BigDecimal.valueOf(20000), "6533"));
        expected.add(new Car(756443, "Polo", Brand.WV, 2008, Color.WHITE, BigDecimal.valueOf(13000), "9952"));
        Assert.assertEquals(carFindShopService.findAll(),expected);
    }

    @Test
    public void testCarShopSortByModel() throws SortServiceException, ServiceException {
        CarSortServiceImpl carSortService = new CarSortServiceImpl();
        carSortService.carShopSortByBrand();
        expected.add(new Car(245124, "Corolla", Brand.TOUOTA, 2004, Color.RED, BigDecimal.valueOf(20000), "6533"));
        expected.add(new Car(756443, "Polo", Brand.WV, 2008, Color.WHITE, BigDecimal.valueOf(13000), "9952"));
        Assert.assertEquals(carFindShopService.findAll(),expected);
    }

    @Test
    public void testCarShopSortByPrice() throws SortServiceException, ServiceException {
        CarSortServiceImpl carSortService = new CarSortServiceImpl();
        carSortService.carShopSortByBrand();
        expected.add(new Car(245124, "Corolla", Brand.TOUOTA, 2004, Color.RED, BigDecimal.valueOf(20000), "6533"));
        expected.add(new Car(756443, "Polo", Brand.WV, 2008, Color.WHITE, BigDecimal.valueOf(13000), "9952"));
        Assert.assertEquals(carFindShopService.findAll(),expected);
    }
}