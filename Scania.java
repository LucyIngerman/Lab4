package src;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Scania extends TipperTruck{

    public Scania(Color colorInput, double xInput, double yInput, BufferedImage bufferedImageInput){
        super(2, 80, colorInput, 90, 75, xInput, yInput, bufferedImageInput);

    }

    public Rectangle getBounds() {
        double[] position = getPosition();
        return new Rectangle((int) position[0], (int) position[1], 100, 60);
    }

    public double speedFactor(){
        return 1;
    }

}
