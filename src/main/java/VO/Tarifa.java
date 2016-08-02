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
    private int minutos;
    private int valor;

    public Tarifa(int minutos, int valor) {
        this.minutos = minutos;
        this.valor = valor;
    }
    
        public Tarifa() {
        this.minutos = 0;
        this.valor = 0;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "minutos=" + minutos + ", valor=" + valor + '}';
    } 
    
}
