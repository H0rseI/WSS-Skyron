package frc.robot.subsystems;

//Java imports

//Vendor imports

import com.studica.frc.Cobra;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
//WPI imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//import the Servo Library


public class Sensor extends SubsystemBase
{
    //Creates all necessary hardware interface here for sensors
    //For servo testing also????

    // Sensors
    private final DigitalInput input10;
    private final AnalogInput input22;
    private final AnalogInput input23;
    private int i;

    

    // Good for debugging
    // Shuffleboard
    private final ShuffleboardTab tab = Shuffleboard.getTab("Sensors");
    private final NetworkTableEntry D_inputDisp = tab.add("inputDisp", 0).getEntry();
    private NetworkTableEntry D_poopoo = tab.add("icount", 0).getEntry();
    private final NetworkTableEntry D_IR = tab.add("IR sensor", 0).getEntry();
    private final NetworkTableEntry D_IR2 = tab.add("IR sensor2", 0).getEntry();

    //Subsystem for sensors
    //This is just an example.
    public Sensor() {
        
        input10 = new DigitalInput(10);
        input22 = new AnalogInput(0);
        input23 = new AnalogInput(1);
        
    }


    

    public Boolean getSwitch() {
        return input10.get();
    }

    public double getDistance(){
        return (Math.pow(input22.getAverageVoltage(), -1.2045)) * 27.726;
    }

    public double getDistance2(){
        return (Math.pow(input23.getAverageVoltage(), -1.2045)) * 27.726;
    }
    /**
     * Call for the raw ADC value
     * <p>
     * 
     * @param channel range 0 - 3 (matches what is on the adc)
     * @return value between 0 and 2047 (11-bit)
     */
    public int getCobraRawValue(final int channel) {
        return 0;
    }


    /**
     * Call for the distance measured by the Sharp IR Sensor
     * <p>
     * 
     * @return value between 0 - 100 (valid data range is 10cm - 80cm)
     */
    public double getIRDistance() {
        return 0;
    }
   
    /**
     * Code that runs once every robot loop
     */
    @Override
    public void periodic()
    {
        //Display on shuffleboard
        //These display is good for debugging but may slow system down.
        //Good to remove unnecessary display during competition
        D_inputDisp.setBoolean(getSwitch());
        D_poopoo.setNumber(i);
        D_IR.setDouble(getDistance());
        D_IR2.setDouble(getDistance2());
        
    }
}