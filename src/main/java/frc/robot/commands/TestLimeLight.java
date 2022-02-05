package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimeLight;

public class TestLimeLight extends CommandBase 
{
    public LimeLight LimeLight;

    public int Timer;

    public TestLimeLight(LimeLight limeLight) 
    {
        LimeLight = limeLight;
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
        Timer = 0;
        LimeLight.ForceOn();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        Timer++;
        LimeLight.GetAndLogTableData();
        double ta0 = LimeLight.LimeLight.getEntry("ta0").getDouble(0);
        SmartDashboard.putNumber("LLTA0", ta0);
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