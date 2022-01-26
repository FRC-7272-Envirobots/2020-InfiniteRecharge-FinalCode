package frc.robot.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TestGyro extends CommandBase 
{
    private final ADXRS450_Gyro Gyro;

    public double Rotation;
 
    public TestGyro(ADXRS450_Gyro gyro) 
    {
        Gyro = gyro;
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
        Gyro.reset();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        Rotation = Gyro.getAngle() % 360;
        SmartDashboard.putNumber("rotation", Rotation);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() 
    {
      return false;
    }
}