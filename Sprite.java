package src;

import java.awt.image.BufferedImage;

public class Sprite {
    private double[] position;
    private BufferedImage image;

    public Sprite(double[] positionInput, BufferedImage imageInput){

        position = positionInput;
        image = imageInput;

    }

    public double[] getPosition(){
        return position;
    }
    public BufferedImage getImage() {
        return image;
    }
}
