package edu.epam.carshop.entity;

import java.io.Serializable;
import java.util.Comparator;

public abstract class Entity implements Serializable, Cloneable, Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
