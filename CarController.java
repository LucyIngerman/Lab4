package src;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Truck> trucks = new ArrayList<>();
    Garage<Volvo240> garage = new Garage<>(1);

    ArrayList<Car> carsToRemove = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // cc.cars.add(new Volvo240());
        Volvo240 volvo = new Volvo240(4, 70, Color.red, 4, 30, 2, 3, 0, 300);
        Saab95 saab = new Saab95(4, 70, Color.YELLOW, 4, 30, 2, 3, 0, 0);
        Scania scania = new Scania(4, 100, Color.BLUE, 200, 60, 0, 150);
        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.trucks.add(scania);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : carsToRemove){
                cars.remove(car);
            }
            for (Car car : cars) {
                moveLogic(car);
                if (garage.isColliding(car) ){
                    if (car instanceof Volvo240 volvo){
                        garage.addCar(volvo);
                        carsToRemove.add(car);
                    }

                    else{
                        car.reverseDirection();

                    }
                }

                frame.drawPanel.currentVehiclePositions(cars, trucks);
                frame.drawPanel.repaint();

            }
            for (Truck truck : trucks){
                moveLogic(truck);
                if (garage.isColliding(truck)){
                    truck.reverseDirection();
                }
                frame.drawPanel.currentVehiclePositions(cars, trucks);
                frame.drawPanel.repaint();
            }

        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gasAmount = ((double) amount) / 100;
       for (Car car : cars){
            car.gas(gasAmount);
        }
        for (Truck truck : trucks){
            truck.gas(gasAmount);
        }
    }

    void startCar() {
        for(Car car: cars){
            car.startEngine();
        }
        for(Truck truck: trucks){
            truck.startEngine();
        }
    }

    void brakeCar(double amount){
        double brakeAmount = amount / 100;

        for(Car car: cars){
            car.brake(brakeAmount);
        }

        for(Truck truck: trucks){
            truck.brake(brakeAmount);
        }
    }

    void stopCar(){
        for (Car car: cars){
            car.stopEngine();
        }
        for(Truck truck: trucks){
            truck.stopEngine();
        }
    }

    void turboOn(){
        for (Car car: cars){
            if (car instanceof Saab95 saab){
                saab.setTurboOn();

            }
        }
    }

    void turboOff(){
        for (Car car: cars){
            if (car instanceof Saab95 saab){
                saab.setTurboOff();
            }
        }
    }

    void raiseDumpBox(){
        for (Truck truck: trucks){
            if (truck instanceof Scania scania){
                scania.raiseDumpBox(5);
            }
        }
    }

    void lowerDumpBox(){
        for (Truck truck: trucks){
            if (truck instanceof Scania scania){
                scania.lowerDumpBox(5);
            }
        }
    }

    void moveLogic(Vehicle vehicle){
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
    }

}

