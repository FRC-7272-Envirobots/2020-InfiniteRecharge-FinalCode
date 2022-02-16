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
        SmartDashboard.putString("Encoder Active", "Yes");
        Encoder.Reset();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        Timer++;
        SmartDashboard.putNumber("Encoder Value", Encoder.GetRotate());
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