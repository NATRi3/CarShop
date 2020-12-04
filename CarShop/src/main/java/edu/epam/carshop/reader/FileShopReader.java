package edu.epam.carshop.reader;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.FileReaderException;
import edu.epam.carshop.exception.ServiceException;
import edu.epam.carshop.service.impl.CarFactory;
import edu.epam.carshop.util.IdCarCreator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class FileShopReader {
    private static final Logger logger = LogManager.getLogger(FileShopReader.class);
    private static final String path = "data//data.txt";
    public void readShopFromFile() throws FileReaderException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String read;
            IdCarCreator idCarCreator = new IdCarCreator();
            while ((read=reader.readLine())!=null) {
                String[] str = read.split(", ");
                try {
                    CarFactory.INSTANCE.create(Integer.parseInt(str[0]),str[1],Brand.valueOf(str[2]),
                                Integer.parseInt(str[3]), Color.valueOf(str[4]),BigDecimal.valueOf(Integer.parseInt(str[5])),str[6]);
                } catch (ServiceException e) {
                    throw new FileReaderException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
