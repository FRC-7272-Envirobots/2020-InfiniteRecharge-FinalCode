// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private final WPI_VictorSPX leftFront;
  private final WPI_VictorSPX leftBack;
  private final WPI_VictorSPX rightFront;
  private final WPI_VictorSPX rightBack;

  private final SpeedControllerGroup left;
  private final SpeedControllerGroup right;
  private final DifferentialDrive drive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftFront = new WPI_VictorSPX(3);
    leftBack = new WPI_VictorSPX(1);
    rightFront = new WPI_VictorSPX(2);
    rightBack = new WPI_VictorSPX(4);
    left = new SpeedControllerGroup(leftFront, leftBack);
    right = new SpeedControllerGroup(rightFront, rightBack);
    drive = new DifferentialDrive(left, right);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    this.drive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
