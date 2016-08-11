/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package VO;

/**
 *
 * @author Jarvis
 */
public class Tarifa {
    private int id;
    private int idTarifa;
    private int valor;
    
    public Tarifa(int id, int idTarifa, int valor) {
        this.id = id;
        this.idTarifa = idTarifa;
        this.valor = valor;
    }
    
    public Tarifa() {
        this.id = 0;
        this.idTarifa = 0;
        this.valor = 0;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdTarifa() {
        return idTarifa;
    }
    
    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }
    
    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Tarifa{" + "id=" + id + ", idTarifa=" + idTarifa + ", valor=" + valor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.valor;
        return hash;
    }

  
    
}
