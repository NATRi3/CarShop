package edu.epam.carshop.dao;

import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.Entity;
import edu.epam.carshop.exception.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<T,K extends Entity> {
    List<K> findAll() throws DAOException;
    K findEntityById (T t) throws DAOException;
    boolean delete (K k) throws DAOException;
    boolean delete (T id) throws DAOException;
    Car create (K k) throws DAOException;
    K update (K k) throws DAOException;
    default void close(Statement statement){
        try{
            if(statement!=null){
                statement.close();
            }
        }catch (SQLException e){
            // log
        }
    }
    default void close (Connection connection){
        try{
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            //log
        }
    }
}
