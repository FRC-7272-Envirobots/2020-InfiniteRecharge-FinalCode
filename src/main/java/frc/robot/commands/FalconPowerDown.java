package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Falcon500Test;

public class FalconPowerDown extends CommandBase 
{
    public Falcon500Test FalconMotor;

    public FalconPowerDown(Falcon500Test falcon500Test) 
    {
        FalconMotor = falcon500Test;
        addRequirements(FalconMotor);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
        
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        FalconMotor.CurrentSpeed *= 0.99f;
        FalconMotor.rotate(FalconMotor.CurrentSpeed);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted)
    {
        FalconMotor.rotate(0);
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() 
    {
      return FalconMotor.CurrentSpeed <= 0.01f;
    }
}
