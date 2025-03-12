package src;



import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController {
    private final CarModel carM;
    private final CarView carV;

    public CarController(CarModel model) {
        this.carM = model;
        this.carV = carM.frame;
        addActionListeners();
    }

    private void addActionListeners() {


        carV.getGasSpinner().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                carM.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });


        carV.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.gas(carM.gasAmount);
            }
        });

        carV.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.brakeCar(carM.gasAmount);
            }
        });

        carV.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.stopCar();
            }
        });

        carV.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.turboOn();
            }
        });

        carV.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.turboOff();
            }
        });

        carV.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.raiseDumpBox();
            }
        });

        carV.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.lowerDumpBox();
            }
        });
        carV.startButton.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e){
               carM.startCar();
           }
       });
        carV.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.stopCar();
            }
        });
    }
}


