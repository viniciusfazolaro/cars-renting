package br.edu.ifsp.arq.tsi.inoo.cars_renting.model;

public class Car {

    private static int count = 1;
    private int code;
    private String maker;
    private String model;
    private int year;
    private String plate;
    private int doorsQty;
    private boolean hasAC;
    private double valuePerDay;
    private boolean rented;

    public Car(String maker, String model, int year, String plate, int doorsQty, boolean hasAC, double valuePerDay) {
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.doorsQty = doorsQty;
        this.hasAC = hasAC;
        this.valuePerDay = valuePerDay;
        this.rented = false;
    }

    public int getCode() {
        return code;
    }

    public void setCode() {
        this.code = count++;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getDoorsQty() {
        return doorsQty;
    }

    public void setDoorsQty(int doorsQty) {
        this.doorsQty = doorsQty;
    }

    public boolean isHasAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public double getValuePerDay() {
        return valuePerDay;
    }

    public void setValuePerDay(double valuePerDay) {
        this.valuePerDay = valuePerDay;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
