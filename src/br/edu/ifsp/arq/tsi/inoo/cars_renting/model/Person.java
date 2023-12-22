package br.edu.ifsp.arq.tsi.inoo.cars_renting.model;

import java.util.ArrayList;

public abstract class Person implements Id {

    protected static int count = 1;
    protected int code;
    protected String name;
    protected ArrayList<Rent> rents;

    public Person(String name) {
        this.name = name;
        this.rents = new ArrayList<Rent>();
    }
    
    public int getCode() {
        return code;
    }
    
    public void setCode() {
        this.code = count++;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Rent> getRents() {
        return rents;
    }
    
    public void setRents(ArrayList<Rent> rents) {
        this.rents = rents;
    }
}
