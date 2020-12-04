package edu.epam.carshop.app;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.FileReaderException;
import edu.epam.carshop.exception.ServiceException;
import edu.epam.carshop.exception.SortServiceException;
import edu.epam.carshop.reader.FileShopReader;
import edu.epam.carshop.service.CarFindShopService;
import edu.epam.carshop.service.impl.CarFindShopShopServiceImpl;
import edu.epam.carshop.service.impl.CarSortServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws SortServiceException, FileReaderException, ServiceException {
        CarFindShopService carFindShopService = new CarFindShopShopServiceImpl();
        ArrayList<Car> expected = new ArrayList<Car>();
        FileShopReader fileShopReader = new FileShopReader();
        fileShopReader.readShopFromFile();
        boolean result = true;
        expected.add(new Car(476544, "Rapid", Brand.SKODA, 2003, Color.BLUE, BigDecimal.valueOf(23000), "9645"));
        expected.add(new Car(65434, "Rapid", Brand.SKODA, 2006, Color.YELLOW, BigDecimal.valueOf(2000), "7521"));
        ArrayList<Car> actual = new ArrayList<Car>(carFindShopService.findAllBy(Brand.SKODA));
        if(actual.size()!=expected.size()){
            result = false;
        }else {
            for(int i = 0; i<actual.size(); i++){
                System.out.println(actual.get(i));
                System.out.println(expected.get(i));
                System.out.println(actual.get(i).equals(expected.get(i)));
            }
        }
    }
}
