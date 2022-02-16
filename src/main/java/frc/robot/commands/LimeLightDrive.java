package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimeLight;
import frc.robot.data.Vector3;
import frc.robot.subsystems.Drivetrain;

public class LimeLightDrive extends CommandBase 
{
    public Drivetrain Drivetrain;

    public LimeLight LimeLight;

    public LimeLightDrive(Drivetrain drivetrain, LimeLight limeLight) 
    {
        Drivetrain = drivetrain;
        LimeLight = limeLight;
        addRequirements(drivetrain);
        addRequirements(limeLight);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
        LimeLight.ForceOn();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        Vector3 data = LimeLight.GetTableData();
        Vector3.SmartDashboardLog(data, "LLDrive");
        float heading_error = -(float)data.X;
        float controlConstant = -0.1f;
        float minimumMovement = 0.05f;
        float steering_adjust = controlConstant * heading_error + (data.X < 1.0 ? minimumMovement : -minimumMovement);
        //Drivetrain.left.set(steering_adjust);
        //Drivetrain.right.set(-steering_adjust);
        SmartDashboard.putNumber("Left Wheel", steering_adjust);
        SmartDashboard.putNumber("Right Wheel", -steering_adjust);
        String wheelState = "Null";
        SmartDashboard.putString("Wheel State", wheelState);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted)
    {
        LimeLight.ForceOff();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() 
    {
      return false;
    }
}