package src;

import java.awt.*;

public abstract class Truck extends Vehicle{
    
    private double transportationWeight = 0;
    private double maxWeight;


    public Truck(int NrDoorsInput, double enginePowerInput, Color colorInput, double maxWeightInput, double xInput, double yInput){
        super(NrDoorsInput, enginePowerInput, colorInput, xInput, yInput);
        maxWeight = maxWeightInput;
    }

    public double getMaxWeight(){
        return maxWeight;
    }

    public void setMaxWeight(double amount){
        maxWeight = amount;
    }

    public double getTransportationWeight(){
        return transportationWeight;
    }

    public void setTransportationWeight(double amount){
        if (transportationWeight+amount > maxWeight){
            transportationWeight = maxWeight;
        }
        else{
            transportationWeight = amount;
        }
    }

}

