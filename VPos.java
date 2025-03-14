package src;


public class VPos {
    private final double[] position;
    private final String ID;

    public VPos(double[] positionInput, String IDInput){

        position = positionInput;
        ID = IDInput;

    }

    public double[] getPosition(){
        return position;
    }
    public String getID() {
        return ID;
    }
}
