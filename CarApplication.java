package src;

import java.awt.*;
import java.io.IOException;

public class CarApplication {



    public static void main(String[] args) {
        // Instance of this class
        CarModel cm = new CarModel();

        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0");

        cm.registerObserver(frame.drawPanel);


        CarController cc = new CarController(cm, frame.getGasSpinner(), frame.getGasButton(), frame.getBrakeButton(),
                frame.getStopButton(), frame.getTurboOnButton(), frame.getTurboOffButton(), frame.getLiftBedButton(),
                frame.getLowerBedButton(), frame.getStartButton(), frame.getAddCarButton(), frame.getRemoveCarButton());

        cm.start();
    }

}
