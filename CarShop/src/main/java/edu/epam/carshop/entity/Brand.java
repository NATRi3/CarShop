package edu.epam.carshop.entity;

public enum Brand {
    AUDI("Audi"),
    BMW("BMW"),
    Toyota("Toyota"),
    Skoda("Skoda"),
    WV("Volkswagen");

    private String brandName;

    Brand(String brandName) {
        this.brandName = brandName;
    }
}
