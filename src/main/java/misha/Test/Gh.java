package misha.Test;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import misha.dao.PersonDAOImpl;
import misha.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Gh {
    public static void main(String[] args) {

    String url = "jdbc:h2:~/test2";
    String username = "a2";
    String password = "1";



        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }


    }
}
