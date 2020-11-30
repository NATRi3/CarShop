package edu.epam.carshop.entity;

import edu.epam.carshop.util.IdCarCreator;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Car extends Entity {
    private static final IdCarCreator idCarCreator = new IdCarCreator();
    private final int id;
    private String model;
    private Brand brand;
    private final Calendar year = new GregorianCalendar();
    private Color color;
    private BigDecimal price;
    private String number;

    public Car(String model, Brand brand, int year, Color color, BigDecimal price, String number) {
        this.id = idCarCreator.idCreator();
        this.setModel(model);
        this.setBrand(brand);
        this.setYear(year);
        this.setColor(color);
        this.setPrice(price);
        this.setNumber(number);
    }

    public Car(int id ,String model, Brand brand, int year, Color color, BigDecimal price, String number) {
        this.id = id;
        this.setModel(model);
        this.setBrand(brand);
        this.setYear(year);
        this.setColor(color);
        this.setPrice(price);
        this.setNumber(number);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year.get(Calendar.YEAR);
    }

    public void setYear(int year) {
        this.year.set(Calendar.YEAR,year);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("Car{id=").append(id).append(", model=")
                .append(model).append(", brand=").append(brand).append(", year=").append(this.getYear()).append(", color=")
                .append(color).append(", price=").append(price).append(", number=").append(number).append("}");
        return String.valueOf(stringBuilder);
    }
}
