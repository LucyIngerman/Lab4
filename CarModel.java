package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class CarModel{

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    Garage<Volvo240> garage;

    ArrayList<Vehicle> vehiclesToRemove = new ArrayList<>();

    ArrayList<Sprite> sprites = new ArrayList<>();
    

    public static void main(String[] args) throws IOException {
        // Instance of this class
        CarModel cm = new CarModel();
        CarController cc = new CarController();

        VehicleFactory factory = new VehicleFactory();

        Volvo240 volvo = factory.createVolvo240(Color.BLACK, 0, 300, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        Saab95 saab = factory.createSaab95(Color.RED, 0, 0, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        Scania scania = factory.createScania(Color.BLUE, 0, 150, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        cm.vehicles.add(volvo);
        cm.vehicles.add(saab);
        cm.vehicles.add(scania);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }





    public ArrayList<Sprite> actionToPerform(){
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
        

        for (Vehicle vehicle: vehicles){

            Sprite sprite = new Sprite(vehicle.getPosition(), vehicle.getBufferedImage());

            sprites.add(sprite);
        }
        return sprites;

        
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gasAmount = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles){
            vehicle.gas(gasAmount);
        }

    }

    void startCar() {
        for (Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
        for (Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
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
