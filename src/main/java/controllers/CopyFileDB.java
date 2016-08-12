/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controllers;

import VO.Parking;
import VO.Tarifa;
import VO.TipoVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.ConnectionToDB;

/**
 *
 * @author Jarvis
 */
public class CopyFileDB {
    
    private ArrayList<TipoVehiculo> tipoVehiculoList = new ArrayList<TipoVehiculo>();
    
    public Parking getDataParking(Connection connection){
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
                //System.out.println(parking.toString());
            }
            //System.out.println(parking.toString());
            result.close();
        } catch (SQLException e) {
            System.out.println("SQLException en la consulta: " + e.getMessage());
        }
        return parking;
    }
    
    public ArrayList<TipoVehiculo> getTypeVehicle(Connection connection){
        PreparedStatement preStatement = null;
        ResultSet result = null;
        
        String query = "SELECT * FROM vehiculoTipo";
        
        try {
            preStatement = connection.prepareStatement(query);
            
            result = preStatement.executeQuery();
            
            while(result.next()){
                TipoVehiculo tipoVehiculo = new TipoVehiculo();
                tipoVehiculo.setNombre(result.getString("nombre"));
                tipoVehiculo.setCapacidad(result.getInt("capacidad"));
                tipoVehiculoList.add(tipoVehiculo);
            }
            result.close();
        } catch (SQLException e) {
            System.out.println("SQLException en la consulta: " + e.getMessage());
        }
        return(getTarifaId(connection));
    }
    
    public ArrayList<TipoVehiculo> getTarifaId(Connection connection){
        PreparedStatement preStatement = null;
        ResultSet result = null;
        
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        int size = tipoVehiculoList.size();
        
        String query = "SELECT * FROM tarifas where vehiculotipo_id = ?";
        
        try {
            preStatement = connection.prepareStatement(query);
            for(int i = 0; i < size; i++){
                preStatement.setInt(1, i+1);
                result = preStatement.executeQuery();
                String tarifas = "";
                while(result.next()){
                    if(result.isLast()){
                        tarifas = tarifas.concat(result.getString("id"));
                    }else{
                        tarifas = tarifas.concat(result.getString("id") + ",");
                    }
                }
                tipoVehiculo = tipoVehiculoList.get(i);
                tipoVehiculo.setTarifa(tarifas);
                tipoVehiculoList.set(i, tipoVehiculo);
                result.close();
            }
            
        } catch (SQLException e) {
            System.out.println("SQLException en la consulta: " + e.getMessage());
        }
        return(getTarifa(connection));
    }
    
    public ArrayList<TipoVehiculo> getTarifa(Connection connection){
        PreparedStatement preStatement = null;
        ResultSet result = null;
        
        int size = tipoVehiculoList.size();
        
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        
        String query = "SELECT * FROM tarifasrangos WHERE tarifas_id = ?";
        
        try {
            preStatement = connection.prepareStatement(query);
            for(int i = 0; i < size; i++){
                tipoVehiculo = tipoVehiculoList.get(i);
                String[] idsList;
                idsList = tipoVehiculo.getTarifa().split(",");
                tipoVehiculo = tipoVehiculoList.get(i);
                tipoVehiculo.setTarifa("999999");
                tipoVehiculoList.set(i, tipoVehiculo);
                for(String id : idsList){
                    if(!id.isEmpty()){
                        preStatement.setInt(1, Integer.valueOf(id));
                        ArrayList<Tarifa> valorList = new ArrayList<Tarifa>();
                        result = preStatement.executeQuery();
                        while(result.next()){
                            Tarifa tarifa = new Tarifa();
                            tarifa.setId(result.getInt("id"));
                            tarifa.setIdTarifa(result.getInt("tarifas_id"));
                            tarifa.setValor(result.getInt("valor"));
                            valorList.add(tarifa);
                        }
                        
                        if(getMin(valorList).getValor() < Integer.valueOf(tipoVehiculoList.get(i).getTarifa())){
                            tipoVehiculo.setTarifa(String.valueOf(getMin(valorList).getValor()));
                            tipoVehiculoList.set(i, tipoVehiculo);
                        }
                    }
                    result.close();
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException en la consulta: " + e.getMessage());
        }
        return(getDisp(connection));
    }
    
    public Tarifa getMin(ArrayList<Tarifa> valorList){
        int tmp = 999999;
        int indice = 0;
        int idx = valorList.size();
        for(int i = 0; i < idx; i++){
            if(valorList.get(i).getValor() < tmp){
                tmp = valorList.get(i).getValor();
                indice = i;
            }
        }
        return valorList.get(indice);
    }
    
    public ArrayList<TipoVehiculo> getDisp(Connection connection){
        PreparedStatement preStatement = null;
        ResultSet result = null;
        
        int size = tipoVehiculoList.size();
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        
        String query = "SELECT * FROM parqueo WHERE vehiculotipo_id = ?";
        
        try {
            preStatement = connection.prepareStatement(query);
            for(int i = 0; i < size; i++){
                int entrada = 0;
                tipoVehiculo = tipoVehiculoList.get(i);
                preStatement.setInt(1, i+1);
                result = preStatement.executeQuery();
                while(result.next()){
                    if(result.getString("estado").equals("E")){
                        entrada++;
                    }
                }
                tipoVehiculo.setDisp(tipoVehiculo.getCapacidad() - entrada);
                tipoVehiculoList.set(i, tipoVehiculo);
            }
        } catch (SQLException e) {
            System.out.println("SQLException en la consulta: " + e.getMessage());
        }
        return(tipoVehiculoList);
    }
}
