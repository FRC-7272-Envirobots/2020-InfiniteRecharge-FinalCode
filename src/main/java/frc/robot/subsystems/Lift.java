// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
  TalonSRX conveyor;
  Solenoid dropper = new Solenoid(0, 1);
  Solenoid otherDropper = new Solenoid(0, 0); // im guessing it's channel 0
  
  /** Creates a new Lift. */
  public Lift() {
    this.conveyor = new TalonSRX(5);
  }

  public void rotate(double speed) {
    conveyor.set(ControlMode.PercentOutput, speed);
  }

  public void setDropper(boolean extended) {
    this.dropper.set(extended);
  }

  public void setOtherDropper(boolean extended) 
  {
    otherDropper.set(extended);
  }

  public void Pulse(double pulseDuration) {
    dropper.startPulse();
    dropper.setPulseDuration(pulseDuration);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
