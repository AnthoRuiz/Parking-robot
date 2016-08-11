/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controllers;

import VO.DataBase;
import VO.Parking;
import VO.TipoVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jarvis
 */
public class CopyFileMyDB {
    
    static final String BD_NAME = "parking";
    static final String BD_USER = "root";
    static final String BD_PASS = "";
    private MainController mainController = new MainController();
    
    public ArrayList<Parking> getDataParking(){
        
        DataBase dataBase = new DataBase();
        Connection connection = null;
        dataBase.setNameDataBase(BD_NAME);
        dataBase.setPass(BD_PASS);
        dataBase.setUser(BD_USER);
        connection = this.mainController.ConnectionToCloudDB(dataBase);
        ArrayList<Parking> ParkingCloudList = new ArrayList<Parking>();
            
        PreparedStatement preStatement = null;
        ResultSet result = null;
        
        String query = "SELECT * FROM parkings";
        
        try {
            preStatement = connection.prepareStatement(query);
            
            result = preStatement.executeQuery();
            
            while(result.next()){
                Parking parking = new Parking();
                parking.setNombre(result.getString("nombre"));
                parking.setHorarioInicio(result.getString("horario"));
                parking.setDireccion(result.getString("direccion"));
                parking.setTelefono(result.getString("telefono"));
                parking.setLatitud(result.getString("latitud"));
                parking.setLongitud(result.getString("longitud"));
                ParkingCloudList.add(parking);
            }
            result.close();
        } catch (SQLException e) {
            System.out.println("SQLException en la consulta: " + e.getMessage());
        }
        
        return ParkingCloudList;
    }
}
