package frc.robot.utils;

public class MathHelper 
{
    public static int Sign(double value)
    {
        if (value > 0)
        {
            return 1;
        }
        else if (value < 0)
        {
            return -1;
        }
        return 0;
    }
}
