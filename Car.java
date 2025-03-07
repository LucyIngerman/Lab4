package src;


import java.awt.*;

public abstract class Car extends Vehicle{
    private final int nrSeats;
    private double weight;
    private final int lenght;
    private final int width;

    public Car(int NrDoorsInput, double enginePowerInput, Color colorInput, int nrSeatsInput, double weightInput,
               int widthInput, int lengthInput, double xInput, double yInput){
        super(NrDoorsInput, enginePowerInput, colorInput, xInput, yInput);
        nrSeats = nrSeatsInput;
        weight = weightInput;
        width = widthInput;
        lenght = lengthInput;

    }


    public int getNrSeats(){
        return nrSeats;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double amount){
        weight = amount;
    }

    public double getWidth(){
        return width;
    }

    public double getLenght(){
        return lenght;
    }



}

