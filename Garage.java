package src;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Garage<T>{
    int carCapacity;
    int currentCarsAmount = 0;
    private T[] cars;
    private final Rectangle bounds = new Rectangle(300, 300, 101, 96);
    BufferedImage bufferedImage;
    private double x;
    private double y;

    // Test
    @SuppressWarnings("unchecked")
    public Garage(int capacityInput, double xInput, double yInput,BufferedImage bufferedImageInput){
        carCapacity = capacityInput;
        x = xInput;
        y = yInput;
        bufferedImage = bufferedImageInput;
        this.cars = (T[]) new Object[capacityInput];
    }

    public double[] getPosition(){
        return new double[]{x, y};
    }

    public void removeCar(T inputCar){
        for(int i = 0; i < cars.length; i++){
            if(cars[i] != null && cars[i].equals(inputCar)){
                cars[i] = null;
                currentCarsAmount -= 1;
                break;
            }
        }
    }

    public void addCar(T inputCar){
        if(currentCarsAmount == carCapacity){
            return;
        }
        for(int i = 0; i < cars.length; i++){
            if(cars[i] == null){
                cars[i] = inputCar;
                currentCarsAmount += 1;
                return;
            }
        }
    }

    public boolean carInGarage(T inputCar){
        for (T car : cars) {
            if (car != null && car.equals(inputCar)) {
                return true;
            }
        }
        return false;
    }

    public boolean isColliding(Vehicle vehicle) {
        return bounds.intersects(vehicle.getBounds()); // Check if car and workshop overlap
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}
