package edu.epam.carshop.reader;

import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.exception.FileReaderException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class FileShopReaderTest {

    @AfterMethod
    public static void cleanCarShop(){
        CarShop.INSTANCE.set(new ArrayList<Car>());
    }

    @Test
    public void testReadShopFromFile() throws FileReaderException {
        FileShopReader fileShopReader = new FileShopReader();
        fileShopReader.readShopFromFile();
        Assert.assertNotNull(CarShop.INSTANCE.getCars());
    }
}