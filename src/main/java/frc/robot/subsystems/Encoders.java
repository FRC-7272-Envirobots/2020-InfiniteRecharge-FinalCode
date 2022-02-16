// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Encoders extends SubsystemBase 
{
  public Encoder ThroughBore;

  public Encoders()
  {
    ThroughBore = new Encoder(0, 1, true, EncodingType.k4X);
  }

  public void Reset()
  {
      ThroughBore.reset();
  }

  public double GetRotate()
  {
      return ThroughBore.getDistance();
  }
}