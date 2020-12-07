package edu.epam.carshop.dao.impl;

import edu.epam.carshop.dao.CarDao;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.exception.DAOException;

import java.util.List;

public class CarDaoImpl implements CarDao {
    //private static final String SQL_SELECT_ALL =
    //        "SELECT id, model, brand, year, color, price, number FROM carshop";
    //private static String user = "root";
    //private static String pass = "root";
    //private static String url = "jdbc:mysql://localhost:3306/carshop?useSSL=false";

    @Override
    public List<Car> findAll() throws DAOException {
        if(CarShop.INSTANCE.getCars()==null){
            throw new DAOException("The car shop is empty");
        }
        return CarShop.INSTANCE.getCars();
    }

    @Override
    public Car findEntityById(Integer id) throws DAOException {
        List <Car> carList = CarShop.INSTANCE.getCars();
        for(int i = 0; i<carList.size(); i++){
            if (carList.get(i).getId()==id){
                return CarShop.INSTANCE.get(i);
            }
        }
        throw new DAOException("Car not found.");
    }

    @Override
    public boolean delete(Car carDel) {
        boolean result = false;
        List <Car> carList = CarShop.INSTANCE.getCars();
        for(Car carFound: carList){
            if (carFound.equals(carDel)){
                CarShop.INSTANCE.remove(carFound.getId());
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        boolean result = false;
        List<Car> list = CarShop.INSTANCE.getCars();
        for (int i = 0; i<list.size();i++) {
            if (list.get(i).getId() == id) {
                CarShop.INSTANCE.remove(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Car create(Car car){
        CarShop.INSTANCE.add(car);
        return CarShop.INSTANCE.get(CarShop.INSTANCE.getCars().size()-1);
    }

    @Override
    public Car update(Car car) {
        List<Car> carList = CarShop.INSTANCE.getCars();
        Car carUpdate = null;
        for(int i = 0; i<carList.size();i++ ){
            if(car.getId()==carList.get(i).getId()){
                carUpdate = carList.get(i);
            }
        }
        carUpdate.setColor(car.getColor());
        carUpdate.setBrand(car.getBrand());
        carUpdate.setNumber(car.getNumber());
        carUpdate.setModel(car.getModel());
        carUpdate.setYear(car.getYear());
        carUpdate.setPrice(car.getPrice());
        return carUpdate;
    }

    public List<Car> updateAll(List<Car> cars){
        CarShop.INSTANCE.set(cars);
        return CarShop.INSTANCE.getCars();
    }
}
