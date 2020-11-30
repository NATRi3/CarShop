package edu.epam.carshop.service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.Color;
import edu.epam.carshop.exception.DAOException;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarShopDao{
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/carshop?useSSL=false";
    private Driver driver = null;
    private Connection connection = null;
    private Statement statement = null;
    public void connect() throws DAOException {
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = (Connection) DriverManager.getConnection(url, user, pass);
            Statement statement = (Statement) connection.createStatement();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }
    public void close() throws DAOException {
        try {
            if(statement!=null) {
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public List findAll() throws DAOException {
        List<Car> carShop = new ArrayList<Car>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT id, model, brand, year, color, price, number FROM carshop");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String model = resultSet.getString("model");
                Brand brand = Brand.valueOf(resultSet.getString("brand"));
                int year = resultSet.getInt("year");
                Color color = Color.valueOf(resultSet.getString("color"));
                BigDecimal price = resultSet.getBigDecimal("price");
                String number = resultSet.getString("number");
                carShop.add(new Car(id,model,brand,year,color,price,number));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return carShop;
    }

    public Car findEntityById(int id) throws DAOException {
        return null;
    }

    public boolean delete(int id) throws DAOException {
        return false;
    }

    public boolean create(Car car) throws DAOException {
        return false;
    }

    public Car update(int id) throws DAOException {
        return null;
    }
}
