package com.pluralsight;


import java.time.LocalDate;

public class Vehicle extends Asset {
    private String model;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String model, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.model = model;
        this.year = year;
        this.odometer = odometer;
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

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    //derived getAge getter
    public int getAge() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - year;

    }

    //derived getVal getter
    //overrides assets getter method
    @Override
    public double getValue() {

        int age = getAge();
        double value;
        int milage = getOdometer();

        //cannot use a switch statement for comparisons (greater than =)
        //can use boolean conditional hack but that's not good practice
        //switch conditional & what it is val it is trying to match must be of same type
        if(age <= 3) {
            value = getOriginalCost() - (getOriginalCost() * 0.03 * age);
        } else if(age <=6) {
            value = getOriginalCost() - (getOriginalCost() * 0.06 * age);
        } else if(age <= 10) {
            value = getOriginalCost() - (getOriginalCost() * 0.1 * age);
        } else {
            value = 1000;
        }

        if(milage > 100000 && !(getModel().contains("Honda") || getModel().contains("Toyota"))){
            value *= 0.75;
        }
        return value;
    }
}
