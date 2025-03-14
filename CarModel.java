package src;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;


public class CarModel implements Subject{

    private ArrayList<Observer> observers = new ArrayList<>();

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<VPos> vPos = new ArrayList<>();

    Garage<Volvo240> garage;

    private ArrayList<Vehicle> vehiclesToRemove = new ArrayList<>();

    int gasAmount;
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());



    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(ArrayList<VPos> vPos) {
        for (Observer observer : observers) {
            observer.update(vPos);
        }
    }




    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehiclesToRemove){
                vehicles.remove(vehicle);
            }
            for (Vehicle vehicle : vehicles) {
                double[] previousPoint = vehicle.getPosition();

                vehicle.move();

                int x = (int) Math.round(vehicle.getPosition()[0]);
                int y = (int) Math.round(vehicle.getPosition()[1]);
                if (x > 690 || x < 0){
                    vehicle.setPosition(previousPoint[0], previousPoint[1]);
                    vehicle.reverseDirection();
                    vehicle.setPosition(previousPoint[0], previousPoint[1]);
                }
                if (y > 500 || y < 0){
                    vehicle.setPosition(previousPoint[0], previousPoint[1]);
                    vehicle.reverseDirection();
                    vehicle.setPosition(previousPoint[0], previousPoint[1]);

                }
                if (garage.isColliding(vehicle) ){
                    if (vehicle instanceof Volvo240 volvo){
                        garage.addCar(volvo);
                        vehiclesToRemove.add(vehicle);
                    }

                    else{
                        vehicle.reverseDirection();

                    }
                }

            }
            vPos.clear();
            for (Vehicle vehicle : vehicles){
                vPos.add(new VPos(vehicle.getPosition(), vehicle.getClass().getSimpleName()));
            }


            notifyObservers(vPos);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gasAmount = ((double) amount) / 100;
        System.out.println("yes");
        for (Vehicle vehicle : vehicles){
            vehicle.gas(gasAmount);
        }

    }

    void startCar() {
        for (Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
        System.out.println("started");
    }

    void brakeCar(double amount){
        double brakeAmount = amount / 100;

        for (Vehicle vehicle : vehicles){
            vehicle.brake(brakeAmount);
        }


    }

    void stopCar(){
        for (Vehicle vehicle : vehicles){
            vehicle.stopEngine();
        }

    }

    void turboOn(){
        for (Vehicle vehicle : vehicles){
            if (vehicle instanceof Saab95 saab){
                saab.setTurboOn();

            }
        }
    }

    void turboOff(){
        for (Vehicle vehicle : vehicles){
            if (vehicle instanceof Saab95 saab){
                saab.setTurboOff();
            }
        }
    }

    void raiseDumpBox(){
        for (Vehicle vehicle : vehicles){
            if (vehicle instanceof Scania scania){
                scania.raiseDumpBox(5);
            }
        }
    }

    void lowerDumpBox(){
        for (Vehicle vehicle : vehicles){
            if (vehicle instanceof Scania scania){
                scania.lowerDumpBox(5);
            }
        }
    }

}
