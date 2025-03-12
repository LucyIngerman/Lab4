package src;

import java.awt.*;
import java.io.IOException;

public class CarApplication {

    public static void main(String[] args) throws IOException {
        // Instance of this class
        CarModel cm = new CarModel();


        VehicleFactory factory = new VehicleFactory();

        Volvo240 volvo = factory.createVolvo240(Color.BLACK, 0, 300);
        Saab95 saab = factory.createSaab95(Color.RED, 0, 0);
        Scania scania = factory.createScania(Color.BLUE, 0, 150);
        cm.garage = factory.createVolvo240Garage(4, 300, 300);
        cm.vehicles.add(volvo);
        cm.vehicles.add(saab);
        cm.vehicles.add(scania);
        // Start a new view and send a reference of self
        cm.frame = new CarView("CarSim 1.0", cm);

        cm.registerObserver(cm.frame.drawPanel);

        cm.cc = new CarController(cm);
        // Start the timer
        cm.timer.start();
    }

}
