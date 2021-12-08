// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
  TalonSRX conveyor;
  public DoubleSolenoid dropper;
  
  /** Creates a new Lift. */
  public Lift()
  {
    this.conveyor = new TalonSRX(5);
    dropper = new DoubleSolenoid(0, 2, 3);
  }

  public void rotate(double speed)
  {
    conveyor.set(ControlMode.PercentOutput, speed);
  }

  public void setDropper(DoubleSolenoid.Value value) 
  {
    this.dropper.set(value);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
