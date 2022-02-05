// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.data.Vector3;

public class LimeLight extends SubsystemBase {

  public NetworkTable LimeLight;

  public NetworkTableEntry TableX;

  public NetworkTableEntry TableY;

  public NetworkTableEntry TableA;

  public LimeLight() 
  {
    LimeLight = NetworkTableInstance.getDefault().getTable("limelight");
    LimeLight.getEntry("ledMode").setNumber(1);
    TableX = LimeLight.getEntry("tx");
    TableY = LimeLight.getEntry("ty");
    TableA = LimeLight.getEntry("ta");
  }

  public void ForceOn()
  {
    LimeLight.getEntry("ledMode").setNumber(3);
  }

  public void ForceOff()
  {
    LimeLight.getEntry("ledMode").setNumber(1);
  }

  public Vector3 GetTableData()
  {
    return new Vector3(TableX.getDouble(0), TableY.getDouble(0), TableA.getDouble(0));
  }

  public void GetAndLogTableData()
  {
    Vector3.SmartDashboardLog(GetTableData(), "Table");
  }
}