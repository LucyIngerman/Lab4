package src;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Volvo240 extends Car{
    public final static double trimFactor = 1.25;

    public Volvo240(Color colorInput, double xInput, double yInput){
        super(4, 50, colorInput, 5, 40, 2, 1, xInput, yInput);

    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public Rectangle getBounds() {
        double[] position = getPosition();
        return new Rectangle((int) position[0], (int) position[1], 100, 60);
    }
}
