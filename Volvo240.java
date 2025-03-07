package src;

import java.awt.*;

public class Volvo240 extends Car{
    public final static double trimFactor = 1.25;

    public Volvo240(int NrDoorsInput, double enginePowerInput, Color colorInput, int nrSeatsInput, double weightInput,
                  int widthInput, int lengthInput, double xInput, double yInput){
        super(NrDoorsInput, enginePowerInput, colorInput, nrSeatsInput, weightInput, widthInput, lengthInput, xInput, yInput);

    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public Rectangle getBounds() {
        double[] position = getPosition();
        return new Rectangle((int) position[0], (int) position[1], 100, 60);
    }
}
