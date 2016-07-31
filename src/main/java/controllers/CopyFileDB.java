/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controllers;

import VO.Parking;
import VO.TipoVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.ConnectionToDB;

/**
 *
 * @author Jarvis
 */
public class CopyFileDB {
    
    public void getDataParking(Connection connection){
        Parking parking = new Parking();
        PreparedStatement preStatement = null;
        ResultSet result = null;
        
        String query = "SELECT * FROM aparcadero";
        
        try {
            preStatement = connection.prepareStatement(query);
            
            result = preStatement.executeQuery();
            
            while(result.next()){
                parking.setNombre(result.getString("nombre"));
                parking.setHorarioInicio(result.getString("horainicio"));
                parking.setHorarioFin(result.getString("horafin"));
                parking.setDireccion(result.getString("direccion"));
                parking.setTelefono(result.getString("telefono"));
                parking.setLatitud(result.getString("latitud"));
                parking.setLongitud(result.getString("longitud"));
                System.out.println(parking.toString());
            }
            //System.out.println(parking.toString());
            result.close();
        } catch (SQLException e) {
            System.out.println("SQLException en la consulta: " + e.getMessage());
        }
    }
    
    public void getDataTypeVehicle(Connection connection){
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        PreparedStatement preStatement = null;
        ResultSet result = null;
        
        String query = "SELECT * FROM vehiculoTipo";
        
        try {
            preStatement = connection.prepareStatement(query);
            
            result = preStatement.executeQuery();
            
            while(result.next()){
                tipoVehiculo.setNombre(result.getString("nombre"));
                tipoVehiculo.setCapacidad(result.getInt("capacidad"));
                System.out.println(tipoVehiculo.toString());
            }
            result.close();
        } catch (SQLException e) {
            System.out.println("SQLException en la consulta: " + e.getMessage());
        }
    }
    
    
}
