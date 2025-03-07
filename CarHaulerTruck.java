package src;

import java.awt.*;
import java.util.Stack;

public abstract class CarHaulerTruck extends Truck{
    private final int carCapacity;
    private final Stack<Car> loadedCars = new Stack<>();
    private final double truckWidth;
    private boolean rampIsDown = true;


    public CarHaulerTruck(int NrDoorsInput, double enginePowerInput, Color colorInput, double maxWeightInput,
                          int carCapacityInput, double truckWidthInput, double xInput, double yInput){
        super(NrDoorsInput, enginePowerInput, colorInput, maxWeightInput, xInput, yInput);
        carCapacity = carCapacityInput;
        truckWidth = truckWidthInput;

    }

    public Car getTopCar(){
        return loadedCars.peek();
    }

    public boolean getRampStatus(){
        return rampIsDown;
    }

    public void raiseRamp(){
        rampIsDown = false;
    }

    public void lowerRamp(){
        if (getEngineStatus()){
            return;
        }
        rampIsDown = true;
    }

    @Override public void startEngine(){
        if (rampIsDown){
            return;
        }
        super.startEngine();
    }

    @Override public void move(){
        if (!getEngineStatus()){
            return;
        }

        super.move();

        for (Car car : loadedCars){

            double[] position = car.getPosition();

            double xPos = position[0];
            double yPos = position[1];

            car.setPosition(xPos, yPos);
        }
    }


    public void loadCar(Car car){

        if (!rampIsDown){
            return;
        }

        double[] carPos = car.getPosition();
        double[] truckPos = getPosition();

        double carX = carPos[0];
        double carY = carPos[1];
        double truckX = truckPos[0];
        double truckY = truckPos[1];


        if ((carX > (truckX+5)) || (carX < (truckX-5))){
            return;
        }

        if ((carY > (truckY+5)) || (carY < (truckY-5))){
            return;
        }

        if (getNrCars() >= (getCarCapacity())){
            return;
        }

        if (car.getWeight() >= (getMaxWeight()-getTransportationWeight())){
            return;
        }

        if (car.getWidth() > getTruckWidth()){
            return;
        }

        loadedCars.push(car);
    }
    public void unloadCar(){
        if (!rampIsDown){
            return;
        }

        if (loadedCars.isEmpty()){
            return;
        }

        Car car = loadedCars.pop();
        double[] carPos = car.getPosition();

        car.setPosition(carPos[0]+3, carPos[1]+2);
        
    }

    public int getNrCars(){
        return loadedCars.size();
    }

    public double getTruckWidth(){
        return truckWidth;
    }

    public int getCarCapacity(){
        return carCapacity;
    }
}


