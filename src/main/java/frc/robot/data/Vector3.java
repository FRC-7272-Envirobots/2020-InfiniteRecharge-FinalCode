package frc.robot.data;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vector3 
{
    public double X;

    public double Y;

    public double Z;

    public Vector3(double x, double y, double z)
    {
        X = x;
        Y = y;
        Z = y;
    }

    public static void SmartDashboardLog(Vector3 value, String identifier)
    {
        SmartDashboard.putNumber(identifier + ".X", value.X);
        SmartDashboard.putNumber(identifier + ".Y", value.Y);
        SmartDashboard.putNumber(identifier + ".Z", value.Z);
    }
}
