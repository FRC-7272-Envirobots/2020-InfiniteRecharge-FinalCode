// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DefaultDrive extends CommandBase {
  private final Drivetrain drivetrain;
  private final Joystick joystick;
  /** Creates a new DefaultDrive. */
  public DefaultDrive(Drivetrain drivetrain, Joystick joystick) {
    this.drivetrain = drivetrain;
    this.joystick = joystick;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  public int Sign(double input)
  {
    if (input == 0)
    {
      return 0;
    }

    return input > 0 ? 1 : -1;
  }

  @Override
  public void execute() 
  {
    double velocityY = joystick.getY();
    double velocityX = joystick.getX();
    /*if (velocityX != 0)
    {
      double velocityXNormalized = velocityX / 5;
      double velocityLeft = velocityX > 0 ? velocityY * velocityXNormalized : 0;
      double velocityRight = velocityX > 0 ? 0 : velocityY * velocityXNormalized;
      this.drivetrain.tankDrive(velocityLeft, velocityRight);
    }
    else
    {
      double velocityLeft = velocityY;
      double velocityRight = velocityY;
      this.drivetrain.tankDrive(velocityLeft, velocityRight);
    }
*/
      double velocityXNormalized = velocityX / 5;
      double velocityLeft = (velocityY / 2) + (velocityX > 0 ? (velocityY / 2) * velocityXNormalized : 0);
      double velocityRight = (velocityY / 2) + (velocityX > 0 ? 0 : (velocityY / 2) * velocityXNormalized);
      this.drivetrain.tankDrive(velocityLeft, velocityRight);
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
