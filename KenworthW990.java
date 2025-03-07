package src;

import java.awt.*;

public class KenworthW990 extends CarHaulerTruck{
    
    public KenworthW990(Color colorInput, double xInput, double yInput){
        super(2, 405, colorInput,200, 6, 2.5, xInput, yInput);
    }

    public double speedFactor(){
        return 1;
    }
    public Rectangle getBounds() {
        double[] position = getPosition();
        return new Rectangle((int) position[0], (int) position[1], 100, 60);
    }

}
