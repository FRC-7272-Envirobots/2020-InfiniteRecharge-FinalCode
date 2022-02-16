// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Falcon500Test extends SubsystemBase 
{
  public TalonSRX Rotate;

  public Falcon500Test()
  {
    this.Rotate = new TalonSRX(7);
  }

  public void rotate(double speed)
  {
    Rotate.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}
