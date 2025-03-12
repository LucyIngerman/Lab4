package src;

import java.awt.*;

public class VehicleFactory {

    public Saab95 createSaab95(Color color, double x, double y){
        Saab95 newSaab95 = new Saab95(color, x, y);
        return newSaab95;
    }

    public Volvo240 createVolvo240(Color color, double x, double y){
        Volvo240 newVolvo240 = new Volvo240(color, x, y);
        return newVolvo240;
    }

    public Scania createScania(Color color, double x, double y){
        Scania newScania = new Scania(color, x, y);
        return newScania;
    }

    public Garage<Volvo240> createVolvo240Garage(int capacityInput, double x, double y){
        Garage<Volvo240> newGarage = new Garage<Volvo240>(capacityInput, x, y);
        return newGarage;
    }
}

