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
public class DataBase {
    private String nameDataBase;
    private String user;
    private String pass;

    public DataBase(String nameDataBase, String user, String pass) {
        this.nameDataBase = nameDataBase;
        this.user = user;
        this.pass = pass;
    }

    public DataBase() {
        this.nameDataBase = null;
        this.user = null;
        this.pass = null;
    }

    public String getNameDataBase() {
        return this.nameDataBase;
    }

    public void setNameDataBase(String nameDataBase) {
        this.nameDataBase = nameDataBase;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String toString() {
        return "DataBase [nameDataBase=" + this.nameDataBase + ", user=" + this.user + ", pass=" + this.pass + "]";
    }
}
