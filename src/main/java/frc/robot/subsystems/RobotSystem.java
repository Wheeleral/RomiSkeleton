// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.XboxController;

import java.util.HashMap;
import java.util.Map;

public class RobotSystem{
    private final Drivetrain drivetrain;
    private int state = 1;
    public boolean isButtonAPressed = false;
    public boolean isButtonBPressed = false;
    public double robotAngle = 0;
    public double robotSpeed = 0;
    public double xaxis = 0;
    public double yaxis = 0;
    private Map<String, String> mapString = new HashMap<String, String>();
    private Map<String, Double> mapDouble = new HashMap<String, Double>();
    private Map<String, Boolean> mapBoolean = new HashMap<String, Boolean>();
    private XboxController joystick;

    public RobotSystem(Drivetrain drive, XboxController joy) {
        drivetrain = drive;
        joystick = joy;
    }

    public void setTurn(double speed) {
        drivetrain.resetEncoders();
        drivetrain.arcadeDrive(0, speed);
    }

    public void setSpeed(double speed) {
        drivetrain.resetEncoders();
        drivetrain.arcadeDrive(speed, 0);
    }

    public void joystickDrive() {
        drivetrain.arcadeDrive(joystick.getRawAxis(1), joystick.getRawAxis(0));
    }
    
    public void setState(int newState) {
        state = newState;
    }
    public int getState() {
        return state;
    }

    public double getDouble(String name) {
        return mapDouble.get(name);
    }
    public void setDouble(String name, Double value) {
        mapDouble.put(name, value);
    }

    public Boolean getBoolean(String name) {
        return mapBoolean.get(name);
    }
    public void setBoolean(String name, Boolean value) {
        mapBoolean.put(name, value);
    }

    public String getString(String name) {
        return mapString.get(name);
    }
    public void setString(String name, String value) {
        mapString.put(name, value);
    }


}
