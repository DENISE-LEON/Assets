package com.pluralsight;


import static com.pluralsight.Condition.*;

public class House extends Asset {
    private String address;
    private int squareFoot;
    private int lotSize;
    private Condition condition;

    public House(String description, String dateAcquired, double originalCost, String address, int squareFoot, int lotSize, Condition condition) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
        this.condition = condition;
    }

    public String getAddress() {
        return address;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //override getValue from superclass
    @Override
    public double getValue() {
        double costPerFoot = squareFoot * 0.25;
        double houseValue = 0.0;

        switch (condition) {
            case HORRIBLE
                    -> houseValue = (70.00 * squareFoot) +costPerFoot;
            case POOR
                    -> houseValue = (80.00 * squareFoot) + costPerFoot;
            case FAIR
                    -> houseValue = (90.00 * squareFoot) + costPerFoot;
            case GOOD
                    -> houseValue = (130.00 * squareFoot) + costPerFoot;
            case EXCELLENT
                    -> houseValue = (180.00 * squareFoot) + costPerFoot;

        }
        return  houseValue;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
