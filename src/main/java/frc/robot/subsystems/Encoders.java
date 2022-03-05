// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Encoders extends SubsystemBase 
{
  public DutyCycleEncoder ThroughBore;

  public Encoders(DutyCycleEncoder encoder)
  {
    ThroughBore = encoder;
  }

  public void Reset()
  {
    ThroughBore.reset();
  }

  public double GetDistance()
  {
      return ThroughBore.getDistance();
  }
}