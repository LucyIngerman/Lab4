package src;


import java.awt.*;

public class Garage<T>{
    int carCapacity;
    int currentCarsAmount = 0;
    private T[] cars;
    private final Rectangle bounds = new Rectangle(300, 300, 101, 96);


    // Test
    @SuppressWarnings("unchecked")
    public Garage(int capacityInput){
        carCapacity = capacityInput;

        this.cars = (T[]) new Object[capacityInput];
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

}
