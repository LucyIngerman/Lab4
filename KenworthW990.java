package src;

import java.awt.*;
import java.awt.image.BufferedImage;

public class KenworthW990 extends CarHaulerTruck{
    
    public KenworthW990(Color colorInput, double xInput, double yInput, BufferedImage bufferedImageInput){
        super(2, 405, colorInput,200, 6, 2.5, xInput, yInput, bufferedImageInput);
    }

    public double speedFactor(){
        return 1;
    }
    public Rectangle getBounds() {
        double[] position = getPosition();
        return new Rectangle((int) position[0], (int) position[1], 100, 60);
    }

}
