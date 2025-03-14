package src;


import javax.swing.*;


public class CarController {
    private final CarModel carM;
    private final JSpinner gasSpinner;
    private final JButton gasButton, brakeButton, stopButton, turboOnButton, turboOffButton, liftBedButton, lowerBedButton, startButton, addCarButton, removeCarButton;

    public CarController(CarModel model, JSpinner gasSpinner, JButton gasButton, JButton brakeButton, JButton stopButton,
                         JButton turboOnButton, JButton turboOffButton, JButton liftBedButton, JButton lowerBedButton,
                         JButton startButton, JButton addCarButton, JButton removeCarButton) {
        this.carM = model;
        this.gasSpinner = gasSpinner;
        this.gasButton = gasButton;
        this.brakeButton = brakeButton;
        this.stopButton = stopButton;
        this.turboOnButton = turboOnButton;
        this.turboOffButton = turboOffButton;
        this.liftBedButton = liftBedButton;
        this.lowerBedButton = lowerBedButton;
        this.startButton = startButton;
        this.addCarButton = addCarButton;
        this.removeCarButton = removeCarButton;


        addActionListeners();
    }


    private void addActionListeners() {
        gasSpinner.addChangeListener(e -> carM.gasAmount = (int) ((JSpinner) e.getSource()).getValue());

        gasButton.addActionListener(e -> carM.gas(carM.gasAmount));
        brakeButton.addActionListener(e -> carM.brakeCar(carM.gasAmount));
        stopButton.addActionListener(e -> carM.stopCar());
        turboOnButton.addActionListener(e -> carM.turboOn());
        turboOffButton.addActionListener(e -> carM.turboOff());
        liftBedButton.addActionListener(e -> carM.raiseDumpBox());
        lowerBedButton.addActionListener(e -> carM.lowerDumpBox());
        startButton.addActionListener(e -> carM.startCar());
        addCarButton.addActionListener(e -> carM.addCar());
        removeCarButton.addActionListener(e -> carM.removeCar());

    }


}


