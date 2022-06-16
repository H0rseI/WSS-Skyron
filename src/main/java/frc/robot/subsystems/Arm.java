package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Good to create a subsystem for robot arm
public class Arm extends SubsystemBase{
    
    private final Servo servo;        
    private double servoValue;

    public Arm() {
        servo = new Servo(0);
    }
    // Good for debugging
    // Shuffleboard
    private final ShuffleboardTab tab = Shuffleboard.getTab("Arm");
    //Shuffleboard servo
    private final NetworkTableEntry D_servo = tab.add("IR servo1", 0).getEntry();

    public void setServoAngle(final double degrees){
        servoValue = degrees;
        servo.setAngle(degrees);
    }

    @Override
    public void periodic() {
        D_servo.setDouble(servoValue);
    }
    

}
