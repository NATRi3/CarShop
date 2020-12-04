package edu.epam.carshop.util;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;

import java.math.BigDecimal;
import java.util.Comparator;

public enum CarComparator implements Comparator<Car> {
    ID {
        @Override
        public int compare(Car o1, Car o2){
            return Integer.compare(o1.getId(), o2.getId());
        }
    },
    BRAND {
        @Override
        public int compare(Car o1, Car o2){
            return o1.getBrand().compareTo(o2.getBrand());
        }
    },
    MODEL {
        @Override
        public int compare(Car o1, Car o2){
            return o1.getModel().compareTo(o2.getModel());
        }
    },
    PRICE {
        @Override
        public int compare(Car o1, Car o2){
            if (o1 == o2) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return o1.getPrice().compareTo(o2.getPrice());
        }
    }
}
