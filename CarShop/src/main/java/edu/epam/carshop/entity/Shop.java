package edu.epam.carshop.entity;

import java.util.List;

public interface Shop <T extends Entity>{
    public void add(T t);
    public void remove(int idList);
    public Car get(int id);
    public void set(List<Car> cars);
}
