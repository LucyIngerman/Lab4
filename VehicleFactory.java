package src;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class VehicleFactory {

    public Saab95 createSaab95(Color color, double x, double y, BufferedImage image){
        Saab95 newSaab95 = new Saab95(color, x, y, image);
        return newSaab95;
    }

    public Volvo240 createVolvo240(Color color, double x, double y, BufferedImage image){
        Volvo240 newVolvo240 = new Volvo240(color, x, y, image);
        return newVolvo240;
    }

    public Scania createScania(Color color, double x, double y, BufferedImage image){
        Scania newScania = new Scania(color, x, y, image);
        return newScania;
    }

    

    public Garage<Vehicle> createVehicleGarage(int capacityInput, BufferedImage image){
        Garage<Vehicle> newGarage = new Garage<Vehicle>(capacityInput, image);
        return newGarage;
    }

    public Garage<Volvo240> createVolvo240Garage(int capacityInput, BufferedImage image){
        Garage<Volvo240> newGarage = new Garage<Volvo240>(capacityInput, image);
        return newGarage;
    }
}
