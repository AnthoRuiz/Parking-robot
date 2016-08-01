package models;

/**
 *
 * @author Jarvis
 */
import VO.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToCloudDB {
    
    private Connection connection;
    
    public ConnectionToCloudDB() {
        this.connection = null;
    }
    
    public ConnectionToCloudDB(DataBase dataBase) {
        String URL2 = "jdbc:mysql://localhost:3306/" + dataBase.getNameDataBase() + "?autoReconnect=true&useSSL=false&allowMultiQueries=true";
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
