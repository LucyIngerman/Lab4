package src;

import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn = false;

    public Saab95(int NrDoorsInput, double enginePowerInput, Color colorInput, int nrSeatsInput, double weightInput,
                  int widthInput, int lengthInput, double xInput, double yInput){
        super(NrDoorsInput, enginePowerInput, colorInput, nrSeatsInput, weightInput, widthInput, lengthInput, xInput, yInput);
    }
    

    public Rectangle getBounds() {
        double[] position = getPosition();
        return new Rectangle((int) position[0], (int) position[1], 100, 60);
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
