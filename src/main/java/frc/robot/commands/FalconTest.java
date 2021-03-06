package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Falcon500Test;

public class FalconTest extends CommandBase 
{
    public Falcon500Test FalconMotor;

    public int Timer = 0;
    
    public FalconTest(Falcon500Test falcon500Test) 
    {
        FalconMotor = falcon500Test;
        addRequirements(FalconMotor);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
        Timer = 0;
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        if (FalconMotor.CurrentSpeed < 0.8f)
        {
            FalconMotor.CurrentSpeed *= 1.05f;

            if (FalconMotor.CurrentSpeed <= 0)
            {
                FalconMotor.CurrentSpeed = 0.05f;
            }

            if (FalconMotor.CurrentSpeed > 0.8)
            {
                FalconMotor.CurrentSpeed = 0.8;
            }
        }
        else
        {
            FalconMotor.CurrentSpeed = 0.8;
        }
        FalconMotor.rotate(FalconMotor.CurrentSpeed);
        Timer++;
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted)
    {
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() 
    {
      return false;
    }
}