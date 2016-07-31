/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import VO.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jarvis
 */
public class ConnectionToDB {
    private Connection connection;

    public ConnectionToDB() {
        this.connection = null;
    }

    public ConnectionToDB(DataBase dataBase) {
        String URL2 = "jdbc:mysql://localhost:3306/" + dataBase.getNameDataBase() + "?autoReconnect=true&useSSL=false";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL2, dataBase.getUser(), dataBase.getPass());
        }
        catch (ClassNotFoundException e) {
            System.out.println("Ocurrio un ClassNotFoundException:  " + e.getMessage());
        }
        catch (SQLException e) {
            System.out.println("Ocurrio un SQLException:  " + e.getMessage());
        }
    }

    public void close() {
        this.connection = null;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
