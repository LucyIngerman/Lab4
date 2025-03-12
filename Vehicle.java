package src;


import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Vehicle implements IMovable{       // Why extend from movable?
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double currentSpeed = 0;
    private char direction = 'E';
    private double x;
    private double y;
    private boolean engineOn = false;


    public Vehicle(int NrDoorsInput, double enginePowerInput, Color colorInput, double xInput, double yInput){
        nrDoors = NrDoorsInput;
        enginePower = enginePowerInput;
        color = colorInput;
        x = xInput;
        y = yInput;
    }


    public void move(){
        // n w s e
        switch(direction){
            case 'N':
                y += currentSpeed;
                break;
            case 'W':
                x -= currentSpeed;
                break;
            case 'S':
                y -= currentSpeed;
                break;
            case 'E':
                x += currentSpeed;
                break;
        }
    }

    public void reverseDirection(){
        switch(direction){
            case 'N':
                direction = 'S';
                break;
            case 'S':
                direction = 'N';
                break;
            case 'W':
                direction = 'E';
                break;
            case 'E':
                direction = 'W';
                break;
            default:
                direction = 'N';
        }
    }


    public void turnLeft(){
        switch(direction){
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            default:
                direction = 'N';
        }
    }
    public void turnRight(){
        switch(direction){
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
            default:
                direction = 'N';
        }
    }


    public double[] getPosition(){
        return new double[]{x, y};
    }

    public char getDirection(){
        return direction;
    }

    public void setPosition(double xPos, double yPos){
        x = xPos;
        y = yPos;
    }

    public final int getNrDoors(){
        return nrDoors;
    }
    public final double getEnginePower(){
        return enginePower;
    }

    public final double getCurrentSpeed(){
        return currentSpeed;
    }

    public final Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    if (!engineOn){
            engineOn = true;
        }
    }

    public void stopEngine(){
	    if (engineOn){
            engineOn = false;
            currentSpeed = 0;
        }
    }

    public boolean getEngineStatus(){
        return engineOn;
    }

    public abstract Rectangle getBounds();


    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount){
        if (!engineOn){
            return;
        }

        if  (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){

        if  (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }
}

