package edu.epam.carshop.util;

import java.util.Random;

public class IdCarCreator {
    public int idCreator(){
        return new Random().nextInt(999999);
    }
}
