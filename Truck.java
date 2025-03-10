package src;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Truck extends Vehicle{
    
    private double transportationWeight = 0;
    private double maxWeight;


    public Truck(int NrDoorsInput, double enginePowerInput, Color colorInput, double maxWeightInput, double xInput, double yInput, BufferedImage bufferedImageInput){
        super(NrDoorsInput, enginePowerInput, colorInput, xInput, yInput, bufferedImageInput);
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
