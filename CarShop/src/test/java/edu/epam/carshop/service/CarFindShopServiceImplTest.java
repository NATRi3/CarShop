package edu.epam.carshop.service;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.FileReaderException;
import edu.epam.carshop.exception.ServiceException;
import edu.epam.carshop.reader.FileShopReader;
import edu.epam.carshop.service.impl.CarFindShopShopServiceImpl;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CarFindShopServiceImplTest {
    public static final CarFindShopService carFindShopService = new CarFindShopShopServiceImpl();
    public static ArrayList<Car> expected = new ArrayList<Car>();
    @BeforeMethod
    public static void createCarShop() throws FileReaderException, ServiceException {
        FileShopReader fileShopReader = new FileShopReader();
        fileShopReader.readShopFromFile();
        Assert.assertNotNull(CarShop.INSTANCE.getCars());
    }

    @AfterMethod
    public static void cleanCarShop(){
        CarShop.INSTANCE.set(new ArrayList<Car>());
        expected = new ArrayList<Car>();
    }

    @Test
    public void testFindAll() throws ServiceException {
        Assert.assertEquals(carFindShopService.findAll(), CarShop.INSTANCE.getCars());
    }

    @Test
    public void testFindAllByBrand() throws ServiceException {
        expected.add(new Car(476544, "Rapid", Brand.SKODA, 2003, Color.BLUE, BigDecimal.valueOf(23000), "9645"));
        expected.add(new Car(65434, "Rapid", Brand.SKODA, 2006, Color.YELLOW, BigDecimal.valueOf(2000), "7521"));
        ArrayList<Car> actual = new ArrayList<Car>(carFindShopService.findAllBy(Brand.SKODA));
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testFindAllByColor() throws ServiceException {
        expected.add(new Car(65434, "Rapid", Brand.SKODA, 2006, Color.YELLOW, BigDecimal.valueOf(2000), "7521"));
        ArrayList<Car> actual = new ArrayList<Car>(carFindShopService.findAllBy(Color.YELLOW));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindCarById() throws ServiceException {
        Car expected = new Car(65434, "Rapid", Brand.SKODA, 2006, Color.YELLOW, BigDecimal.valueOf(2000), "7521");
        Car actual = (carFindShopService.findCarBy(65434));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindCarByCar() throws ServiceException {
        Car expected = new Car(65434, "Rapid", Brand.SKODA, 2006, Color.YELLOW, BigDecimal.valueOf(2000), "7521");
        Car actual = (carFindShopService.findCarBy(expected));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindAllByNumber() throws ServiceException {
        expected.add(new Car(65434, "Rapid", Brand.SKODA, 2006, Color.YELLOW, BigDecimal.valueOf(2000), "7521"));
        ArrayList<Car> actual = new ArrayList<Car>(carFindShopService.findAllBy("7521"));
        Assert.assertEquals(actual, expected);
    }
}