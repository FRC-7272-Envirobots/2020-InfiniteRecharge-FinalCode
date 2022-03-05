package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Encoders;

public class TestRevEncoder extends CommandBase 
{
    public Encoders Encoder;

    public int Timer;

    public TestRevEncoder(Encoders encoders) 
    {
        Encoder = encoders;
        addRequirements(Encoder);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
        Timer = 0;
        Encoder.Reset();
        SmartDashboard.putNumber("Encoder Active", -9999);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        Timer++;
        SmartDashboard.putNumber("Encoder Value", Encoder.GetDistance());
        SmartDashboard.putNumber("Encoder Active", Timer);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() 
    {
      return Timer >= 999;
    }

    @Override 
    public void end(boolean interrupted)
    {
        SmartDashboard.putString("Encoder Active", "No");
    }
}