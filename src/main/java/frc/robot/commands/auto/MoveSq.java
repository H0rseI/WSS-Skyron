package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import the commands
import frc.robot.commands.auto.MoveRobot;

/**
 * DriveMotor class
 * <p>
 * This class creates the inline auto command to drive the motor
 */
public class MoveSq extends SequentialCommandGroup
{
    public MoveSq()
    {
        super(
            new MoveRobot(1, 0.5, 0, 0.01, 0.5),
            new MoveRobot(0, -0.5, 0, 0.01, 0.5),  
            new MoveRobot(1, -0.5, 0, 0.01, 0.5),
            new MoveRobot(0, 0.5, 0, 0.01, 0.5)  
            );
    }
}
