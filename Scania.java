package src;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Scania extends TipperTruck{

    public Scania(int NrDoorsInput, double enginePowerInput, Color colorInput, double maxWeightInput,
                  int dumpBoxMaxAngleInput, double xInput, double yInput, BufferedImage bufferedImageInput){
        super(NrDoorsInput, enginePowerInput, colorInput, maxWeightInput, dumpBoxMaxAngleInput, xInput, yInput, bufferedImageInput);

    }

    public Rectangle getBounds() {
        double[] position = getPosition();
        return new Rectangle((int) position[0], (int) position[1], 100, 60);
    }

    public double speedFactor(){
        return 1;
    }

}
